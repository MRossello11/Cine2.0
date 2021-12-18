/**
 * @author MRossello11
 * @version 2.2
 * @since 10/12/2021
 * @description clase Asiento del proyecto Cine*/
package Parte2v20;

public class Asiento {
    //colores
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    //constantes
                                      //0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31
    private final String[] ALFABETO = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f"};
    private final int NUMLETRAS = 26;

    //atributos
    private int fil;
    private int col;
    private boolean ocupado;
    private Espectador espectador;

    //constructor
    public Asiento(int fil, int col) {
        this.fil = fil;
        this.col = col;
        this.ocupado = false;
    }

    //getters y setters
    public String getPosicion(int colActual){
        if (!isOcupado()){//si no esta ocupado, se presenta el numero de asiento en rojo
            return ANSI_GREEN + getFil() + "" + getLetra(colActual) + ANSI_RESET; //el reset es para que el color no se extienda al resto de outputs

        } else { //si esta ocupado, se muestra en rojo
            return ANSI_RED + getFil() + "" + getLetra(colActual) + ANSI_RESET;
        }
    }
    //devuelve la letra correspondiente a la columna actual (0=A, 1=B... 25=Z)
    public String getLetra(int colActual){
        return ALFABETO[colActual]; //devuelve la letra correspondiente en el array de letras del alfabeto
    }


    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Espectador getE() {
        return espectador;
    }

    public void setE(Espectador e) {
        this.espectador = e;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado, Espectador e) {
        this.ocupado = ocupado;
        setE(e);
    }


    /*
    Intento de poder tener salas con mas de 26 columnas de asientos por sala

    public String getLetraCol(int colActual){
        String  bin = Integer.toBinaryString(colActual);
        String[] arrBin = bin.split(""); //
        String grupo5 = "";
        int numFinal;
        String letraFinal = "";
        for (int i = 0; i < arrBin.length; i++){
            grupo5 += arrBin[arrBin.length-i-1];
            if (i!=0 && i%4==0){
                numFinal = Integer.parseInt(grupo5, 2); //5 bits binarios a decimal
                letraFinal += ALFABETO[numFinal];
                grupo5 = ""; //resetear el grupo de 5 bits
            }
        }
        return letraFinal;
    }*/
    //devuelve la letra correspondiente a la columna
    /*
    public String getLetraCol(){
        //si es la primera columna, el numero de letras sera 0, si no, se hace la operacion para saberlo
        int numLetrasCol = (getCol()==0)? 0:NUMLETRAS/getCol(); //AKA exponente maximo

        //letra final
        String letraFinal = "";
        //si el resultado es entero
        if (getCol()%NUMLETRAS==0){

        }
        //para menos de 26^2 (hasta 675)
        if (getCol()/ NUMLETRAS <= NUMLETRAS){

        }

        //bucle por cada letra
        for (int i =0; i <= numLetrasCol; i++){

        }
        return letraFinal;
    }*/

    //debug
    @Override
    public String toString(){
        return "Asignado: " + getFil() + "" + getCol();
    }
}
