package DataBase;

import com.mongodb.MongoClient;

public class MongoDBConnector implements DBConnector {
	private static MongoClient mongo = null;
	
	public MongoDBConnector(){}

	private void createConnection() {
		mongo = new MongoClient("localhost", 27017);
	}

	public MongoClient getConnection() {
		if (mongo == null)
			createConnection();
		return mongo;
	}
	
	public void closeConnection() {
		mongo.close();
	}
}
