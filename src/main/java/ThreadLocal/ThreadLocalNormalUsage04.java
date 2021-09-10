package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
1000个线程~~~
 */
public class ThreadLocalNormalUsage04 {
    public static ExecutorService threadpool=Executors.newFixedThreadPool(10);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000000; i++) {
            int flag=i;
            threadpool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage04().date(flag);
                    System.out.println(date);
                }
            });

        }
        threadpool.shutdown();

    }
}
