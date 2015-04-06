package DataBase;

import com.mongodb.MongoClient;

public interface DBConnector {
	MongoClient getConnection();

}
