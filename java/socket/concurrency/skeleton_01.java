/* un task dopo l'altro in un unico thread */

class SingleThreaServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
            }
        }
    }
}
