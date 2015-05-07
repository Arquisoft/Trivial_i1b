package model.DB;

import java.util.ArrayList;
import java.util.List;

import model.model.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoUserManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "users";

	public MongoUserManager() {
		connectDatabase(COLLECTION_NAME);
	}

	public boolean saveUser(User user) {
		try {
			if (getUser(user.getUsername()) == null) {
				table.insert(createDocument(user));
				new MongoStatisticsManager().saveStatistics(user);
				return true;
			}
			System.err.println("User with username " + user.getUsername()
					+ " alredy exists.");
			return false;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}

	public User getUser(String username) {
		try {
			BasicDBObject query = new BasicDBObject().append("username",
					username);
			User user = null;
			DBCursor cursor = table.find(query);
			while (cursor.hasNext())
				user = createUser(cursor.next());
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
			DBCursor cursor = table.find();
			while (cursor.hasNext())
				users.add(createUser(cursor.next()));
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
			BasicDBObject document = new BasicDBObject().append("$set",
					createDocument(user));
			table.update(query, document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private User createUser(DBObject doc) {
		User user = new User((String) doc.get("username"),
				(String) doc.get("password"), (String) doc.get("email"),
				new MongoStatisticsManager().getStatistics((String) doc
						.get("username")));
		return user;
	}

	private DBObject createDocument(User user) {
		DBObject doc = new BasicDBObject();
		doc.put("username", user.getUsername());
		doc.put("password", user.getPassword());
		doc.put("email", user.getEmail());
		return doc;
	}
}
