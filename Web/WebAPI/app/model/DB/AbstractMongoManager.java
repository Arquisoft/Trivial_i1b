package model.DB;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public abstract class AbstractMongoManager implements MongoManager {

	protected DB db;
	protected DBCollection table;

	protected void connectDatabase(String CollectionName) {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://user:pass@ds029979.mongolab.com:29979/triviali1b");
		try {
			db = new MongoClient(uri).getDB(uri.getDatabase());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		table = db.getCollection(CollectionName);
	}
}