package bank.idtools;

import java.util.function.UnaryOperator;

public class TransferIDGenerator implements UniqueIDGenerator {
    private final static SnowflakeID generatorAuto = new SnowflakeID();
    private final String prefix = "WT";

    public String generateID(){
        long snowflakeID = generatorAuto.generateSnowflakeId();
        return prefix + String.valueOf(snowflakeID);
    }
}
