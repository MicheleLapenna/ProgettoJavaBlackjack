import java.util.ArrayList;



public class Mazziere {

    private boolean TurnoMazziere;
    private boolean sballatoM;
    private ArrayList<Carta> manoM;

    Mazziere() {
        this.TurnoMazziere = false;
        this.manoM = new ArrayList<Carta>();
        this.sballatoM = false;

    }

    public void pescaCarta(Carta C) {
        this.manoM.add(C);
    }

    public void setTurno(boolean bol) {
        this.TurnoMazziere=bol;
    }

    public ArrayList<Carta> getMano(){
        return this.manoM;
    }

    public void setSballatoM(boolean bol){
        this.sballatoM = bol;
    }
    
    public boolean getSballatoM(){
        return this.sballatoM;
    }

    public boolean getTurnoMazziere(){
        return this.TurnoMazziere;
    }
}