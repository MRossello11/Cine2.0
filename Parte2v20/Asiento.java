/**
 * @author MRossello11
 * @version 2.3
 * @since 10/12/2021
 * @description clase Asiento del proyecto Cine*/
package Parte2v20;

public class Asiento {
    //colores
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

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
    public String getPosicion(String letra){
        if (!isOcupado()){//si no esta ocupado, se presenta el numero de asiento en rojo
            return VERDE + getFil() + "" + letra + RESET; //el reset es para que el color no se extienda al resto de outputs

        } else { //si esta ocupado, se muestra en rojo
            return ROJO + getFil() + "" + letra + RESET;
        }
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
}
