package presentation.controllers;

import Business.GameManager;
import presentation.model.MainModel;
import presentation.views.MainMenuView;

import javax.swing.*;
import java.awt.event.*;

public class MainMenuController implements ActionListener {
    private MainMenuView mainMenuView;
    private MainModel mainModel;
    private GameManager gameManager;
    public MainMenuController(MainMenuView mainMenuView, MainModel mainModel, GameManager gameManager) {
        this.mainMenuView = mainMenuView;
        this.mainModel = mainModel;
        this.gameManager = gameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(mainMenuView.NEWGAME_COMMAND)) {
            // Pasar a la View de Creation Game.
            mainModel.goToCreationGameView();
        } else if(e.getActionCommand().equals(mainMenuView.GAME_COMMAND)) {
            // Buscar partida por el nombre.
        } else if(e.getActionCommand().equals(mainMenuView.SAMEGAME_COMMAND)) {
            // Buscar partida con el mismo nombre.
        } else if(e.getActionCommand().equals(mainMenuView.LOGOUT_COMMAND)) {
            mainModel.goToLogoutView();
        } else if(e.getActionCommand().equals(mainMenuView.DELETE_COMMAND)) {
            // Pasar a su lista de Games para hacer Delete.
        }
    }
}
