package logic.DB;

import logic.model.User;

import org.bson.Document;

import com.mongodb.BasicDBObject;

public class MongoUserManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "users";
	private static final String DATABASE_NAME = "game";

	public static boolean saveUser(User user) {
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

	/*public static boolean saveManyUsers(List<User> users) {
		try {
			connectDatabase();
			List<Document> docs = new ArrayList<Document>();
			for (User user : users) {
				if (getUser(user.getUsername()) != null)
					docs.add(createDocument(user));
				else
					System.err.println("User with username "
							+ user.getUsername() + " alredy exists.");
			}
			table.insertMany(docs);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeDatabase();
		}
	}*/

	public static User getUser(String username) {
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

	public static boolean updateUser(User user) {
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

	private static User createUser(Document doc) {
		User user = new User(doc.getString("username"),
				doc.getString("password"), doc.getString("email"),
				MongoStatisticsManager.getStatistics(doc.getString("username")));
		return user;
	}

	private static Document createDocument(User user) {
		Document doc = new Document();
		doc.put("password", user.getPassword());
		doc.put("email", user.getEmail());
		return doc;
	}

	private static void connectDatabase() {
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}
}
