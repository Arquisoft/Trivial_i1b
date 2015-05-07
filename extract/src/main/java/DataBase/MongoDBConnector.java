package DataBase;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBConnector implements DBConnector {
	private MongoClientURI uri = new MongoClientURI(
			"mongodb://user:pass@ds029979.mongolab.com:29979/triviali1b");
	private MongoClient mongo = null;
	
	public MongoDBConnector(){}

	private void createConnection() {
		mongo = new MongoClient(uri);
	}

	public MongoClient getConnection() {
		if (mongo == null)
			createConnection();
		return mongo;
	}
	
	public void closeConnection() {
		mongo.close();
	}
	
	public MongoClientURI getUri() {
		return uri;
	}

}
