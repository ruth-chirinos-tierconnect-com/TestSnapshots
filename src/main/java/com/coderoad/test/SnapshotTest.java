package com.coderoad.test;

import com.coderoad.snapshots.BlinkData;
import com.coderoad.utils.CasesResults;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RUTH on 16/08/21.
 */
public class SnapshotTest {

    String serialTest = "0000002";

    @Test(description = "[t1,t3,t2][A,B,A]")
    public void testCase1PopDB() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+serialTest;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Enance.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Saloor.value, 2));
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
            String serialNumber = "CASE2"+serialTest;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Enance.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Saloor.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case2Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
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
            String serialNumber = "CASE3"+serialTest;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Enance.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Saloor.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case3Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
//            data.addAll(Utilities.getCase(serialNumber, "status", "None", 2));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Saloor.value, 2));
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
            String serialNumber = "CASE4"+serialTest;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Enance.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case4Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
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
            String serialNumber = "CASE5"+serialTest;
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Enance.value, 1));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Saloor.value, 3));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case5Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Po1.value, 2));
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

}
