import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void passGenerate() {
        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.println("Upper or lower case available? Please input y or n:");
        choice = choice + input.next();
        System.out.println("Numbers available? Please input y or n:");
        choice = choice + input.next();
        System.out.println("Please input the available symbols in password(Without spaces separating):");
        System.out.println("If no symbol is available, please input null");
        String symbolAvailable = input.next();
        System.out.println("Please input the bound of length(if there wasn't a bound, please input -1):");
        System.out.print("minimum: ");
        int minLength = input.nextInt();
        if (minLength == -1) {
            minLength = 10;
        }
        System.out.print("maximum: ");
        int maxLength = input.nextInt();
        if (maxLength == -1) {
            maxLength = 20;
        }
        Random randomGenerator = new Random();
        int passLength = randomGenerator.nextInt(maxLength - minLength + 1) + minLength;
        generate(choice, passLength, symbolAvailable);
    }

    public static String randomNumGenerate() {
        Random randomGenerator = new Random();
        return ("" + randomGenerator.nextInt(10));
    }

    public static String randomLetterGenerate() {
        Random randomGenerator = new Random();
        int UpperOrLower = randomGenerator.nextInt(2);
        if (UpperOrLower == 0) {
            return ("" + (char) ('a' + randomGenerator.nextInt(26)));
        } else {
            return ("" + (char) ('A' + randomGenerator.nextInt(26)));
        }
    }

    public static String randomSymbolGenerate(String symbolsAvailable) {
        int l = symbolsAvailable.length();
        Random randomGenerator = new Random();
        return ("" + symbolsAvailable.charAt(randomGenerator.nextInt(l)));
    }

    public static void generate(String choice, int passLength, String symbolAvailable) {
        Scanner input = new Scanner(System.in);
        String password = "";
        Random randomGenerator = new Random();
        for (int i = 0; i < passLength; i++) {
            int selectChoice = 0;
            if (!symbolAvailable.equals("null") && choice.equals("yy")) {
                selectChoice = randomGenerator.nextInt(3);
            } else if (symbolAvailable.equals("null") && choice.equals("yy")) {
                selectChoice = randomGenerator.nextInt(2);
            }
            if (selectChoice == 0 && choice.charAt(1) == 'y') {
                password = password + randomNumGenerate();
            } else if (selectChoice == 1 && choice.charAt(0) == 'y') {
                password = password + randomLetterGenerate();
            } else {
                password = password + randomSymbolGenerate(symbolAvailable);
            }
        }

        System.out.println("Generation Success!");
        System.out.println("==============PASSWORD GENERATED==============");
        System.out.println("Your generated password is: " + password);
        System.out.println("==============CONTINUE==============");
        System.out.println("1. Store it");
        System.out.println("2. Not satisfied and to generate another one");
        System.out.println("3. Go back to menu");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Please input your choice: ");

        int intChoice = input.nextInt();
        try {
            if (intChoice == 1) {
                PasswordSave.save(password);
            } else if (intChoice == 2) {
                generate(choice, passLength, symbolAvailable);
            } else if (intChoice == 3) {
                PasswordManagement.menu();
            } else if (intChoice == 0) {
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("IOException:" + e);
        }
    }
}
