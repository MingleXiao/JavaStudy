package xiaomin.demo.ThreadPool;

public class main {
    public static void main(String[] args) throws InterruptedException{
        ThreadExecutor excutor = new ThreadExecutor();
        System.out.println( excutor.idleCount());
        for (int i = 0; i < 1000; i++) {
            excutor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");
                }
            });
        }
        System.out.println( excutor.idleCount());
        System.out.println( excutor.idleCount());

    }
}
