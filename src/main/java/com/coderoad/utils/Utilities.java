package com.coderoad.utils;

import com.coderoad.snapshots.BlinkData;
import com.coderoad.snapshots.MongoDAOUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.types.Code;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by RUTH on 16/08/21.
 */
public class Utilities {

    private static String MQTT_HOST  = "localhost";
    private static int    MQTT_PORT  = 1883;
    private static int    QOS        = 2;
    private static String PATH       = "C:/ini_ruth/WorkMojix/Vizix/";
    private static String MONGODB    = "localhost";
    public  static Long   DATE       = 1471579200000L; //Fri Aug 19 2016 00:00:00 GMT-0400 (BOT)
    private static String ALE_CODE   = "ALEB";
    private static String THING_TYPE = "default_rfid_thingtype";
    public  static String MONGO_DB   = "localhost";

    public enum zonesPopDB {
        Enance("Enance"),Po1("Po1"),Saloor("Saloor"),Stroom("Stroom");
        public String value;

        zonesPopDB(String data) {
            this.value = data;
        }
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
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }

    /**
     *  Set case to be executed
     * @param serialNumber
     * @param udf
     * @param value
     * @param step
     * @return
     */
    public static List<String> getCase(String serialNumber, String udf, String value, int step) {
        List<String> data = new ArrayList<>();
        StringBuilder sb =  new StringBuilder("");
        sb.append("sn,"+(int)((step+1)+Math.random()*1000));
        sb.append(System.lineSeparator());
        Long caseTimestamp = DATE + step * 3600000;
        sb.append((new BlinkData(serialNumber,caseTimestamp,udf,value)).toString());
        data.add(sb.toString());
        return data;
    }

    /**
     * Compare Data
     * @param testMap
     * @param dataBaseMap
     * @return
     */
    public static boolean compareData(List<CodeValue> testMap, List<CodeValue> dataBaseMap) {
        boolean response  = true;
        for (CodeValue codeValue : testMap) {
            int a = dataBaseMap.indexOf(codeValue);
            if( a == -1) {
                System.out.println(codeValue.getName() + " does not exist in DB.");
                return false;
            } else {
                if( !dataBaseMap.get(a).getName().equals(codeValue.getName())  ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getName() + " does not exist in DB.");
                    return false;
                } else if( !dataBaseMap.get(a).getType().equals(codeValue.getType())  ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getType() + " does not exist in DB.");
                    return false;
                } else if( !dataBaseMap.get(a).getValue().equals(codeValue.getValue())  ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getValue() + " does not exist in DB.");
                    return false;
                }
            }
        }
        return response;
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
                for (Iterator<DBObject> it = cursor.iterator(); it.hasNext(); ) {
                    BasicDBObject doc = (BasicDBObject) it.next();
                    thingUdfValues = getUDFs(doc, "");
                }

                DBObject sort= new BasicDBObject();
                query = new BasicDBObject();
                query.put("value._id", thingUdfValues.get("_id"));
                sort.put("time", -1);
                MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query).sort(sort).limit(1);
                for (Iterator<DBObject> it = cursor.iterator(); it.hasNext(); ) {
                    BasicDBObject doc = (BasicDBObject) it.next();
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
}
