package es.uniovi.seti.DataBase;

import com.mongodb.MongoClient;

public interface DBConnector {
	MongoClient getConexion();

}
