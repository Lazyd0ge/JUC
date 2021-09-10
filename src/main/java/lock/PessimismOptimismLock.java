package lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class PessimismOptimismLock {
    int a;
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();;
        atomicInteger.incrementAndGet();

    }
    public synchronized void test(){
        a++;
    }
}
