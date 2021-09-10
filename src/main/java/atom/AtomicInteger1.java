package atom;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger1 implements Runnable{
    private static final AtomicInteger atomic=new AtomicInteger();
    public void increment(){
        atomic.getAndIncrement();
    }
    private static volatile int basicCount=0;
    public void increaseBasicCount(){
        basicCount++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increment();
            increaseBasicCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger1 atomicInteger1 = new AtomicInteger1();

        Thread t1=new Thread(atomicInteger1);
        Thread t2=new Thread(atomicInteger1);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("原子类"+atomic.get());
        System.out.println(basicCount);
    }
}
