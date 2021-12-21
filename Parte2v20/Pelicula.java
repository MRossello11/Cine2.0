/**
 * @author MRossello11
 * @version 1.3
 * @since 09/12/2021
 * @description clase Pelicula del proyecto Cine*/

package Parte2v20;

import java.util.Random;

public class Pelicula {
    Random rand = new Random();
    //atributos
    private String nombre; //titulo de la pelicula
    private String director; //nombre del director
    private int edadMinima; //edad minima para poder ver la pelicula
    private double precio; //precio por entrada
    private int duracion; //duracion de la pelicula (en minutos)

    //listas con nombres de peliculas y directores
    private static final String[] titulos = {"Jurassic Park", "Django", "Alien", "Pacific rim", "Inception"};
    private static final String[] directores = {"Steven Spilberg", "Quentin Tarantino", "Ridley Scott", "Guillermo del Toro", "Christopher Nolan"};


    //constructor
    public Pelicula(){
        this.nombre = titulos[rand.nextInt(0, titulos.length)]; //elegir un titulo aleatorio
        this.director = directores[rand.nextInt(0, directores.length)]; //elegir un director aleatorio
        this.edadMinima = generarEdadMinima(); //edad minima con la que se puede entrar
        this.precio = generarPrecio(); //se genera el precio por entrada
        this.duracion = generarDuracion(); //se genera la duracion de la pelicula
    }

    private int generarDuracion(){
        return rand.nextInt(60,240); //se interpreta que solo se emiten largometrages (de mas de 60 minutos)
    }

    private int generarEdadMinima(){
        return rand.nextInt(5,18);
    }

    private double generarPrecio(){
        return rand.nextDouble(3.5,8);
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public double getPrecio() {
        return precio;
    }
}