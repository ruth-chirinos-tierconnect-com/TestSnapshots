package com.coderoad.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 * @date : 9/10/16 12:38 AM
 * @version:
 */
public class CodeValueStatus {
    private String serialNumber;
    private String name;
    private String code;
    private Date time;
    private Long dwellTime;
    private Boolean changed;
    private Date timeSnapshot;
    private String nameStatus;
    private String codeStatus;
    private Long dwellTimeStatus;
    private Boolean changedStatus;
    private Date timeSnapshotStatus;
    private Date timeGroup;
    private Long dwellTimeGroup;
    private Date timeType;
    private Long dwellTimeType;
    private Date timeFacility;
    private Long dwellTimeFacility;
    private int step;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
    //    CodeValue(String name, String code, int step, Boolean changed) {
//        this.name = name;
//        this.code = code;
//        this.time = new Date(Utilities.getDate() + (step * Utilities.getStep()));
//    }

    public CodeValueStatus(String serialNumber, String name, String code, int step) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        this.time = new Date(Utilities.getDate() + (step * Utilities.getStep()));
    }

    public CodeValueStatus(String serialNumber, String name, String code, Long dwellTime, Boolean changed,
                           Integer timeSnapshot, int step, String nameStatus, String codeStatus, Long dwellTimeStatus,
                           Boolean changedStatus, Integer timeSnapshotStatus,
                           Integer timeGroup, Long dwellTimeGroup, Integer timeType, Long dwellTimeType, Integer
                                   timeFacility,
                           Long dwellTimeFacility) {
        this.step = step;
        this.serialNumber = serialNumber;
        this.name = name;
        this.code = code;
        if (timeSnapshot != null) {
            this.time = new Date(Utilities.getDate() + (timeSnapshot * Utilities.getStep()));
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

        this.nameStatus = nameStatus;
        this.codeStatus = codeStatus;
        if (dwellTimeStatus != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeStatus * 3600000);
            this.dwellTimeStatus = aC.getTimeInMillis();
            this.timeSnapshotStatus = aC.getTime();
        } else {
            this.dwellTimeStatus = null;
            this.timeSnapshotStatus = null;
        }
        this.changedStatus = changedStatus;

        if (timeGroup != null) {
            this.timeGroup = new Date(Utilities.getDate() + (timeGroup * Utilities.getStep()));
        } else {
            this.timeGroup = null;
        }
        if (dwellTimeGroup != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeGroup * 3600000);
            this.dwellTimeGroup = aC.getTimeInMillis();
        } else {
            this.dwellTimeGroup = null;
        }
        if (timeType != null) {
            this.timeType = new Date(Utilities.getDate() + (timeType * Utilities.getStep()));
        } else {
            this.timeType = null;
        }
        if (dwellTimeType != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeType * 3600000);
            this.dwellTimeType = aC.getTimeInMillis();
        } else {
            this.dwellTimeType = null;
        }
        if (timeFacility != null) {
            this.timeFacility = new Date(Utilities.getDate() + (timeFacility * Utilities.getStep()));
        } else {
            this.timeFacility = null;
        }
        if (dwellTimeFacility != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeFacility * 3600000);
            this.dwellTimeGroup = aC.getTimeInMillis();
        } else {
            this.dwellTimeFacility = null;
        }
    }

    public CodeValueStatus(String serialNumber, String name, String code, Date time, Long dwellTime, Boolean changed,
                           String nameStatus, String codeStatus, Date time2, Long dwellTimeStatus, Boolean
                                   changedStatus,
                           Date timeGroup, Long dwellTimeGroup, Date timeType, Long dwellTimeType, Date timeFacility,
                           Long dwellTimeFacility) {
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


        this.nameStatus = nameStatus;
        this.codeStatus = codeStatus;
        if (dwellTimeStatus != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeStatus * 3600000);
            this.dwellTimeStatus = aC.getTimeInMillis();
            this.timeSnapshotStatus = aC.getTime();
        } else {
            this.dwellTimeStatus = null;
            this.timeSnapshotStatus = null;
        }
        this.changedStatus = changedStatus;

        this.timeType = timeType;
        if (dwellTimeGroup != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeGroup * 3600000);
            this.dwellTimeGroup = aC.getTimeInMillis();
        } else {
            this.dwellTimeGroup = null;
        }
        this.timeType = timeType;
        if (dwellTimeType != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeType * 3600000);
            this.dwellTimeType = aC.getTimeInMillis();
        } else {
            this.dwellTimeType = null;
        }
        this.timeFacility = timeFacility;
        if (dwellTimeFacility != null) {
            Calendar aC = Calendar.getInstance();
            aC.setTimeInMillis(dwellTimeFacility * 3600000);
            this.dwellTimeGroup = aC.getTimeInMillis();
        } else {
            this.dwellTimeFacility = null;
        }
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

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String name) {
        this.nameStatus = name;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String code) {
        this.codeStatus = code;
    }

    public Long getDwellTimeStatus() {
        return dwellTimeStatus;
    }

    public void setDwellTimeStatus(Long dwellTime) {
        this.dwellTimeStatus = dwellTime;
    }

    public Boolean getChangedStatus() {
        return changedStatus;
    }

    public void setChangedStatus(Boolean changed) {
        this.changedStatus = changed;
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

    public Date getTimeStatus() {
        return timeSnapshotStatus;
    }

    public void setTimeStatus(Date timeSnapshot) {
        this.timeSnapshotStatus = timeSnapshot;
    }

    public Date getTimeGroup() {
        return timeGroup;
    }

    public void setTimeGroup(Date timeSnapshot) {
        this.timeGroup = timeSnapshot;
    }

    public Long getDwellTimeGroup() {
        return dwellTimeGroup;
    }

    public void setDwellTimeGroup(Long dwellTime) {
        this.dwellTimeGroup = dwellTime;
    }

    public Date getTimeType() {
        return timeType;
    }

    public void setTimeType(Date timeSnapshot) {
        this.timeType = timeSnapshot;
    }

    public Long getDwellTimeType() {
        return dwellTimeType;
    }

    public void setDwellTimeType(Long dwellTime) {
        this.dwellTimeType = dwellTime;
    }

    public Date getTimeFacility() {
        return timeFacility;
    }

    public void setTimeFacility(Date timeSnapshot) {
        this.timeFacility = timeSnapshot;
    }

    public Long getDwellTimeFacility() {
        return dwellTimeFacility;
    }

    public void setDwellTimeFacility(Long dwellTime) {
        this.dwellTimeFacility = dwellTime;
    }

    @Override
    public String toString() {
        return "Name:" + this.name + ",Code:" + this.code + ",Time:" + this.time + ",DwellTime:" + this.dwellTime +
                ",Changed:" + changed + ",timeSnapshot:" + timeSnapshot;
    }

    public String getTickleMessage() {
        return this.serialNumber + "," + this.time.getTime() + "," + this.name + "," + this.code;
    }
}
