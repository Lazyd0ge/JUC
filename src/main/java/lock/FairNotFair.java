package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairNotFair {


    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
            printQueue.printJob("???");
            }).start();
        }
    }
}
class PrintQueue{
    private Lock queue=new ReentrantLock(true);
    public  void printJob(Object object){
        queue.lock();
        try {
            Long duration=(long)Math.random()*10;
            System.out.println(Thread.currentThread().getName()+"正在打印");
            Thread.sleep(duration);
        }catch (Exception e){
            e.printStackTrace();
        }finally{

        }
        queue.lock();
        try {
            Long duration=(long)Math.random()*10;
            System.out.println(Thread.currentThread().getName()+"正在打印2");
            Thread.sleep(duration);
        }catch (Exception e){
            e.printStackTrace();
        }finally{

        }
    }
}