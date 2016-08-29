package com.coderoad.test;

import com.coderoad.utils.MongoDAOUtils;
import com.coderoad.results.CasesResults;
import com.coderoad.results.CasesResultsDouble;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by RUTH on 16/08/21.
 * Test cases for duble older blink
 */
public class SnapshotTestDouble {

    String SERIAL_TEST = "DOUBLE13";
    Map<String, Long> thingIds = Utilities.getThingIds();

    @BeforeClass(alwaysRun = true)
    public void initMongo() throws UnknownHostException {
        MongoDAOUtils.getInstance().setupMongodb(Utilities.getMongoDB(),27017,"riot_main",2000000,50,"admin","control123!");
    }

    @Test
    public void testCase1OlderB() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "Status", "None", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }

    @Test
    public void testCase1OlderA() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "Status", "None", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }

    @Test
    public void testCase2OlderB() {
        System.out.println("Inside testCase2()");
        try {
            String serialNumber = "CASE2"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case2Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case2Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case2OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase2()");
    }

    @Test
    public void testCase2OlderA() {
        System.out.println("Inside testCase2()");
        try {
            String serialNumber = "CASE2"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case2Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case2Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case2OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase2()");
    }

    @Test
    public void testCase3OlderB() {
        System.out.println("Inside testCase3()");
        try {
            String serialNumber = "CASE3"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case3Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase3()");
    }

    @Test
    public void testCase3OlderA() {
        System.out.println("Inside testCase3()");
        try {
            String serialNumber = "CASE3"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case3Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase3()");
    }

    @Test
    public void testCase4OlderB() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE4"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case4Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "status", "Changed", 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case4Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case4OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase4()");
    }

    @Test
    public void testCase4OlderA() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE4"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case4Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "status", "Changed", 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case4Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case4OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase4()");
    }

    @Test
    public void testCase5OlderB() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE5"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case5Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.ReassociationBrooklands.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase5()");
    }

    @Test
    public void testCase5OlderA() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE5"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case5Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.ReassociationBrooklands.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase5()");
    }

    @Test
    public void testCase6OlderB() {
        System.out.println("Inside testCase6()");
        try {
            String serialNumber = "CASE6"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "Change", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case6Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase6()");
    }

    @Test
    public void testCase6OlderA() {
        System.out.println("Inside testCase6()");
        try {
            String serialNumber = "CASE6"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "Change", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case6Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase6()");
    }

    @Test
    public void testCase7OlderB() {
        System.out.println("Inside testCase7()");
        try {
            String serialNumber = "CASE7"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case7Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 1));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase7()");
    }

    @Test
    public void testCase7OlderA() {
        System.out.println("Inside testCase7()");
        try {
            String serialNumber = "CASE7"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 4));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case7Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase7()");
    }

    @Test
    public void testCase8OlderB() {
        System.out.println("Inside testCase8()");
        try {
            String serialNumber = "CASE8"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case8Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8OlderB(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase8()");
    }

    @Test
    public void testCase8OlderA() {
        System.out.println("Inside testCase8()");
        try {
            String serialNumber = "CASE8"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case8Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.BrooklandsExcluded.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8OlderA(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase8()");
    }

    @AfterClass(alwaysRun=true)
    public void cleanUp (){
        Utilities.cleanUp();
    }
}
