package logic.DB;

import logic.model.Statistics;
import logic.model.User;

import org.bson.Document;

import com.mongodb.BasicDBObject;

public class MongoStatisticsManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "statistics";
	private static final String DATABASE_NAME = "game";
	
	public static boolean saveStatistics(User user) {
		try {
			connectDatabase();
			if (getStatistics(user.getUsername()) != null)
				table.insertOne(createDocument(user));
			else
				System.err.println("Statistics with username " + user.getUsername()
						+ " alredy exists.");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeDatabase();
		}
	}

	public static Statistics getStatistics(String username) {
		try {
			connectDatabase();
			BasicDBObject query = new BasicDBObject().append("username",
					username);
			Statistics stat = null;
			for (Document doc : table.find(query))
				stat = createStats(doc);
			return stat;
		} catch (Exception e) {
			return null;
		} finally {
			closeDatabase();
		}
	}
	
	public static boolean updateStatistics(User user) {
		try {
			connectDatabase();
			BasicDBObject query = new BasicDBObject().append("username",
					user.getUsername());
			Document document = new Document().append("$inc",
					createDocument(user));
			table.updateOne(query, document);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeDatabase();
		}
	}
	
	private static Document createDocument(User user) {
		Document doc = new Document();
		doc.put("timesPlayed", user.getStatistics().getTimesPlayed());
		doc.put("questionsAnswered", user.getStatistics().getQuestionsAnswered());
		doc.put("questionsMatched", user.getStatistics().getQuestionsMatched());
		return doc;
	}

	private static Statistics createStats(Document doc) {
		Statistics stat = new Statistics(doc.getInteger("timesPlayed", 0),
				doc.getInteger("questionsAnswered", 0), doc.getInteger(
						"questionsMatched", 0));
		return stat;
	}

	private static void connectDatabase() {
		db = mongo.getDatabase(DATABASE_NAME);
		table = db.getCollection(COLLECTION_NAME);
	}
}
