/**
 * @author MRossello11
 * @version 2.2
 * @since 09/12/2021
 * @description clase Sala del proyecto Cine*/

package Parte2v20;

import java.util.ArrayList;
import java.util.Random;

public class Sala {
    Random rand = new Random();
    //atributos
    private int numAsientos;
    private int numFilas;
    private int numColumnas;
    private Asiento[][] asientos;
    private Pelicula p;
    private ArrayList<Asiento> asientosDisponibles;

    public Sala(int n) {
        this.numAsientos = n;
        this.numFilas = 3;
        this.numColumnas = generarColumnas();
        this.asientos = new Asiento[this.getNumFilas()][this.getNumColumnas()];
        this.asientosDisponibles = new ArrayList<Asiento>();
        this.generarAsientos(); //llenar el array
        this.p = new Pelicula();

    }

    //metodos
    //crea un numero de filas aleatorias a partir del numero de asientos
    public int generarFilas(){
        int fil = getNumAsientos()/rand.nextInt(1, getNumAsientos()); //asignar numero filas
        return fil;
    }

    //crea el numero de columnas a partir del numero de filas y el numero total de asientos
    public int generarColumnas(){
        int col;
        //si no hay resto (la sala es un cuadrado/rectangulo) perfecto
        if (getNumAsientos()%getNumFilas() == 0){
            col = getNumAsientos()/getNumFilas();

        }else{ //en caso de que la ultima columna no tenga el mismo numero de asientos que las demas
            col = getNumAsientos()/getNumFilas() + 1;
        }

        return col;
    }

    //llena el array asientos de objetos Asiento
    public void generarAsientos(){
        //resto indica el numero de filas que hay en la ultima columna
        int resto = (getNumColumnas()*getNumFilas())-getNumAsientos();

        //bucle llenado del array asientos
        for (int i = 0; i < getNumFilas(); i++){ //bucle para cada fila
            for (int j = 0; j < getNumColumnas(); j ++){ //bucle para cada columna
                /*cuando el resto sea mayor que la fila actual y sea la penultima columna, salte la iteracion,
                para cuando numAsientos/numFilas no sea entero y se asignen menos asientos a la ultima columna
                para compensar */
                if (i > resto && j == (getNumColumnas()-1)){ //en i>resto segun la direccion del simbolo los asientos nulos estaran en las ultimas filas (configuracion actual) o en las primeras (i<resto)
                    continue;
                }

                getAsientos()[i][j] = new Asiento(i,j); //creacion objeto Asiento en el array asientos
                getAsientosDisponibles().add(new Asiento(i,j)); //creacion objeto Asiento como disponible
            }
        }
    }

    //imprimir el array asientos
    public void imprimirArray(){
        for (int i = 0; i < getNumFilas(); i++){
            for (int j = 0; j < getNumColumnas(); j++){

                //para evitar errores de nulos en las columnas donde haya menos filas
                if (getAsientos()[i][j] == null){ //si el objeto es nulo, se pasa
                    continue;
                }
                System.out.print(getAsientos()[i][j].getPosicion(j) + " ");
            }
            System.out.print("\n");
        }
    }


    //asigna objetos Espectador a cada objeto Asiento
    public void sentar(){
        System.out.println(getNumFilas() + " " + getNumColumnas());
        int asientosOcupados = 0;
        while (asientosOcupados < getNumAsientos()){ //bucle por todos los asientos

            Espectador e = new Espectador();

            //evaluacion de si el espectador cumple con los requisitos de dinero y edad
            if (e.getDinero() >= getP().getPrecio() && e.getEdad() >= getP().getEdadMinima()){
                //si entra, se le busca un Asiento libre
//                int numRandom = (getAsientosDisponibles().size()<=0)? rand.nextInt(0, getAsientosDisponibles().size()):0;
                int numRandom = rand.nextInt(0, getAsientosDisponibles().size());
                getAsientos()[getAsientosDisponibles().get(numRandom).getFil()][getAsientosDisponibles().get(numRandom).getCol()].setOcupado(true, e); //asignar el asiento
                System.out.println(getAsientos()[getAsientosDisponibles().get(numRandom).getFil()][getAsientosDisponibles().get(numRandom).getCol()]); //debug
                getAsientosDisponibles().remove(numRandom); //se elimina el asiento como asiento disponible
                asientosOcupados++;
            } else { //si no cumple con los requisitos se muestra por pantalla el porque
                System.out.println("El espectador " + ((e.getDinero()<getP().getPrecio())? "no tiene suficiente dinero": "no tiene la edad suficiente"));
            }
            imprimirArray(); //se muestra como va quedando la sala
            System.out.println("---------------------------");
        }
    }



    //getters y setters


    public Pelicula getP() {
        return p;
    }

    public ArrayList<Asiento> getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(ArrayList<Asiento> asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
}
