package factory.controller;

import factory.product.Accessory;
import factory.product.Body;
import factory.product.Car;
import factory.product.Engine;
import factory.storage.Storage;
import factory.task.CarBuildTask;
import lombok.RequiredArgsConstructor;
import threadpool.ThreadPool;

//наполняет очередь задачами
@RequiredArgsConstructor
public class ThreadPoolController implements Runnable {
    private final ThreadPool factory;
    private final Storage<Body> bodyStorage;
    private final Storage<Engine> engineStorage;
    private final Storage<Accessory> accessoryStorage;
    private final Storage<Car> carStorage;
    private final Object lock;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {//если занят не зайдем
                while (!carStorage.isEmpty()) {//если на складе машин чето есть
                    try {
                        lock.wait();//ждем пока нотифайнут
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }//если склад машин пустой кидаем новую заадчу
                factory.execute(new CarBuildTask(5,bodyStorage, engineStorage, accessoryStorage, carStorage));
            }
        }
    }
}
