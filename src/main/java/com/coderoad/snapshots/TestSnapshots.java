package com.coderoad.snapshots;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<String> data = readFile("ChangeZone.txt", sequence);
            //Send MQTT message to the Core
            if ( (data != null) && (!data.isEmpty()) ) {
                for( String message : data ) {
                    System.out.println(message);
                    publish0(mqttHost , mqttPort, qos, "/v1/data/ALEBBrooklands0/item", message);
                }
            }
            //Check Mongo
            try{
                MongoDAOUtils.getInstance().setupMongodb("localhost",27017,"riot_main",2000000,50,"admin","control123!");
                DBObject query = new BasicDBObject();
                MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query);

            }
            catch(UnknownHostException e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        PROD
        db.getCollection('things').find({"serialNumber":"3039ECBC014E44012A05F27B"})
        db.getCollection('thingSnapshotIds').find({_id:11568756})
        db.getCollection('thingSnapshots').find({"value._id":11568756},
{"value.zone":1, "value.DressingRoom":1, "tvalue.sCoreIn":1, "value.source":1}).sort({"time":-1})

        10.100.1.30
        db.getCollection('things').find({"serialNumber":"0000000000000000000RC006"}
,{"zone":1, "DressingRoom":1, "tsCoreIn":1, "source":1, "time":1, "modifiedTime":1}
)
        db.getCollection('thingSnapshotIds').find({_id:9587066})
        db.getCollection('thingSnapshots').find({"value._id":9587066}
,{"value.zone":1, "value.DressingRoom":1, "value.tsCoreIn":1, "value.source":1, "value.modifiedTime":1, "time":1}
).sort({"time":-1})



        * */
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
//        1470009600000
//        1470013200000
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

}
