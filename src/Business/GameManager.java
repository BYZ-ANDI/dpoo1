package Business;

import Business.entities.Game;
import Business.entities.Map;
import Business.entities.User;
import persistence.GameDAO;

import javax.xml.crypto.Data;
import java.util.List;

public class GameManager {
    private Game game;
    private GameDAO gameDAO;
    private User user;


    public GameManager(Game game, GameDAO gameDAO, User user){
        this.game = game;
        this.gameDAO = gameDAO;
        this.user = user;
    }
    public void createGame(String name_game, int N_persponajes, int N_impostores, String color, String mapa){
        game.setName(name_game);
        game.setN_impostores(N_persponajes);
        game.setN_persponajes(N_impostores);
        game.setMapa(mapa);
    }
    public void createGameData(String color) {
        gameDAO.gameRecord(game, user, color);
    }

    public boolean inicarGame(String name_game, String new_game_name){
        String color;

        if(!gameDAO.findGame(name_game)){
            return false;
        }

        game = gameDAO.startGame(name_game, new_game_name, game);

        color = gameDAO.getGameColor(name_game);
        gameDAO.gameRecord(game,user, color);

        return true;
    }

    public boolean deleteGame(String game_game){
        if(gameDAO.deleteGame(game_game)){
            resetGame();
            return true;
        }
        return  false;
    }
    public boolean correctPersAndImpos(int N_impostores, int N_persponajes) {
        if (N_impostores > N_persponajes / 3) {
            resetGame();
            return false;
        }
        return true;
    }
    public void resetGame() {
        game.setName(null);
        game.setN_persponajes(0);
        game.setN_impostores(0);
        game.setMapa(null);
    }
    public boolean emptyName() {
        if(game.getName().isEmpty()) {
            resetGame();
            return true;
        }
        return false;
    }
    public void savePartida(String partidaName, int n_personajes, int n_impostores, String mapa){
        gameDAO.saveGame(partidaName,n_personajes,n_impostores,mapa);
    }
}
