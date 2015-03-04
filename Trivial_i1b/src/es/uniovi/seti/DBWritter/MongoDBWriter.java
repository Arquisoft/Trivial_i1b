package es.uniovi.seti.DBWritter;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import es.uniovi.seti.DataBase.MongoDBConnector;
import es.uniovi.seti.Model.Question;

public class MongoDBWriter implements DBWriter {
	
	private MongoClient mongo;
	private List<Question> trivialQuestions;
	private DB database;
	private DBCollection table;
	
	public MongoDBWriter(List<Question> trivialQuestions) {
		this.trivialQuestions=trivialQuestions;
	}
	
	public void insertQuestions(){
		mongo=new MongoDBConnector().getConnection();
		if (mongo!=null){
			createElements();
			addQuestions(trivialQuestions);
		}
		else{
			throw new IllegalStateException("The connection to the database has not beem estabished");
		}
	}
	
	private void createElements(){
		database=mongo.getDB("Trivial");
		table=database.getCollection("question");
	}
	
	private void addQuestions(List<Question>questions){
		BasicDBObject trivialQuestion;
		for (Question question: questions){
			trivialQuestion=createEntries(question);
			table.insert(trivialQuestion);		
		}
	}
	
	private BasicDBObject createEntries(Question question){
		BasicDBObject questionToInsert=new BasicDBObject();

		List<String>answers=question.getAnswers();
		questionToInsert.put("question", question.getQuestion());
		questionToInsert.put("correct", answers.remove(question.getPositionTrue()));
		questionToInsert.put("wrong1", answers.get(0));
		questionToInsert.put("wrong2", answers.get(1));
		
		return questionToInsert;
	}
}
