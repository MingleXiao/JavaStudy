package xiaomin.demo.readwritelockdemo;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    private static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();

    private static Lock readLock= reentrantReadWriteLock.readLock();

    private static Lock writeLock=reentrantReadWriteLock.writeLock();

    private volatile static int value;

    public int handleRead(Lock lock) throws InterruptedException{
        try{
            lock.lock();
            Thread.sleep(1000);
            return value;
        }
        finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws InterruptedException{
        try{
            lock.lock();
            Thread.sleep(1000);
            value=index;
            System.out.println("write"+value);
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLock demo=new ReadWriteLock();
        Runnable readRunnble=new Runnable() {
            @Override
            public void run() {
                try{
                   int value= demo.handleRead(readLock);
                   System.out.println(value);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable=new Runnable() {
            @Override
            public void run() {
                try{
                    demo.handleWrite(writeLock,new Random().nextInt());
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        for(int i=18;i<20;i++){
            new Thread(writeRunnable).start();
        }
        for(int i=0;i<18;i++){
            new Thread(readRunnble).start();
        }


    }
}
