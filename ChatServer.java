import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for 2 clients....");

            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 connected!");

            // Socket client2 = serverSocket.accept();
            // System.out.println("Client 2 connected!");

            // new ClientHandler(client1, client2).start();
            // new ClientHandler(client2, client1).start();

            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client1.getInputStream()));
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("From Client 1: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}