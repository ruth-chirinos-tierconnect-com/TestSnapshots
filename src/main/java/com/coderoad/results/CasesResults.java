package com.coderoad.results;

import com.coderoad.test.CustomNowTest;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.CodeValueStatus;
import com.coderoad.utils.MongoDAOUtils;
import com.coderoad.utils.UDFHandler;
import com.coderoad.utils.Utilities;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by RUTH on 16/08/21. Cases results for SnapshotTest
 */
public class CasesResults {

    public static Map<String, Long> thingIds = new HashMap<>();

    public static List<CodeValue> case1Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, false, 1, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case1Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 1L, false, 2, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case2Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 3, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case2Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 3, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case3Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 3, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case3Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 1L, false, 2, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case4Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, false, 1, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case4Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, false, 1, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case5Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 3, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case5Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.C.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 3, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case6Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber, "zone", null, null, null, null, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case6Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, false, 2, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case7Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, false, 2, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case7Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, false, 2, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case8Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, false, 1, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case8Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, false, 1, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, false, 1, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case9Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 2L, false, 1, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> case9Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.E.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.E.value, 1L, false, 2, 3));
        print(result);
        return result;
    }

    public static List<CodeValue> casesStepDB(String serialNumber) throws Exception {
        MongoDAOUtils.getInstance().setupMongodb(Utilities.getMongoDB(), 27017, "riot_main", 2000000, 50, "admin",
                "control123!");
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValue> result = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        query.put("value.serialNumber", serialNumber);
        BasicDBObject projection = new BasicDBObject();
        projection.append("time", 1);
        projection.append("value", 1);
        projection.append("zone", 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query, projection).sort(new
                BasicDBObject("time", 1));

        System.out.println("Obtained result:");
        while (cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get("zone");

            Date step = (Date) doc.get("time");
            Date time = null;
            Long dwellTime = null;
            Boolean changed = null;
            BasicDBObject dbzone;
            String code = null;

            if (dbval != null) {
                time = (Date) dbval.get("time");
                dwellTime = (Long) dbval.get("dwellTime") / Utilities.getStep();
                changed = dbval.get("changed") == null ? false : (Boolean) dbval.get("changed");
                dbzone = (BasicDBObject) dbval.get("value");
                if (dbzone != null) {
                    code = dbzone.get("code").toString();
                }
            }


            result.add(new CodeValue(serialNumber, "zone", code, time, dwellTime, changed));
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format(step)) + "-->\t" + (code == null ? "" : code)
                    + "\t" + (time == null ? "" : time)
                    + "\t" + (dwellTime == null ? "" : (new SimpleDateFormat("HH:mm:ss")).format((new Date(
                    (dwellTime * Utilities.getStep() + Utilities.getDate())))))
                    + "\t" + (changed == null ? "" : changed));
            thingIds.put(dbo.get("serialNumber").toString(), (Long) dbo.get("_id"));
        }
        return result;
    }

    public static List<CodeValueStatus> casesStepDB(String serialNumber, String udf, Integer sort, Integer limit)
            throws Exception {
        MongoDAOUtils.getInstance().setupMongodb(Utilities.getMongoDB(), 27017, "riot_main", 2000000, 50, "admin",
                "control123!");
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValueStatus> result = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        query.put("value.serialNumber", serialNumber);
        BasicDBObject projection = new BasicDBObject();
        projection.append("time", 1);
        projection.append("value", 1);
        projection.append(udf, 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query, projection).sort(new
                BasicDBObject("time", sort)).limit(limit);

        System.out.println("Obtained result:");
        while (cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get(udf);
            BasicDBObject dbvalStatus = (BasicDBObject) dbo.get("status");

            Date step = (Date) doc.get("time");
            Date time = null;
            Long dwellTime = null;
            Boolean changed = null;
            BasicDBObject dbzone;
            String code = null;
            String valueStatus = null;
            Date timeStatus = null;
            Long dwellTimeStatus = null;
            Boolean changedStatus = null;

            Date timeGroup = null;
            Long dwellTimeGroup = null;
            Date timeType = null;
            Long dwellTimeType = null;
            Date timeFacility = null;
            Long dwellTimeFacility = null;

            if (dbval != null) {
                time = (Date) dbval.get("time");
                dwellTime = (Long) dbval.get("dwellTime") / Utilities.getStep();
                changed = dbval.get("changed") == null ? false : (Boolean) dbval.get("changed");
                dbzone = (BasicDBObject) dbval.get("value");
                if (dbzone != null) {
                    code = dbzone.get("code").toString();
                    timeGroup = (Date) dbzone.get("zoneGroupTime");
                    dwellTimeGroup = (Long) dbzone.get("zoneGroupDwellTime") / Utilities.getStep();
                    timeType = (Date) dbzone.get("zoneTypeTime");
                    dwellTimeType = (Long) dbzone.get("zoneTypeDwellTime") / Utilities.getStep();
                    timeFacility = (Date) dbzone.get("facilityMapTime");
                    dwellTimeFacility = (Long) dbzone.get("facilityMapDwellTime") / Utilities.getStep();
                }
            }
            if (dbvalStatus != null) {
                valueStatus = dbvalStatus.get("value").toString();
                timeStatus = (Date) dbvalStatus.get("time");
                dwellTimeStatus = (Long) dbvalStatus.get("dwellTime") / Utilities.getStep();
                changedStatus = dbvalStatus.get("changed") == null ? false : (Boolean) dbvalStatus.get("changed");
            }


            result.add(new CodeValueStatus(serialNumber, "zone", code, time, dwellTime, changed, "status", valueStatus,
                    timeStatus, dwellTimeStatus, changedStatus, timeGroup, dwellTimeGroup, timeType, dwellTimeType,
                    timeFacility, dwellTimeFacility));
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format(step)) + "-->\t" + (code == null ? "" : code)
                    + "\t" + (time == null ? "" : time)
                    + "\t" + (dwellTime == null ? "" : (new SimpleDateFormat("HH:mm:ss")).format((new Date(
                    (dwellTime * Utilities.getStep() + Utilities.getDate())))))
                    + "\t" + (changed == null ? "" : changed));
            thingIds.put(dbo.get("serialNumber").toString(), (Long) dbo.get("_id"));
        }
        return result;
    }

    public static List<CodeValue> casesStepDBThings(String serialNumber) throws Exception {
        MongoDAOUtils.getInstance().setupMongodb(Utilities.getMongoDB(), 27017, "riot_main", 2000000, 50, "admin",
                "control123!");
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValue> result = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        query.put("serialNumber", serialNumber);
        BasicDBObject projection = new BasicDBObject();
        projection.append("time", 1);
        projection.append("value", 1);
        projection.append("zone", 1);
        projection.append("serialNumber", 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingsCollection.find(query, projection).sort(new BasicDBObject
                ("time", 1));

        System.out.println("Last value:");
        while (cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            BasicDBObject dbval = (BasicDBObject) doc.get("zone");

            Date time = null;
            BasicDBObject dbzone;
            String code = null;

            if (dbval != null) {
                time = (Date) dbval.get("time");
                dbzone = (BasicDBObject) dbval.get("value");
                if (dbzone != null) {
                    code = dbzone.get("code").toString();
                }
            }


            result.add(new CodeValue(serialNumber, "zone", code, time, CustomNowTest.dwellReturn,
                    CustomNowTest.changedReturn));
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format(0)) + "-->\t" + (code == null ? "" : code)
                    + "\t" + (time == null ? "" : time)
                    + "\t" + (CustomNowTest.dwellReturn == null ? "" : (new SimpleDateFormat("HH:mm:ss")).format((new
                    Date(
                    (CustomNowTest.dwellReturn * Utilities.getStep() + Utilities.getDate())))))
                    + "\t" + CustomNowTest.changedReturn);

            thingIds.put(doc.get("serialNumber").toString(), (Long) doc.get("_id"));
        }
        return result;
    }

    public static void print(List<CodeValue> list) {
        System.out.println("Expected Result:");
        for (CodeValue code : list) {
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format((new Date(code
                    .getStep() * Utilities.getStep() + Utilities.getDate())))) + "-->\t" + (code.getCode() == null ?
                    "" : code
                    .getCode())
                    + "\t" + (code.getTime() == null ? "" : code.getTime())
                    + "\t" + (code.getDwellTime() == null ? "" : ((new SimpleDateFormat("HH:mm:ss")).format((new Date
                    (code
                    .getDwellTime() + Utilities.getDate())))))
                    + (code.getDwellTime() == null || code.getDwellTime() == 0 ? "\t" : "") + "\t"
                    + (code.getChanged() == null ? "" : code.getChanged()));
        }
    }

    public static List<CodeValue> case1Now1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, null, null, 4, 5));
        print(result);
        return result;
    }

    public static List<CodeValue> case1Now2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 2L, true, 2, 2));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 2L, true, 4, 4));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 1L, false, 4, 5));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.D.value, 3L, true, 6, 6));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.D.value, 1L, false, 6, 7));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.D.value, 2L, false, 6, 8));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 1L, true, 9, 9));
        result.add(new CodeValue(serialNumber, "zone", UDFHandler.zonesPopDB.B.value, 0L, true, 10, 10));
        print(result);
        return result;
    }

    public static List<CodeValueStatus> caseFromFile(String fileName) {
        String filePath = new File("").getAbsolutePath();
        List<CodeValueStatus> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath + "/resources/" + fileName + ".csv"));
            try {
                String line = br.readLine();
                line = br.readLine();
                while (line != null) {
                    List<String> data = Arrays.asList(line.split(","));
                    result.add(new CodeValueStatus(data.get(1), data.get(2), data.get(3), Long.parseLong(data.get(4)),
                            Boolean.valueOf(data.get(5)), Integer.parseInt(data.get(6)),
                            Integer.parseInt(data.get(0)), data.get(7), data.get(8), Long.parseLong(data.get(9)),
                            Boolean.valueOf(data.get(10)), Integer.parseInt(data.get(11)),
                            Integer.parseInt(data.get(12)), Long.parseLong(data.get(13)),
                            Integer.parseInt(data.get(14)), Long.parseLong(data.get(15)),
                            Integer.parseInt(data.get(16)), Long.parseLong(data.get(17))));
                    line = br.readLine();
                }
            } finally {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getRandomCase(String serialNumber, int init, int blinkCount, boolean flag) {
        List<String> data = new ArrayList<>();
        String lastZone = "_";
        Long dwellReturn = 0L;
        int timeReturn = 0;
        boolean changedReturn = false;
        boolean nexChange = true;
        for (int i = init; i <= blinkCount; i++) {
            changedReturn = false;
            String udf = UDFHandler.udfsPopDB.ranUdfPopDB().value;
            String value;
            switch (udf) {
                case "zone":
                    value = UDFHandler.zonesPopDB.ranZonePopDB().value;
                    if (value.compareTo(lastZone) != 0) {
                        dwellReturn = 0L;
                        timeReturn = i;
                        changedReturn = true;
//                    } else {
//                        dwellReturn = (long) (i - timeReturn);
                    }
                    lastZone = value;
                    break;
                case "status":
                    value = UDFHandler.statusPopDB.ranStatusPopDB().value;
                    dwellReturn = (long) (i - timeReturn);
                    break;
                default:
                    value = Utilities.getRanString(10);
            }
            if (nexChange && !flag) {
                if (CustomNowTest.dwellReturn != dwellReturn) {
                    CustomNowTest.dwellReturn = dwellReturn;
                }
                if (CustomNowTest.timeReturn != timeReturn) {
                    CustomNowTest.timeReturn = timeReturn;
                }
                if (CustomNowTest.changedReturn != changedReturn) {
                    CustomNowTest.changedReturn = changedReturn;
                }
                nexChange = false;
            }
            data.addAll(Utilities.getCase(serialNumber, udf, value, i));
        }
        if (flag) {
            CustomNowTest.dwellReturn = dwellReturn;
            CustomNowTest.timeReturn = timeReturn;
            CustomNowTest.changedReturn = changedReturn;
        }
        return data;
    }

    public static List<CodeValue> casesStepDBCustom(String serialNumber, int start, int end) throws Exception {
        MongoDAOUtils.getInstance().setupMongodb(Utilities.getMongoDB(), 27017, "riot_main", 2000000, 50, "admin",
                "control123!");
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        List<CodeValue> result = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        query.put("value.serialNumber", serialNumber);
        query.put("time", BasicDBObjectBuilder.start("$gte", new Date(Utilities.getDate() + Utilities.getStep() *
                start))
                .add("$lte", new Date(Utilities.getDate() + Utilities.getStep() * end)).get());
        BasicDBObject projection = new BasicDBObject();
        projection.append("time", 1);
        projection.append("value", 1);
        projection.append("zone", 1);
        projection.put("", serialNumber);
        DBCursor cursor = MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query, projection)
                .sort(new BasicDBObject("time", -1)).limit(1);

        System.out.println("Obtained result:");
        while (cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();
            BasicDBObject dbo = (BasicDBObject) doc.get("value");
            BasicDBObject dbval = (BasicDBObject) dbo.get("zone");

            Date step = (Date) doc.get("time");
            Date time = null;
            Long dwellTime = null;
            Boolean changed = null;
            BasicDBObject dbzone;
            String code = null;

            if (dbval != null) {
                time = (Date) dbval.get("time");
                dwellTime = (Long) dbval.get("dwellTime") / Utilities.getStep();
                changed = dbval.get("changed") == null ? false : (Boolean) dbval.get("changed");
                dbzone = (BasicDBObject) dbval.get("value");
                if (dbzone != null) {
                    code = dbzone.get("code").toString();
                }
            }


            result.add(new CodeValue(serialNumber, "zone", code, time, dwellTime, changed));
            System.out.println(((new SimpleDateFormat("HH:mm:ss")).format(step)) + "-->\t" + (code == null ? "" : code)
                    + "\t" + (time == null ? "" : time)
                    + "\t" + (dwellTime == null ? "" : (new SimpleDateFormat("HH:mm:ss")).format((new Date(
                    (dwellTime * Utilities.getStep() + Utilities.getDate())))))
                    + "\t" + (changed == null ? "" : changed));
            thingIds.put(dbo.get("serialNumber").toString(), (Long) dbo.get("_id"));
        }
        return result;
    }

}
