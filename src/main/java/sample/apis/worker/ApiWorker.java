package sample.apis.worker;

import sample.apis.executor.WorkerExecutor;
import sample.apis.vo.ResponseApiDataVo;

public interface ApiWorker {
    void execute(WorkerExecutor executor);
    ResponseApiDataVo getData();
}
