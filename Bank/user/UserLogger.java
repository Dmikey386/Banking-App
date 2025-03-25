package Bank.user;

import Bank.JsonStorage.JsonLogger;
import java.io.IOException;


public class UserLogger extends JsonLogger<User> {

    // constructor
    public UserLogger() {
        super("Storage/users.json");
    }

    public void logUser(String userID, User user) throws IOException {
        logObject(userID, user);
    }

}

