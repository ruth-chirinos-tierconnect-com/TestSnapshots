package com.coderoad.test;

import com.coderoad.results.CasesResults;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.EndPointHandler;
import com.coderoad.utils.MQTTHandler;
import com.coderoad.utils.Utilities;
import com.coderoad.utils.Comparator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 */
public class CustomNowTest {
    String SERIAL_TEST = "REPORT25";
    int BLINKS0 = 20;
    int BLINKS1 = 10;
    int WAIT = 24;
    Map<String, Long> thingIds = Utilities.getThingIds();
    public static Long dwellReturn;
    public static int timeReturn;
    public static boolean changedReturn;

    @Test(description = "[t1,t2,t3,t4,t5][A,B,B,C,C]")
    public void testCase1Now() {
        System.out.println("Inside testCase1()");
        try {
            String serialNumber = "CASE1"+SERIAL_TEST;
            List<String> data = CasesResults.getRandomCase(serialNumber, 1, BLINKS0, true);
            MQTTHandler.sendTickles(data);

            List<CodeValue> testDataNow = CasesResults.casesStepDBThings(serialNumber);

            thingIds.putAll(CasesResults.thingIds);

            data.clear();
            data = CasesResults.getRandomCase(serialNumber, (BLINKS0+WAIT), (BLINKS0+BLINKS1+WAIT), false);
            MQTTHandler.sendTickles(data);

            List<CodeValue> testDataCustom = CasesResults.casesStepDBCustom(serialNumber, 0, (BLINKS0+1));
            Assert.assertEquals(testDataNow.size()== testDataCustom.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ testDataCustom.size()+", they must be "+testDataNow.size());
            Assert.assertEquals(Comparator.compareData(testDataNow,testDataCustom), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }

    @AfterClass(alwaysRun=true)
    public void cleanUp (){
        EndPointHandler.cleanUp();
    }
}
