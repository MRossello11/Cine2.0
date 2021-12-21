/**
 * @author MRossello11
 * @version 1.1
 * @since 09/12/2021
 * @description clase Espectador del proyecto Cine. El espectador tiene todos sus atributos generados aleatoriamente. Un espectador se
 * puede quedar fuera del cine por falta de dinero, de edad o porque han venido demasiados espectadores a la misma sala (no se le reasigna a otra sala).
 * Se crea un numero fijo de espectadores (se crean dentro de la clase Sala) y si no cumplen los requisitos, puede que se queden asientos libres.*/

package Parte2v20;

import java.util.Random;

public class Espectador {
    Random rand = new Random();
    //atributos
    private int dinero;
    private int edad;

    public Espectador() {
        this.dinero = generarDinero();
        this.edad = generarEdad();
    }

    //metodos
    //genera el dinero del espectador
    private int generarDinero(){
        return rand.nextInt(0,20);
    }

    //genera la edad del espectador
    private int generarEdad(){
        return rand.nextInt(5,120);
    }

    public double getDinero() {
        return dinero;
    }

    public int getEdad() {
        return edad;
    }
}
