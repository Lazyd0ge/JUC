package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
ThreadLocal版本
 */
public class ThreadLocalNormalUsageFinal {
    public static ExecutorService threadpool=Executors.newFixedThreadPool(10);

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatThread2.get();
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int flag=i;
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsageFinal().date(flag);
                    System.out.println(date);
                }
            });

        }
        threadpool.shutdown();

    }
}
class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
            return simpleDateFormat;
        }
    };

    public static ThreadLocal<SimpleDateFormat> dateFormatThread2=ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM--dd hh:mm:ss"));
}