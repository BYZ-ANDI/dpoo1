package presentation.controllers;

import Business.UserManager;
import Business.entities.User;
import presentation.model.MainModel;
import presentation.views.LogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogController implements ActionListener {
    private LogView logview;
    private MainModel mainModel;
    private UserManager userManager;
    public LogController(LogView logview, MainModel mainModel, UserManager userManager) {
        this.logview = logview;
        this.mainModel = mainModel;
        this.userManager = userManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logview.REGISTER_COMMAND)) {
            // Pasar a la register View
            mainModel.goToRegisterView();
        }
        else if(e.getActionCommand().equals(logview.SUBMIT_COMMAND)) {
            // Pasar a la View de la Partida.
            userManager.loginUser(logview.getName(), logview.getEmail(), logview.getPassword());
            mainModel.goToMainMenuView();
        }
    }
}