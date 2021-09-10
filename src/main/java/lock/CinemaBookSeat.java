package lock;

import java.util.concurrent.locks.ReentrantLock;

public class CinemaBookSeat {
    private static ReentrantLock lock=new ReentrantLock();
    private static void bookSeat(){
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始预定");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"预定完成");

        }catch (Exception e){
            e.printStackTrace();
        }finally{
//            lock.unlock();
        }

    }

    public static void main(String[] args) {
        new Thread(() -> {
            bookSeat();
        }).start();new Thread(() -> {
            bookSeat();
        }).start();new Thread(() -> {
            bookSeat();
        }).start();new Thread(() -> {
            bookSeat();
        }).start();
    }
}
