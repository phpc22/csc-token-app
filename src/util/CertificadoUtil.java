package util;

import java.io.FileInputStream;
import java.security.KeyStore;

public class CertificadoUtil {

    public static boolean validarSenha(String caminhoPfx, String senha) {
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(caminhoPfx);
            ks.load(fis, senha.toCharArray());
            fis.close();

            return true; // senha correta
        } catch (Exception e) {
            return false; // senha errada ou certificado inválido
        }
    }
}
