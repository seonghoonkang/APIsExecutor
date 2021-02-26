package sample.apis;

import sample.apis.executor.WorkerExecutor;
import sample.apis.vo.FormDataVo;
import sample.apis.worker.ApiWorker;
import sample.apis.worker.ExternalDataCollector;
import sample.apis.worker.FormDataCollector;
import sample.apis.worker.PVDataCollector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ActionEngine {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        WorkerExecutor executor = new WorkerExecutor();
        List<ApiWorker> workerList = Arrays.asList(new ExternalDataCollector(), new FormDataCollector(), new PVDataCollector());
        workerList.forEach(worker -> executor.addWorker(worker));

        for(int i = 0; i < 10; i++){
            executor.setActionId("A00"+i);
            System.out.println(((Map) workerList.get(0).getData().getResultData()).get("Result"));
            System.out.println(((FormDataVo) workerList.get(1).getData().getResultData()).getFormName());
            System.out.println(((List) workerList.get(2).getData().getResultData()).get(0));
            System.out.println("=----------------------------");
        }

        long end = System.currentTimeMillis();

        System.out.println("실행시간 : " + (end - start) / 1000.0);
    }
}
