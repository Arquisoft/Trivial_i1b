package es.uniovi.seti.DataBase;

import com.mongodb.MongoClient;

public interface DBConnector {
	public MongoClient getConexion();
	
	
}

