import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Group members: Wenhao Chen, Yihang Wang, Chenfeng Li
 * Project: Password Management System
 * Date: 2022/8/10
 * Description: This is a class used to decrypt password file
 */

public class PasswordDecrypt {
  /**
   * This method aims to decrypt password file
   * Parameters: null (mostly use methods in PasswordEncrypt)
   * Behavior: get decrypted content and write to file
   * Return values: null
   */
  public static void decrypt() throws InvalidKeyException, NoSuchAlgorithmException, IOException,
      IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, PasswordEncrypt.getKey(PasswordEncrypt.getSeed()));
    byte[] decrypted = cipher.doFinal(PasswordEncrypt.read("password.csv.encrypted"));
    PasswordEncrypt.write(decrypted, "password_decrypted.csv");
  }
}
