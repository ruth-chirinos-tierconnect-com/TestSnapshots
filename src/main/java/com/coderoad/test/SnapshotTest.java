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

    @Test(description = "[t1,t3,t2][A,B,A]")
    public void testCase1PopDB() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1";
            List<String> data = new ArrayList<>();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Enance.value, 0));
            data.addAll(Utilities.getCase(serialNumber, "status", "None", 2));
            Utilities.sendTickles(data);

            List<CodeValue> testData = CasesResults.case1Step1(serialNumber);
            List<CodeValue> resultDB = CasesResults.case1Step1DB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );
            /*
            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesPopDB.Saloor.value, 1));
            Utilities.sendTickles(data);

            testData = CasesResults.case1Step2(serialNumber);
            resultDB = CasesResults.case1Step2DB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Cantidad de Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );
            */
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }
}
