package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDwon {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new ShutDown());
            System.out.println(i);
        }
        Thread.sleep(1500);
        executorService.shutdown();
        boolean shutdown = executorService.isShutdown();
        System.out.println(shutdown);
        System.out.println(executorService.isTerminated());
        executorService.execute(new ShutDown());
    }
}
class ShutDown implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.MICROSECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
