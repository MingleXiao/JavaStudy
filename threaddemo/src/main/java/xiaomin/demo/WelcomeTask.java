package xiaomin.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by HouBank on 2018/2/4.
 */
@Configuration
@EnableScheduling
public class WelcomeTask implements Runnable {

    public final static Logger logger = LoggerFactory.getLogger(WelcomeThread.class);

    @Scheduled(cron="0/10 * * * * *")
    @Override
    public void run() {
        logger.info("thread running....");
        System.out.printf("2.Welcome! I'm %s.%n",Thread.currentThread().getName());
    }
}
