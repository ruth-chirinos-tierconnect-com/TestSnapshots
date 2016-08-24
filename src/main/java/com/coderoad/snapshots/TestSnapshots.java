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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

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
            MongoDAOUtils.getInstance().setupMongodb("localhost",27017,"riot_main",2000000,50,"admin","control123!");

            case1("CASE00001DBC");

            case2("CASE00002DBC");

            case3("CASE00003DBC");

            case4("CASE00004DBC");

            case5("CASE00005DBC");

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

    public static void compare (String serialNumber, int step) {
        SortedMap<String, Object> thingUdfValues = new TreeMap<>();
        SortedMap<String, Object> snapshotUdfValues = new TreeMap<>();
        try{
            File csvFile = new File("/home/dbascope/dev/TestSnapshots/output/"+serialNumber+"_step"+step+".csv");
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

    public static Map<String, String> case1 (String serialNumber) throws MqttException, InterruptedException {
        Map<String, String> data = new LinkedHashMap<>();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 0));
        data.putAll(BlinkData.getCase(serialNumber, "CLRCode", "None", 2));
        data.putAll(BlinkData.getCase(serialNumber, "zone", "317", 1));
        iterate(data);
        return data;
    }

    public static Map<String, String> case2 (String serialNumber) throws MqttException, InterruptedException {
        Map<String, String> data = new LinkedHashMap<>();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 0));
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 2));
        data.putAll(BlinkData.getCase(serialNumber, "zone", "317", 1));
        iterate(data);
        return data;
    }

    public static Map<String, String> case3 (String serialNumber) throws MqttException, InterruptedException {
        Map<String, String> data = new LinkedHashMap<>();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 0));
        data.putAll(BlinkData.getCase(serialNumber, "CLRCode", "Test", 2));
        data.putAll(BlinkData.getCase(serialNumber, "zone", "317", 1));
        iterate(data);
        return data;
    }

    public static Map<String, String> case4 (String serialNumber) throws MqttException, InterruptedException {
        Map<String, String> data = new LinkedHashMap<>();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 0));
        data.putAll(BlinkData.getCase(serialNumber, "CLRCode", "Test", 2));
        data.putAll(BlinkData.getCase(serialNumber, "CLRCode", "New", 1));
        iterate(data);
        return data;
    }

    public static Map<String, String> case5 (String serialNumber) throws MqttException, InterruptedException {
        Map<String, String> data = new LinkedHashMap<>();
        data.putAll(BlinkData.getCase(serialNumber, "zone", "183", 0));
        data.putAll(BlinkData.getCase(serialNumber, "zone", "317", 2));
        data.putAll(BlinkData.getCase(serialNumber, "zone", "446", 1));
        iterate(data);
        return data;
    }

    public static void iterate (Map<String, String> data) throws MqttException, InterruptedException {
        if ( (data != null) && (!data.isEmpty()) ) {
            for (Map.Entry<String, String> message : data.entrySet()) {
                System.out.println(message.getValue());
                publish0(mqttHost , mqttPort, qos, "/v1/data/ALEBBrooklands0/item", message.getValue());
                TimeUnit.SECONDS.sleep(2);
                //Check Mongo
                compare(message.getKey().substring(0, message.getKey().indexOf("_")), Integer.parseInt(message.getKey().substring(message.getKey().indexOf("_")+1)));
            }
        }
    }

}
