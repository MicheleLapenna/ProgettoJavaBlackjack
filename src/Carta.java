public class Carta {

    private int numero;
    private char seme;
    private int valore;

    Carta(int numero, char seme, int valore){
        this.numero = numero;
        this.seme = seme;
        this.valore = valore;
    }


    public int getValore() {
        return this.valore;
    }

    @Override
    public String toString() {
            if( numero == 11){
                return  "J" + seme;
            }else if(numero == 12){
                return "Q"+seme;
            }else if(numero == 13){
                return "K"+seme;
            }else {
                return numero + "" + seme;
            }
    }
    }
