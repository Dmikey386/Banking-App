package bank.user;

import bank.locking.DocumentLocker;
import bank.persistentstorage.JsonLogger;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;


public class UserLogger extends JsonLogger<User> {
    public static volatile UserLogger single_instance;
    //
    public static UserLogger getInstance() {
        if (single_instance == null) {
            synchronized (UserLogger.class) {
                if (single_instance == null) {
                    single_instance = new UserLogger();
                }
            }
        }
        return single_instance;
    }
    // constructor
    private UserLogger() {
        super("Storage/users.json");
    }

    // Log new User
    public void logUser(User user) throws IOException {
        logObject(user.getUserID(), user);
    }

    // get User from user log
    public User getUser(String userID) throws IOException {
        ReentrantLock lock = DocumentLocker.getInstance().getLock(path);
        Map<String, Object> userAttrMap = (Map<String, Object>) getObjectMap(userID);
        String id = (String) userAttrMap.get("userID");
        HashMap<String, Double> userAccMap = (HashMap<String, Double>) userAttrMap.get("userAccMap");
        User user = new User(id, userAccMap);
        return user;
    }


}

