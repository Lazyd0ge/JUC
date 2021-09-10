package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadLocalNormalUsage01 {
    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage01().date(10);
            System.out.println(date);
        }).start();
        try {
            TimeUnit.MICROSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage01().date(10644507);
            System.out.println(date);
        }).start();
    }
}
