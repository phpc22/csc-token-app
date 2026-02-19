package ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import util.CertificadoUtil;
import java.io.File;


public class Layout {

    private JPanel panel;
    private JComboBox<String> estadoComboBox;
    private JTextField cnpjField;
    private JPasswordField senhaField;
    private JTextField certPathField;
    private JButton btnCert;

    public Layout() {

        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // ===== TÍTULO =====
        JLabel titulo = new JLabel("CSC Token Generator");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titulo, gbc);

        gbc.gridwidth = 1;

        // ===== ESTADO =====
        gbc.gridy++;
        panel.add(label("Estado:"), gbc);

        gbc.gridx = 1;
        estadoComboBox = new JComboBox<>(new String[]{"SP","RJ","MG","RS", "SC"});
        panel.add(estadoComboBox, gbc);

        // ===== CNPJ =====
        gbc.gridx = 0; gbc.gridy++;
        panel.add(label("CNPJ:"), gbc);

        gbc.gridx = 1;
        cnpjField = new JTextField();
        panel.add(cnpjField, gbc);

        // ===== SENHA =====
        gbc.gridx = 0; gbc.gridy++;
        panel.add(label("Senha Certificado:"), gbc);

        gbc.gridx = 1;
        senhaField = new JPasswordField();
        panel.add(senhaField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;

        btnCert = new JButton("Selecionar Certificado A1 (.pfx)");
        btnCert.setBackground(new Color(0,120,215));
        btnCert.setForeground(Color.WHITE);
        btnCert.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCert.setFocusPainted(false);
        panel.add(btnCert, gbc);

        btnCert.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Certificado A1 (*.pfx)", "pfx"));

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File certFile = fileChooser.getSelectedFile();
                String senha = new String(senhaField.getPassword());

                if (senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite a senha do certificado primeiro!");
                    return;
                }

                boolean ok = CertificadoUtil.validarSenha(certFile.getAbsolutePath(), senha);

                if (ok) {
                    JOptionPane.showMessageDialog(null, "Certificado válido! Senha correta.");
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta ou certificado inválido!");
                }
            }
        });


        // Evento botão
        btnCert.addActionListener(e -> escolherCertificado());
    }

    // Label branco
    private JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        return l;
    }

    // Abrir seletor de arquivos (.pfx)
    private void escolherCertificado() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecione o certificado A1 (.pfx)");

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Certificado Digital (*.pfx)", "pfx"
        );
        chooser.setFileFilter(filter);

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            certPathField.setText(file.getAbsolutePath());
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
