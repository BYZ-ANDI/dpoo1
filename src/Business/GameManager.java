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
    private Map mapa;

    public GameManager(Game game, GameDAO gameDAO, User user, Map mapa){
        this.game = game;
        this.gameDAO = gameDAO;
        this.user = user;
        this.mapa = mapa;
    }

    public void createGame(String name_game, int N_persponajes, int N_impostores, String color){
        game.setName(name_game);
        game.setN_impostores(N_persponajes);
        game.setN_persponajes(N_impostores);
        game.setMapa(mapa);
    }
    public void createGameData(String color) {
        gameDAO.gameRecord(game, user, color);
    }

    public void inicarGame(String name_game, int N_persponajes, int N_impostores){
        game.setName(name_game);
        game.setN_impostores(N_persponajes);
        game.setN_persponajes(N_impostores);
        game.setMapa(mapa);

        gameDAO.startGame(game);
    }
    /*
    public void createUser (String name, String email, String password){
        UserDAO userDAO = new UserDAO();
        User user = new User(name,email,password);

        userDAO.signupUser(user);
    }
     */
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
