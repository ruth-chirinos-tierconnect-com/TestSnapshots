package com.coderoad.utils;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rchirinos on 8/18/16 6:47 PM
 */
public class BlinkData {
    private String serialNumber;
    private Long timestamp;
    private String property;
    private String value;

    public BlinkData(String serialNumber, Long timestamp, String property, String value) {
        this.serialNumber = serialNumber;
        this.timestamp = timestamp;
        this.property  = property;
        this.value = value;
    }

    @Override
    public String toString() {
        return serialNumber+","+timestamp+","+property+","+value;
    }
}
