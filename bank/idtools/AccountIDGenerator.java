package bank.idtools;

public class AccountIDGenerator implements UniqueIDGenerator {
    private final static SnowflakeID generatorAcc = new SnowflakeID();
    static final String prefix = "BA";


    public String generateID(){
        long snowflakeID = generatorAcc.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }

}
