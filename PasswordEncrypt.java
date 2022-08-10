import javax.crypto.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Group members: Wenhao Chen, Yihang Wang, Chenfeng Li
 * Project: Password Management System
 * Date: 2022/8/10
 * Description: This is a class used to encrypt password file
 * and provide reusable methods for decryption.
 */
public class PasswordEncrypt {
  /**
   * This method aims to generate key for encryption/decryption
   * Parameters: seed for generating key
   * Behavior: generate key
   * Return values: key in the type of SecretKey
   */
  public static SecretKey getKey(String seed) throws NoSuchAlgorithmException {
    KeyGenerator generator = KeyGenerator.getInstance("AES");
    SecureRandom random = new SecureRandom();
    random.setSeed(seed.getBytes());
    generator.init(random);
    SecretKey key = generator.generateKey();
    return key;
  }

  /**
   * This method aims to encrypt password file
   * Parameters: password file, seed for generating key
   * Behavior: get encrypted content
   * Return values: encrypted content in the type of byte[]
   */
  public static byte[] encrypt(String seed, byte[] content)
      throws InvalidKeyException, NoSuchAlgorithmException,
      NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, getKey(seed));
    byte[] encrypted = cipher.doFinal(content);
    return encrypted;
  }

  /**
   * This method aims to read encrypted or decrypted password file
   * Parameters: password file pathname
   * Behavior: get file content
   * Return values: decrypted or encrypted content in the type of byte[]
   */
  public static byte[] read(String pathname) throws IOException {
    File file = new File(pathname);
    byte[] content = new byte[(int) file.length()];
    FileInputStream in = new FileInputStream(file);
    in.read(content);
    in.close();
    return content;
  }

  /**
   * This method aims to write encrypted or decrypted password file
   * Parameters: password file pathname, content to be written
   * Behavior: write content to file
   * Return values: null
   */
  public static void write(byte[] content, String pathname) throws IOException {
    File encryptedFile = new File(pathname);
    FileOutputStream fos = new FileOutputStream(encryptedFile);
    fos.write(content);
    fos.close();
  }

  /**
   * This method aims to get seed from user
   * Parameters: null
   * Behavior: get seed from user
   * Return values: seed in the type of String
   */
  public static String getSeed() {
    Scanner input = new Scanner(System.in);
    System.out.println("Please input your seed:");
    String seed = input.nextLine();
    return seed;
  }

  /**
   * This method aims to show the options and execute the corresponding action
   * Parameters: null
   * Behavior: show the options and execute the corresponding action
   * Return values: null
   */
  public static void process() throws IOException {
    System.out.println("Encryption/Decryption");
    System.out.println("1. Encrypt your passwords");
    System.out.println("2. Decrypt your passwords");
    System.out.println("3. Back to main menu");
    System.out.println("0. Exit");
    System.out.println("Please input your choice:");
    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();
    switch (choice) {
      case 1:
        try {
          write(encrypt(getSeed(), read("password.csv")), "password.csv.encrypted");
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | IllegalBlockSizeException | BadPaddingException | IOException e) {
          e.printStackTrace();
        }
        break;
      case 2:
        try {
          PasswordDecrypt.decrypt();
        } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException
                 | BadPaddingException | NoSuchPaddingException | IOException e) {
          e.printStackTrace();
        }
        break;
      case 3:
        PasswordManagement.menu();
        break;
      case 0:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice!");
        process();
        break;
    }
  }
}