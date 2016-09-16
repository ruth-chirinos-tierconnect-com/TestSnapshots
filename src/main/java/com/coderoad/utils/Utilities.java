package com.coderoad.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
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
    private static Long   DATE          = 1471579200000L; //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
    private static int    STEP          = 3600000; //One hour
    private static String ALE_CODE      = "ALEB";
    private static String THING_TYPE    = "default_rfid_thingtype";
    private static String MONGO_DB      = "localhost";
    private static boolean CLEAN_THINGS = false;
    private static int    SLEEP         = 2;
    private static String SERVICES_URL  = "http://localhost:8080/riot-core-services";
    private static Map<String, Long> thingIds = new HashMap<>();


    public enum zonesPopDB {
        A("Enance"),B("Po1"),C("Saloor"),D("Stroom"),E("EnanceCP"),F("SaloorCP");
        public String value;

        zonesPopDB(String data) {
            this.value = data;
        }

        public static zonesPopDB ranZonePopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum udfsPopDB {
        A("zone"),B("status");
        public String value;

        udfsPopDB(String data) {
            this.value = data;
        }

        public static udfsPopDB ranUdfPopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum zonesMnS {
        A("BrooklandsExcluded"),B("DerbyExcluded"),C("FosseExcluded"),D("ReassociationBrooklands");
        public String value;

        zonesMnS(String data) {
            this.value = data;
        }

        public static zonesMnS ranZonePopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum udfsMnS {
        A("zone"),B("Status");
        public String value;

        udfsMnS(String data) {
            this.value = data;
        }

        public static udfsMnS ranUdfPopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum statusPopDB {
        A("None"),B("Free"),C("Paid"),D("Stolen"),E("Returned");
        public String value;

        statusPopDB(String data) {
            this.value = data;
        }

        public static statusPopDB ranStatusPopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public static String getRanString (int length){
        Random random = new Random();
        return new BigInteger(130, random).toString(32).substring(0, length);
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
        Long caseTimestamp = DATE + step * STEP;
        String sb = "" + "sn," + (int) ((step + 1) + Math.random() * 1000) +
                System.lineSeparator() +
                (new BlinkData(serialNumber, caseTimestamp, udf, value)).toString();
        data.add(sb);
        return data;
    }

    public static List<String> getCaseEndPoint(String serialNumber, String udf, String value, int step, String udf2,
                                               String value2) {
        List<String> data = new ArrayList<>();
        Long caseTimestamp = DATE + step * STEP;
        String sb = serialNumber+","+caseTimestamp+","+udf+","+value+","+udf2+","+value2;
        data.add(sb);
        return data;
    }

    public static List<String> getCaseBridge(String serialNumber, String udf, String value, int step, String udf2,
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

    public static boolean compareDataStatus(List<CodeValueStatus> testMap, List<CodeValueStatus> dataBaseMap) {
        int a = 0;
        for (CodeValueStatus codeValue : testMap) {
            if (!String.valueOf(dataBaseMap.get(a)).equals(codeValue.toString())){
                System.out.println("There are differences between results:\n\tExpected:\t"+codeValue.toString()+"\n\tObtained:\t"+dataBaseMap.get(a).toString());
                return false;
            } else {
                if( dataBaseMap.get(a).getName()!= null && !dataBaseMap.get(a).getName().equals(codeValue.getName())  ) {
                    System.out.println("Name-"+codeValue.toString()+"-"+codeValue.getName() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getCode()!= null && !dataBaseMap.get(a).getCode().equals(codeValue.getCode())  ) {
                    System.out.println("Code-"+codeValue.toString()+"-"+codeValue.getCode() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTime()!= null && dataBaseMap.get(a).getTime().compareTo(codeValue.getTime()) != 0 ) {
                    System.out.println("Time-"+codeValue.toString()+"-"+codeValue.getTime() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTime()!= null && dataBaseMap.get(a).getDwellTime().compareTo(codeValue.getDwellTime()) != 0 ) {
                    System.out.println("Dwelltime-"+codeValue.toString()+"-"+codeValue.getDwellTime() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getChanged()!= null && dataBaseMap.get(a).getChanged().compareTo(codeValue.getChanged()) != 0 ) {
                    System.out.println("Changed-"+codeValue.toString()+"-"+codeValue.getChanged() + " does not exist " +
                            "in DB" +
                            ".");
                    return false;
                } else if( dataBaseMap.get(a).getNameStatus()!= null && !dataBaseMap.get(a).getNameStatus().equals(codeValue
                        .getNameStatus())  ) {
                    System.out.println("Status-"+codeValue.toString()+"-"+codeValue.getNameStatus() + " does not " +
                            "exist in DB" +
                            ".");
                    return false;
                } else if( dataBaseMap.get(a).getCodeStatus()!= null && !dataBaseMap.get(a).getCodeStatus().equals(codeValue
                        .getCodeStatus())  ) {
                    System.out.println("CodeStatus-"+codeValue.toString()+"-"+codeValue.getCodeStatus() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeStatus()!= null && dataBaseMap.get(a).getTimeStatus().compareTo(codeValue
                        .getTimeStatus()) != 0 ) {
                    System.out.println("TimeStatus-"+codeValue.toString()+"-"+codeValue.getTimeStatus() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeStatus()!= null && dataBaseMap.get(a).getDwellTimeStatus().compareTo
                        (codeValue.getDwellTimeStatus()) != 0 ) {
                    System.out.println("DwellTimeStatus-"+codeValue.toString()+"-"+codeValue.getDwellTimeStatus() + "" +
                            " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getChangedStatus()!= null && dataBaseMap.get(a).getChangedStatus().compareTo
                        (codeValue.getChangedStatus()) != 0 ) {
                    System.out.println("ChangedStatus-"+codeValue.toString()+"-"+codeValue.getChangedStatus() + " " +
                            "does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeGroup()!= null && dataBaseMap.get(a).getTimeGroup().compareTo
                        (codeValue.getTimeGroup()) != 0 ) {
                    System.out.println("TimeGroup-"+codeValue.toString()+"-"+codeValue.getTimeGroup() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeGroup()!= null && dataBaseMap.get(a).getDwellTimeGroup()
                        .compareTo
                                (codeValue.getDwellTimeGroup()) != 0 ) {
                    System.out.println("DwellTImeGroup-"+codeValue.toString()+"-"+codeValue.getDwellTimeGroup() + " " +
                            "does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeType()!= null && dataBaseMap.get(a).getTimeType().compareTo
                        (codeValue
                                .getTimeType()) != 0 ) {
                    System.out.println("TimeType-"+codeValue.toString()+"-"+codeValue.getTimeType() + " does not " +
                            "exist " +
                            "in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeType()!= null && dataBaseMap.get(a).getDwellTimeType()
                        .compareTo
                                (codeValue.getDwellTimeType()) != 0 ) {
                    System.out.println("DwellTimeType-"+codeValue.toString()+"-"+codeValue.getDwellTimeType() + " " +
                            "does" +
                            " not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeFacility()!= null && dataBaseMap.get(a).getTimeFacility().compareTo
                        (codeValue.getTimeFacility()) != 0 ) {
                    System.out.println("TimeFacility-"+codeValue.toString()+"-"+codeValue.getTimeFacility() + " does " +
                            "not exist" +
                            " in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeFacility()!= null && dataBaseMap.get(a).getDwellTimeFacility()
                        .compareTo
                                (codeValue.getDwellTimeFacility()) != 0 ) {
                    System.out.println("DwellTimeFacility-"+codeValue.toString()+"-"+codeValue.getDwellTimeFacility() +
                            " does not " +
                            "exist in DB.");
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
            String filePath = new File("").getAbsolutePath();
            File csvFile = new File(filePath+"/output/"+serialNumber+"_step"+step+".csv");
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
//                httpURLConnection.setRequestProperty("Api_key", "7B4BCCDC");
                httpURLConnection.setRequestProperty("Api_key", "root");
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
                        Utilities.getCaseEndPoint(data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(0))
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
                        Utilities.getCaseBridge(data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(0))
                                , data.get(4), data.get(5)));
                line = br.readLine();
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean thingExists(Long thingId){
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(SERVICES_URL + "/api/thing/"+String.valueOf(thingId));
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
//            httpURLConnection.setRequestProperty("Api_key", "7B4BCCDC");
            httpURLConnection.setRequestProperty("Api_key", "root");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection.getResponseCode() == 200;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

    }

    public static Long createThing(String body){
        HttpURLConnection httpURLConnection = null;
        DataOutputStream dataOutputStream;
        try {
            URL url = new URL(SERVICES_URL + "/api/thing");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
//            httpURLConnection.setRequestProperty("Api_key", "7B4BCCDC");
            httpURLConnection.setRequestProperty("Api_key", "root");
            httpURLConnection.setRequestProperty("useDefaultValue", "true");
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeChars(body);
            if (httpURLConnection.getResponseCode() == 200){
                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(httpURLConnection.getInputStream());
                return Long.parseLong(node.get("thing").get("id").toString());
            } else {
                return 0L;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return 0L;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public static boolean updateThing(Long thingId, String body){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPatch request = new HttpPatch( SERVICES_URL + "/api/thing/"+String.valueOf(thingId) );
        request.addHeader("Content-Type", "application/json");
//        request.addHeader("Api_key", "7B4BCCDC");
        request.addHeader("Api_key", "root");
        StringEntity entity = new StringEntity( body, ContentType.create( "application/json", "UTF-8" ) );
        request.setEntity( entity );
        try {
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                response.close();
                return true;
            } else {
                response.close();
                return false;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Long sendEndPoint(String data, Long thingId) {
        if ( (data != null) && (!data.isEmpty()) ) {
            System.out.println("Sending to endpoint...");

            List<String> messList = Arrays.asList(data.split(","));
            JSONObject bjson = new JSONObject();
            bjson.put("group", ">MOJIX>SM");
            bjson.put("thingTypeCode", "default_rfid_thingtype");
            bjson.put("name", messList.get(0));
            bjson.put("serialNumber", messList.get(0));
            JSONObject udfs = new JSONObject();
            JSONObject zone = new JSONObject();
            zone.put("value", messList.get(3));
            udfs.put(messList.get(2),zone);
            if (!messList.get(5).equals("null")) {
                JSONObject status = new JSONObject();
                status.put("value", messList.get(5));
                udfs.put(messList.get(4), status);
            }
            bjson.put("udfs", udfs);
            bjson.put("time", messList.get(1));
            if (thingId == 0L){
                return createThing(bjson.toString());
            } else {
                updateThing(thingId, bjson.toString());
                return thingId;
            }
        } else {
            return 0L;
        }
    }
}
