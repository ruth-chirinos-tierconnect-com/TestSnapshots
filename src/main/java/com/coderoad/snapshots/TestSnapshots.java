package com.coderoad.snapshots;

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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rchirinos
 * @date : 8/17/16 4:47 PM
 * @version:
 */
public class TestSnapshots {

    private static String mqttHost = "localhost";
    private static int mqttPort = 1883;
    private static int qos = 2;

    public static void main(String[] args) {
        try {
            int sequence = 10002;
            String serialNumber = "RCC1000000005";
            List<String> data = BlinkData.getCase0(serialNumber);
            //Send MQTT message to the Core
            if ( (data != null) && (!data.isEmpty()) ) {
                for( String message : data ) {
                    System.out.println(message);
                    publish0(mqttHost , mqttPort, qos, "/v1/data/ALEBBrooklands0/item", message);
                }
            }
            //Check Mongo
            compare(serialNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static private void publish0(String mqttHost, int mqttPort, int qos, String topic, String body) throws MqttException {
        // logger.info( "SENDING MQTT MESSAGE: " + mqttHost + ":" + mqttPort +
        // "- topic='" + topic + "' body='" + body + "'" );

        String serverURI = "tcp://" + mqttHost + ":" + mqttPort;
        MemoryPersistence persistence = new MemoryPersistence();

        MqttClient client = new MqttClient(serverURI, "unitTest", persistence);

        MqttConnectOptions co = new MqttConnectOptions();
        co.setCleanSession(true);
        client.connect(co);

        MqttMessage message = new MqttMessage(body.getBytes());
        message.setQos(qos);

        client.publish(topic, message);
        client.disconnect();
    }

    /**
     * Get info of the filename
     * @param fileName
     * @return
     */
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
                    sb.append("sn,5");
                    sb.append(System.lineSeparator());
                    sb.append(line.substring(2, line.length()));
                    sb.append(System.lineSeparator());
                    line = br.readLine();
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

    public static void compare (String serialNumber) {
        SortedMap<String, Object> thingUdfValues = new TreeMap<>();
        SortedMap<String, Object> snapshotUdfValues = new TreeMap<>();
        try{
            File csvFile = new File("/home/dev/TestSnapshots/output/compareSerial_"+serialNumber+".csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));

            //Check Mongo
            try{
                MongoDAOUtils.getInstance().setupMongodb("10.100.1.30",27017,"riot_main",2000000,50,"admin","control123!");
                DBObject query = new BasicDBObject();
                query.put("serialNumber", serialNumber);
                DBCursor cursor = MongoDAOUtils.getInstance().thingsCollection.find(query);
                for (Iterator<DBObject> it = cursor.iterator(); it.hasNext(); ) {
                    BasicDBObject doc = (BasicDBObject) it.next();
                    thingUdfValues = getUDFs(doc, "");
                }

                MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query);
                for (Iterator<DBObject> it = cursor.iterator(); it.hasNext(); ) {
                    BasicDBObject doc = (BasicDBObject) it.next();
                    snapshotUdfValues = getUDFs(doc, "");
                }

                bw.write("Thing UDF,Value,Control,Snapshot UDF,Value");
                for(Map.Entry<String,Object> entry : thingUdfValues.entrySet()) {
                    bw.write(System.lineSeparator()+entry.getKey()+","+entry.getValue()+",");
                    if (snapshotUdfValues.containsKey(entry.getKey())){
                        if ((entry.getValue()).toString().equals(snapshotUdfValues.get(entry.getKey()).toString())){
                            bw.write("OK,"+entry.getKey()+","+snapshotUdfValues.get(entry.getKey()));
                        }else{
                            System.out.println(entry.getValue().toString()+"<>"+snapshotUdfValues.get(entry.getKey()).toString());
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
            System.out.println("Cannot create temp file for report");
        }
    }

    public static SortedMap<String, Object> getUDFs (BasicDBObject doc, String key){
        SortedMap<String, Object> udfValues = new TreeMap<>();
        for (Map.Entry<String, Object> entry : doc.entrySet()) {
            if (entry.getValue() instanceof BasicDBObject) {
                udfValues.putAll(getUDFs((BasicDBObject) entry.getValue(), entry.getKey()));
            } else {
                if (String.valueOf(key) != ""){
                    udfValues.put(key+"."+entry.getKey(), entry.getValue().toString().replace(",",";"));
                } else {
                    udfValues.put(entry.getKey(), entry.getValue().toString().replace(",",";"));
                }

            }
        }
        return udfValues;
    }


}
