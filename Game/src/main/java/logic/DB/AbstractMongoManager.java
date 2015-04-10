package logic.DB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class AbstractMongoManager implements MongoManager{
	
	protected MongoClient mongo = new MongoClient("localhost", 27017);
	protected MongoDatabase db;
	protected MongoCollection<Document> table;
	
	public void closeDatabase() {
		mongo.close();
	}
}
