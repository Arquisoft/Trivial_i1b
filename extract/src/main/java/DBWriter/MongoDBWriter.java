package DBWriter;

import java.util.List;

import org.bson.Document;

import DataBase.MongoDBConnector;
import Model.Question;
import Parser.Utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBWriter implements DBWriter {

	private final static String DATABASE_NAME = "game";
	private static final String QUESTIONS_COLLECTION = "questions";

	private MongoClient mongo;
	private MongoDatabase database;
	private MongoCollection<Document> table;

	public MongoDBWriter() {
		mongo = new MongoDBConnector().getConnection();
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
		database = mongo.getDatabase(DATABASE_NAME);
		table = database.getCollection(QUESTIONS_COLLECTION);
	}

	private void addQuestions(List<Question> trivialQuestions) {
		Document trivialQuestion;
		for (Question question : trivialQuestions) {
			trivialQuestion = createEntrie(question);
			table.insertOne(trivialQuestion);
		}
	}

	private Document createEntrie(Question question) {
		Document questionToInsert = new Document();

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
