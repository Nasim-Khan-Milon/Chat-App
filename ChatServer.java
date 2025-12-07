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

            BufferedReader inFromClient1 = new BufferedReader(
                new InputStreamReader((client1.getInputStream()))
            );

            String message = inFromClient1.readLine();
            System.out.println("Message from Client  1: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}