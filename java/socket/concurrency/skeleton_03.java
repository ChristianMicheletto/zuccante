/* con gli executors */

class TaskExecutionServer {
    private static final int NTHREADS = 100;
    /* use the factory method
     * 
     * Creates a thread pool that reuses a fixed number of threads 
     * operating off a shared unbounded queue
     */ 
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        while (true) {
            final Socket connection = socket.accept();
            // task is a runnable object 
            Runnable task = new Runnable() {
                public void run() {
                    handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }
}

// in order to obtai one thread for one task

public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    };
}

/*
i)      In what thread will tasks be executed?
ii)     In what order should tasks be executed (FIFO, LIFO, priority order)?
iii)    How many tasks may execute concurrently?
iv)     How many tasks may be queued pending execution?
v)      If a task has to be rejected because the system is overloaded, which task should be
        selected as the victim, and how should the application be notified?
vi)     What actions should be taken before or after executing a task?
*/


