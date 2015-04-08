package logic.DB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import Model.Question;
import Model.TrivialQuestion;

import com.mongodb.MongoClient;

public class MongoQuestionManager extends AbstractMongoManager{
	
	private static final String COLLECTION_NAME = "questions";
	private static final String DATABASE_NAME = "game";
	
	public static List<Question> getQuestions() {
		try {
			connectDatabase();
			List<Question> questions = new ArrayList<Question>();
			for (Document doc : table.find())
				questions.add(createQuestion(doc));
			return questions;
		} catch (Exception e) {
			return null;
		} finally {
			closeDatabase();
		}
	}

	private static Question createQuestion(Document doc) {
		List<String> answers = new ArrayList<String>();

		for (String key : doc.keySet())
			if (key.contains("answer"))
				answers.add(doc.getString(key));

		Question question = new TrivialQuestion(doc.getString("question"),
				answers, doc.getInteger("correct", -1));
		return question;
	}
	
	private static void connectDatabase() {
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}
	
	private static void closeDatabase() {
		mongo.close();
	}
}
