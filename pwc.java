import java.util.Scanner;
import java.util.regex.Pattern;

public class StrongPasswordChecker {

    // Method to check password strength
    public static String checkPasswordStrength(String password) {
        int strengthPoints = 0;

        if (password.length() >= 8) strengthPoints++;
        if (Pattern.compile("[A-Z]").matcher(password).find()) strengthPoints++;
        if (Pattern.compile("[a-z]").matcher(password).find()) strengthPoints++;
        if (Pattern.compile("\\d").matcher(password).find()) strengthPoints++;
        if (Pattern.compile("[@$!%*?&]").matcher(password).find()) strengthPoints++;

        if (strengthPoints == 5) return "✅ Very Strong Password";
        else if (strengthPoints >= 4) return "⚡ Strong Password";
        else if (strengthPoints >= 3) return "⚠️ Medium Password";
        else return "❌ Weak Password";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println(strength);

        scanner.close();
    }
}
