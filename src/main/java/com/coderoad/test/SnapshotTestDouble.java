package com.coderoad.test;

import com.coderoad.results.CasesResults;
import com.coderoad.results.CasesResultsDouble;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by RUTH on 16/08/21.
 * Test cases for duble older blink
 */
public class SnapshotTestDouble {

    String SERIAL_TEST = "DOUBLE29";
    Map<String, Long> thingIds = Utilities.getThingIds();

    @Test
    public void testCase1Older0() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1Older0(serialNumber);
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
    public void testCase1Older1() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case1Older1(serialNumber);
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
    public void testCase2Older0() {
        System.out.println("Inside testCase2()");
        try {
            String serialNumber = "CASE2"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 5));
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
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case2Older0(serialNumber);
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
    public void testCase2Older1() {
        System.out.println("Inside testCase2()");
        try {
            String serialNumber = "CASE2"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 5));
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
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case2Older1(serialNumber);
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
    public void testCase3Older0() {
        System.out.println("Inside testCase3()");
        try {
            String serialNumber = "CASE3"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case3Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3Older0(serialNumber);
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
    public void testCase3Older1() {
        System.out.println("Inside testCase3()");
        try {
            String serialNumber = "CASE3"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case3Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case3Older1(serialNumber);
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
    public void testCase4Older0() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE4"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
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
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case4Older0(serialNumber);
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
    public void testCase4Older1() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE4"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
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
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case4Older1(serialNumber);
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
    public void testCase5Older0() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE5"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case5Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.D.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5Older0(serialNumber);
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
    public void testCase5Older1() {
        System.out.println("Inside testCase5()");
        try {
            String serialNumber = "CASE5"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case5Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.D.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case5Older1(serialNumber);
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
    public void testCase6Older0() {
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
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6Older0(serialNumber);
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
    public void testCase6Older1() {
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
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case6Older1(serialNumber);
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
    public void testCase7Older0() {
        System.out.println("Inside testCase7()");
        try {
            String serialNumber = "CASE7"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 4));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case7Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 1));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7Older0(serialNumber);
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
    public void testCase7Older1() {
        System.out.println("Inside testCase7()");
        try {
            String serialNumber = "CASE7"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 4));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case7Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.B.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case7Older1(serialNumber);
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
    public void testCase8Older0() {
        System.out.println("Inside testCase8()");
        try {
            String serialNumber = "CASE8"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case8Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8Older0(serialNumber);
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
    public void testCase8Older1() {
        System.out.println("Inside testCase8()");
        try {
            String serialNumber = "CASE8"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case8Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.C.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case8Older1(serialNumber);
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
    public void testCase9Older0() {
        System.out.println("Inside testCase9()");
        try {
            String serialNumber = "CASE9"+SERIAL_TEST+"B";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case9Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.E.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case9Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.F.value, 2));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case9Older0(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase9()");
    }

    @Test
    public void testCase9Older1() {
        System.out.println("Inside testCase9()");
        try {
            String serialNumber = "CASE9"+SERIAL_TEST+"A";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.A.value, 5));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResultsDouble.case9Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            thingIds.putAll(CasesResultsDouble.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.E.value, 3));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case9Step2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.F.value, 4));
            Utilities.sendTickles(data);

            testData = CasesResultsDouble.case9Older1(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step3." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase9()");
    }

    @AfterClass(alwaysRun=true)
    public void cleanUp (){
        Utilities.cleanUp();
    }
}
