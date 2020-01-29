import java.util.ArrayList;

public class Giocatore {


    private ArrayList<Carta> manoG;
    private boolean sballatoG;

    Giocatore() {
        this.manoG = new ArrayList<Carta>();
        this.sballatoG = false;
    }

    public void pescaCarta(Carta C) {
        this.manoG.add(C);
    }

    public ArrayList<Carta> getMano() {
        return this.manoG;
    }

    public void setSballatoG(boolean bol){
        this.sballatoG = bol;
    }

    public boolean getSballatoG(){
        return this.sballatoG;
    }

}
