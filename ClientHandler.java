import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {

    private Socket socket;         // each client has ONLY ONE socket
    private ClientHandler partner; // reference to the other client

    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void setPartner(ClientHandler partner) {
        this.partner = partner;
    }

    // For sending messages safely from other handler
    public void sendMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void run() {
        try {
            // Create input/output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {

                // Exit handling
                if (message.equalsIgnoreCase("exit")) {
                    sendMessage("You left the chat.");

                    if (partner != null) {
                        partner.sendMessage("The other user has left the chat.");
                    }

                    break; // exit loop
                }

                // Forward normal messages to partner
                if (partner != null) {
                    partner.sendMessage("Partner: " + message);
                }
            }

        } catch (IOException e) {
            System.out.println("A client disconnected unexpectedly.");
        } finally {
            try { socket.close(); } catch (IOException ex) {}
        }
    }
}
