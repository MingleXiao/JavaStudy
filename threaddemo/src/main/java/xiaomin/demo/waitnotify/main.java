package xiaomin.demo.waitnotify;

public class main {
    public static Object syn=new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (syn) {
                        System.out.println("wait....");
                        syn.wait();
                        while (true){
                            System.out.println("我醒了....");
                            Thread.sleep(1000);
                            System.out.println("我睡了....");
                            syn.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

        while (true) {
            Thread.sleep(1000);
            synchronized (syn) {
                syn.notifyAll();
                System.out.println("起床啦....");
                Thread.sleep(2000);
            }
        }


    }
}
