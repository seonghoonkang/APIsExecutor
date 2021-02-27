package sample.apis;

import org.junit.jupiter.api.Test;
import sample.apis.handler.ExecutionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExecutionHandler {

    @Test
    public void runExecutor(){
        Map<String, Object> contrast = new HashMap<>();
        String primaryKey = "PK-001";
        contrast.put("Form", "FORM::" + primaryKey);
        contrast.put("WorkForce", "WORKFORCE::" + primaryKey);
        contrast.put("External", "EXTERNAL::" + primaryKey);

        Map<String, Object> map = ExecutionHandler.ACTION_ENGINE.getData(primaryKey);
        assertTrue(map.equals(contrast));

        map.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "::" + e.getValue());
        });
    }
}
