package logic.DB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import Model.Question;
import Model.TrivialQuestion;
import Parser.Utils;

public class MongoQuestionManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "questions";
	private static final String DATABASE_NAME = "game";

	public List<Question> getQuestions() {
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

	private Question createQuestion(Document doc) {
		List<String> answers = new ArrayList<String>();

		for (String key : doc.keySet())
			if (key.contains("answer"))
				answers.add(doc.getString(key));

		Question question = new TrivialQuestion(
				Utils.getCategory(doc.getString("category")), doc.getString("question"),
				answers, doc.getInteger("correct", -1));
		return question;
	}

	private void connectDatabase() {
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}

}
