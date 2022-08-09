import java.io.IOException;
import java.util.Scanner;

public class PasswordEstimate
{
    public static void estimate() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your password:");
        String password = input.nextLine();
        int score = 0;
        boolean isTooShort = true, onlyNum = true, isUpper = false, isLower = false, isSymbol = false;
        if (password.length() > 8)
        {
            isTooShort = false;
            score = score + 1;
        }
        for (int i = 0; i < password.length(); i++)
        {
            if ((int) password.charAt(i) >= 65 && (int) password.charAt(i) <= 90)
            {
                isUpper = true;
                onlyNum = false;
            }
            else if ((int) password.charAt(i) >= 97 && (int) password.charAt(i) <= 122)
            {
                isLower = true;
                onlyNum = false;
            }
            else if (((int) password.charAt(i) >= 33 && (int) password.charAt(i) <= 47) || ((int) password.charAt(i) >= 58 && (int) password.charAt(i) <= 64) || ((int) password.charAt(i) >= 91 && (int) password.charAt(i) <= 96) || ((int) password.charAt(i) >= 123 && (int) password.charAt(i) <= 126))
            {
                isSymbol = true;
                onlyNum = false;
            }
        }
        if (!onlyNum)
        {
            score = score + 1;
        }
        if (isUpper)
        {
            score = score + 1;
        }
        if (isLower)
        {
            score = score + 1;
        }
        if (isSymbol)
        {
            score = score + 1;
        }
        System.out.println("The security score of your password is: " + score);
        if (score == 0)
        {
            System.out.println("Your password is not safe at all! Here are some advise:");
            System.out.println("1. Use a longer password.");
            System.out.println("2. Avoid using password consisted of only numbers, use letters and symbols also.");
        }
        else if (score == 1)
        {
            System.out.println("Your password is not safe. Here are some advise:");
        }
        else if (score == 2)
        {
            System.out.println("Your password is not that safe. Here are some advise:");
        }
        else if (score == 3)
        {
            System.out.println("Your password is in a medium degree. Here are some advise:");
        }
        else if (score == 4)
        {
            System.out.println("Your password is safe. Still some advise for you:");
        }
        else if (score == 5)
        {
            System.out.println("Your password is so safe! Good password!");
        }
        if (isTooShort)
        {
            System.out.println("Your password is too short! Please change to a longer one.");
        }
        if (onlyNum)
        {
            System.out.println("Your password is consisted of only numbers, please use letters and symbols also.");
        }
        if (!isLower)
        {
            System.out.println("Your password doesn't have lower letters, please use lower letters also.");
        }
        if (!isUpper)
        {
            System.out.println("Your password doesn't have upper letters, please use upper letters also.");
        }
        if (!isSymbol)
        {
            System.out.println("Your password doesn't have symbols, please use symbols also.");
        }
        System.out.println("If you want to estimate another password, please input 1");
        System.out.println("If you want to go back to menu, please input 2");
        System.out.println("If you want to exit, please input 0");
        System.out.println("Please input your choice:");
        int choice = input.nextInt();
        if (choice == 1)
        {
            estimate();
        }
        else if (choice == 2)
        {
            PasswordManagement.menu();
        }
        else if (choice == 0)
        {
            System.exit(0);
        }
    }
}
