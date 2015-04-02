package DBWriter;

import java.util.List;

import org.bson.Document;

import DataBase.MongoDBConnector;
import Model.Question;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBWriter implements DBWriter {

	private MongoClient mongo;
	private List<Question> trivialQuestions;
	private MongoDatabase database;
	private MongoCollection<Document> table;

	public MongoDBWriter(List<Question> trivialQuestions) {
		this.trivialQuestions = trivialQuestions;
	}

	public void insertQuestions() {
		mongo = new MongoDBConnector().getConnection();
		if (mongo != null) {
			createElements();
			addQuestions();
		} else {
			throw new IllegalStateException(
					"The connection to the database has not beem estabished");
		}
	}

	private void createElements() {
		database = mongo.getDatabase("localhost");
		database.createCollection("questions");
		table = database.getCollection("question");
	}

	private void addQuestions() {
		Document trivialQuestion;
		for (Question question : trivialQuestions) {
			trivialQuestion = createEntries(question);
			table.insertOne(trivialQuestion);
		}
	}

	private Document createEntries(Question question) {
		Document questionToInsert = new Document();

		List<String> answers = question.getAnswers();
		questionToInsert.put("question", question.getQuestion());
		questionToInsert.put("correct",
				answers.remove(question.getPositionTrue()));
		questionToInsert.put("wrong1", answers.get(0));
		questionToInsert.put("wrong2", answers.get(1));

		return questionToInsert;
	}
}
