package Trivial_i1b.Trivial_i1b.DataBase;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoDBConnector implements DBConnector {
	private MongoClient mongo = null;
	
	public MongoDBConnector(){}

	private void createConnection() {
		try {
			mongo = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.err
					.println("The connection to the database could not be established");
		}

	}

	public MongoClient getConnection() {
		if (mongo == null)
			createConnection();
		return mongo;
	}
}
