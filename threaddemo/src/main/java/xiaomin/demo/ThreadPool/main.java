package xiaomin.demo.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class main {

    private static AtomicInteger count=new AtomicInteger();

    public static void main(String[] args) throws InterruptedException{
        ThreadExecutor excutor = new ThreadExecutor();
        System.out.println( excutor.idleCount());
        for (int i = 0; i < 10; i++) {
            excutor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活"+String.valueOf(count.addAndGet(1)));
                }
            });
        }
        Thread.sleep(1000);
        System.out.println("end:"+ String.valueOf(count.addAndGet(1)));
        System.out.println( excutor.idleCount());

    }
}
