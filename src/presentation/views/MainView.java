package presentation.views;

import com.sun.tools.javac.Main;
import presentation.controllers.LogController;
import presentation.controllers.LogoutController;
import presentation.controllers.RegisterController;
import presentation.model.MainModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private LogView logView;
    private LogoutView logoutView;
    private RegisterView registerView;
    private MainModel mainModel;
    public MainView(MainModel mainModel) {
        this.mainModel = mainModel;
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

        logView = new LogView();
        logView.setName("Log In");
        LogController logController = new LogController(logView, mainModel);
        logView.registController(logController);
        getContentPane().add(logView, "Log In");

        logoutView = new LogoutView();
        logoutView.setName("Logout");
        LogoutController logoutController = new LogoutController(logoutView, mainModel);
        logoutView.registController(logoutController);
        getContentPane().add(logoutView, "Logout");

        registerView = new RegisterView();
        registerView.setName("Register");
        RegisterController registerController = new RegisterController(registerView, mainModel);
        registerView.registController(registerController);
        getContentPane().add(registerView, "Register");
    }
    public void start() {
        showLogoutView();
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