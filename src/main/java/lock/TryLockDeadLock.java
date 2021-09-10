package lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntFunction;

public class TryLockDeadLock implements Runnable{
    int flag=1;
    static Lock lock1=new ReentrantLock();
    static Lock lock2=new ReentrantLock();
    @Override
    public void run() {
        if (flag==1){
            try {
                if (lock1.tryLock(800, TimeUnit.MICROSECONDS)){
                    try {
                        System.out.println("线程撕裂者1");
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock2.tryLock(800,TimeUnit.MICROSECONDS)){
                            try {
                                System.out.println("线程1获得两把锁");
                            }catch (Exception e){
                                e.printStackTrace();
                            }


                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock1.unlock();
                        Thread.sleep(new Random().nextInt(1000));

                    }
                }else {
                    System.out.println("线程撕裂者获得锁失败");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
