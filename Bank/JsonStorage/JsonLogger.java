package Bank.JsonStorage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Bank.user.User;


public class JsonLogger<T> {
    private static ObjectMapper mapper = new ObjectMapper();
    protected String path;

    public JsonLogger(String path) {
        this.path = path;
    }


    // Update Json File
    public void writeJson(HashMap log) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), log);
    }
    // Log new Object
    public void logObject(String SnowflakeID, T obj) throws IOException {
        HashMap<String, T> objLogger = readLog();
        objLogger.put(SnowflakeID, obj);
        writeJson(objLogger);
    }
    public HashMap<String, T> readLog() throws IOException {
        HashMap<String, T> objLog = mapper.readValue(new File(path), new TypeReference<HashMap<String, T>>() {});
        return objLog;
    }



}
