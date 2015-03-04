package es.uniovi.seti.DBWritter;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import es.uniovi.seti.DataBase.MongoDBConnector;
import es.uniovi.seti.Model.TrivialQuestion;

public class MongoDBWriter implements DBWriter {
	
	private MongoClient mongo;
	private List<TrivialQuestion> preguntas;
	private DB database;
	private DBCollection table;
	
	public MongoDBWriter(List<TrivialQuestion> preguntas) {
		this.preguntas=preguntas;
	}
	
	public void insertQuestions(){
		mongo=new MongoDBConnector().getConexion();
		if (mongo!=null){
			crearElementos();
			addPreguntas(preguntas);
		}
		else{
			throw new IllegalStateException("No se ha establecido una conexión con la base de datos");
		}
	}
	
	private void crearElementos(){
		database=mongo.getDB("Trivial");
		table=database.getCollection("pregunta");
	}
	
	private void addPreguntas(List<TrivialQuestion>preguntas){
		BasicDBObject pregunta;
		for (TrivialQuestion question: preguntas){
			pregunta=crearEntradas(question);
			table.insert(pregunta);		
		}
	}
	
	private BasicDBObject crearEntradas(TrivialQuestion question){
		BasicDBObject pregunta=new BasicDBObject();

		List<String>answers=question.getAnswers();
		pregunta.put("pregunta", question.getQuestion());
		pregunta.put("correcta", answers.remove(question.getPositionTrue()));
		pregunta.put("erronea1", answers.get(0));
		pregunta.put("erronea2", answers.get(1));
		
		return pregunta;
	}
}
