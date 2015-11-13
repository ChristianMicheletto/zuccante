import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/************* THREAD STATE ***********************************************************************************

A thread can be in one of the following states:
-> NEW
A thread that has not yet started is in this state.

-> RUNNABLE
A thread executing in the Java virtual machine is in this state.

-> BLOCKED
A thread that is blocked waiting for a monitor lock is in this state.

-> WAITING
A thread that is waiting indefinitely for another thread to perform a particular action is in this state.

-> TIMED_WAITING
A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.

-> TERMINATED
A thread that has exited is in this state.

*******************************************************************************************************************/

public class TestCalculator {
    public static void main(String[] args) {
        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10]; // Thread.State is an enum
        // threads settings
        for (int i=0; i<10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i%2)==0){ 
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }
        PrintWriter pw = null;
        System.out.println("... writing on file");
        try {
            pw = new PrintWriter("log.txt");
            for (int i=0; i<10; i++) {
                System.out.println("... print line: " + i);
                pw.println("Main : Status of Thread " + i + ": " + threads[i].getState());
                System.out.println("... status of " + threads[i].getName() + ": " + threads[i].getState());
                // initialize status array
                status[i] = threads[i].getState();
            }
        } catch ( IOException e) {
                e.printStackTrace();
        }
        
        for (int i=0; i<10; i++){
            threads[i].start();
            System.out.println("... status of " + threads[i].getName() + ": " + threads[i].getState());
        }
        // let's go
        boolean finish = false;
        while (!finish) {
            for (int i=0; i<10; i++){
                // if new state != old state
                if (threads[i].getState() != status[i]) {
                    // write
                    System.out.println("... status of " + threads[i].getName() + " modified in " + threads[i].getState());
                    writeThreadInfo(pw, threads[i], status[i]);
                    // update state
                    status[i] = threads[i].getState();
                }
            }
            finish = true;
            for (int i=0; i<10; i++){
                finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        // in order to write file
        pw.close();
        }
    }
        
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State oldState) {
        long id = thread.getId();
        String name = thread.getName();
        int priority = thread.getPriority();
        Thread.State newState = thread.getState();
        pw.println("Main : " + id + " = " + name);  
        pw.println("Main : Priority: " + priority);
        pw.println("Main : Old State: " + oldState);
        pw.println("Main : New State: " + thread.getState());
        pw.println("Main : ************************************\n");
    }
}



class Calculator implements Runnable {
    private int number;
    public Calculator(int number) {
        this.number=number;
    }
    
    @Override
    public void run() {
        for (int i=1; i<=10; i++){
            System.out.printf("%s: %d * %d = %d\n",
            Thread.currentThread().getName(), number, i, i*number);
        }
    }
}
