package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(new EveryTaskOneThread.Task(),5, TimeUnit.SECONDS);

    }
}
