package Bank.IDTools;

public class UserIDGenerator implements UniqueIDGenerator {
    static final SnowflakeID generatorUser = new SnowflakeID();
    static final String prefix = "USER";

    public String generateID(){
        long snowflakeID = generatorUser.generateSnowflakeId();

        return prefix + String.valueOf(snowflakeID);
    }
}

