package com.coderoad.test;

import com.coderoad.results.CasesResults;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.CodeValueStatus;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 * @date : 8/29/16 5:25 PM
 * @version:
 */
public class BlinkFromFileTest {

    String fileName = "ChangeZone";

    @Test
    public void BlinkFromFile(){
        try {
            List<String> blinks = Utilities.blinkFromFile(fileName + ".txt");

            Utilities.sendTickles(blinks);

            List<CodeValueStatus> testData = CasesResults.caseFromFile(fileName);
            List<CodeValueStatus> resultDB = CasesResults.casesStepDB(testData.get(0).getSerialNumber(),
                    testData.get(0).getCode(), 1, 10000);

            Assert.assertEquals(testData.size() == resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo " + resultDB.size() + ", they must be " + testData.size());

            Assert.assertEquals(Utilities.compareDataStatus(testData, resultDB), true, "Data is inconsistent in step1" +
                    ".");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
