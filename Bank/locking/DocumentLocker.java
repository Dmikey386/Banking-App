package bank.locking;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class JsonLocker {
    private static final JsonLocker instance = new JsonLocker();
    private HashMap<String, ReentrantLock> locks = new HashMap<>();

    private JsonLocker() {}

    public static JsonLocker getInstance() {
        return instance;
    }

    public ReentrantLock getLock(String path) {
        return locks.computeIfAbsent(path, k -> new ReentrantLock());
    }
}
