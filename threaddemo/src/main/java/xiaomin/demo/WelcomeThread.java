package xiaomin.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HouBank on 2018/2/4.
 */
public class WelcomeThread extends Thread {

    public final static Logger logger = LoggerFactory.getLogger(WelcomeThread.class);
    @Override
    public void run(){
        logger.info("thread running....");
        System.out.printf("2.Welcome! I'm %s.%n",Thread.currentThread().getName());
    }
}
