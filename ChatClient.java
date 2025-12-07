import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        
        try {

            Socket socket = new Socket("10.200.195.81", 5000);
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

                if(message.equalsIgnoreCase("exit")) {
                    out.println("exit");
                    socket.close();
                    System.out.println("You left the chat.");
                    break;
                }
                
                out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
