/**
 * @author MRossello11
 * @version 2.0
 * @since 02/12/2021
 * @description clase Main del proyecto Cine*/

package Parte2v20;

public class Main {
    public static void main(String[] args) {
        inicializar();
    }

    public static void inicializar(){
        //crear objeto Cine
        Cine c1 = new Cine("Ocimax", 20, 26);
        c1.crearSalas(); //creacion salas
        c1.llenarCine(); //llena el cine
    }
}
