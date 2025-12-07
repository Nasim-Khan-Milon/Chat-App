import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket fromClient;
    private Socket toClient;

    public ClientHandler(Socket fromClient, Socket toClient) {
        this.fromClient = fromClient;
        this.toClient = toClient;
    }

    public void run () {

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(fromClient.getInputStream()));

            PrintWriter out = new PrintWriter(toClient.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
                out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
