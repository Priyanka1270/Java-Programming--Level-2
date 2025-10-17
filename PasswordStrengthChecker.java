import java.util.Scanner;
import java.util.regex.*;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        sc.close();

        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String password) {
        int strength = 0;
        StringBuilder feedback = new StringBuilder();
        if (password.length() >= 8) {
            strength++;
        } else {
            feedback.append("• Password should be at least 8 characters long.\n");
        }
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            strength++;
        } else {
            feedback.append("• Add lowercase letters.\n");
        }
        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            strength++;
        } else {
            feedback.append("• Add uppercase letters.\n");
        }
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            strength++;
        } else {
            feedback.append("• Add numbers.\n");
        }
        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            strength++;
        } else {
            feedback.append("• Add special characters (e.g., @, #, $, %).\n");
        }
        System.out.println("\nPassword Strength:");
        if (strength == 5) {
            System.out.println(" Strong Password ");
        } else if (strength >= 3) {
            System.out.println(" Moderate Password ");
        } else {
            System.out.println("Weak Password ");
        }
        if (feedback.length() > 0) {
            System.out.println("\nSuggestions to improve your password:");
            System.out.println(feedback.toString());
        }
    }
}
