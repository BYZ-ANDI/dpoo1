package presentation.model;

import presentation.controllers.MainController;

public class MainModel {
    private  MainController mainController;
    public void goToLogView() {
        mainController.changeToLogView();
    }
    public void goToLogoutView() {
        mainController.changeToLogoutView();
    }
    public void goToRegisterView() {
        mainController.changeToRegisterView();
    }

    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
}
