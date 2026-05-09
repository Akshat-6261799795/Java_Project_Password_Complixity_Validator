import java.util.Scanner;

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

        if (password.length() < 8){
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpper = false;

        for (int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if (Character.isDigit(ch)){
                hasDigit = true;
            }
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

public class Password_compixity_Validator{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        UserAccount user = new UserAccount(username, password);

        SecurityValidator validator = new SecurityValidator();
        boolean isValid = validator.isValid(user);

        if (isValid){
            System.out.println("Password is valid.");
        }
        else{
            System.out.println("Password is invalid.");
        }
        
        sc.close();
    }
}