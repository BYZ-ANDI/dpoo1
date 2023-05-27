package Business;

import Business.entities.Game;
import Business.entities.User;
import persistence.GameDAO;

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
    public boolean inicarGame(String name_game){
        String color;
        String new_game_name = name_game + "Copy";

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
    public void existingGames(List<String> games){
        gameDAO.existingGames(games);
    }
    public String getExistingGameColor(String name_game){
        String color;

        color = gameDAO.getExistingGameColor(name_game);

        return color;
    }
    public Integer getExistingNumImp(String name_game){
        Integer n_IMP;

        n_IMP = gameDAO.getExistingNumImp(name_game);

        return n_IMP;
    }
    public Integer getExistingNumPers(String name_game){
        Integer n_PERS;

        n_PERS = gameDAO.getExistingNumPers(name_game);

        return n_PERS;
    }
    public String getExistingGameMap(String name_game){
        String mapa;

        mapa = gameDAO.getExistingGameMap(name_game);

        return mapa;
    }

}
