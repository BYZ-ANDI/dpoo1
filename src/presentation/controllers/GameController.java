package presentation.controllers;

import Business.GameManager;
//import Business.ImpostorManager;
import Business.entities.Room;
import presentation.model.MainModel;
import presentation.views.MapGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController implements ActionListener {
    private int posX;
    private int posY;
    private boolean[][] gameBoardMatrix = new boolean[4][4];
    private MainModel mainModel;
    private GameManager gameManager;
    private MapGUI mapGUI;
    private List<Room> rooms;
    private Room[][] roomsMatrix = new Room[4][4];
    private int xImpostor = 0;
    private int yImpostor = 0;
    private boolean toggleButtonPressed = false;
    public GameController(GameManager gameManager, MapGUI mapGUI, MainModel mainModel){
        this.gameManager = gameManager;
        this.mapGUI = mapGUI;
        this.mainModel = mainModel;
    }
    /*public void startImposterManager(){
        ImpostorManager impostorManager = new ImpostorManager();
        impostorManager.startImpostor(xImpostor, yImpostor);
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        rooms = mapGUI.getRooms();
        setRoomMatrix(rooms);
        posX = mapGUI.getXCirclePosition();
        posY = mapGUI.getYCirclePosition();
        if(e.getActionCommand().equals("up")){
            posY--;
            if(posY >= 0 && posY < 4){
                if(!roomsMatrix[posY][posX].getId().equals("null1") && !roomsMatrix[posY][posX].getId().equals("null2") && !roomsMatrix[posY][posX].getId().equals("null3") && !roomsMatrix[posY][posX].getId().equals("null4") && !roomsMatrix[posY][posX].getId().equals("null5")) {
                    mapGUI.uptadeCirclePosition(posY, posX);
                    System.out.println("PosY: " + posY + " PosX: " + posX);
                    //enviar a vista nueva posicion de Y
                }
            }
        }
        if(e.getActionCommand().equals("down")){
            posY++;
            if(posY >= 0 && posY < 4){
                if(!roomsMatrix[posY][posX].getId().equals("null1") && !roomsMatrix[posY][posX].getId().equals("null2") && !roomsMatrix[posY][posX].getId().equals("null3") && !roomsMatrix[posY][posX].getId().equals("null4") && !roomsMatrix[posY][posX].getId().equals("null5")) {
                    mapGUI.uptadeCirclePosition(posY, posX);
                    System.out.println("PosY: " + posY + " PosX: " + posX);
                    //enviar a vista nueva posicion de Y
                }
            }
        }
        if(e.getActionCommand().equals("left")){
            posX--;
            if(posX >= 0 && posX < 4){
                if(!roomsMatrix[posY][posX].getId().equals("null1") && !roomsMatrix[posY][posX].getId().equals("null2") && !roomsMatrix[posY][posX].getId().equals("null3") && !roomsMatrix[posY][posX].getId().equals("null4") && !roomsMatrix[posY][posX].getId().equals("null5")) {
                    mapGUI.uptadeCirclePosition(posY, posX);
                    System.out.println("PosY: " + posY + " PosX: " + posX);
                    //enviar a vista nueva posicion de X
                }
            }
        }
        if(e.getActionCommand().equals("right")){
            posX++;
            if(posX >= 0 && posX < 4){
                if(!roomsMatrix[posY][posX].getId().equals("null1") && !roomsMatrix[posY][posX].getId().equals("null2") && !roomsMatrix[posY][posX].getId().equals("null3") && !roomsMatrix[posY][posX].getId().equals("null4") && !roomsMatrix[posY][posX].getId().equals("null5")) {
                    mapGUI.uptadeCirclePosition(posY, posX);
                    System.out.println("PosY: " + posY + " PosX: " + posX);
                    //enviar a vista nueva posicion de X
                }
            }
        }
        if(e.getActionCommand().equals("toggle")){
            if (!toggleButtonPressed){
                toggleButtonPressed = true;
                mapGUI.seeMap();
            } else {
                toggleButtonPressed = false;
                mapGUI.hideMap();
            }

        }
        if(e.getActionCommand().equals("logout")){
            mainModel.goToLogoutView();
            //gameExit();
            //recibir de gameView los parámetros
        }
    }

    private void setRoomMatrix(List<Room> rooms) {
        int iterador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                roomsMatrix[i][j] = rooms.get(iterador);
                iterador++;
            }
        }
    }
    private boolean movementValid() {
        if(true){
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

    public void setFila(int impostorYPosition) {
        this.posY = impostorYPosition;
    }

    public void setColumna(int impostorXPosition) {
        this.posX = impostorXPosition;
    }
}