package logic.DB;

import logic.model.Statistics;
import logic.model.User;

import org.bson.Document;

import com.mongodb.BasicDBObject;

public class MongoStatisticsManager extends AbstractMongoManager {

	private static final String COLLECTION_NAME = "statistics";
	private static final String DATABASE_NAME = "game";

	public MongoStatisticsManager() {
		connectDatabase(DATABASE_NAME, COLLECTION_NAME);
	}

	public boolean saveStatistics(User user) {
		try {
			if (getStatistics(user.getUsername()) == null)
				table.insertOne(createDocument(user));
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
			for (Document doc : table.find(query))
				stat = createStats(doc);
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
			Document document = new Document().append("$inc",
					createDocument(user));
			table.updateOne(query, document);
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}

	private Document createDocument(User user) {
		Document doc = new Document();
		doc.put("timesPlayed", user.getStatistics().getTimesPlayed());
		doc.put("questionsAnswered", user.getStatistics()
				.getQuestionsAnswered());
		doc.put("questionsMatched", user.getStatistics().getQuestionsMatched());
		return doc;
	}

	private Statistics createStats(Document doc) {
		Statistics stat = new Statistics(doc.getInteger("timesPlayed", 0),
				doc.getInteger("questionsAnswered", 0), doc.getInteger(
						"questionsMatched", 0));
		return stat;
	}
}
