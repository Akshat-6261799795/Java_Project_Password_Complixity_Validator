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

class SecutiryValidator{
    public boolean isValid(UserAccount user){

        String password = user.getPassword();

        if (password.length()<8){
            return false;

        }

    }

}
public class Password_compixity_Validator{
    public static void main(String[] args){
        
    }
}