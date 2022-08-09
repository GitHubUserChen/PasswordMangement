import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordSave
{
    public static void save(String password) throws IOException
    {
        Scanner input = new Scanner(System.in);
        File file = new File("password.xlsx");
        FileWriter fileWriter = new FileWriter(file, true);
        System.out.println("Please input your website:");
        String strInput = input.nextLine();
        fileWriter.write(strInput);
        fileWriter.write("\t");
        System.out.println("Please input your user name of this website:");
        strInput = input.nextLine();
        fileWriter.write(strInput);
        fileWriter.write("\t");
        fileWriter.write(password);
        fileWriter.write("\n");
        fileWriter.close();
        System.out.println("Saving Success!");
        System.out.println("If you want to save another, please input 1.");
        System.out.println("If you want to go back to menu, please input 2.");
        System.out.println("If you want to exit, please input 0.");
        System.out.println("Please input your choice:");
        int choice = input.nextInt();
        if (choice == 1)
        {
            save();
        }
        else if (choice == 2)
        {
            PasswordManagement.menu();
        }
        else
        {
            System.exit(0);
        }
    }

    public static void save() throws IOException
    {
        Scanner input = new Scanner(System.in);
        File file = new File("password.xlsx");
        FileWriter fileWriter = new FileWriter(file, true);
        System.out.println("Please input your website:");
        String strInput = input.nextLine();
        fileWriter.write(strInput);
        fileWriter.write("\t");
        System.out.println("Please input your user name of this website:");
        strInput = input.nextLine();
        fileWriter.write(strInput);
        fileWriter.write("\t");
        System.out.println("Please input your password:");
        strInput = input.nextLine();
        fileWriter.write(strInput);
        fileWriter.write("\n");
        fileWriter.close();
        System.out.println("Saving Success!");
        System.out.println("If you want to save another password, please input 1.");
        System.out.println("If you want to go back to menu, please input 2.");
        System.out.println("If you want to exit, please input 0.");
        System.out.println("Please input your choice:");
        int choice = input.nextInt();
        if (choice == 1)
        {
            System.out.println("Saving this password for other websites or another password");
            System.out.println("1. This password.");
            System.out.println("2. Another password.");
            System.out.println("Please input your choice:");
            choice = input.nextInt();
            if (choice == 1)
            {
                save(strInput);
            }
            else
            {
                save();
            }
        }
        else if (choice == 2)
        {
            PasswordManagement.menu();
        }
        else
        {
            System.exit(0);
        }
    }
}
