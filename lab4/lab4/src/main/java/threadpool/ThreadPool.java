package threadpool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ThreadPool {
    private final List<TaskWorker> workers;//создаем колво воркеров
    private final Queue<Runnable> tasksQueue;//создаем очередь из которой берут
    private boolean isStopped;

    public ThreadPool(int numberOfWorkers) {
        this.workers = new ArrayList<>(numberOfWorkers);
        this.tasksQueue = new ArrayDeque<>();
        initializeWorkers(numberOfWorkers);
        startWorkers();
    }

    private void initializeWorkers(int numberOfWorkers) {
        for (int i = 0; i < numberOfWorkers; i++) {
            this.workers.add(new TaskWorker(tasksQueue));
        }
    }

    private void startWorkers() {
        this.workers.forEach(e -> new Thread(e).start());
    }//создаемдля кадого воркера поток в котором он крутится

    public synchronized void stop() {
        this.isStopped = true;
        workers.forEach(TaskWorker::stop);
    }

    public void execute(Runnable command) {
        synchronized (tasksQueue) {
            if (isStopped) {
                return;
            }
            tasksQueue.offer(command);
            tasksQueue.notify();
        }
    }
}
