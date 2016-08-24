package com.coderoad.utils;

import com.coderoad.snapshots.MongoDAOUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by RUTH on 16/08/21.
 */
public class CasesResults {

    public static Map<String, Long> thingIds = new HashMap<>();

    public static List<CodeValue> case1Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case2Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case3Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case4Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case5Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Po1.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case6Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case6Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case7Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Saloor.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Enance.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> casesStepDB(String serialNumber) throws UnknownHostException {
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValue> result = new ArrayList<>();
        MongoDAOUtils.getInstance().setupMongodb(Utilities.MONGO_DB,27017,"riot_main",2000000,50,"admin","control123!");
        BasicDBObject query  = new BasicDBObject();
        query.put("value.serialNumber", serialNumber);
        BasicDBObject projection  = new BasicDBObject();
        projection.append("time", 1);
        projection.append("value", 1);
        projection.append("zone", 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query, projection).sort(new BasicDBObject("time", 1));

        System.out.println("Obtained result:");
        while(cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            Date timeSnapshot = (Date) doc.get("time");
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get("zone");

            Date   time       = null;
            Long dwellTime    = null;
            Boolean changed   = null;
            BasicDBObject dbzone;
            String code       = null;

            if (dbval!=null){
                time       = (Date)    dbval.get("time");
                dwellTime  = (Long) dbval.get("dwellTime")/3600000;
                changed    = (Boolean) dbval.get("changed")==null?false:(Boolean) dbval.get("changed");
                dbzone     = (BasicDBObject) dbval.get("value");
                if (dbzone!=null){
                    code       = dbzone.get("code").toString();
                }
            }


            result.add(new CodeValue(serialNumber,"zone", code, time, dwellTime, changed, timeSnapshot));
            System.out.println("-->\t"+(code==null?"":code)
                    +"\t"+(time==null?"":time)
                    +"\t"+(dwellTime==null?0:(dwellTime*3600000))
                    +"\t"+(changed==null?"":changed));
            thingIds.put(dbo.get("serialNumber").toString(), (Long) dbo.get("_id"));
        }
        return result;
    }

    public static void print (List<CodeValue> list){
        System.out.println("Expected Result:");
        for (CodeValue code : list){
            System.out.println("-->\t"+(code.getCode()==null?"":code.getCode())
                    +"\t"+(code.getTime()==null?"":code.getTime())
                    +"\t"+(code.getDwellTime()==null?"":code.getDwellTime())
                    +(code.getDwellTime()==null||code.getDwellTime()==0?"\t":"")+"\t"
                    +(code.getChanged()==null?"":code.getChanged()));
        }
    }

}
