package Bank.Tools;


import java.util.concurrent.atomic.AtomicLong;

public interface UniqueIDGenerator {
    String generateID();
}

class AccountIDGenerator implements UniqueIDGenerator {
    private static SnowflakeID generatorAcc = new SnowflakeID();
    static final String prefix = "BA";


    public String generateID(){
        long snowflakeID = generatorAcc.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }

}
class UserIDGenerator implements UniqueIDGenerator {
    static SnowflakeID generatorUser = new SnowflakeID();
    static final String prefix = "USER";

    public String generateID(){
        long snowflakeID = generatorUser.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }
}

class TransactionIDGenerator implements UniqueIDGenerator {
    static SnowflakeID generatorTransac = new SnowflakeID();
    static final String prefix = "USER";

    public String generateID(){
        long snowflakeID = generatorTransac.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }
}