package presentation.controllers;

import Business.model.MainModel;
import presentation.views.LogoutView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    private LogoutView logoutView;
    private MainModel mainModel;
    public LogoutController(LogoutView logoutView, MainModel mainModel) {
        this.logoutView = logoutView;
        this.mainModel = mainModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logoutView.LOGOUT_COMMAND)) {
            // Pasar a la Log View
            mainModel.goToLogView();
            // Reiniciar el user actual?
        }
        else if(e.getActionCommand().equals(logoutView.DELETE_COMMAND)) {
            // Pasar a la Log View
            mainModel.goToLogView();
            // Eliminar en la database.
        }
    }
}
