package presentation.controllers;

import presentation.model.MainModel;
import presentation.views.LogView;
import presentation.views.MainView;
import presentation.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogController implements ActionListener {
    private LogView logview;
    private MainModel mainModel;
    public LogController(LogView logview, MainModel mainModel) {
        this.logview = logview;
        this.mainModel = mainModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logview.REGISTER_COMMAND)) {
            // Pasar a la register View
            mainModel.goToRegisterView();

        }
        else if(e.getActionCommand().equals(logview.SUBMIT_COMMAND)) {
            // Pasar a la View de la Partida.
        }
    }
}