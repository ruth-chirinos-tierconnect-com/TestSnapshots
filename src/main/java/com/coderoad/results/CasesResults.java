package com.coderoad.results;

import com.coderoad.utils.CodeValue;
import com.coderoad.utils.MongoDAOUtils;
import com.coderoad.utils.Utilities;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by RUTH on 16/08/21.
 * Cases results for SnapshotTest
 */
public class CasesResults {

    public static Map<String, Long> thingIds = new HashMap<>();

    public static List<CodeValue> case1Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case2Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case3Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case4Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case5Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
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
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case7Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 2, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case8Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> casesStepDB(String serialNumber) throws UnknownHostException {
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValue> result = new ArrayList<>();
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
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get("zone");

            Date   step       = (Date) doc.get("time");
            Date   time       = null;
            Long dwellTime    = null;
            Boolean changed   = null;
            BasicDBObject dbzone;
            String code       = null;

            if (dbval!=null){
                time       = (Date)    dbval.get("time");
                dwellTime  = (Long) dbval.get("dwellTime")/Utilities.getStep();
                changed    = dbval.get("changed")==null?false:(Boolean) dbval.get("changed");
                dbzone     = (BasicDBObject) dbval.get("value");
                if (dbzone!=null){
                    code       = dbzone.get("code").toString();
                }
            }


            result.add(new CodeValue(serialNumber,"zone", code, time, dwellTime, changed));
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format(step))+"-->\t"+(code==null?"":code)
                    +"\t"+(time==null?"":time)
                    +"\t"+((new SimpleDateFormat("HH:mm:ss")).format((new Date(
                    (dwellTime==null?0:dwellTime*Utilities.getStep()+Utilities.getDate())))))
                    +"\t"+(changed==null?"":changed));
            thingIds.put(dbo.get("serialNumber").toString(), (Long) dbo.get("_id"));
        }
        return result;
    }

    public static List<CodeValue> casesStepDBThings(String serialNumber) throws UnknownHostException {
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValue> result = new ArrayList<>();
        BasicDBObject query  = new BasicDBObject();
        query.put("serialNumber", serialNumber);
        BasicDBObject projection  = new BasicDBObject();
        projection.append("time", 1);
        projection.append("value", 1);
        projection.append("zone", 1);
        projection.append("serialNumber", 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingsCollection.find(query, projection).sort(new BasicDBObject("time", 1));

        System.out.println("Obtained result:");
        while(cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            BasicDBObject dbval = (BasicDBObject) doc.get("zone");

            Date   time       = null;
            BasicDBObject dbzone;
            String code       = null;

            if (dbval!=null){
                time       = (Date)    dbval.get("time");
                dbzone     = (BasicDBObject) dbval.get("value");
                if (dbzone!=null){
                    code       = dbzone.get("code").toString();
                }
            }


            result.add(new CodeValue(serialNumber,"zone", code, time, null, null));
            System.out.println("-->\t"+(code==null?"":code)+"\t"+(time==null?"":time)+"\t0\t");
            thingIds.put(doc.get("serialNumber").toString(), (Long) doc.get("_id"));
        }
        return result;
    }

    public static void print (List<CodeValue> list){
        System.out.println("Expected Result:");
        for (CodeValue code : list){
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format((new Date(code
                    .getStep()*Utilities.getStep()+Utilities.getDate()))))+"-->\t"+(code.getCode()==null?"":code
                    .getCode())
                    +"\t"+(code.getTime()==null?"":code.getTime())
                    +"\t"+(code.getDwellTime()==null?"":((new SimpleDateFormat("HH:mm:ss")).format((new Date(code
                    .getDwellTime()+Utilities.getDate())))))
                    +(code.getDwellTime()==null||code.getDwellTime()==0?"\t":"")+"\t"
                    +(code.getChanged()==null?"":code.getChanged()));
        }
    }

    public static List<CodeValue> case1Now1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Po1.value, null, null, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case1Now2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Po1.value, 2L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Po1.value, 1L, false, 4, 5));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Stroom.value, 3L, true, 6, 6));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Stroom.value, 1L, false, 6, 7));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Stroom.value, 2L, false, 6, 8));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, true, 9, 9));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.Po1.value, 0L, true, 10, 10));
        CasesResults.print(result);
        return result;
    }
}
