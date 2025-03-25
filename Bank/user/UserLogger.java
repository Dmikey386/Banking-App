package Bank.user;


import Bank.JsonStorage.JsonLogger;
import Bank.core.Bank;

import java.io.IOException;



public class UserLogger extends JsonLogger<User> {

    // constructor
    public UserLogger() {
        super("Storage/users.json");
    }

    public void logUser(String SnowflakeID, User user) throws IOException {
        logObject(SnowflakeID,user);
    }



}

