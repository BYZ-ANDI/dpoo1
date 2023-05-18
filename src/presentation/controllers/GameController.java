package presentation.controllers;

import Business.GameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private int posX;
    private int posY;
    private boolean[][] gameBoardMatrix = new boolean[4][4];
    private GameManager gameManager;
    public GameController(GameManager gameManager){
        this.gameManager = gameManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        posX = getCharacterPosX();
        posY = getCharacterPosY();
        if(e.getActionCommand().equals("U")){
            posY++;
            if(movementValid()){
                //enviar a vista nueva posicion de Y
            }
        }
        if(e.getActionCommand().equals("D")){
            posY--;
            if(movementValid()){
                //enviar a vista nueva posicion de Y
            }
        }
        if(e.getActionCommand().equals("L")){
            posX--;
            if(movementValid()){
                //enviar a vista nueva posicion de X
            }
        }
        if(e.getActionCommand().equals("R")){
            posX++;
            if(movementValid()){
                //enviar a vista nueva posicion de X
            }
        }
        if(e.getActionCommand().equals("EXIT")){
            //gameExit();
            //recibir de gameView los parámetros
        }
    }
    private boolean movementValid() {
        if(gameBoardMatrix[posX][posY]){
            return true;
        }
        return false;
    }
    private int getCharacterPosY() {
        return 0;
    }

    private int getCharacterPosX() {
        return 0;
    }
    private void reciveMatrix(){
        //recibir matriz de vista
    }
    private void gameExit(String partidaName, int n_personajes, int n_impostores, String mapa){
        gameManager.savePartida(partidaName,n_personajes,n_impostores,mapa);
    }
}