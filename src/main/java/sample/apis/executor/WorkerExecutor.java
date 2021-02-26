package sample.apis.executor;

import sample.apis.worker.ApiWorker;

import java.util.ArrayList;
import java.util.List;

public class WorkerExecutor implements ActionApisExecutor {
    private final List<ApiWorker> workers = new ArrayList<>();
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
    public void copyWorkers(List<ApiWorker> originWorkers) {
        if (originWorkers == null) {
            throw new NullPointerException("Can not register null worker list");
        }
        synchronized (workers) {
            workers.addAll(originWorkers);
        }
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        this.actionId = primaryKey;
        this.changed = true;
        executeAll();
    }

    @Override
    public void executeAll() {
        List<ApiWorker> copyWorkers;
        synchronized (workers) {
            if (!changed) return;
            copyWorkers = new ArrayList<>(workers);
            this.changed = false;
        }
        for (ApiWorker worker : copyWorkers) {
            worker.execute(this);
        }
    }

    public String getActionId() {
        return actionId;
    }
}