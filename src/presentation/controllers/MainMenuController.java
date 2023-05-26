package presentation.controllers;

import Business.GameManager;
import Business.entities.Game;
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
            if (mainMenuView.getJtfSameGame().isEmpty()){
                mainMenuView.emptyNameSettingsGame();
            }else if(mainMenuView.getJtfSameGameName().isEmpty()){
                mainMenuView.emptyNameNewGame();
            }else{
                if (gameManager.inicarGame(mainMenuView.getJtfSameGame(), mainMenuView.getJtfSameGameName())){
                    mainMenuView.GameLoadSuccessMessage();
                    mainModel.goToMapView();
                }else {
                    mainMenuView.GameLoadErrorMessage();
                }
            }
        } else if(e.getActionCommand().equals(mainMenuView.LOGOUT_COMMAND)) {
            mainModel.goToLogoutView();
        } else if(e.getActionCommand().equals(mainMenuView.DELETE_COMMAND)) {
            if (gameManager.deleteGame(mainMenuView.getJtfSameGame())){
                mainMenuView.GameDeletionSuccessMessage();
            }else {
                mainMenuView.GameDeletionErrorMessage();
            }
        }
    }
}
