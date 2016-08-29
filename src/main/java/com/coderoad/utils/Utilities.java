package com.coderoad.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by RUTH on 16/08/21.
 * Contains utilities for test cases
 */
public class Utilities {

    private static String MQTT_HOST     = "localhost";
    private static int    MQTT_PORT     = 1883;
    private static int    QOS           = 2;
    private static String PATH          = "/home/dev/";
    private static Long   DATE          = 1471579200000L; //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
    private static int    STEP          = 3600000; //One hour
    private static String ALE_CODE      = "ALEB";
    private static String THING_TYPE    = "default_rfid_thingtype";
    private static String MONGO_DB      = "localhost";
    private static boolean CLEAN_THINGS = false;
    private static int    SLEEP         = 2; //One hour
    private static String SERVICES_URL  = "http://localhost:8080/riot-core-services";
    private static Map<String, Long> thingIds = new HashMap<>();



    public enum zonesPopDB {
        A("Enance"),B("Po1"),C("Saloor"),D("Stroom"),E("EnanceCP"),F("SaloorCP");
        public String value;

        zonesPopDB(String data) {
            this.value = data;
        }
    }

    public enum zonesMnS {
        A("BrooklandsExcluded"),B("DerbyExcluded"),C("FosseExcluded"),D("ReassociationBrooklands");
        public String value;

        zonesMnS(String data) {
            this.value = data;
        }
    }

    public static Long getDate(){
        return DATE;
    }

    public static int getStep(){
        return STEP;
    }

    public static String getMongoDB(){
        return MONGO_DB;
    }

    public static Map<String, Long> getThingIds(){
        return thingIds;
    }

    /**
     * This method publics messages through MQTT to COreBridge
     * @param mqttHost IP of the MQTT
     * @param mqttPort Port of the MQTT
     * @param qos Quality of Service Level = 2
     * @param topic Topic of the message
     * @param body Body of the message
     * @throws org.eclipse.paho.client.mqttv3.MqttException
     */
    public static void publish0(String mqttHost, int mqttPort, int qos, String topic, String body) throws MqttException {
        String serverURI = "tcp://" + mqttHost + ":" + mqttPort;
        MemoryPersistence persistence = new MemoryPersistence();
        MqttClient client = new MqttClient(serverURI, "unitTest", persistence);
        MqttConnectOptions co = new MqttConnectOptions();
        client.connect(co);
        co.setCleanSession(true);

        MqttMessage message = new MqttMessage(body.getBytes());
        message.setQos(qos);
        client.publish(topic, message);
        client.disconnect();
    }

    /**
     * This method send messsages as Tickles to the CORE Bridges
     * @param data Map of messages
     * @throws MqttException
     * @throws InterruptedException
     */
    public static void sendTickles (List<String> data) throws MqttException, InterruptedException {
        if ( (data != null) && (!data.isEmpty()) ) {
            for (String message : data) {
                System.out.println(message);
                publish0(MQTT_HOST, MQTT_PORT, QOS, "/v1/data/" + ALE_CODE + "/" + THING_TYPE, message);
                TimeUnit.SECONDS.sleep(SLEEP);
            }
        }
    }

    /**
     *  Set case to be executed
     * @param serialNumber: serialNumber to create thing
     * @param udf: udf name
     * @param value: udf value
     * @param step: step of test
     * @return data for message
     */
    public static List<String> getCase(String serialNumber, String udf, String value, int step) {
        List<String> data = new ArrayList<>();
        Long caseTimestamp = DATE + step * Utilities.STEP;
        String sb = "" + "sn," + (int) ((step + 1) + Math.random() * 1000) +
                System.lineSeparator() +
                (new BlinkData(serialNumber, caseTimestamp, udf, value)).toString();
        data.add(sb);
        return data;
    }

