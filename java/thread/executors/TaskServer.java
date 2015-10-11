import java.util.concurrent.*;
import java.util.Date;
import java.util.Random;


public class TaskServer {
    
    // wi do not use Executor in order to obtain pool methods
    private static final ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    
    public static void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        
        executor.execute(task);
        
        System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
    }
    
    private static class Task implements Runnable {
        
        private static Random random = new Random(System.currentTimeMillis());
        
        private Date initDate;
        private String name;
        
        public Task(String name){
            initDate=new Date();
            this.name=name;
        }
        
        @Override
        public void run() {
            System.out.printf("%s: Task %s: Created on: %s\n",
                Thread.currentThread().getName(),name,initDate);
            System.out.printf("%s: Task %s: Started on: %s\n",
                Thread.currentThread().getName(),name,new Date());
            try {
                // nextLong(11) does not exists
                long duration = (long)random.nextInt(11);
                System.out.printf("%s: Task %s: Doing a task during %d seconds\n",
                    Thread.currentThread().getName(),name,duration);
                // Thread.sleep(1000*duration)
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: Task %s: Finished on: %s\n",
                Thread.currentThread().getName(),name,new Date());
            return;
        }
    }
    

    public static void endServer() {
        executor.shutdown();
    }
    
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            Task task = new Task("Task "+i);
            executeTask(task);
        }
        endServer();
    }
}



