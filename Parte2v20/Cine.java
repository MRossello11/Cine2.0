/**
 * @author MRossello11
 * @version 2.1
 * @since 02/12/2021
 * @description clase Cine del proyecto Cine*/

package Parte2v20;

import java.util.Random;

public class Cine {
    Random rand = new Random(); //objeto Random
    //atributos
    private String nombre;
    private int numAsientos;
    private Sala[] salas;



    //constructor
    public Cine(String nombre, int salas, int asientos){
        this.nombre = nombre;
        this.numAsientos = asientos;
        this.salas = new Sala[salas];
    }

    //metodos
    //llena el array salas de objetos Sala
    public void crearSalas(){
        for (int i = 0; i < getNumSalas(); i++){
            getSalas()[i] = new Sala(getNumAsientos());
        }
    }

    //llena el cine
    public void llenarCine(){
        for (int j =0; j < this.getNumSalas(); j++){
            System.out.println("Llenando sala " + j);
            getSalas()[j].imprimirArray(); //estado inicial de la sala
            System.out.println("---------------------------");
            getSalas()[j].sentar();
            System.out.println("Sala " + j + " llena");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }





    //getters y setters

    public int getNumSalas(){
        return salas.length;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public int getNumAsientos() {
        return numAsientos;
    }
}
