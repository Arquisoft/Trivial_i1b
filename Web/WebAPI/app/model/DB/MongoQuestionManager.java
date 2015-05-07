package model.DB;

import java.util.ArrayList;
import java.util.List;

import model.DB.AbstractMongoManager;

import model.model.Question;
import model.model.TrivialQuestion;
import model.Utils;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoQuestionManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "questions";
	
	public MongoQuestionManager() {
		connectDatabase(COLLECTION_NAME);
	}

	public List<Question> getQuestions() {
		try {
			List<Question> questions = new ArrayList<Question>();
			DBCursor cursor = table.find();
			while (cursor.hasNext())
				questions.add(createQuestion(cursor.next()));
			return questions;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		}
	}

	private Question createQuestion(DBObject doc) {
		List<String> answers = new ArrayList<String>();

		for (String key : doc.keySet())
			if (key.contains("answer"))
				answers.add((String)doc.get(key));

		Question question = new TrivialQuestion(
				Utils.getCategory((String)doc.get("category")), (String)doc.get("question"),
				answers, (int)doc.get("correct"));
		return question;
	}

}
