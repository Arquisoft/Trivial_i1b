package Trivial_i1b.Trivial_i1b.DataBase;

import com.mongodb.MongoClient;

public interface DBConnector {
	MongoClient getConnection();

}
