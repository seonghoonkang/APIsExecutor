package sample.apis.executor;

import sample.apis.worker.ApiWorker;

import java.util.ArrayList;
import java.util.List;

public class WorkerExecutor implements ActionApisExecutor {
    List<ApiWorker> workers = new ArrayList<>();
    private boolean changed;
    private String actionId;

    @Override
    public void addWorker(ApiWorker worker) {
        if (worker == null) {
            throw new NullPointerException("Can not register null worker");
        }
        synchronized (workers) {
            if (!workers.contains(worker)) workers.add(worker);
        }
    }

    @Override
    public void removeWorker(ApiWorker worker) {
        synchronized (workers) {
            workers.remove(worker);
        }
    }

    @Override
    public void executeAll() {
        List<ApiWorker> copyWorkers = null;
        synchronized (workers) {
            if (!changed) return;
            copyWorkers = new ArrayList<>(workers);
            this.changed = false;
        }
        for (ApiWorker worker : copyWorkers) {
            worker.execute(this);
        }
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
        this.changed = true;
        executeAll();
    }

    public String getActionId() {
        return actionId;
    }
}