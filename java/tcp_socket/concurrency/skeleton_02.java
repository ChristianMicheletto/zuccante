/* un thread per task */

class ThreadPerTaskServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    handleRequest(connection);
                    }
                };
            new Thread(task).start();
        }
    }
}
