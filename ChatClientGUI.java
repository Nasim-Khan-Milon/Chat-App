import javax.swing.*;
import java.awt.*;

public class ChatClientGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Chat App");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(400, 500));

        JLabel label = new JLabel("This is step 1: basic window", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
