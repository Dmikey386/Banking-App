package Bank.IDTools;

public class TransactionIDGenerator implements UniqueIDGenerator {
    static final SnowflakeID generatorTransac = new SnowflakeID();
    static final String prefix = "TR";

    public String generateID(){
        long snowflakeID = generatorTransac.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }
}