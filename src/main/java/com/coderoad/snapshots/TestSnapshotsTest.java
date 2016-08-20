package com.coderoad.snapshots;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 * @date : 8/19/16 6:25 PM
 * @version:
 */
public class TestSnapshotsTest {

    @org.junit.Test
    public void testCase1() throws Exception {
        List<Results> results = new ArrayList<>();
        String serialNumber = "CASE00014SNAPSHOT";

        Date time = new Date(1471579200000L);
        Date newTime = new Date(1471579200000L+7200000);
        Calendar aC = Calendar.getInstance();
        aC.setTimeInMillis((1471579200000L+7200000)-time.getTime());
        results.add(new Results(time, "S3803-L0-POS-Belted", time, aC.getTimeInMillis()));

        results.add(new Results(time, "S3803-L0-POS-Belted", time, 0L));

        MongoDAOUtils.getInstance().setupMongodb("10.100.1.30",27017,"riot_main",2000000,50,"admin","control123!");

        Map<String, String> data = new LinkedHashMap<>();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 0));
        data.putAll(BlinkData.getCase(serialNumber, "ADJ", "true", 2));
        TestSnapshots.iterate(data);

        doTest(serialNumber, results);

        List<Results> resultsB = new ArrayList<>();


        time = new Date(1471579200000L);
        Date newTimeB = new Date(1471579200000L+3600000);
        newTime = new Date(1471579200000L+7200000);
        aC = Calendar.getInstance();
        aC.setTimeInMillis((1471579200000L+7200000)-newTimeB.getTime());
        resultsB.add(new Results(newTime, "S3803-L0-POS-Belted-8", newTimeB, aC.getTimeInMillis()));

        newTime = new Date(1471579200000L+3600000);
        aC.setTimeInMillis((1471579200000L+3600000)-time.getTime());
        resultsB.add(new Results(newTime, "S3803-L0-POS-Belted-8", newTime, aC.getTimeInMillis()));

        resultsB.add(new Results(time, "S3803-L0-POS-Belted", time, 0L));

        data.clear();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "317", 1));
        TestSnapshots.iterate(data);

        doTest(serialNumber, resultsB);

    }

    public void doTest (String serialNumber, List<Results> results){
        DBObject sort= new BasicDBObject();
        BasicDBObject query  = new BasicDBObject();
        query.put("value.serialNumber", serialNumber);
        sort.put("time", -1);
        DBCursor cursor = MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query).sort(sort);

        List<BasicDBObject> a  = new ArrayList<>();
//        a.addAll((List<>)cursor.getCollection())
        while (cursor.hasNext()){
            a.add((BasicDBObject) cursor.next());
        }
        if (a.size() != results.size()) {
            Assert.fail("Error number of snapshots");
        }

        BasicDBObject doc;
        for(int i =0; i<a.size() ; i++) {
            doc = (BasicDBObject) a.get(i);
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get("zone");
            BasicDBObject dbzone = (BasicDBObject) dbval.get("value");
            String zone = dbzone.get("code").toString();
            Date zoneTime = (Date) dbval.get("time");
            Long zoneDwell = (Long) dbval.get("dwellTime");
            System.out.println(i+"\t"+zone+"\t"+zoneTime+"\t"+zoneDwell);
            if(!results.get(i).getValue().toString().equals(zone)){
                Assert.fail(i+" UDF value " + zone + " not match with " +results.get(i).getValue().toString());
            }
            if(results.get(i).getTime().compareTo(zoneTime) != 0){
                Assert.fail(i+" UDF time " + zoneTime + " not match with "+results.get(i).getTime());
            }
            if(results.get(i).getDwelltime().compareTo(zoneDwell) != 0){
                Assert.fail(i+" UDF dwellTime " + zoneDwell + " not match with "+results.get(i).getDwelltime());
            }
        }

    }
}