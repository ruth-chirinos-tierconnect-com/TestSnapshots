package com.coderoad.utils;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rchirinos
 * @date : 8/17/16 8:58 PM
 * @version:
 */

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

public class MongoDAOUtils {

    private static MongoDAOUtils instance = new MongoDAOUtils();

    public MongoClient mongoClient;
    public DB db;
    public DBCollection thingsCollection;
    public DBCollection thingTypesCollection;
    public DBCollection thingSnapshotsCollection;
    public DBCollection thingSnapshotIdsCollection;
    public DBCollection thingBucketCollection;
    public DBCollection timeseriesCollection;
    public DBCollection timeseriesControlCollection;
    public DBCollection sapCollection;

    public MongoDAOUtils() {
    }

    public static MongoDAOUtils getInstance() {
        return instance;
    }

    public static void setupMongodb(String mongoHost,
                                    int mongoPort,
                                    String mongoDatabase,
                                    Integer connectTimeOut,
                                    Integer connectionsPerHost,
                                    String username,
                                    String password
    ) throws UnknownHostException {
        MongoClientOptions options = MongoClientOptions.builder()
                .connectTimeout(connectTimeOut == null ? 3000 : connectTimeOut)
                .connectionsPerHost(connectionsPerHost == null ? 200 : connectionsPerHost)  //sets the connection timeout to 3 seconds
                .build();

        MongoCredential credential = MongoCredential.createCredential(username, "admin", password.toCharArray());
        MongoClient mongoClient =
                new MongoClient(
                        new ServerAddress(mongoHost, mongoPort),
                        Arrays.asList(credential),
                        options);

        if (instance.mongoClient != null) {
            instance.mongoClient.close();
        }
        instance.mongoClient = mongoClient;
        DB db = mongoClient.getDB(mongoDatabase);
        instance.db = db;
        instance.thingsCollection = db.getCollection("things");
        instance.thingTypesCollection = db.getCollection("thingTypes");
        instance.thingSnapshotsCollection = db.getCollection("thingSnapshots");
        instance.thingSnapshotIdsCollection = db.getCollection("thingSnapshotIds");
        instance.thingBucketCollection = db.getCollection("thingBucket");
        instance.timeseriesCollection = db.getCollection("timeseries");
        instance.timeseriesControlCollection = db.getCollection("timeseriesControl");
        instance.sapCollection = db.getCollection("sap");
  }
}
