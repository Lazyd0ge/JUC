package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ForLoop {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new EveryTaskOneThread.Task());
        }

    }

}
