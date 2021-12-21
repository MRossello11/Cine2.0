/**
 * @author MRossello11
 * @version 2.4
 * @since 09/12/2021
 * @description clase Sala del proyecto Cine. En la sala se crean los asientos, los espectadores que quieren asistir a la sala y la pelicula que se emite.
 * Se toma como parametro el numero de asientos a partir del cual se generara un numero aleatorio de filas (el numero de columnas se deriva de las filas) para acomodar
 * de distintas maneras el total de asientos (tolera las salas con distribuciones de asientos que no sean cuadriculas perfectas). Las columnas se identifican por letras
 * de la A a la ZZ (a partir de la columna 701 (la siguiente a la que corresponde a la ZZ) se sustituyen las letras por numeros temporalmente hasta que este aspecto se mejore)*/

package Parte2v20;

import java.util.ArrayList; //para el array de asientosDisponibles
import java.util.Random; //para la generacion de numeros aleatorios (en el numero de

public class Sala {
    Random rand = new Random(); //variable random
    //atributos
    private int numAsientos; //numero de asientos
    private int numFilas; //numero de filas
    private int numColumnas; //numero de columnas
    private Asiento[][] asientos; //array de objetos Asiento
    private ArrayList<Asiento> asientosDisponibles; //arrayList con las posiciones de asientos libres, se usa un arrayList para mejorar la eficiencia del programa
    private Pelicula p; //pelicula que se emite en la sala
    private String[] letrasColumnas; //contiene las letras que se asignaran a las columnas
    private Espectador[] espectadores; //array de espectadores
    private int cantidadEspectadores; //numero total de espectadores
    private int contadorEspectadores; //contador de los espectadores que entran en la sala
    private static int espectadoresSinDineroOEdad = 0; //contador de espectadores que no han podido entrar por dinero y/o edad
    private static double ganancias = 0; //dinero ganado

    //constantes
    private final String[] ALFABETO = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; //letras del abecedario

