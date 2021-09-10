package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
lock不会像synchronized异常自动释放锁
 */
public class MustUnLock {
    private static Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始执行任务");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
