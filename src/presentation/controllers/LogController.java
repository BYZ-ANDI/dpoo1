package presentation.controllers;

import presentation.views.LogView;
import presentation.views.MainView;
import presentation.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogController implements ActionListener {
    private LogView logview;
    public LogController(LogView logview) {
        this.logview = logview;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logview.REGISTER_COMMAND)) {
            // Pasar a la register View
        }
        else if(e.getActionCommand().equals(logview.SUBMIT_COMMAND)) {
            // Pasar a la View de la Partida.
        }
    }
}
