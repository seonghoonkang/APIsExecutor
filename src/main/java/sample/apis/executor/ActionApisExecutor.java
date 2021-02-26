package sample.apis.executor;

import sample.apis.worker.ApiWorker;

public interface ActionApisExecutor {

    void addWorker(ApiWorker worker);
    void removeWorker(ApiWorker worker);
    void executeAll();
}
