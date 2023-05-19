package presentation.controllers;

import Business.GameManager;
import presentation.model.MainModel;
import presentation.views.CreationGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;

public class CreationGameController implements ActionListener, MouseWheelListener {
    private CreationGameView creationGameView;
    private MainModel mainModel;
    private GameManager gameManager;

    public CreationGameController(CreationGameView creationGameView, MainModel mainModel, GameManager gameManager) {
        this.creationGameView = creationGameView;
        this.mainModel = mainModel;
        this.gameManager = gameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(creationGameView.MAP_COMMAND)) {
            // Hacer lo del JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(creationGameView);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // Lógica para procesar el archivo seleccionado
                //por ejemplo, cargar los datos en el modelo usando Gson
                mainModel.loadDataFromJsonFile(selectedFile.getName());
            }
        } else if(e.getActionCommand().equals(creationGameView.SUBMIT_COMMAND)) {
            // Pasar a la MapView || GameView
            // Hay que cambiar lo del GameManager, para que funcione bien.
            gameManager.createGame(creationGameView.getGameName(), creationGameView.getNumImpos(), creationGameView.getNumPers(), creationGameView.getColor());
            if (!gameManager.correctPersAndImpos(creationGameView.getNumImpos(), creationGameView.getNumPers())) {
                creationGameView.PersAndImposErrorMessage();
                return;
            } else if(gameManager.emptyName()) {
                creationGameView.emptyName();
                return;
            }
            gameManager.createGameData(creationGameView.getColor());
            creationGameView.createCorrect();
        } else if(e.getActionCommand().equals(creationGameView.LOGOUT_COMMAND)) {
            mainModel.goToLogoutView();
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getSource() instanceof JComboBox<?>) {
            JComboBox<?> combobox = (JComboBox<?>) e.getSource();
            // We get the rotation value of the wheel
            // Positive value = down side rotation.
            int selectedItem = combobox.getSelectedIndex();
            int offset = e.getWheelRotation();
            selectedItem += offset;
            if (selectedItem < 0) {
                selectedItem = combobox.getItemCount() + selectedItem;
            }
            selectedItem %= combobox.getItemCount();
            //combobox.setSelectedIndex(selectedItem);
            String comboBoxName = combobox.getName();

            if(comboBoxName.equals(creationGameView.NUMPERS_COMMAND)) {
                creationGameView.setNumPers(selectedItem);
            } else if(comboBoxName.equals(creationGameView.NUMIMP_COMMAND)) {
                creationGameView.setNumImpos(selectedItem);
            } else if(comboBoxName.equals(creationGameView.COLORS_COMMAND)) {
                creationGameView.setColor(selectedItem);
            }
        }
    }
}
