package com.coderoad.utils;

import com.coderoad.snapshots.MongoDAOUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RUTH on 16/08/21.
 */
public class CasesResults {

    public static List<CodeValue> case1Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0, true, null, 0));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0, true, null, 2));
        return result;
    }
    public static List<CodeValue> case1Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1, true, null, 0));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0, true, null, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 2));
        return result;
    }

    public static List<CodeValue> case1Step1DB(String serialNumber) throws UnknownHostException {
        List<CodeValue> result = new ArrayList<>();
        MongoDAOUtils.getInstance().setupMongodb(Utilities.MONGO_DB,27017,"riot_main",2000000,50,"admin","control123!");
        BasicDBObject query  = new BasicDBObject();
        query.put("value.serialNumber", serialNumber);
        BasicDBObject projection  = new BasicDBObject();
        projection.append("time", 1);
        projection.append("zone", 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query, projection).sort(new BasicDBObject("time", 1));

        while(cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            Date timeSnapshot = (Date) doc.get("time");
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get("zone");

            Date   time       = (Date)    dbval.get("time");
            Integer dwellTime = (Integer) dbval.get("dwellTime");
            Boolean changed   = (Boolean) dbval.get("changed");

            BasicDBObject dbzone = (BasicDBObject) dbval.get("value");
            String code       = dbzone.get("code").toString();

            result.add(new CodeValue(serialNumber,"zone", code, time, dwellTime, changed, timeSnapshot));
        }
        return result;
    }
}
