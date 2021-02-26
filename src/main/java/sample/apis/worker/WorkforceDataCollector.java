package sample.apis.worker;

import sample.apis.executor.WorkerExecutor;
import sample.apis.vo.ResponseApiDataVo;

import java.util.ArrayList;
import java.util.List;

public class WorkforceDataCollector implements ApiWorker{
    private ResponseApiDataVo response;

    @Override
    public void execute(WorkerExecutor executor) {
        response = new ResponseApiDataVo();
        List<String> list = new ArrayList<>();
        list.add("WORKFORCE::" + executor.getActionId());
        response.setResultData(list);
    }

    @Override
    public ResponseApiDataVo getData() {

        return response;
    }
}
