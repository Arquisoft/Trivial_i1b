package logic.DB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class AbstractMongoManager implements MongoManager{
	
	protected static MongoClient mongo;
	protected static MongoDatabase db;
	protected static MongoCollection<Document> table;
	
	protected static void closeDatabase() {
		mongo.close();
	}
}
