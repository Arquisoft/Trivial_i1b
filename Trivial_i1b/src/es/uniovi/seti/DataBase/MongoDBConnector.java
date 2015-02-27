package es.uniovi.seti.DataBase;
import java.net.UnknownHostException;

import com.mongodb.MongoClient;
public class MongoDBConnector implements DBConnector {
private MongoClient mongo=null;

private void createConexion(){
     try {
         mongo = new MongoClient("localhost", 27017);
     } catch (UnknownHostException e) {
         System.err.println("No se ha podido establecer la conexion con la base");
     }

 
}
public MongoClient getConexion(){
	if (mongo==null)
		createConexion();
	return mongo;
}
}
