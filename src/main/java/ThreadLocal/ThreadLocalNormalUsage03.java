package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
1000个线程~~~
 */
public class ThreadLocalNormalUsage03 {
    public static ExecutorService threadpool=Executors.newFixedThreadPool(10);

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int flag=i;
            threadpool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage03().date(flag);
                    System.out.println(date);
                }
            });

        }
        threadpool.shutdown();

    }
}
