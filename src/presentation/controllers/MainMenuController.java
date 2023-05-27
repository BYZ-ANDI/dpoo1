package presentation.controllers;

import Business.GameManager;
import Business.entities.Game;
import presentation.model.MainModel;
import presentation.views.MainMenuView;
import presentation.views.MapGUI;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenuController implements ActionListener {
    private MainMenuView mainMenuView;
    private MainModel mainModel;
    private GameManager gameManager;
    private MapGUI mapGUI;

    public MainMenuController(MainMenuView mainMenuView, MainModel mainModel, GameManager gameManager, MapGUI mapGUI) {
        this.mainMenuView = mainMenuView;
        this.mainModel = mainModel;
        this.gameManager = gameManager;
        this.mapGUI = mapGUI;
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
            }else {
                if (gameManager.inicarGame(mainMenuView.getJtfSameGame())){
                    mainMenuView.GameLoadSuccessMessage();
                    mapGUI.setColor(gameManager.getExistingGameColor(mainMenuView.getJtfSameGame()));
                    mapGUI.setNumImpostores(gameManager.getExistingNumImp(mainMenuView.getJtfSameGame()),gameManager.getExistingNumPers(mainMenuView.getJtfSameGame()));
                    mainModel.loadDataFromJsonFile(gameManager.getExistingGameMap(mainMenuView.getJtfSameGame()));
                    mainModel.goToMapView();
                }else {
                    mainMenuView.GameLoadErrorMessage();
                }
            }
        } else if (e.getActionCommand().equals(mainMenuView.EXISTING_COMMAND)) {
            List<String> games = new ArrayList<>();
            gameManager.existingGames(games);
            mainMenuView.existingGames(games);
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
