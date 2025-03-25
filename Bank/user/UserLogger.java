package Bank.user;


import Bank.JsonStorage.JsonLogger;
import java.util.HashMap;
import java.util.Map;

public class UserLogger {
    public Map<String, User> userLog = new HashMap<>();
    private JsonLogger jsonLogger = new JsonLogger();

    public void logUser(String userID, User user) {
        userLog.put(userID,user);
    }
    public User getUser(String userID) {
        return userLog.get(userID);
    }

    public Map<String, User> getUserAccMap() {
        return userLog;
    }
}

