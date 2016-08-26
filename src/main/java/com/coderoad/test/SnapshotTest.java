package com.coderoad.test;

import com.coderoad.utils.CasesResults;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RUTH on 16/08/21.
 */
public class SnapshotTest {

    String SERIAL_TEST = "SNAPSHOT08";
    boolean CLEAN_THINGS = true;
    String SERVICES_URL = "http://localhost:8080/riot-core-services";
    Map<String, Long> thingIds = new HashMap<>();

    @Test(description = "[t1,t3,t2][A,B,A]")
    public void testCase1PopDB() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "Status", "None", 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case1Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }


    @Test(description = "[t1,t3,t2][A,A,B]")
    public void testCase2PopDB() {
        System.out.println("Inside testCase2()");
        try {
            String serialNumber = "CASE2"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case2Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case2Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase2()");
    }

    @Test(description = "[t1,t3,t2][A,B,B]")
    public void testCase3PopDB() {
        System.out.println("Inside testCase3()");
        try {
            String serialNumber = "CASE3"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case3Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
//            data.addAll(Utilities.getCase(serialNumber, "status", "None", 2));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case3Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase3()");
    }

    @Test(description = "[t1,t3,t2][A,A,A]")
    public void testCase4PopDB() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE4"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case4Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "status", "Changed", 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case4Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase4()");
    }

    @Test(description = "[t1,t3,t2][A,B,C]")
    public void testCase5PopDB() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE5"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case5Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case5Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase5()");
    }

    @Test(description = "[t1,t3,t2][null,null,A]")
    public void testCase6PopDB() {
        System.out.println("Inside testCase6()");
        try {
            String serialNumber = "CASE6"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "Change", 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case6Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case6Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase6()");
    }

    @Test(description = "[t3,t1,t2][B,A,A]")
    public void testCase7PopDB() {
        System.out.println("Inside testCase7()");
        try {
            String serialNumber = "CASE7"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case7Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 1));
            Utilities.sendTickles(data);

            testData = CasesResults.case7Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase7()");
    }


    @Test(description = "[t3,t1,t2][A,A,A]")
    public void testCase8PopDB() {
        System.out.println("Inside testCase7()");
        try {
            String serialNumber = "CASE7"+SERIAL_TEST;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case8Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResults.case8Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase7()");
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
