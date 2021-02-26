package sample.apis.worker;

import sample.apis.executor.WorkerExecutor;
import sample.apis.vo.FormDataVo;
import sample.apis.vo.ResponseApiDataVo;

public class FormDataCollector implements ApiWorker {
    private ResponseApiDataVo response;


    @Override
    public void execute(WorkerExecutor executor) {
        response = new ResponseApiDataVo();
        FormDataVo data = new FormDataVo();
        data.setFormName("BPM Form :: " + executor.getActionId());
        response.setResultData(data);
    }

    @Override
    public ResponseApiDataVo getData() {
        return response;
    }
}