package bank.persistentstorage;

import bank.locking.JsonLocker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;


public class JsonLogger<T> {
    private static ObjectMapper mapper = new ObjectMapper();
    protected String path;

    public JsonLogger(String path) {
        this.path = path;
    }

    // Update Json File
    public void writeJson(HashMap log) throws IOException {
        ReentrantLock lock = JsonLocker.getInstance().getLock(path);
        lock.lock();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), log);
        }finally {
            lock.unlock();
        }

    }
    // Log new Object
    public synchronized void logObject(String SnowflakeID, T obj) throws IOException {
        HashMap<String, T> objLogger = readLog();
        objLogger.put(SnowflakeID, obj);
        writeJson(objLogger);


    }
    public HashMap<String, T> readLog() throws IOException {
        ReentrantLock lock = JsonLocker.getInstance().getLock(path);
        lock.lock();
        try {
            HashMap<String, T> objLog = mapper.readValue(new File(path), new TypeReference<HashMap<String, T>>() {});
            return objLog;
        }finally {
            lock.unlock();
        }
    }
    public T getObjectMap(String SnowflakeID) throws IOException {
        HashMap<String, T> objLog = readLog();
        return objLog.get(SnowflakeID);
    }
}