    /**
     * Compare Data
     * @param testMap: Map result from test
     * @param dataBaseMap: Map result from database
     * @return false if there are differences between maps
     */
    public static boolean compareData(List<CodeValue> testMap, List<CodeValue> dataBaseMap) {
        int a = 0;
        for (CodeValue codeValue : testMap) {
            if (!String.valueOf(dataBaseMap.get(a)).equals(codeValue.toString())){
                System.out.println("There are differences between results:\n\tExpected:\t"+codeValue.toString()+"\n\tObtained:\t"+dataBaseMap.get(a).toString());
                return false;
            } else {
                if( dataBaseMap.get(a).getName()!= null && !dataBaseMap.get(a).getName().equals(codeValue.getName())  ) {
                    System.out.println("Name-"+codeValue.toString()+"-"+codeValue.getName() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getCode()!= null && !dataBaseMap.get(a).getCode().equals(codeValue.getCode())  ) {
                    System.out.println(""+codeValue.toString()+"-"+codeValue.getCode() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTime()!= null && dataBaseMap.get(a).getTime().compareTo(codeValue.getTime()) != 0 ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getTime() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTime()!= null && dataBaseMap.get(a).getDwellTime().compareTo(codeValue.getDwellTime()) != 0 ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getDwellTime() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getChanged()!= null && dataBaseMap.get(a).getChanged().compareTo(codeValue.getChanged()) != 0 ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getChanged() + " does not exist in DB.");
                    return false;
                }
            }
            a++;
        }
        return true;
    }

    public static void compare (String serialNumber, int step) {
        SortedMap<String, Object> thingUdfValues = new TreeMap<>();
        SortedMap<String, Object> snapshotUdfValues = new TreeMap<>();
        try{
            File csvFile = new File(PATH+"TestSnapshots/output/"+serialNumber+"_step"+step+".csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));

            //Check Mongo
            try{
                DBObject query = new BasicDBObject();
                query.put("serialNumber", serialNumber);
                DBCursor cursor = MongoDAOUtils.getInstance().thingsCollection.find(query);
                for (DBObject aCursor1 : cursor) {
                    BasicDBObject doc = (BasicDBObject) aCursor1;
                    thingUdfValues = getUDFs(doc, "");
                }

                DBObject sort= new BasicDBObject();
                query = new BasicDBObject();
                query.put("value._id", thingUdfValues.get("_id"));
                sort.put("time", -1);
                MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query).sort(sort).limit(1);
                for (DBObject aCursor : cursor) {
                    BasicDBObject doc = (BasicDBObject) aCursor;
                    snapshotUdfValues = getUDFs(doc, "");
                }

                bw.write("Thing UDF,Value,Control,Snapshot UDF,Value");
                for(Map.Entry<String,Object> entry : thingUdfValues.entrySet()) {
                    bw.write(System.lineSeparator()+entry.getKey()+","+entry.getValue()+",");
                    if (snapshotUdfValues.containsKey(entry.getKey())){
                        if (entry.getValue()!=null && (entry.getValue()).equals(snapshotUdfValues.get(entry.getKey()))){
                            bw.write("OK,"+entry.getKey()+","+snapshotUdfValues.get(entry.getKey()));
                        }else if (entry.getValue()==null && snapshotUdfValues.get(entry.getKey())==null) {
                            bw.write("OK,null,null");
                        }else {
                            bw.write("ERROR,"+entry.getKey()+","+snapshotUdfValues.get(entry.getKey()));
                        }
                    }else{
                        bw.write("ERROR,,");
                    }
                }
                bw.close();

            }
            catch(UnknownHostException e){
                e.printStackTrace();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SortedMap<String, Object> getUDFs (BasicDBObject doc, String key){
        SortedMap<String, Object> udfValues = new TreeMap<>();
        try {
            for (Map.Entry<String, Object> entry : doc.entrySet()) {
                if (entry.getValue() instanceof BasicDBObject) {
                    udfValues.putAll(getUDFs((BasicDBObject) entry.getValue(), entry.getKey()));
                } else {
                    if (!String.valueOf(key).isEmpty()) {
                        udfValues.put(key + "." + entry.getKey(), entry.getValue().toString().replace(",", ";"));
                    } else {
                        udfValues.put(entry.getKey(), entry.getValue());
                    }

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return udfValues;
    }

    public static void cleanUp (){
        if (CLEAN_THINGS) {
            System.out.println("Removing test things...");

            String body = "[";
            int i = 0;
            int things = thingIds.size();
            for (Map.Entry<String, Long> entry : thingIds.entrySet()) {
                body += "{\"id\": " + entry.getValue() + "}";
                i++;
                if (i < things) {
                    body += ',';
                }
            }
            body += "]";

            HttpURLConnection httpURLConnection = null;
            DataOutputStream dataOutputStream;
            try {
                URL url = new URL(SERVICES_URL + "/api/thing/batchDelete");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Api_key", "7B4BCCDC");
                httpURLConnection.setRequestMethod("DELETE");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeChars(body);
                System.out.println(httpURLConnection.getResponseCode() + ": " + httpURLConnection.getResponseMessage());
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }

    public static List<String> readFile (String fileName, int sequence){
        Long dateTimestamp = 1470009600000L;
        dateTimestamp = dateTimestamp + 3600000L;
        List<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/dev/TestSnapshots/src/main/resources/"+fileName));
            try {
                StringBuilder sb = new StringBuilder("");
                String line = br.readLine();
                line = line.replace("&", sequence+"");
                line = line.replace("#", dateTimestamp+"");
                int count = 1;
                int position = 0;
                while (line != null) {
                    position = Integer.parseInt(line.subSequence(0,1)+"");

                    if (position != count ) {
                        result.add((count-1), sb.toString());
                        sb = new StringBuilder();
                        count = position;
                        dateTimestamp = dateTimestamp + 3600000L;
                    }
                    line = line.replace("&", sequence+"");
                    line = line.replace("#", dateTimestamp+"");
                    sb.append("sn," + (int) ((1 + Math.random() * 1000)));
                    sb.append(line.substring(2, line.length()));
                    line = br.readLine();
                    List<String> data = new ArrayList<>();

//                    result.addAll(Utilities.getCase(serialNumber, udf, value, step));

                }
                if ((sb!=null) && (sb.length()>0)) {
                    result.add((count-1), sb.toString());
                }
            } finally {
                br.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
