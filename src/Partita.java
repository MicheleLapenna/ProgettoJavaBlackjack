import java.util.ArrayList;
import java.util.Scanner;

public class Partita {

    private Giocatore giocatore;
    private Mazziere mazziere;
    private Mazzo mazzo;


    Partita() {
        this.giocatore = new Giocatore();
        this.mazziere = new Mazziere();
        this.mazzo = new Mazzo();
        PescaCarta();
        mazzo.rimuoviCarta();
        System.out.print("Giocatore: ");
        stampaMano(giocatore.getMano());
        mazziere.setTurno(true);
        PescaCarta();
        mazzo.rimuoviCarta();
        System.out.print("Banco: ");
        stampaMano(mazziere.getMano());
        Turno();

    }


    public Mazzo getMazzo() {

        return this.mazzo;
    }

    private void Turno(){
        ChiediCarta();
        System.out.print("\nGiocatore:");
        stampaMano(giocatore.getMano());
        CalcolaPunteggio(this.giocatore.getMano());
        if(this.CalcolaPunteggio(this.giocatore.getMano())>21){
            this.giocatore.setSballatoG(true);
            System.out.println("\nhai sballato!");
        }
        System.out.print("\nBanco:");
        stampaMano(mazziere.getMano());
        sceltaMazziere();
        DeterminaVincitore();
    }

    private int CalcolaPunteggio(ArrayList<Carta> carte){
        int tot = 0;
        for(Carta o : carte){
            tot = tot + o.getValore();
        }
        return tot;
    }

    private void DeterminaVincitore(){
        if (giocatore.getSballatoG()== true){
            System.out.println("\nHai Perso!");
        }else if(giocatore.getSballatoG()== false && mazziere.getSballatoM()==true){
            System.out.println("\nHai Vinto!");
        }else if(giocatore.getSballatoG()== false && mazziere.getSballatoM()==false){
            if(CalcolaPunteggio(giocatore.getMano())>CalcolaPunteggio(mazziere.getMano())){
                System.out.println("\nHa vinto Giocatore");
            }else if(CalcolaPunteggio(giocatore.getMano())<CalcolaPunteggio(mazziere.getMano())){
                System.out.println("\nHa vinto il Banco");
            }else if(CalcolaPunteggio(giocatore.getMano())==CalcolaPunteggio(mazziere.getMano())){
                System.out.println("\nPartità");
            }

        }
    }

    private void sceltaMazziere() {//se la somma è minore di 17 continua a pescare
        if(this.giocatore.getSballatoG()==true){

        }else{
            while(this.CalcolaPunteggio(mazziere.getMano())<17){
                System.out.println("Il Banco pesca un' altra carta...");
                mazziere.setTurno(true);
                PescaCarta();
                mazzo.rimuoviCarta();
                System.out.print("\nBanco:");
                stampaMano(mazziere.getMano());
            }
            if(this.CalcolaPunteggio(mazziere.getMano())>21){
                System.out.print("\nBanco:");
                stampaMano(mazziere.getMano());
                mazziere.setSballatoM(true);
                System.out.println("\nIl mazziere ha sballato");
            }else{
                System.out.println("Il mazziere si ferma...");
            }
        }
    }

    public void PescaCarta () {


        if (mazziere.getTurnoMazziere() == true) {
            //Aggiungi a mano del mazziere
            mazziere.pescaCarta(getMazzo().ritornaCarta());
            mazziere.setTurno(mazziere.getTurnoMazziere());
        } else {
            //Aggiungi a mano del giocatore
            this.giocatore.pescaCarta(getMazzo().ritornaCarta());
            mazziere.setTurno(mazziere.getTurnoMazziere());
        }

    }

    public void stampaMano(ArrayList<Carta> mano){
        System.out.println(mano);
    }

    public void ChiediCarta(){

        String RispG="";
        while (RispG!="no"){
            if(CalcolaPunteggio(giocatore.getMano())>21){
                System.out.println("hai sballato");
                break;
            }
            System.out.print("\nCarta ? ");
            Scanner input = new Scanner(System.in);
            System.out.print("(Si o No):  ");
            RispG = input.nextLine();

            if (null == RispG) {
                System.out.println("Valore inserito non valido");

            } else {
                switch (RispG) {
                    case "SI":
                    case "si":
                    case "Si":
                        mazziere.setTurno(false);
                        PescaCarta();
                        mazzo.rimuoviCarta();
                        System.out.print("\nGiocatore:");
                        stampaMano(giocatore.getMano());
                        break;
                    case "NO":
                    case "no":
                    case "No":
                        RispG = "no";
                        break;
                    default:
                        System.out.println("Valore inserito non valido");
                        break;

                }

            }


        }
    }
}
