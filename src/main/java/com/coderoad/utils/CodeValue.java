package com.coderoad.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by RUTH on 16/08/21.
 */
public class CodeValue {
    private String serialNumber;
    private String name;
    private String code;
    private Date time;
    private Long dwellTime;
    private Boolean changed;
    private Date timeSnapshot;

//    CodeValue(String name, String code, int step, Boolean changed) {
//        this.name = name;
//        this.code = code;
//        this.time = new Date(Utilities.DATE + (step * 3600000));
//    }

    CodeValue(String serialNumber, String name,String code, int step) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        this.time = new Date(Utilities.DATE + (step * 3600000));
    }

    CodeValue(String serialNumber, String name,String code, Long dwellTime, Boolean changed, Integer timeSnapshot,int step) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        if (timeSnapshot!=null){
            this.time = new Date(Utilities.DATE + (timeSnapshot * 3600000));
        } else {
            this.time = null;
        }
        if (dwellTime != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTime * 3600000);
            this.dwellTime = aC.getTimeInMillis();
            this.timeSnapshot = aC.getTime();
        } else {
            this.dwellTime = null;
            this.timeSnapshot = null;
        }
        this.changed = changed;
    }

    CodeValue(String serialNumber, String name,String code, Date time, Long dwellTime, Boolean changed, Date timeSnapshot) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        this.time = time;
        if (dwellTime != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTime * 3600000);
            this.dwellTime = aC.getTimeInMillis();
            this.timeSnapshot = aC.getTime();
        } else {
            this.dwellTime = null;
            this.timeSnapshot = null;
        }
        this.changed = changed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getDwellTime() {
        return dwellTime;
    }

    public void setDwellTime(Long dwellTime) {
        this.dwellTime = dwellTime;
    }

    public Boolean getChanged() {
        return changed;
    }

    public void setChanged(Boolean changed) {
        this.changed = changed;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getTimeSnapshot() {
        return timeSnapshot;
    }

    public void setTimeSnapshot(Date timeSnapshot) {
        this.timeSnapshot = timeSnapshot;
    }

    @Override
    public String toString () {
        return "Name:"+this.name +",Code:"+this.code+",Time:"+this.time+",DwellTime:"+this.dwellTime+",Changed:"+changed+",timeSnapshot:"+timeSnapshot;
    }

    public String getTickleMessage() {
        return this.serialNumber+","+this.time.getTime()+","+this.name+","+this.code;
    }
}
