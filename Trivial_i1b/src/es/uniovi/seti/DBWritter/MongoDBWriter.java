package es.uniovi.seti.DBWritter;

import java.util.List;

import com.mongodb.MongoClient;

import es.uniovi.seti.DataBase.MongoDBConnector;
import es.uniovi.seti.Model.Question;

public class MongoDBWriter implements DBWriter {
	
	private MongoClient mongo;
	private List<Question> preguntas;
	
	public MongoDBWriter(List<Question> preguntas) {
		this.preguntas=preguntas;
	}
	
	public void insertQuestions(){
		
	}
}
