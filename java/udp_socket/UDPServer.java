import java.io.*;
import java.net.*;
import java.util.Arrays;

class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        DatagramPacket receivePacket = null;
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true) {
            Arrays.fill(receiveData, (byte)0); // try to remove
            Arrays.fill(sendData, (byte)0); // try to remove
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
           
            System.out.println("RECEIVED: " + sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
            new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
