package com.coderoad.utils;

import com.mongodb.BasicDBObject;

import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by dbascope on 9/16/16
 */
public class UDFHandler {
    public enum zonesPopDB {
        A("Enance"),B("Po1"),C("Saloor"),D("Stroom"),E("EnanceCP"),F("SaloorCP");
        public String value;

        zonesPopDB(String data) {
            this.value = data;
        }

        public static zonesPopDB ranZonePopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum udfsPopDB {
        A("zone"),B("status");
        public String value;

        udfsPopDB(String data) {
            this.value = data;
        }

        public static udfsPopDB ranUdfPopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum zonesMnS {
        A("BrooklandsExcluded"),B("DerbyExcluded"),C("FosseExcluded"),D("ReassociationBrooklands");
        public String value;

        zonesMnS(String data) {
            this.value = data;
        }

        public static zonesMnS ranZonePopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum udfsMnS {
        A("zone"),B("Status");
        public String value;

        udfsMnS(String data) {
            this.value = data;
        }

        public static udfsMnS ranUdfPopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum statusPopDB {
        A("None"),B("Free"),C("Paid"),D("Stolen"),E("Returned");
        public String value;

        statusPopDB(String data) {
            this.value = data;
        }

        public static statusPopDB ranStatusPopDB() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public static SortedMap<String, Object> getUDFs (BasicDBObject doc, String key){
        SortedMap<String, Object> udfValues = new TreeMap<>();
        try {
            for (Map.Entry<String, Object> entry : doc.entrySet()) {
                if (entry.getValue() instanceof BasicDBObject) {
                    udfValues.putAll(getUDFs((BasicDBObject) entry.getValue(), entry.getKey()));
                } else {
                    if (!String.valueOf(key).isEmpty()) {
                        udfValues.put(key + "." + entry.getKey(), entry.getValue().toString().replace(",", ";"));
                    } else {
                        udfValues.put(entry.getKey(), entry.getValue());
                    }

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return udfValues;
    }

}
