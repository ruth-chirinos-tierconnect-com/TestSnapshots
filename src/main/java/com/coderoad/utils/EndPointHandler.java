package com.coderoad.utils;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by dbascope on 9/16/16
 */
public class EndPointHandler {

    private static String ENDPOINT_URL = "http://localhost:8080/riot-core-services";

    public static boolean thingExists(Long thingId){
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(ENDPOINT_URL + "/api/thing/"+String.valueOf(thingId));
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
            URL url = new URL(ENDPOINT_URL + "/api/thing");
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
        HttpPatch request = new HttpPatch( ENDPOINT_URL + "/api/thing/"+String.valueOf(thingId) );
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

    public static void cleanUp (){
        if (Utilities.getCleanThings()) {
            System.out.println("Removing test things...");

            String body = "[";
            int i = 0;
            int things = Utilities.getThingIds().size();
            for (Map.Entry<String, Long> entry : Utilities.getThingIds().entrySet()) {
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
                URL url = new URL(ENDPOINT_URL + "/api/thing/batchDelete");
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

}
