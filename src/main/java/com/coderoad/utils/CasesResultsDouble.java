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
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 * @date : 8/26/16 10:44 AM
 * @version:
 */
public class CasesResultsDouble {

    public static Map<String, Long> thingIds = new HashMap<>();

    public static List<CodeValue> case1Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case2Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {

        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case3Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case4Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 3L, false, 2, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case5Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 2L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.ReassociationBrooklands.value, 1L, true, 2,
                2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 2L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.ReassociationBrooklands.value, 1L, true, 4,
                4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case6Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case6Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case6OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, false, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case6OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case7Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 2L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.DerbyExcluded.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case8Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8OlderB(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 2L, false, 2, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8OlderA(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesMnS.FosseExcluded.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

}
