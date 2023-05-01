package presentation.controllers;

import presentation.views.LogView;
import presentation.views.LogoutView;
import presentation.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    private LogoutView logoutView;
    public LogoutController(LogoutView logoutView) {
        this.logoutView = logoutView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logoutView.LOGOUT_COMMAND)) {
            // Pasar a la Log View
            // Reiniciar el user actual?
        }
        else if(e.getActionCommand().equals(logoutView.DELETE_COMMAND)) {
            // Pasar a la Log View
            // Eliminar en la database.
        }
    }
}
