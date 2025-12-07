import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DiscoveryClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(4445);
        byte[] buffer = new byte[1024];

        System.out.println("Listening for chat server...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String msg = new String(packet.getData(), 0, packet.getLength());
            
            if (msg.startsWith("CHAT_SERVER_IP:")) {
                String serverIp = msg.split(":")[1];
                System.out.println("Server found at: " + serverIp);
                break;
            }
        }
    }
}