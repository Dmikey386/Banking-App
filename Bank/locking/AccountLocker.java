package bank.locking;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccountLocker {
   private static final AccountLocker instance = new AccountLocker();
   private final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

   private AccountLocker() {}

    public static AccountLocker getInstance() {
       return instance;
    }

    public ReentrantLock getLock(String accountID) {
        return locks.computeIfAbsent(accountID, accountIDkey -> new ReentrantLock());
    }
}
