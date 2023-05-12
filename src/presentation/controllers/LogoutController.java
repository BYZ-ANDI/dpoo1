package presentation.controllers;

import Business.UserManager;
import presentation.model.MainModel;
import presentation.views.LogoutView;
import Business.entities.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    private LogoutView logoutView;
    private MainModel mainModel;
    private UserManager userManager;
    private User user;
    public LogoutController(LogoutView logoutView, MainModel mainModel, UserManager userManager, User user) {
        this.logoutView = logoutView;
        this.mainModel = mainModel;
        this.userManager = userManager;
        this.user = user;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logoutView.LOGOUT_COMMAND)) {
            userManager.logoutUser();
            // Pasar a la Log View
            mainModel.goToLogView();

        }
        else if(e.getActionCommand().equals(logoutView.DELETE_COMMAND)) {
            userManager.deleteUser(user);
            // Pasar a la Log View
            mainModel.goToLogView();
        }
    }
}
