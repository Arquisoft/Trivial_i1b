package logic;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
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
			if (getUser(user.getUsername()) != null)
				table.insertOne(createDocument(user));
			else
				System.err.println("User with username " + user.getUsername() + " alredy exists.");
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
				if(getUser(user.getUsername()) != null)
					docs.add(createDocument(user));
				else
					System.err.println("User with username " + user.getUsername() + " alredy exists.");
			}
			table.insertMany(docs);
			closeDatabase();
			return true;
		} catch (Exception e) {
			closeDatabase();
			return false;
		}
	}

	public static User getUser(String username) {
		connectDatabase();
		BasicDBObject query = new BasicDBObject();
		query.put("user", username);
		User user = null;
		for (Document doc : table.find(query))
			user = createUser(doc);
		closeDatabase();
		return user;
	}

	private static User createUser(Document doc) {
		User user = new User((String) doc.get("username"),
				(String) doc.get("password"), (String) doc.get("email"));
		return user;
	}

	private static Document createDocument(User user) {
		Document doc = new Document();
		doc.put("username", user.getUsername());
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
