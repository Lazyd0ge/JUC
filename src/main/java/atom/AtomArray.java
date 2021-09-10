package atom;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomArray {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Add add = new Add(atomicIntegerArray);
        Decrement decrement = new Decrement(atomicIntegerArray);
        Thread[] threadA = new Thread[100];
        Thread[] threadD = new Thread[100];
        for (int i = 0; i < 100; i++) {
             threadD[i]= new Thread(decrement);
             threadA[i]= new Thread(add);
             threadA[i].start();
             threadD[i].start();
        }
//        Thread.sleep(1000);
        for (int i = 0; i < 100; i++) {
            threadA[i].join();
            threadD[i].join();
        }
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            if (atomicIntegerArray.get(i)!=0){
                System.out.println("发现错误");
            }

        }
        System.out.println("运行借宿");

    }
}
class Decrement implements Runnable{
    private AtomicIntegerArray array;
    public Decrement(AtomicIntegerArray array){
        this.array=array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}
class Add implements Runnable{
    private AtomicIntegerArray array;
    public Add(AtomicIntegerArray array){
        this.array=array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}