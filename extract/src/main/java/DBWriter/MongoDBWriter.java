package DBWriter;

import java.util.List;

import DataBase.MongoDBConnector;
import Model.Question;
import Parser.Utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBWriter implements DBWriter {

	private static final String QUESTIONS_COLLECTION = "questions";

	private MongoDBConnector connector;
	private MongoClient mongo;
	private DB database;
	private DBCollection table;

	public MongoDBWriter() {
		connector = new MongoDBConnector();
		mongo = connector.getConnection();
	}

	public void insertQuestions(List<Question> trivialQuestions) {
		if (mongo != null) {
			createElements();
			addQuestions(trivialQuestions);
		} else {
			throw new IllegalStateException(
					"The connection to the database has not beem estabished");
		}
	}

	private void createElements() {
		database = mongo.getDB(connector.getUri().getDatabase());
		table = database.getCollection(QUESTIONS_COLLECTION);
	}

	private void addQuestions(List<Question> trivialQuestions) {
		DBObject trivialQuestion;
		for (Question question : trivialQuestions) {
			trivialQuestion = createEntrie(question);
			table.insert(trivialQuestion);
		}
	}

	private DBObject createEntrie(Question question) {
		DBObject questionToInsert = new BasicDBObject();

		questionToInsert.put("category", Utils.getStringCategory(question.getCategory()));
		questionToInsert.put("question", question.getQuestion());
		List<String> answers = question.getAnswers();

		for (int i = 0; i < answers.size(); i++) {
			if (i == question.getPositionTrue())
				questionToInsert.put("correct", i);
			questionToInsert.put("answer" + i, answers.get(i));
		}
		return questionToInsert;
	}
}
