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
        String pk = "PK-001";
        contrast.put("Form", "FORM::" + pk);
        contrast.put("WorkForce", "WORKFORCE::" + pk);
        contrast.put("External", "EXTERNAL::" + pk);

        Map<String, Object> map = ExecutionHandler.ACTION_ENGINE.getData(pk);
        assertTrue(map.equals(contrast));
        map.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "::" + e.getValue());
        });
    }
}
