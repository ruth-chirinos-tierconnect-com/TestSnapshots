package com.coderoad.snapshots;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rchirinos
 * @date : 8/19/16 7:48 AM
 * @version:
 */
public class TestTimestamp {
    public static void main(String[] args) {
        Long a = 1471579200000L;
        System.out.println(a);
        for(int i=0;i<=10;i++){
            a=a+3600000L;
            System.out.println(a);
        }
    }

            /*
        PROD
        db.getCollection('things').find({"serialNumber":"3039ECBC014E44012A05F27B"})
        db.getCollection('thingSnapshotIds').find({_id:11568756})
        db.getCollection('thingSnapshots').find({"value._id":11568756},
{"value.zone":1, "value.DressingRoom":1, "tvalue.sCoreIn":1, "value.source":1}).sort({"time":-1})

        10.100.1.30
        db.getCollection('things').find({"serialNumber":"0000000000000000000RC006"}
,{"zone":1, "DressingRoom":1, "tsCoreIn":1, "source":1, "time":1, "modifiedTime":1}
)
        db.getCollection('thingSnapshotIds').find({_id:9587066})
        db.getCollection('thingSnapshots').find({"value._id":9587066}
,{"value.zone":1, "value.DressingRoom":1, "value.tsCoreIn":1, "value.source":1, "value.modifiedTime":1, "time":1}
).sort({"time":-1})
        * */
}
