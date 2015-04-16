package logic.DB;

import org.bson.Document;

import DataBase.MongoDBConnector;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class AbstractMongoManager implements MongoManager{
	
	//protected MongoClient mongo = new MongoClient("localhost",27017);
	protected MongoDatabase db;
	protected MongoCollection<Document> table;
	
	protected void connectDatabase(String dbName,String CollectionName) {
		db = new MongoDBConnector().getConnection().getDatabase(dbName);
		table = db.getCollection(CollectionName);
	}
}
