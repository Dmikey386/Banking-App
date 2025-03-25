package Bank.user;


import java.util.HashMap;
import java.util.Map;

public class UserLogger {
    private Map<String, User> userLog = new HashMap<>();

    public void logUser(String userID, User user) {
        userLog.put(userID,user);
    }
    public User getUser(String userID) {
        return userLog.get(userID);
    }
}

