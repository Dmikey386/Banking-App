package Bank.Tools;


import java.util.concurrent.atomic.AtomicLong;

public interface UniqueIDGenerator {
    String generateID();
}

class AccountIDGenerator implements UniqueIDGenerator {
    private static SnowflakeID generator = new SnowflakeID();
    static final String prefix = "BA";


    public String generateID(){
        long snowflakeID = generator.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }

}
class UserIDGenerator implements UniqueIDGenerator {
    static SnowflakeID generator = new SnowflakeID();
    static final String prefix = "USER";

}