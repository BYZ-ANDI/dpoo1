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
            // Sacar los games del user actual en RAM, pasando a una View con la lista.
        } else if(e.getActionCommand().equals(mainMenuView.SAMEGAME_COMMAND)) {
            // Pasar a la view de la creationGame sin los componentes ya elegidos.
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
