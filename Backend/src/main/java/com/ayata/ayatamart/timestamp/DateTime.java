package com.ayata.ayatamart.timestamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class DateTime {
    public long timeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15));


        Instant instant = timestamp.toInstant();
        return instant.toEpochMilli();


    }
}
