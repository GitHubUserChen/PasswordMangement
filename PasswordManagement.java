import java.io.IOException;
import java.util.Scanner;

public class PasswordManagement
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to Password Management System!");
        menu();
    }

    public static void menu() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1. Password generator");
        System.out.println("2. Save the existing password");
        System.out.println("3. List your information");
        System.out.println("4. Estimate the security of your password");
        System.out.println("0. exit");
        System.out.println("Please input your choice:");
        int choice = input.nextInt();
        if (choice == 1)
        {
            passGenerate();
        }
        else if (choice == 2)
        {
            save();
        }
        else if (choice == 3)
        {
            show();
        }
        else if (choice == 4)
        {
            estimate();
        }
        else if (choice == 0)
        {
            System.exit(0);
        }
    }

    public static void passGenerate()
    {
        PasswordGenerator.passGenerate();
    }

    public static void save() throws IOException
    {
        PasswordSave.save();
    }

    public static void show() throws IOException
    {
        PasswordShow.show();
    }

    public static void estimate() throws IOException
    {
        PasswordEstimate.estimate();
    }
}
