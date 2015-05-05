package model.DB;

import model.DB.MongoManager;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;

public abstract class AbstractMongoManager implements MongoManager{
	
	//protected MongoClient mongo = new MongoClient("localhost",27017);
	protected MongoDatabase db;
	protected MongoCollection<Document> table;
	
	protected void connectDatabase(String dbName,String CollectionName) {
		db = new MongoClient("localhost").getDatabase(dbName);
		table = db.getCollection(CollectionName);
	}
}