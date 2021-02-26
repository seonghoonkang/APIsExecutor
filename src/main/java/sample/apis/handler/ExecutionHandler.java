package sample.apis.handler;

import sample.apis.executor.WorkerExecutor;
import sample.apis.vo.FormDataVo;
import sample.apis.worker.ApiWorker;
import sample.apis.worker.ExternalDataCollector;
import sample.apis.worker.FormDataCollector;
import sample.apis.worker.WorkforceDataCollector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum ExecutionHandler {

    ACTION_ENGINE{

        @Override
        public Map<String, Object> getData(String pk) {
            WorkerExecutor executor = new WorkerExecutor();
            List<ApiWorker> workerList = getWorkList(pk);
            executor.copyWorkers(workerList);
            executor.setPrimaryKey(pk);

            ConcurrentHashMap<String, Object> result = new ConcurrentHashMap<>();
            result.put("External", ((Map) workerList.get(0).getData().getResultData()).get("Result"));
            result.put("Form", ((FormDataVo) workerList.get(1).getData().getResultData()).getFormName());
            result.put("WorkForce", ((List) workerList.get(2).getData().getResultData()).get(0));
            return result;
        }

        private List<ApiWorker> getWorkList(String pk){
            return Collections.synchronizedList(Arrays.asList(new ExternalDataCollector(), new FormDataCollector(), new WorkforceDataCollector()));
        }
    };

    public abstract Map<String, Object> getData(String pk);
}
