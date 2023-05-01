package presentation.views;

import presentation.controllers.LogController;
import presentation.controllers.LogoutController;
import presentation.controllers.RegisterController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private JPanel views;
    public MainView() {
        setLayout(new BorderLayout());
        configWindow();
        configLayout();
    }

    private void configWindow() {
        setSize(900,650);
        setTitle("Between Us");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void configLayout() {
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        LogView logView = new LogView();
        logView.setName("Log In");
        LogController logController = new LogController(logView);
        logView.registController(logController);
        getContentPane().add(logView, "Log In");

        LogoutView logoutView = new LogoutView();
        logoutView.setName("Logout");
        LogoutController logoutController = new LogoutController(logoutView);
        logoutView.registController(logoutController);
        getContentPane().add(logoutView, "Logout");

        RegisterView registerView = new RegisterView();
        registerView.setName("Register");
        RegisterController registerController = new RegisterController(registerView);
        registerView.registController(registerController);
        getContentPane().add(registerView, "Register");
    }
    public void start() {
        showLoginView();
        setVisible(true);
    }
    public void showLoginView() {
        cardLayout.show(getContentPane(), "Log In");
    }
    public void showRegisterView() {
        cardLayout.show(getContentPane(), "Register");
    }
    public void showLogoutView() {
        cardLayout.show(getContentPane(), "Logout");
    }
}
