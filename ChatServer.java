import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        
        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for 2 clients....");

            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 connected!");

            Socket client2 = serverSocket.accept();
            System.out.println("Client 2 connected!");

            ClientHandler handler1 = new ClientHandler(client1);
            ClientHandler handler2 = new ClientHandler(client2);

            handler1.setPartner(handler2);
            handler2.setPartner(handler1);

            handler1.start();
            handler1.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}