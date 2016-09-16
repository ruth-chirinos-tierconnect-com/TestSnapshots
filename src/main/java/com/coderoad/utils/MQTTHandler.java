package com.coderoad.utils;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dbascope on 9/16/16
 */
public class MQTTHandler {
    public static void publish(String mqttHost, int mqttPort, int qos, String topic, String body) throws MqttException {
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
                publish(Utilities.getMQTTHost(), Utilities.getMQTTPort(), Utilities.getMQTTQoS(), "/v1/data/" +
                        Utilities.getALECode() + "/" + Utilities.getThingType(), message);
                TimeUnit.SECONDS.sleep(Utilities.getSleep());
            }
        }
    }

}
