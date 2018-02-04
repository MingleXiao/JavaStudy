package xiaomin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);

        Thread welcomeThread=new WelcomeThread();
        //守护线程，主线程退出后跟着退出
        welcomeThread.setDaemon(true);
        welcomeThread.setName("My Thread Executor");

        welcomeThread.start();

        Thread welcomeThread2=new Thread(new WelcomeTask());

        welcomeThread2.start();

        System.out.printf("1.Welcome! I'm %s.%n",Thread.currentThread().getName());
    }
}

