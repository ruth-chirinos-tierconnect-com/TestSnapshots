package com.coderoad.results;

import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case1Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case2Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 3L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case2Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 3L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case3Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case3Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
//                     CodeValue(serialNumber, name,   code,                    dwellTime,changed,timeSnapshot,step) {
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case4Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 3L, false, 2, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case4Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 3L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case5Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 2L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.D.value, 1L, true, 2,
                2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 2L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case5Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.D.value, 1L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 0L, true, 5, 5));
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
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case6Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case6Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", null, null, null, null, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case7Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 2L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 2L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case7Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.B.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case8Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 2, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 3L, false, 2, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case8Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 3L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, false, 1, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.C.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

    public static List<CodeValue> case9Step1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 0L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 4L, false, 1, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case9Step2(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.E.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.E.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case9Older0(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 1L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.F.value, 1L, true, 2, 2));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.E.value, 0L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.E.value, 2L, false, 3, 5));
        CasesResults.print(result);
        return result;
    }
    public static List<CodeValue> case9Older1(String serialNumber) {
        List<CodeValue> result = new ArrayList<>();
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.A.value, 2L, true, 1, 1));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.E.value, 1L, true, 3, 3));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.F.value, 0L, true, 4, 4));
        result.add(new CodeValue(serialNumber,"zone", Utilities.zonesPopDB.F.value, 1L, false, 4, 5));
        CasesResults.print(result);
        return result;
    }

}
