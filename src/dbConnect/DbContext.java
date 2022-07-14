package dbConnect;

import com.mongodb.client.MongoDatabase;

public class DbContext {

    private static MongoDatabase mongoDatabase;

    public static void setMongoDatabase(MongoDatabase mongoDb) {
        if (mongoDb == null) {
            throw new NullPointerException("mongoDatabase cannot be null");
        }
        mongoDatabase = mongoDb;
    }

    public static MongoDatabase getMongoDatabase() {
        if (mongoDatabase == null) {
            throw new IllegalStateException("mongoDatabase must be set before calling this method");
        }
        return mongoDatabase;
    }

    public static void clear() {
        mongoDatabase = null;
    }

}
