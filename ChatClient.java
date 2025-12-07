import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        
        try {

            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter message: ");

            new Thread(() -> {

                try {

                    String inComingMessage;
                    while((inComingMessage = in.readLine()) != null) {
                        System.out.println("Friend: " + inComingMessage);
                    }

                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }

            }).start();

            while (true) {
                String message = scanner.nextLine();
                out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
