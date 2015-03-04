package Trivial_i1b.Trivial_i1b.DBWritter;

import java.util.List;

import Trivial_i1b.Trivial_i1b.DataBase.MongoDBConnector;
import Trivial_i1b.Trivial_i1b.Model.Question;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoBDWriter implements DBWriter {
	
	private MongoClient mongo;
	private List<Question> answers;
	private DB database;
	private DBCollection table;
	
	public MongoBDWriter(List<Question> answers) {
		this.answers = answers;
	}
	
	public void insertQuestions(){
		mongo = new MongoDBConnector().getConnection();
		if (mongo != null) {
			createElements();
			addQuestions(answers);
		}
		else {
			throw new IllegalStateException("It's not possible to connect to the database.");
		}
	}
	
	public void createElements() {
		database = mongo.getDB("Trivial");
		table = database.getCollection("question");
	}
	
	private void addQuestions(List<Question> questions) {
		BasicDBObject question;
		for (Question q : questions) {
			question = createEntries(q);
			table.insert(question);
		}
	}
	
	private BasicDBObject createEntries(Question question) {
		
		List<String> answers = question.getAnswers();
		BasicDBObject answer = new BasicDBObject();
		
		answer.put("question", question.getQuestion());
		answer.put("correct", answers.remove(question.getPositionTrue()));
		answer.put("wrong",  answers.get(0));
		answer.put("wrong2",  answers.get(1));
		
		return answer;	
	}
}
