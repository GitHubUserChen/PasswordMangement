import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class PasswordDecrypt {
    public static void decrypt() throws InvalidKeyException, NoSuchAlgorithmException, IOException,
            IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, PasswordEncrypt.getKey(PasswordEncrypt.getSeed()));
        byte[] decrypted = cipher.doFinal(PasswordEncrypt.read("password.csv.encrypted"));
        PasswordEncrypt.write(decrypted, "password_decrypted.csv");
    }
}
