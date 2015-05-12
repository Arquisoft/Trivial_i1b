package model.DB;

import java.util.ArrayList;
import java.util.List;

import model.model.Statistics;
import model.model.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoStatisticsManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "statistics";

	public MongoStatisticsManager() {
		connectDatabase(COLLECTION_NAME);
	}

	public boolean saveStatistics(User user) {
		try {
			if (getStatistics(user.getUsername()) == null)
				table.insert(createDocument(user));
			else
				System.err.println("Statistics with username "
						+ user.getUsername() + " alredy exists.");
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}

	public Statistics getStatistics(String username) {
		try {
			BasicDBObject query = new BasicDBObject().append("username",
					username);
			Statistics stat = null;
			DBCursor cursor = table.find(query);
			while (cursor.hasNext())
				stat = createStats(cursor.next());
			return stat;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		}
	}
	
	public List<Statistics> getAllStatistics() {
		try {
			List<Statistics> stat = new ArrayList<Statistics>();
			DBCursor cursor = table.find();
			while (cursor.hasNext())
				stat.add(createStats(cursor.next()));
			return stat;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		}
	}

	public boolean updateStatistics(User user) {
		try {
			BasicDBObject query = new BasicDBObject().append("username",
					user.getUsername());
			DBObject document = new BasicDBObject().append("$set",
					createDocument(user));
			table.update(query, document);
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}

	private DBObject createDocument(User user) {
		DBObject doc = new BasicDBObject();
		doc.put("timesPlayed", user.getStatistics().getTimesPlayed());
		doc.put("questionsAnswered", user.getStatistics()
				.getQuestionsAnswered());
		doc.put("questionsMatched", user.getStatistics().getQuestionsMatched());
		return doc;
	}

	private Statistics createStats(DBObject doc) {
		Statistics stat = new Statistics((int) doc.get("timesPlayed"),
				(int) doc.get("questionsAnswered"), (int) doc.get(
						"questionsMatched"));
		return stat;
	}
}
