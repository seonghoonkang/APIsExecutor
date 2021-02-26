package sample.apis.worker;

import sample.apis.executor.WorkerExecutor;
import sample.apis.vo.ResponseApiDataVo;

import java.util.HashMap;
import java.util.Map;

public class ExternalDataCollector implements ApiWorker{
    private ResponseApiDataVo response;

    @Override
    public void execute(WorkerExecutor executor) {
        response = new ResponseApiDataVo();
        Map<String, String> test = new HashMap<>();
        test.put("Result", "EXTERNAL::" + executor.getActionId());
        response.setResultData(test);
    }

    @Override
    public ResponseApiDataVo getData() {
        return response;
    }
}
