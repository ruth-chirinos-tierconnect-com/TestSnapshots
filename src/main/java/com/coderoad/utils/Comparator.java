package com.coderoad.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by dbascope on 9/16/16
 */
public class Comparator {
    public static boolean compareData(List<CodeValue> testMap, List<CodeValue> dataBaseMap) {
        int a = 0;
        for (CodeValue codeValue : testMap) {
            if (!String.valueOf(dataBaseMap.get(a)).equals(codeValue.toString())){
                System.out.println("There are differences between results:\n\tExpected:\t"+codeValue.toString()+"\n\tObtained:\t"+dataBaseMap.get(a).toString());
                return false;
            } else {
                if( dataBaseMap.get(a).getName()!= null && !dataBaseMap.get(a).getName().equals(codeValue.getName())  ) {
                    System.out.println("Name-"+codeValue.toString()+"-"+codeValue.getName() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getCode()!= null && !dataBaseMap.get(a).getCode().equals(codeValue.getCode())  ) {
                    System.out.println(""+codeValue.toString()+"-"+codeValue.getCode() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTime()!= null && dataBaseMap.get(a).getTime().compareTo(codeValue.getTime()) != 0 ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getTime() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTime()!= null && dataBaseMap.get(a).getDwellTime().compareTo(codeValue.getDwellTime()) != 0 ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getDwellTime() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getChanged()!= null && dataBaseMap.get(a).getChanged().compareTo(codeValue.getChanged()) != 0 ) {
                    System.out.println(codeValue.toString()+"-"+codeValue.getChanged() + " does not exist in DB.");
                    return false;
                }
            }
            a++;
        }
        return true;
    }

    public static boolean compareDataStatus(List<CodeValueStatus> testMap, List<CodeValueStatus> dataBaseMap) {
        int a = 0;
        for (CodeValueStatus codeValue : testMap) {
            if (!String.valueOf(dataBaseMap.get(a)).equals(codeValue.toString())){
                System.out.println("There are differences between results:\n\tExpected:\t"+codeValue.toString()+"\n\tObtained:\t"+dataBaseMap.get(a).toString());
                return false;
            } else {
                if( dataBaseMap.get(a).getName()!= null && !dataBaseMap.get(a).getName().equals(codeValue.getName())  ) {
                    System.out.println("Name-"+codeValue.toString()+"-"+codeValue.getName() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getCode()!= null && !dataBaseMap.get(a).getCode().equals(codeValue.getCode())  ) {
                    System.out.println("Code-"+codeValue.toString()+"-"+codeValue.getCode() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTime()!= null && dataBaseMap.get(a).getTime().compareTo(codeValue.getTime()) != 0 ) {
                    System.out.println("Time-"+codeValue.toString()+"-"+codeValue.getTime() + " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTime()!= null && dataBaseMap.get(a).getDwellTime().compareTo(codeValue.getDwellTime()) != 0 ) {
                    System.out.println("Dwelltime-"+codeValue.toString()+"-"+codeValue.getDwellTime() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getChanged()!= null && dataBaseMap.get(a).getChanged().compareTo(codeValue.getChanged()) != 0 ) {
                    System.out.println("Changed-"+codeValue.toString()+"-"+codeValue.getChanged() + " does not exist " +
                            "in DB" +
                            ".");
                    return false;
                } else if( dataBaseMap.get(a).getNameStatus()!= null && !dataBaseMap.get(a).getNameStatus().equals(codeValue
                        .getNameStatus())  ) {
                    System.out.println("Status-"+codeValue.toString()+"-"+codeValue.getNameStatus() + " does not " +
                            "exist in DB" +
                            ".");
                    return false;
                } else if( dataBaseMap.get(a).getCodeStatus()!= null && !dataBaseMap.get(a).getCodeStatus().equals(codeValue
                        .getCodeStatus())  ) {
                    System.out.println("CodeStatus-"+codeValue.toString()+"-"+codeValue.getCodeStatus() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeStatus()!= null && dataBaseMap.get(a).getTimeStatus().compareTo(codeValue
                        .getTimeStatus()) != 0 ) {
                    System.out.println("TimeStatus-"+codeValue.toString()+"-"+codeValue.getTimeStatus() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeStatus()!= null && dataBaseMap.get(a).getDwellTimeStatus().compareTo
                        (codeValue.getDwellTimeStatus()) != 0 ) {
                    System.out.println("DwellTimeStatus-"+codeValue.toString()+"-"+codeValue.getDwellTimeStatus() + "" +
                            " does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getChangedStatus()!= null && dataBaseMap.get(a).getChangedStatus().compareTo
                        (codeValue.getChangedStatus()) != 0 ) {
                    System.out.println("ChangedStatus-"+codeValue.toString()+"-"+codeValue.getChangedStatus() + " " +
                            "does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeGroup()!= null && dataBaseMap.get(a).getTimeGroup().compareTo
                        (codeValue.getTimeGroup()) != 0 ) {
                    System.out.println("TimeGroup-"+codeValue.toString()+"-"+codeValue.getTimeGroup() + " does not " +
                            "exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeGroup()!= null && dataBaseMap.get(a).getDwellTimeGroup()
                        .compareTo
                                (codeValue.getDwellTimeGroup()) != 0 ) {
                    System.out.println("DwellTImeGroup-"+codeValue.toString()+"-"+codeValue.getDwellTimeGroup() + " " +
                            "does not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeType()!= null && dataBaseMap.get(a).getTimeType().compareTo
                        (codeValue
                                .getTimeType()) != 0 ) {
                    System.out.println("TimeType-"+codeValue.toString()+"-"+codeValue.getTimeType() + " does not " +
                            "exist " +
                            "in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeType()!= null && dataBaseMap.get(a).getDwellTimeType()
                        .compareTo
                                (codeValue.getDwellTimeType()) != 0 ) {
                    System.out.println("DwellTimeType-"+codeValue.toString()+"-"+codeValue.getDwellTimeType() + " " +
                            "does" +
                            " not exist in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getTimeFacility()!= null && dataBaseMap.get(a).getTimeFacility().compareTo
                        (codeValue.getTimeFacility()) != 0 ) {
                    System.out.println("TimeFacility-"+codeValue.toString()+"-"+codeValue.getTimeFacility() + " does " +
                            "not exist" +
                            " in DB.");
                    return false;
                } else if( dataBaseMap.get(a).getDwellTimeFacility()!= null && dataBaseMap.get(a).getDwellTimeFacility()
                        .compareTo
                                (codeValue.getDwellTimeFacility()) != 0 ) {
                    System.out.println("DwellTimeFacility-"+codeValue.toString()+"-"+codeValue.getDwellTimeFacility() +
                            " does not " +
                            "exist in DB.");
                    return false;
                }
            }
            a++;
        }
        return true;
    }

    public static void compareToFile (String serialNumber, int step) {
        SortedMap<String, Object> thingUdfValues = new TreeMap<>();
        SortedMap<String, Object> snapshotUdfValues = new TreeMap<>();
        try{
            String filePath = new File("").getAbsolutePath();
            File csvFile = new File(filePath+"/output/"+serialNumber+"_step"+step+".csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));

            //Check Mongo
            try{
                DBObject query = new BasicDBObject();
                query.put("serialNumber", serialNumber);
                DBCursor cursor = MongoDAOUtils.getInstance().thingsCollection.find(query);
                for (DBObject aCursor1 : cursor) {
                    BasicDBObject doc = (BasicDBObject) aCursor1;
                    thingUdfValues = UDFHandler.getUDFs(doc, "");
                }

                DBObject sort= new BasicDBObject();
                query = new BasicDBObject();
                query.put("value._id", thingUdfValues.get("_id"));
                sort.put("time", -1);
                MongoDAOUtils.getInstance().thingSnapshotsCollection.find(query).sort(sort).limit(1);
                for (DBObject aCursor : cursor) {
                    BasicDBObject doc = (BasicDBObject) aCursor;
                    snapshotUdfValues = UDFHandler.getUDFs(doc, "");
                }

                bw.write("Thing UDF,Value,Control,Snapshot UDF,Value");
                for(Map.Entry<String,Object> entry : thingUdfValues.entrySet()) {
                    bw.write(System.lineSeparator()+entry.getKey()+","+entry.getValue()+",");
                    if (snapshotUdfValues.containsKey(entry.getKey())){
                        if (entry.getValue()!=null && (entry.getValue()).equals(snapshotUdfValues.get(entry.getKey()))){
                            bw.write("OK,"+entry.getKey()+","+snapshotUdfValues.get(entry.getKey()));
                        }else if (entry.getValue()==null && snapshotUdfValues.get(entry.getKey())==null) {
                            bw.write("OK,null,null");
                        }else {
                            bw.write("ERROR,"+entry.getKey()+","+snapshotUdfValues.get(entry.getKey()));
                        }
                    }else{
                        bw.write("ERROR,,");
                    }
                }
                bw.close();

            }
            catch(UnknownHostException e){
                e.printStackTrace();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
