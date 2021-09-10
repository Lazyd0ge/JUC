package ThreadLocal;

public class TLNPE {
    ThreadLocal<Long> longThreadLocal =new ThreadLocal<Long>();
    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
    }
    public Long get(){
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        TLNPE tlnpe=new TLNPE();
        System.out.println(tlnpe.get());
        new Thread(() -> {
            tlnpe.set();
            tlnpe.get();
            System.out.println(tlnpe.get());
            String a;
        }).start();

    }

}
