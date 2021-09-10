package atom;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdateDemo implements Runnable{
    static Candidate tom;
    static Candidate peter;
    public static AtomicIntegerFieldUpdater<Candidate>scoreUpdater=AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            scoreUpdater.getAndIncrement(tom);
        }
    }

    public static class Candidate{

        volatile  int score;
    }

    public static void main(String[] args) throws InterruptedException {
        tom=new Candidate();
        peter=new Candidate();
        AtomicIntegerFieldUpdateDemo r=new AtomicIntegerFieldUpdateDemo();

        Thread t1=new Thread(r);
        Thread t2=new Thread(r);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("perter="+peter.score);
        System.out.println("tom="+tom.score);
    }

}
