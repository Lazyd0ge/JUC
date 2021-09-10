package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/*
十个线程~~~
 */
public class ThreadLocalNormalUsage02 {
    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            int flag=i;
            new Thread(() -> {
                String date = new ThreadLocalNormalUsage02().date(flag);
                System.out.println(date);
            }).start();
            Thread.sleep(100);
        }

    }
}
