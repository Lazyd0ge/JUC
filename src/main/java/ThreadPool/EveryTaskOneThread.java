package ThreadPool;

import java.util.concurrent.TimeUnit;

public class EveryTaskOneThread {
    public static void main(String[] args) {

        Thread thread=new Thread(new Task());
        thread.start();
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
