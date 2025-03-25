package Bank.JsonStorage;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class JsonLogger<T> {
    private static ObjectMapper mapper = new ObjectMapper();


    public void jsonifyLogger(T logger) throws IOException {
       mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Storage/users.json"), logger);
    }

    public static void main(String[] args) throws IOException {
    }
}
