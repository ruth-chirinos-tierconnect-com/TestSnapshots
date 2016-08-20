package com.coderoad.snapshots;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : dbascope
 * @date : 8/19/16 6:26 PM
 * @version:
 */
public class Results {
    private Date time;
    private Object value;
    private Date timeUdf;
    private Long dwelltime;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Date getTimeUdf() {
        return timeUdf;
    }

    public void setTimeUdf(Date timeUdf) {
        this.timeUdf = timeUdf;
    }

    public Long getDwelltime() {
        return dwelltime;
    }

    public void setDwelltime(Long dwelltime) {
        this.dwelltime = dwelltime;
    }

    public Results(Date time, Object value, Date timeUdf, Long dwelltime) {
        this.time = time;
        this.value = value;
        this.timeUdf = timeUdf;
        this.dwelltime = dwelltime;
    }
}
