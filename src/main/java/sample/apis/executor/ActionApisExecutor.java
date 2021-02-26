package sample.apis.executor;

import sample.apis.worker.ApiWorker;

import java.util.List;

public interface ActionApisExecutor {

    void addWorker(ApiWorker worker);
    void copyWorkers(List<ApiWorker> workers);
    void setPrimaryKey(String primaryKey);
    void executeAll();
}
