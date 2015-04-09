package logic.DB;

import java.util.ArrayList;
import java.util.List;

import logic.model.User;

import org.bson.Document;

import com.mongodb.BasicDBObject;

public class MongoUserManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "users";
	private static final String DATABASE_NAME = "game";

	public boolean saveUser(User user) {
		try {
			connectDatabase();
			if (getUser(user.getUsername()) != null) {
				table.insertOne(createDocument(user));
			} else
				System.err.println("User with username " + user.getUsername()
						+ " alredy exists.");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeDatabase();
		}
	}

	public User getUser(String username) {
		try {
			connectDatabase();
			BasicDBObject query = new BasicDBObject().append("username",
					username);
			User user = null;
			for (Document doc : table.find(query))
				user = createUser(doc);
			return user;
		} catch (Exception e) {
			return null;
		} finally {
			closeDatabase();
		}
	}
	
	public List<User> getAllUsers() {
		try {
			connectDatabase();
			List<User> users = new ArrayList<User>();
			for (Document doc : table.find())
				users.add(createUser(doc));
			return users;
		} catch (Exception e) {
			return null;
		} finally {
			closeDatabase();
		}
	}

	public boolean updateUser(User user) {
		try {
			connectDatabase();
			BasicDBObject query = new BasicDBObject().append("username",
					user.getUsername());
			Document document = new Document().append("$set",
					createDocument(user));
			table.updateOne(query, document);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeDatabase();
		}
	}

	private User createUser(Document doc) {
		User user = new User(doc.getString("username"),
				doc.getString("password"), doc.getString("email"),
				new MongoStatisticsManager().getStatistics(doc.getString("username")));
		return user;
	}

	private Document createDocument(User user) {
		Document doc = new Document();
		doc.put("password", user.getPassword());
		doc.put("email", user.getEmail());
		return doc;
	}

	private void connectDatabase() {
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}
}
