package logic;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUserManager {

	private static final String COLLECTION_NAME = "users";
	private static final String DATABASE_NAME = "game";
	private static MongoClient mongo;
	private static MongoDatabase db;
	private static MongoCollection<Document> table;

	public static boolean saveUser(User user) {
		try {
			connectDatabase();
			table.insertOne(createDocument(user));
			closeDatabase();
			return true;
		} catch (Exception e) {
			closeDatabase();
			return false;
		}
	}

	public static boolean saveManyUsers(List<User> users) {
		try {
			connectDatabase();
			List<Document> docs = new ArrayList<Document>();
			for (User user : users) {
				docs.add(createDocument(user));
			}
			table.insertMany(docs);
			closeDatabase();
			return true;
		} catch (Exception e) {
			closeDatabase();
			return false;
		}
	}

	private static Document createDocument(User user) {
		Document doc = new Document();
		doc.put("user", user.getUser());
		doc.put("password", user.getPassword());
		doc.put("email", user.getEmail());
		return doc;
	}

	private static void connectDatabase() {
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}

	private static void closeDatabase() {
		mongo.close();
	}
}
