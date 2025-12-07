import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        
        try {

            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            out.println(message);

            out.close();
            socket.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
