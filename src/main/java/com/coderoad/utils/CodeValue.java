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
    private Integer dwellTime;
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

    CodeValue(String serialNumber, String name,String code, Integer dwellTime, Boolean changed, Date timeSnapshot,int step) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        this.time = new Date(Utilities.DATE + (step * 3600000));;
        Calendar aC = Calendar.getInstance();
        aC.setTimeInMillis(dwellTime * 3600000);
        this.dwellTime = (int) aC.getTimeInMillis();
        this.changed = changed;
        this.timeSnapshot = timeSnapshot;
    }

    CodeValue(String serialNumber, String name,String code, Date time, Integer dwellTime, Boolean changed, Date timeSnapshot) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        this.time = time;
        Calendar aC = Calendar.getInstance();
        aC.setTimeInMillis(dwellTime * 3600000);
        this.dwellTime = (int) aC.getTimeInMillis();
        this.changed = changed;
        this.timeSnapshot = timeSnapshot;
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

    public Integer getDwellTime() {
        return dwellTime;
    }

    public void setDwellTime(Integer dwellTime) {
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
        return "Name:"+this.name +",Code:"+this.code+",Time:"+this.time+",DwellTime"+this.dwellTime+",Changed"+changed;
    }

    public String getTickleMessage() {
        return this.serialNumber+","+this.time.getTime()+","+this.name+","+this.code;
    }
}
