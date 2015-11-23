import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestSearchTask {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i=0; i<10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // System.out.println("thread " + Thread.currentThread().getName() + " is interrupted while it is sleeping");
            }
        }
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i=0; i <threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].
            getName(), threads[i].getState()); // see Testcalculator.java
        }
        waitFinish(threadGroup);
        // when one thread is finisched ...
        threadGroup.interrupt();
    }
     
    // It will wait until one of the threads of the ThreadGroup objects ends
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) { // one is finished
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("from \"waitFinish()\": a thread is finished");
    }
}

class SearchTask implements Runnable {

    private Result result;
    
    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() { // the task
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n", name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
    System.out.printf("Thread %s: End\n", name);
    }
    
    private void doTask() throws InterruptedException {
        
        // everytime seed is changed
        Random random = new Random((new Date()).getTime());
        int value = random.nextInt(100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }
}

class Result {
    
    private String name;
    
    public void setName(String name){
        this.name = name;
    }
    
    public String readName(){
        return name;
    }
}
    
