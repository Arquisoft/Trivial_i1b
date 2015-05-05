package model.DB;

import java.util.ArrayList;
import java.util.List;

import model.DB.AbstractMongoManager;

import org.bson.Document;

import model.model.Question;
import model.model.TrivialQuestion;
import model.Utils;

public class MongoQuestionManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "questions";
	private static final String DATABASE_NAME = "game";
	
	public MongoQuestionManager() {
		connectDatabase(DATABASE_NAME, COLLECTION_NAME);
	}

	public List<Question> getQuestions() {
		try {
			List<Question> questions = new ArrayList<Question>();
			for (Document doc : table.find())
				questions.add(createQuestion(doc));
			return questions;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
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

}