    public Sala(int n) {
        this.numAsientos = n;
        this.numFilas = generarFilas();
        this.numColumnas = generarColumnas();
        this.asientos = new Asiento[this.getNumFilas()][this.getNumColumnas()];
        this.asientosDisponibles = new ArrayList<Asiento>();
        this.generarAsientos(); //llenar el array
        this.p = new Pelicula();
        this.letrasColumnas = generarArrayLetras(getNumColumnas());
        this.espectadores = generarEspectadores(); //genera el array de espectadores

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
                if (i < resto && j == (getNumColumnas()-1)){ //en i>resto segun la direccion del simbolo los asientos nulos estaran en las ultimas filas (configuracion actual) o en las primeras (i<resto)
                    continue;
                }

                getAsientos()[i][j] = new Asiento(i,j); //creacion objeto Asiento en el array asientos
                getAsientosDisponibles().add(new Asiento(i,j)); //creacion objeto Asiento como disponible
            }
        }
    }

    //imprime el array asientos
    public void imprimirArray(){
        for (int i = 0; i < getNumFilas(); i++){ //bucle por cada fila
            for (int j = 0; j < getNumColumnas(); j++){ //bucle por cada columna

                //para evitar errores de nulos en las columnas donde haya menos filas
                if (getAsientos()[i][j] == null){ //si el objeto es nulo, se pasa
                    continue;
                }
                //se imprime el asiento
                System.out.print(getAsientos()[i][j].getPosicion(getLetraCol(j)) + " ");
            }
            System.out.print("\n"); //al final de cada fila se hace un salto de linea para mejor visualizacion
        }
    }


    //asigna objetos Espectador a cada objeto Asiento
    public void sentar(){
//        System.out.println(getNumFilas() + " " + getNumColumnas()); //debug

        int asientosOcupados = 0; //contador de asientos ocupados

        do{ //bucle por todos los asientos
            if (getContadorEspectadores() >= getEspectadores().length){ //si no hay mas espectadores
                System.out.println("No hay mas espectadores");
                break;
            }
            Espectador e = getEspectadores()[getContadorEspectadores()];
            sumarContadorEspectadores(); //se incrementa el contador de espectadores

            //evaluacion de si el espectador cumple con los requisitos de dinero y edad
            if (e.getDinero() >= getP().getPrecio() && e.getEdad() >= getP().getEdadMinima()){
                //si entra, se le busca un Asiento libre
                int numRandom;
                try{ //en caso de que se intente asignar un asiento que no existe
                    numRandom = rand.nextInt(0, getAsientosDisponibles().size()); //se genera un numero random que sera el asiento que se asignara al espectador

                } catch(Exception IllegalArgumentException){
                    break;
                }

                try {
                    getAsientos()[getAsientosDisponibles().get(numRandom).getFil()][getAsientosDisponibles().get(numRandom).getCol()].setOcupado(true, e); //asignar el asiento
//                    System.out.println("Asiento asignado "); //debug
                }catch (Exception IndexOutOfBoundsException){
                    System.out.println("Error");
                }
                getAsientosDisponibles().remove(numRandom); //se elimina el asiento como asiento disponible
                asientosOcupados++; //como se ha asignado un asiento, aumenta el contador
                ganancias += getP().getPrecio();
                imprimirArray(); //se muestra como va quedando la sala
                System.out.println("---------------------------"); //separador visual

            } else { //si no cumple con los requisitos se muestra por pantalla el porque
                System.out.println("El espectador " + ((e.getDinero()<getP().getPrecio())? "no tiene suficiente dinero": "no tiene la edad suficiente"));
                espectadoresSinDineroOEdad++; //se suma el contador de espectadores que no han podido entrar por requisitos
            }
        }while (asientosOcupados < getNumAsientos()); //mientras haya asientos libres, se ejecutara el bucle
    }

    //genera un array con una cantidad aleatoria de objetos Espectadores
    public Espectador[] generarEspectadores(){
        Espectador[] arrEspectadores;
        int probabilidadEspectadores = rand.nextInt(0, 4); //generacion de la probabilidad


        switch (probabilidadEspectadores){ //switch donde se define la cantidad de espectadores que habra en cada sala
            case 1: //25% de haber mas gente que asientos (60% mas)
                setCantidadEspectadores((int) (getNumAsientos()*1.6));
                arrEspectadores = new Espectador[cantidadEspectadores];
                break;

            default: //habra un 75% de haber tantos espectadores como asientos
                arrEspectadores = new Espectador[getNumAsientos()];
        }
        //se llena el array
        for (int i = 0; i < arrEspectadores.length; i++){
            arrEspectadores[i] = new Espectador();
        }
        return arrEspectadores;
    }

    public String[] generarArrayLetras(int numColumnas){
        String columnas[] = new String[numColumnas];
        for (int i = 0; i < numColumnas; i++){
            String letra = "";
            int indice = i/ALFABETO.length;
            if (i>701){ //a partir de la columna ZZ (numero 701), el programa empieza a dar problemas asi que se devuelve el numero de la columna
                columnas[i] = Integer.toString(i-702);
                continue;

//                letra += ALFABETO[i-702];
            }
            if (indice>0) { //cuando hay mas de una letra
                letra += ALFABETO[indice-1];
            }
            letra += ALFABETO[i%ALFABETO.length]; //se agnade una letra
            columnas[i] = letra; //se asigna la letra a la posicion correspondiente
//            System.out.println(letra); //debug
        }
        return columnas;
    }


    //getters y setters

    public static int getEspectadoresSinDineroOEdad() {
        return espectadoresSinDineroOEdad;
    }

    public int getNumEspectadoresSinSentar(){
        return getEspectadores().length - getContadorEspectadores();
    }
    public int getContadorEspectadores() {
        return contadorEspectadores;
    }

    public void setContadorEspectadores(int contadorEspectadores) {
        this.contadorEspectadores = contadorEspectadores;
    }

    public void sumarContadorEspectadores() {
        this.contadorEspectadores += 1;
    }

    public void setCantidadEspectadores(int cantidadEspectadores) {
        this.cantidadEspectadores = cantidadEspectadores;
    }

    public int getCantidadEspectadores() {
        return cantidadEspectadores;
    }

    public Espectador[] getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(Espectador[] espectadores) {
        this.espectadores = espectadores;
    }

    public static double getGanancias() {
        return ganancias;
    }

    public static void setGanancias(double ganancias) {
        Sala.ganancias = ganancias;
    }

    public String getLetraCol(int colActual){
        return getLetrasColumnas()[colActual];
    }

    public String[] getLetrasColumnas() {
        return letrasColumnas;
    }

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
