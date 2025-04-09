package bank.locking;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DocumentLocker {
    private static final DocumentLocker instance = new DocumentLocker();
    private HashMap<String, ReentrantLock> locks = new HashMap<>();

    private DocumentLocker() {}

    public static DocumentLocker getInstance() {
        return instance;
    }

    public ReentrantLock getLock(String path) {
        return locks.computeIfAbsent(path, k -> new ReentrantLock());
    }
}
