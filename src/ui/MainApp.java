package ui;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CSC Token Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 350);
            frame.setLocationRelativeTo(null);

            Layout layout = new Layout();
            frame.add(layout.getPanel());

            frame.setVisible(true);
        });
    }
}
