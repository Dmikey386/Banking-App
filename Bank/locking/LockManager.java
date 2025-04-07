package bank.locking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LockManager {
   private static final LockManager instance = new LockManager();
   private final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

   private LockManager() {}

    public static LockManager getInstance() {
       return instance;
    }

    public ReentrantLock getLock(String accountID) {
        return locks.computeIfAbsent(accountID, accountIDkey -> new ReentrantLock());
    }
}
