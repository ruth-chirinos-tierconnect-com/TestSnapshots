package com.coderoad.utils;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by RUTH on 16/08/21.
 * Contains utilities for test cases
 */
public class Utilities {

    private static String MQTT_HOST     = "localhost";
    private static int    MQTT_PORT     = 1883;
    private static int    MQTT_QoS           = 2;
    private static String ALE_CODE      = "ALEB";
    private static String THING_TYPE    = "default_rfid_thingtype";
    private static Long   DATE          = 1471579200000L; //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
    private static int    STEP          = 3600000; //One hour
    private static String MONGO_DB      = "localhost";
    private static boolean CLEAN_THINGS = false;
    private static int    SLEEP         = 2;
    private static Map<String, Long> thingIds = new HashMap<>();

    public static Long getDate(){
        return DATE;
    }

    public static int getStep(){
        return STEP;
    }

    public static String getMongoDB(){
        return MONGO_DB;
    }

    public static String getMQTTHost(){
        return MQTT_HOST;
    }

    public static int getMQTTPort(){
        return MQTT_PORT;
    }

    public static int getMQTTQoS(){
        return MQTT_QoS;
    }

    public static String getALECode(){
        return ALE_CODE;
    }

    public static String getThingType(){
        return THING_TYPE;
    }

    public static int getSleep(){
        return SLEEP;
    }

    public static boolean getCleanThings(){
        return CLEAN_THINGS;
    }

    public static Map<String, Long> getThingIds(){
        return thingIds;
    }

    public static String getRanString (int length){
        Random random = new Random();
        return new BigInteger(130, random).toString(32).substring(0, length);
    }

    public static List<String> getCase(String serialNumber, String udf, String value, int step) {
        List<String> data = new ArrayList<>();
        Long caseTimestamp = DATE + step * STEP;
        String sb = "" + "sn," + (int) ((step + 1) + Math.random() * 1000) +
                System.lineSeparator() +
                (new BlinkData(serialNumber, caseTimestamp, udf, value)).toString();
        data.add(sb);
        return data;
    }

    public static List<String> makeCaseEndPoint(String serialNumber, String udf, String value, int step, String udf2,
                                                String value2) {
        List<String> data = new ArrayList<>();
        Long caseTimestamp = DATE + step * STEP;
        String sb = serialNumber+","+caseTimestamp+","+udf+","+value+","+udf2+","+value2;
        data.add(sb);
        return data;
    }

    public static List<String> makeCaseBridge(String serialNumber, String udf, String value, int step, String udf2,
                                              String value2) {
        List<String> data = new ArrayList<>();
        Long caseTimestamp = DATE + step * STEP;
        String sb = "" + "sn," + (int) ((step + 1) + Math.random() * 1000) +
                System.lineSeparator() + serialNumber+","+caseTimestamp+","+udf+","+value;
        if (!value2.equals("null")){
            sb += System.lineSeparator() + serialNumber+","+caseTimestamp+","+udf2+","+value2;
        }
        data.add(sb);
        return data;
    }

    public static List<String> blinkFromFile (String fileName){
        String filePath = new File("").getAbsolutePath();
        List<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath+"/resources/"+fileName));
            String line = br.readLine();
            while (line != null) {
                List<String> data = Arrays.asList(line.split(","));
                result.addAll(
                        Utilities.getCase(data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(0))));
                line = br.readLine();
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> blinkFromFileEndPoint(String fileName){
        String filePath = new File("").getAbsolutePath();
        List<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath+"/resources/"+fileName));
            String line = br.readLine();
            while (line != null) {
                List<String> data = Arrays.asList(line.split(","));
                result.addAll(
                        Utilities.makeCaseEndPoint(data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(0))
                                , data.get(4), data.get(5)));
                line = br.readLine();
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> blinkFromFileBridge (String fileName){
        String filePath = new File("").getAbsolutePath();
        List<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath+"/resources/"+fileName));
            String line = br.readLine();
            while (line != null) {
                List<String> data = Arrays.asList(line.split(","));
                result.addAll(
                        Utilities.makeCaseBridge(data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(0))
                                , data.get(4), data.get(5)));
                line = br.readLine();
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
