package Business;

import Business.entities.Game;
import Business.entities.User;
import persistence.GameDAO;

public class GameManager {
    private String name_game;
    private int N_persponajes;
    private int N_impostores;
    private String mapa;
    private String name_user;
    private String email;
    private String password;
    public GameManager(String name_game, int N_persponajes, int N_impostores, String mapa, String name_user, String email, String password){
        this.name_game = name_game;
        this.N_persponajes = N_persponajes;
        this.N_impostores = N_impostores;
        this.mapa = mapa;
        this.name_user = name_user;
        this.email = email;
        this.password = password;
    }

    public void createGame(String name_game, int N_persponajes, int N_impostores, String mapa, String name_user, String email, String password, String color){
        GameDAO gameDAO = new GameDAO();
        Game game = new Game(name_game, N_persponajes, N_impostores, mapa);
        User user = new User(name_user, email, password);

        gameDAO.gameRecord(game, user, color);
    }

    public void inicarGame(String name_game, int N_persponajes, int N_impostores, String mapa){
        GameDAO gameDAO = new GameDAO();
        Game game = new Game(name_game, N_persponajes, N_impostores, mapa);

        gameDAO.startGame(game);
    }
    /*
    public void createUser (String name, String email, String password){
        UserDAO userDAO = new UserDAO();
        User user = new User(name,email,password);

        userDAO.signupUser(user);
    }
     */
}
