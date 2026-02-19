import ui.Layout;

import javax.swing.*;

public class CSCTokenApp extends JFrame {

    public CSCTokenApp() {
        setTitle("Gerador CSC Token");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Layout layout = new Layout();
        add(layout.getPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CSCTokenApp().setVisible(true));
    }
}
