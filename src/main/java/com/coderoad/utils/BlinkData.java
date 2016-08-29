package com.coderoad.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rchirinos
 * @date : 8/18/16 6:47 PM
 * @version:
 */
public class BlinkData {
    private String serialNumber;
    private Long timestamp;
    private String property;
    private String value;

    public BlinkData(String serialNumber, Long timestamp, String property, String value) {
        this.serialNumber = serialNumber;
        this.timestamp = timestamp;
        this.property  = property;
        this.value = value;
    }

    /**
     * Case 1 , Incremental changes
     * @return data
     */
    public static List<String> getCase1(String serialNumber) {
        //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
        List<String> data = new ArrayList<>();
        StringBuilder sb =  new StringBuilder("");
        sb.append("sn,5");
        sb.append(System.lineSeparator());
        data.add((new BlinkData(serialNumber,1471579200000L,"zone","S5241-L0-Sales")).toString());
        sb.append(System.lineSeparator());
        data.add((new BlinkData(serialNumber,1471582800000L,"zone","S5241-L0-Sales")).toString());
        sb.append(System.lineSeparator());
        data.add((new BlinkData(serialNumber,1471586400000L,"zone","S5241-L0-Sales")).toString());
        sb.append(System.lineSeparator());
        data.add((new BlinkData(serialNumber,1471590000000L,"zone","S5241-L0-Sales")).toString());
        return data;
    }

    /**
     * Case 1 , Incremental changes
     * @return data
     */
    public static List<String> getCase0(String serialNumber) {
        //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
        List<String> data = new ArrayList<>();
        StringBuilder sb =  new StringBuilder("");
        sb.append("sn,5");
        sb.append(System.lineSeparator());
        sb.append((new BlinkData(serialNumber,1471579200000L,"zone","S5241-L0-Sales")).toString());
        data.add(sb.toString());
        return data;
    }

    public static Map<String, String> getCase(String serialNumber, String udf, String value, int step) {
        //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
        Map<String, String> data = new LinkedHashMap<>();
        StringBuilder sb =  new StringBuilder("");
        sb.append("sn,"+(int)((step+1)+Math.random()*1000));
        sb.append(System.lineSeparator());
        Long caseTimestamp = Utilities.getDate() + step * Utilities.getStep();
        sb.append((new BlinkData(serialNumber,caseTimestamp,udf,value)).toString());
        data.put(serialNumber+"_"+step, sb.toString());
        return data;
    }

    @Override
    public String toString() {
        return serialNumber+","+timestamp+","+property+","+value;
    }
}
