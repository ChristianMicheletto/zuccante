class LifecycleWebServer {
    // schose the factory method
    private final ExecutorService exec = ...;
    
    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                // task
                exec.execute(new Runnable() {
                    public void run() { handleRequest(conn); }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) 
                    e.printStackTrace();
                log("task submission rejected", e);
            }
        }
    }
    
    public void stop() { exec.shutdown(); }
    void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if (isShutdownRequest(req))
            stop();
        else
            dispatchRequest(req);
    }
}
