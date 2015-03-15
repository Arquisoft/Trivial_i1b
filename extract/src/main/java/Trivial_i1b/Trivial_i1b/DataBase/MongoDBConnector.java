package Trivial_i1b.Trivial_i1b.DataBase;

import com.mongodb.MongoClient;

public class MongoDBConnector implements DBConnector {
	private MongoClient mongo = null;
	
	public MongoDBConnector(){}

	private void createConnection() {
		mongo = new MongoClient("localhost", 27017);

	}

	public MongoClient getConnection() {
		if (mongo == null)
			createConnection();
		return mongo;
	}
}
