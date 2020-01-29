import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Mazzo {
    private ArrayList<Carta> MazzoCarte;


    Mazzo(){
        this.MazzoCarte = new ArrayList<Carta>();
        InizializzaMazzo();
        MescolaMazzo();
    }



    private void InizializzaMazzo() {
        char seme = 0;

        for (int n_seme = 1; n_seme <= 4; n_seme++) { //per 4 volte= 4 semi

            //Selezione Seme;
            switch (n_seme) {
                case 1:
                    seme = '♥';
                    break;
                case 2:
                    seme = '♦';
                    break;
                case 3:
                    seme = '♣';
                    break;
                case 4:
                    seme = '♠';
                    break;
                default:
                    break;
            }
            //Carte Numeriche
            for (int carte = 1; carte <= 13; carte++) {

                if (carte >= 11) {

                    this.MazzoCarte.add(new Carta(carte, seme, 10));
                } else {
                    this.MazzoCarte.add(new Carta(carte, seme, carte));
                }

            }
        }
    }

    public void MescolaMazzo(){
        Collections.shuffle(MazzoCarte);
    }

    public Carta rimuoviCarta() {
        return this.MazzoCarte.remove(0);
    }

    public Carta ritornaCarta(){
        return this.MazzoCarte.get(0);
    }


}

