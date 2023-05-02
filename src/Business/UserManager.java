package Business;

import Business.Entities.User;
import persistence.UserDAO;

public class UserManager {
    private static final String EMAIL_FORMAT = "@";
    private static final String PASSWORD_FORMAT = " ";
    private String name;
    private String email;
    private String password;
    private String confirm_password;
    public UserManager(String name, String email, String password, String confirm_password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }
    public boolean correctEmail() {
        if (!email.contains(EMAIL_FORMAT)) {
            return false;
        }
        return true;
    }
    public boolean correctPassword() {
        // Falta implementar la validacion de la password.
        if (password.length() < 8 || password.contains(PASSWORD_FORMAT)
                || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }
    public boolean confirmPassword() {
        return password.equals(confirm_password);
    }
    public void createUser (String name, String email, String password){
        UserDAO userDAO = new UserDAO();
        User user = new User(name,email,password);

        userDAO.signupUser(user);
    }

    //public
}
