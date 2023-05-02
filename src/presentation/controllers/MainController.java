package presentation.controllers;

import presentation.model.MainModel;
import presentation.views.MainView;

public class MainController {
    private MainView mainView;
    public MainController(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        mainModel.setController(this);
    }
    public void changeToLogView() {
        mainView.showLoginView();
    }
    public void changeToLogoutView() {
        mainView.showLogoutView();
    }
    public void changeToRegisterView() {
        mainView.showRegisterView();
    }
}
