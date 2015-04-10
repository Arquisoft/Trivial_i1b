package logic.DB;

import java.util.ArrayList;
import java.util.List;

import logic.model.User;

import org.bson.Document;

import com.mongodb.BasicDBObject;

public class MongoUserManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "users";
	private static final String DATABASE_NAME = "game";
	
	public MongoUserManager(){
		connectDatabase();
	}

	public boolean saveUser(User user) {
		try{
			if (getUser(user.getUsername()) == null) {
				table.insertOne(createDocument(user));
				return true;
			}
			System.err.println("User with username " + user.getUsername()
				+ " alredy exists.");
			return false;
		} catch (Exception e){
			e.printStackTrace(System.err);
			return false;
		}
	}

	public User getUser(String username) {
		try {
			BasicDBObject query = new BasicDBObject().append("username",
					username);
			User user = null;
			for (Document doc : table.find(query))
				user = createUser(doc);
			if (user != null)
				return user;
			return null;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		}
	}

	public List<User> getAllUsers() {
		try {
			List<User> users = new ArrayList<User>();
			for (Document doc : table.find())
				users.add(createUser(doc));
			return users;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		}
	}

	public boolean updateUser(User user) {
		try {
			BasicDBObject query = new BasicDBObject().append("username",
					user.getUsername());
			Document document = new Document().append("$set",
					createDocument(user));
			table.updateOne(query, document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private User createUser(Document doc) {
		User user = new User(doc.getString("username"),
				doc.getString("password"), doc.getString("email"),
				new MongoStatisticsManager().getStatistics(doc
						.getString("username")));
		return user;
	}

	private Document createDocument(User user) {
		Document doc = new Document();
		doc.put("username", user.getUsername());
		doc.put("password", user.getPassword());
		doc.put("email", user.getEmail());
		return doc;
	}

	private void connectDatabase() {
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}
}
