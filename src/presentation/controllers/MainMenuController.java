package presentation.controllers;

import presentation.model.MainModel;
import presentation.views.MainMenuView;

import javax.swing.*;
import java.awt.event.*;

public class MainMenuController implements FocusListener, ActionListener {
    private MainMenuView mainMenuView;
    private MainModel mainModel;
    public MainMenuController(MainMenuView mainMenuView, MainModel mainModel) {
        this.mainMenuView = mainMenuView;
        this.mainModel = mainModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(mainMenuView.NEWGAME_COMMAND)) {
            // Pasar a la View de Creation Game.
            mainModel.goToCreationGameView();
        } else if(e.getActionCommand().equals(mainMenuView.GAME_COMMAND)) {
            // Sacar los games del user actual en RAM, pasando a una View con la lista, para continuar partida.
        } else if(e.getActionCommand().equals(mainMenuView.SAMEGAME_COMMAND)) {
            // Pasar a su lista de Games para crear una partida con un JLabel del nombre.
        } else if(e.getActionCommand().equals(mainMenuView.LOGOUT_COMMAND)) {
            mainModel.goToLogoutView();
        } else if(e.getActionCommand().equals(mainMenuView.DELETE_COMMAND)) {
            // Pasar a su lista de Games para hacer Delete.
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField textField = (JTextField) e.getComponent();
            if (textField.getText().equals("Enter Name of Game in progress...")) {
                textField.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
