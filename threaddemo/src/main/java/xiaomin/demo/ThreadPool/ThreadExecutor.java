package xiaomin.demo.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadExecutor {

    private  LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<Runnable>();
    private final List<Thread> threadList = new ArrayList<Thread>();
    private final List<Worker> workers=new ArrayList<Worker>();

    public int idleCount(){
        int count=0;

        for(int i=0;i<10;i++){
            if(workers.get(i).getWorkerStatus()== WorkerStatus.Idle){
                count++;
            }
        }

        return count;
    }

    //工作线程数
    int poolSize = 20;

    public ThreadExecutor(){
        for(int i=0;i<poolSize;i++){
            Worker worker=new Worker(queue);
            Thread thread=new Thread(worker);
            threadList.add(thread);
            workers.add(worker);

            thread.start();
        }
    }

    public void exec(Runnable runnable){
        queue.add(runnable);
    }


}
