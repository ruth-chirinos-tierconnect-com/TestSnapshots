package com.coderoad.test;

import com.coderoad.snapshots.MongoDAOUtils;
import com.coderoad.utils.CasesResults;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 * @date : 8/25/16 5:48 PM
 * @version:
 */
public class CustomNowTest {
    String SERIAL_TEST = "REPORT10";
    boolean CLEAN_THINGS = false;
    String SERVICES_URL = "http://localhost:8080/riot-core-services";
    Map<String, Long> thingIds = new HashMap<>();

    @BeforeClass(alwaysRun = true)
    public void initMongo() throws UnknownHostException {
        MongoDAOUtils.getInstance().setupMongodb(Utilities.MONGO_DB,27017,"riot_main",2000000,50,"admin","control123!");
    }

    @Test(description = "[t1,t2,t3,t4,t5][A,B,B,C,C]")
    public void testCase1Now() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 2));
            data.addAll(Utilities.getCase(serialNumber, "Status", "None", 3));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            data.addAll(Utilities.getCase(serialNumber, "Status", "Open", 5));
            Utilities.sendTickles(data);
//
//
//            List<CodeValue> testData = CasesResults.case1Now1(serialNumber);
//            List<CodeValue> resultDB = CasesResults.casesStepDBThings(serialNumber);
//
//            thingIds.putAll(CasesResults.thingIds);
//            Assert.assertEquals(testData.size()== resultDB.size(), true
//                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
//            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );
//
//            data.clear();
//            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.ReassociationBrooklands.value, 11));
//            data.addAll(Utilities.getCase(serialNumber, "Status", "None", 12));
//            data.addAll(Utilities.getCase(serialNumber, "Status", "Open", 13));
//            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 14));
//            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 15));
//            Utilities.sendTickles(data);
//
//            testData = CasesResults.case1Now2(serialNumber);
//            resultDB = CasesResults.casesStepDB(serialNumber);
//            Assert.assertEquals(testData.size()== resultDB.size(), true
//                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
//            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }

    @AfterClass(alwaysRun=true)
    public void cleanUp (){
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

            URL url = null;
            try {
                url = new URL(SERVICES_URL + "/api/thing/batchDelete");
            } catch (MalformedURLException exception) {
                exception.printStackTrace();
            }
            HttpURLConnection httpURLConnection = null;
            DataOutputStream dataOutputStream = null;
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Api_key", "7B4BCCDC");
                httpURLConnection.setRequestMethod("DELETE");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeChars(body);
                System.out.println(httpURLConnection.getResponseCode() + ": " + httpURLConnection.getResponseMessage());
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }
}
