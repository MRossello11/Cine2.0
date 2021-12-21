/**
 * @author MRossello11
 * @version 2.1
 * @since 02/12/2021
 * @description clase Cine del proyecto Cine. Crea las Salas y recoge datos de las mismas (numero de espectadores, asientos libres)*/

package Parte2v20;

public class Cine {
    //atributos
    private String nombre; //nombre del cine
    private int numAsientos; //numero de asientos por sala
    private Sala[] salas; //array de objetos Sala del cine
    private int numEspectadores; //numero de espectadores totales
    private int numEspectadoresSinSentar; //espectadores que no se han podido sentar
    private int asientosLibres; //asientos que se han quedado libres

    //constructor
    public Cine(String nombre, int salas, int asientos){
        this.nombre = nombre;
        this.numAsientos = asientos;
        this.salas = new Sala[salas];
        this.numEspectadores = 0;
        this.numEspectadoresSinSentar = 0;
        this.asientosLibres = 0;
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

            numEspectadores += getSalas()[j].getContadorEspectadores(); //se recoge la cantidad de espectadores que han entrado
            numEspectadoresSinSentar += getSalas()[j].getNumEspectadoresSinSentar(); //se recoge la cantidad de espectadores que no han podido entrar
            asientosLibres += getSalas()[j].getAsientosDisponibles().size(); //se recogen los asientos que han quedado libres

            System.out.println("Fin llenado de la sala " + j);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); //separador visual entre salas
        }
    }

    //getters y setters
    public int getAsientosLibres() {
        return asientosLibres;
    }

    public int getNumEspectadoresSinSentar() {
        return numEspectadoresSinSentar;
    }

    public int getNumEspectadores() {
        return numEspectadores;
    }

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
