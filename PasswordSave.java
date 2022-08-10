import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordSave {
    public static String inputInfo(boolean passInputNeeded) {
        Scanner input = new Scanner(System.in);
        String strInput = "";
        System.out.println("Please input your website:");
        strInput += input.nextLine();
        System.out.println("Please input your user name of this website:");
        strInput += ("," + input.nextLine());
        if (passInputNeeded) {
            System.out.println("Please input your password of this website:");
            strInput += ("," + input.nextLine());
        }
        return strInput;
    }

    public static void save(String password) throws IOException {
        Scanner input = new Scanner(System.in);
        File file = new File("password.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        String strInput = inputInfo(false);
        strInput += ",";
        strInput += password;
        fileWriter.write(strInput + "\r\n");
        fileWriter.close();
        System.out.println("Saving Success!");
        System.out.println("==============CONTINUE==============");
        System.out.println("1. Save another password");
        System.out.println("2. Go back to menu");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Please input your choice: ");
        int choice = input.nextInt();
        if (choice == 1) {
            save();
        } else if (choice == 2) {
            PasswordManagement.menu();
        } else {
            System.exit(0);
        }
    }

    public static void save() throws IOException {
        Scanner input = new Scanner(System.in);
        File file = new File("password.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        String strInput = inputInfo(true);
        fileWriter.write(strInput + "\r\n");
        fileWriter.close();
        System.out.println("Saving Success!");
        System.out.println("==============CONTINUE==============");
        System.out.println("1. Save another password");
        System.out.println("2. Go back to menu");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Please input your choice: ");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println();
            System.out.println("Saving this password for other websites or another password");
            System.out.println("1. This password");
            System.out.println("2. Another password");
            System.out.println();
            System.out.print("Please input your choice: ");
            choice = input.nextInt();
            if (choice == 1) {
                save(strInput);
            } else {
                save();
            }
        } else if (choice == 2) {
            PasswordManagement.menu();
        } else {
            System.exit(0);
        }
    }
}
