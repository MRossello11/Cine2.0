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
    private String nombre; //nombre del cine
    private int numAsientos; //numero de asientos por sala
    private Sala[] salas; //array de objeto Sala del cine



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
            getSalas()[i] = new Sala(getNumAsientos()); //se agnade la sala al array
        }
    }

    //llena el cine (asigna objetos Espectador a cada objeto Asiento de cada Sala)
    public void llenarCine(){
        for (int j =0; j < this.getNumSalas(); j++){ //bucle por cada sala
            System.out.println("Llenando sala " + j + " con la pelicula " + getSalas()[j].getP().getNombre() + ". Precio por entrada " + getSalas()[j].getP().getPrecio()); //presentacion de la sala
            getSalas()[j].imprimirArray(); //estado inicial de la sala
            System.out.println("---------------------------"); //separador visual
            getSalas()[j].sentar(); //se sientan los espectadores en el cine
            System.out.println("Sala " + j + " llena");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); //separador visual entre salas
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
