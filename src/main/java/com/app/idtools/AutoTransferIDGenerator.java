package com.app.idtools;

public class AutoTransferIDGenerator implements UniqueIDGenerator {
    private final static SnowflakeID generatorAuto = new SnowflakeID();
    private final String prefix = "AWT";

    public String generateID(){
        long snowflakeID = generatorAuto.generateSnowflakeId();
        return prefix + String.valueOf(snowflakeID);
    }
}