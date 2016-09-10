package com.coderoad.test;

import com.coderoad.results.CasesResults;
import com.coderoad.utils.CodeValueStatus;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 *
 */
public class servicesVsBridges {
    String fileName = "ChangeZone";

    @Test
    public void BlinkFromFileEndPoint() {
        try {
            List<String> blinks = Utilities.blinkFromFileEndPpoint(fileName + ".txt");
            List<CodeValueStatus> testData = CasesResults.caseFromFile(fileName);
            List<CodeValueStatus> testBlink = new ArrayList<>();
            int i = 0;
            Long thingId = 0L;
            for (String blink : blinks) {

                thingId = Utilities.sendEndPoint(blink, thingId);

                testBlink.add(testData.get(i));
                List<CodeValueStatus> resultDB = CasesResults.casesStepDB(testData.get(i).getSerialNumber(),
                        testData.get(i).getName(), -1, 1);

                Assert.assertEquals(testBlink.size() == resultDB.size(), true
                        , "Error number of snapshots" + "Quantity of Snapshots in Mongo " + resultDB.size() + ", they" +
                                " must be " + testBlink.size());

                Assert.assertEquals(Utilities.compareDataStatus(testBlink, resultDB), true, "Data is inconsistent in " +
                        "step1.");
                i++;
                testBlink.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BlinkFromFileBridge() {
        try {
            List<String> blinks = Utilities.blinkFromFileBridge(fileName + ".txt");
            List<CodeValueStatus> testData = CasesResults.caseFromFile(fileName + "All");

            Utilities.sendTickles(blinks);

            List<CodeValueStatus> resultDB = CasesResults.casesStepDB(testData.get(0).getSerialNumber(),
                    testData.get(0).getName(), 1, 100000);

            Assert.assertEquals(testData.size() == resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo " + resultDB.size() + ", they " +
                            "must be " + testData.size());

            Assert.assertEquals(Utilities.compareDataStatus(testData, resultDB), true, "Data is inconsistent in " +
                    "step1.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BlinkFromFileAll() {
        try {
            List<CodeValueStatus> testData = CasesResults.caseFromFile(fileName + "All");
            List<CodeValueStatus> resultDB = CasesResults.casesStepDB(testData.get(0).getSerialNumber(),
                    testData.get(0).getName(), 1, 100000);

            Assert.assertEquals(testData.size() == resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo " + resultDB.size() + ", they " +
                            "must be " + testData.size());

            Assert.assertEquals(Utilities.compareDataStatus(testData, resultDB), true, "Data is inconsistent in " +
                    "step1.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
