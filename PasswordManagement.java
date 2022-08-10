/**
 * Group members: Wenhao Chen, Yihang Wang, Chenfeng Li Project: Password Management System Date:
 * 2022/8/10 Description: This is the main class of the project, calling other methods to use
 * functions.
 */

import java.io.IOException;
import java.util.Scanner;

public class PasswordManagement {

  /**
   * This method is the main method to start the program
   * Parameters: null
   * Behavior: Start program
   * Return values: null
   * Possible errors: IOException: Handle in other method
   */
  public static void main(String[] args) throws IOException {
    System.out.println("==============WELCOME==============");
    System.out.println("Welcome to Password Management System!");
    menu();
  }

  /**
   * This method aims to show the main menu of the program
   * Parameters: null
   * Behavior: Show main menu and call functions
   * Return values: null
   * Possible errors: IOException: Print exception message
   */
  public static void menu() throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.println("==============MENU==============");
    System.out.println("1. Password generator");
    System.out.println("2. Save the existing password");
    System.out.println("3. List your information");
    System.out.println("4. Estimate the security of your password");
    System.out.println("5. Encrypt/Decrypt your password");
    System.out.println("0. exit");
    System.out.println();
    System.out.print("Please input your choice: ");
    int choice = input.nextInt();
    if (choice == 1) {
      passGenerate();
    } else if (choice == 2) {
      save();
    } else if (choice == 3) {
      show();
    } else if (choice == 4) {
      estimate();
    } else if (choice == 5) {
      encrypt();
    } else if (choice == 0) {
      System.exit(0);
    } else {
      System.out.println("Invalid input!");
      menu();
    }
  }

  /**
   * This method aims to call the password generating function
   * Parameters: null
   * Behavior: Call password generate function
   * Return values: null
   * Possible errors: null
   */
  public static void passGenerate() {
    PasswordGenerator.passGenerate();
  }

  /**
   * This method aims to call password saving function
   * Parameters: null
   * Behavior: Call password saving function
   * Return values: null
   * Possible errors: IOException: Handle in other method
   */
  public static void save() throws IOException {
    PasswordSave.save();
  }

  /**
   * This method aims to call password showing function
   * Parameters: null
   * Behavior: Call password showing function
   * Return values: null
   * Possible errors: IOException: Handle in other method
   */
  public static void show() throws IOException {
    PasswordShow.show();
  }

  /**
   * This method aims to call password security estimating function
   * Parameters: null
   * Behavior: Call password security estimating function
   * Return values: null
   * Possible errors: IOException: Handle in other method
   */
  public static void estimate() throws IOException {
    PasswordEstimate.estimate();
  }

  public static void encrypt() throws IOException {
    PasswordEncrypt.process();
  }
}
