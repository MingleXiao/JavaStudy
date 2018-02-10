package xiaomin.demo.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

public class Worker implements Runnable {

    private WorkerStatus workerStatus;

    private LinkedBlockingQueue<Runnable> queue=null;

    public Worker(LinkedBlockingQueue<Runnable> queue ){
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true){
            Runnable task=null;
            try{
                this.workerStatus=WorkerStatus.Idle;
                task=getTask();

                this.workerStatus=WorkerStatus.Running;
                task.run();
                this.workerStatus=WorkerStatus.Idle;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public Runnable getTask() throws InterruptedException{
        return queue.take();
    }

    public WorkerStatus getWorkerStatus() {
        return workerStatus;
    }
}
