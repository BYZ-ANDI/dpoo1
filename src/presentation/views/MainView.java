package presentation.views;

import presentation.controllers.*;
import presentation.model.MainModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private LogView logView;
    private LogoutView logoutView;
    private RegisterView registerView;
    private MainModel mainModel;
    private MainMenuView mainMenuView;
    private CreationGameView creationGameView;
    private MapGUI mapGUI;
    public MainView(MainModel mainModel, LogView logView, LogoutView logoutView, RegisterView registerView, MainMenuView mainMenuView, CreationGameView creationGameView, MapGUI mapGUI) {
        this.mainModel = mainModel;
        this.logView = logView;
        this.logoutView = logoutView;
        this.registerView = registerView;
        this.mainMenuView = mainMenuView;
        this.creationGameView = creationGameView;
        this.mapGUI = mapGUI;
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

        logView.setName("Log In");
        getContentPane().add(logView, "Log In");

        logoutView.setName("Logout");
        getContentPane().add(logoutView, "Logout");

        registerView.setName("Register");
        getContentPane().add(registerView, "Register");

        mainMenuView.setName("Menu");
        getContentPane().add(mainMenuView, "Menu");

        creationGameView.setName("Creation Game");
        getContentPane().add(creationGameView, "Creation Game");

        mapGUI.setName("Map");
        getContentPane().add(mapGUI, "Map");
    }
    public void start() {
        //showLogoutView();
        showMainMenuView();
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
    public void showMainMenuView() {
        cardLayout.show(getContentPane(), "Menu");
    }
    public void showCreationGameView() {
        cardLayout.show(getContentPane(), "Creation Game");
    }
    public void showMapView(){cardLayout.show(getContentPane(), "Map");}
}
