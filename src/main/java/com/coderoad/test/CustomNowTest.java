package com.coderoad.test;

import com.coderoad.utils.MongoDAOUtils;
import com.coderoad.results.CasesResults;
import com.coderoad.utils.CodeValue;
import com.coderoad.utils.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        MongoDAOUtils.getInstance().setupMongodb(Utilities.getMongoDB(),27017,"riot_main",2000000,50,"admin","control123!");
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


            List<CodeValue> testData = CasesResults.case1Now1(serialNumber);
            List<CodeValue> resultDB = CasesResults.casesStepDBThings(serialNumber);

            thingIds.putAll(CasesResults.thingIds);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step1." );

            data.clear();
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.ReassociationBrooklands.value, 11));
            data.addAll(Utilities.getCase(serialNumber, "Status", "None", 12));
            data.addAll(Utilities.getCase(serialNumber, "Status", "Open", 13));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.DerbyExcluded.value, 14));
            data.addAll(Utilities.getCase(serialNumber, "zone", Utilities.zonesMnS.FosseExcluded.value, 15));
            Utilities.sendTickles(data);

            testData = CasesResults.case1Now2(serialNumber);
            resultDB = CasesResults.casesStepDB(serialNumber);
            Assert.assertEquals(testData.size()== resultDB.size(), true
                    , "Error number of snapshots" + "Quantity of Snapshots in Mongo "+ resultDB.size()+", they must be "+testData.size());
            Assert.assertEquals(Utilities.compareData(testData,resultDB), true, "Data is inconsistent in step2." );
        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("End testCase1()");
    }

    @AfterClass(alwaysRun=true)
    public void cleanUp (){
        Utilities.cleanUp();
    }
}
