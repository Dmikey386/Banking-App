package Bank.IDTools;

public class AutoTransactionIDGenerator {
    private final static SnowflakeID generatorAuto = new SnowflakeID();
    private final String prefix = "AUTO";


    public String generateID(){
        long snowflakeID = generatorAuto.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }
}
