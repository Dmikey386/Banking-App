package Bank.user;

import Bank.JsonStorage.JsonLogger;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


public class UserLogger extends JsonLogger<User> {

    // constructor
    public UserLogger() {
        super("Storage/users.json");
    }

    // Log new User
    public void logUser(String userID, User user) throws IOException {
        logObject(userID, user);
    }

    // get User from user log
    public User getUser(String userID) throws IOException {
        Map<String, Object> userAttrMap = (Map<String, Object>) getObjectMap(userID);
        System.out.println(userAttrMap);
        String id = (String) userAttrMap.get("userID");
        HashMap<String, Double> userAccMap = (HashMap<String, Double>) userAttrMap.get("userAccMap");
        User user = new User(id, userAccMap);
        return user;
    }

}

