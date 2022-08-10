import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * PasswordEncrypt
 */
public class PasswordEncrypt {

    public static SecretKey getKey(String seed) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        random.setSeed(seed.getBytes());
        generator.init(random);
        SecretKey key = generator.generateKey();
        return key;
    }

    public static byte[] encrypt(String seed, byte[] content) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getKey(seed));
        byte[] encrypted = cipher.doFinal(content);
        return encrypted;
    }

    public static byte[] read(String pathname) throws IOException {
        File file = new File(pathname);
        byte[] content = new byte[(int) file.length()];
        FileInputStream in = new FileInputStream(file);
        in.read(content);
        in.close();
        return content;
    }

    public static void write(byte[] content, String pathname) throws IOException {
        File encryptedFile = new File(pathname);
        FileOutputStream fos = new FileOutputStream(encryptedFile);
        fos.write(content);
        fos.close();
    }

    public static String getSeed() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your seed:");
        String seed = input.nextLine();
        return seed;

    }
}