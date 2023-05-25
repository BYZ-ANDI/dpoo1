package presentation.controllers;

import Business.GameManager;
import Business.entities.Player;
import presentation.model.MainModel;
import presentation.views.CreationGameView;
import presentation.views.GameTrackingView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameTrackingController implements ActionListener{
    private GameTrackingView gameTrackingView;
    private MainModel mainModel;
    private GameManager gameManager;
    private List<Player> personajes;

    public GameTrackingController(MainModel mainModel, GameManager gameManager) {
        this.mainModel = mainModel;
        this.gameManager = gameManager;

        gameTrackingView = new GameTrackingView(mainModel, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        Player personaje = (Player) sourceButton.getClientProperty("personaje");

        if (sourceButton.getText().equals("<")) {
            moverPersonajeIzquierda(personaje);
        } else if (sourceButton.getText().equals(">")) {
            moverPersonajeDerecha(personaje);
        }

        gameTrackingView.actualizarVista();
    }
    public void moverPersonajeIzquierda(Player personaje) {
        if (personaje.getClasified().equals("Suspicious")) {
            personaje.setClasified("Unknown");
        } else if (personaje.getClasified().equals("No suspicious")) {
            personaje.setClasified("Suspicious");
        }
    }

    public void moverPersonajeDerecha(Player personaje) {
        if (personaje.getClasified().equals("Unknown")) {
            personaje.setClasified("Suspicious");
        } else if (personaje.getClasified().equals("Suspicious")) {
            personaje.setClasified("No suspicious");
        }
    }

    public GameTrackingView getGameTrackingView() {
        return gameTrackingView;
    }
}
