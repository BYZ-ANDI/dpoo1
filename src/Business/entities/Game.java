package Business.entities;

public class Game {
    String name;
    int N_persponajes;
    int N_impostores;
    String mapa;

    public Game(String name, int N_persponajes, int N_impostores, String mapa) {
        this.name = name;
        this.N_persponajes = N_persponajes;
        this.N_impostores = N_impostores;
        this.mapa = mapa;
    }

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public int getN_persponajes(){return this.N_persponajes;}
    public void setN_persponajes(int N_persponajes){this.N_persponajes = N_persponajes;}
    public int getN_impostores() {return this.N_impostores;}
    public void setN_impostores(int N_impostores){this.N_impostores = N_impostores;}

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }
}
