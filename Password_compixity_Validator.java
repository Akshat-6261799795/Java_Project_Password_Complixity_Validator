import java.util.Scanner;

// Simple container for the user's login credentials.
class UserAccount{

    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class SecurityValidator{
    public boolean isValid(UserAccount user){

        String password = user.getPassword();

        // Password must be at least 8 characters long.
        if (password.length() < 8){
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpper = false;

        // Check each character for a digit and an uppercase letter.
        for (int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            // Character.isDigit checks whether the character is a numeric digit.
            if (Character.isDigit(ch)){
                hasDigit = true;
            }
            // Character.isUpperCase checks whether the character is an uppercase letter.
            if (Character.isUpperCase(ch)){
                hasUpper = true;
            }
        }

        if (hasDigit && hasUpper){
            return true;
        }
        return false;

    }
}

// Main entry point for prompting the user and validating the password.

public class Password_compixity_Validator{
    public static void main(String[] args){
        
        // Create a Scanner to read text input from the user.
        Scanner sc = new Scanner(System.in);
        
        // Read username and password from the console.
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        UserAccount user = new UserAccount(username, password);     

        SecurityValidator validator = new SecurityValidator();
        boolean isValid = validator.isValid(user);

        String validity = isValid ? "valid" : "invalid";
        switch (validity) {
            case "valid":
                System.out.println("Password is valid.");
                break;
            case "invalid":
                System.out.println("Password is invalid.");
                break;
            default:
                System.out.println("Password validation result unknown.");
                break;
        }
        
        // Close the Scanner to release the underlying input stream.
        sc.close();
    }
}