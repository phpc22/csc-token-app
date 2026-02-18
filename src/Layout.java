import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout {

    private JPanel panel;
    private JComboBox<String> estadoComboBox;
    private JTextField cnpjField;
    private JPasswordField senhaField;
    private JButton btnCert;
    private JButton btnLink;

    public Layout() {
        // Fonte padrão
        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // Painel principal
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30)); // fundo dark
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ====== TÍTULO ======
        JLabel titulo = new JLabel("CSC Token Generator");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titulo, gbc);

        gbc.gridwidth = 1;

        // ====== ESTADO ======
        gbc.gridy++;
        panel.add(label("Estado:"), gbc);

        gbc.gridx = 1;
        estadoComboBox = new JComboBox<>(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
                                                            "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" });
        styleField(estadoComboBox, font);
        panel.add(estadoComboBox, gbc);

        // ====== CNPJ ======
        gbc.gridx = 0; gbc.gridy++;
        panel.add(label("CNPJ:"), gbc);

        gbc.gridx = 1;
        cnpjField = new JTextField();
        styleField(cnpjField, font);
        panel.add(cnpjField, gbc);

        // ====== SENHA ======
        gbc.gridx = 0; gbc.gridy++;
        panel.add(label("Senha Certificado:"), gbc);

        gbc.gridx = 1;
        senhaField = new JPasswordField();
        styleField(senhaField, font);
        panel.add(senhaField, gbc);

        // ====== BOTÃO CERTIFICADO ======
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        btnCert = new JButton("Anexar Certificado (.pfx)");
        styleButton(btnCert);
        panel.add(btnCert, gbc);

        // ====== BOTÃO ABRIR PORTAL CSC ======
        gbc.gridy++;
        btnLink = new JButton("Abrir Portal CSC");
        styleButton(btnLink);
        panel.add(btnLink, gbc);
        btnLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estado = (String) estadoComboBox.getSelectedItem();
                if (estado.equals("Selecione o Estado")) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um estado.");
                    return;
                }
                String link = EstadoLink.getLinkPorEstado(estado);
                try {
                    Desktop.getDesktop().browse(new java.net.URI(link));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o navegador.");
                }
            }
        });

    }

    // Label branco
    private JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        return l;
    }

    // Estilo campos
    private void styleField(JComponent comp, Font font) {
        comp.setFont(font);
        comp.setBackground(new Color(50, 50, 50));
        comp.setForeground(Color.WHITE);
        comp.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80)));
    }

    // Estilo botões
    private void styleButton(JButton b) {
        b.setBackground(new Color(0, 120, 215)); // azul Windows
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    public JPanel getPanel() {
        return panel;
    }
}
