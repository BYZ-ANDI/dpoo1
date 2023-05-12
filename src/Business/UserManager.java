package Business;

import Business.entities.User;
import persistence.UserDAO;

public class UserManager {
    private static final String EMAIL_FORMAT = "@";
    private static final String PASSWORD_FORMAT = " ";
    private User user;
    private UserDAO userDAO;
    private String confirm_password;

    public UserManager(User user, UserDAO userDAO) {
        this.user = user;
        this.userDAO = userDAO;
    }
    public boolean correctEmail() {
        if (!user.getMail().contains(EMAIL_FORMAT)) {
            resetUser();
            return false;
        }
        return true;
    }
    public boolean correctPassword() {
        // Falta implementar la validacion de la password.
        if (user.getPassword().length() < 8 || user.getPassword().contains(PASSWORD_FORMAT)
                || !user.getPassword().matches(".*[A-Z].*") || !user.getPassword().matches(".*[a-z].*") || !user.getPassword().matches(".*[0-9].*")) {
            resetUser();
            return false;
        }
        return true;
    }
    public boolean confirmPassword() {
        if(user.getPassword().equals(confirm_password)) {
            return true;
        }
        resetUser();
        return false;
    }
    public void createUser (String name, String email, String password){
        user.setName(name);
        user.setMail(email);
        user.setPassword(password);

        userDAO.signupUser(user);
    }

    public void loginUser ( String name, String email, String password){
        user.setName(name);
        user.setMail(email);
        user.setPassword(password);

        if(userDAO.loginUser(user)){
            System.out.println("Success");
        }
    }

    public void deleteUser(User user){
        userDAO.deleteUser(user);
        resetUser();
    }
    public void logoutUser(){
        resetUser();
    }
    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    public void resetUser() {
        user.setName(null);
        user.setMail(null);
        user.setPassword(null);
    }
}
