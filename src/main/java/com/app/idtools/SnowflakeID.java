package com.app.idtools;

import java.util.concurrent.atomic.AtomicLong;

public class SnowflakeID{
    private static final long epochStartTime = 1735689600000L; // 2025-01-01 00:00:00 (GMT)
    private static final int MACHINE_SHIFT = 12;
    private static final int TIMESTAMP_SHIFT = 22;
    private static final long MAX_SEQUENCE = 4095L;
    private static final long machineID = 0L;

    private final AtomicLong lastTimestamp = new AtomicLong(-1L);
    private long sequence = 0L;

    public synchronized long generateSnowflakeId() {
        long timeStamp = System.currentTimeMillis() - epochStartTime;
        long lastTs = lastTimestamp.get();

        if (timeStamp < lastTs) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate ID");
        }

        if (timeStamp == lastTs) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                while ((timeStamp = System.currentTimeMillis() - epochStartTime) <= lastTs) {
                    // Busy-wait for the next millisecond
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp.set(timeStamp);
        return (timeStamp << TIMESTAMP_SHIFT) | (machineID << MACHINE_SHIFT) | sequence;
    }

}

