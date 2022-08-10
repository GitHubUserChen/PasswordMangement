/**
 * Group members: Wenhao Chen, Yihang Wang, Chenfeng Li Project: Password Management System Date:
 * 2022/8/10 Description: This is a class used to show the saving password.
 */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PasswordShow {

  /**
   * This method aims to show to saving password
   * Parameters: null
   * Behavior: Show the saving password
   * Return values: null
   * Possible errors: IOException: Print exception message
   */
  public static void show() throws IOException {
    File file = new File("password.csv");
    String content;
    try {

      InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file),
          StandardCharsets.UTF_8);
      BufferedReader bufferedReader = new BufferedReader(streamReader);
      System.out.println("Your stored passwords are below:");
      System.out.println("==============SHOW==============");
      System.out.println("Webisite\tUsername\tPassword");
      while ((content = bufferedReader.readLine()) != null) {
        String[] str = content.split(",");
        System.out.println(str[0] + " " + str[1] + " " + str[2]);
      }
    } catch (IOException e) {
      System.out.println("IOException.");
    }
  }
}