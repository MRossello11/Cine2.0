/**
 * @author MRossello11
 * @version 2.0
 * @since 02/12/2021
 * @description clase Main del proyecto Cine*/

package Parte2v20;

public class Main {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis(); //tiempo inicio
        inicializar(); //metodo de inicio
        long fin = System.currentTimeMillis(); //tiempo final
        double tiempoEjecucion = fin-inicio; //tiempo total
        System.out.println("Tiempo ejecucion: " + tiempoEjecucion + " milisegundos (" + tiempoEjecucion/1000 + " segundos)");
    }

    //inicializa los objetos y hace uso de los metodos
    public static void inicializar(){
        //crear objeto Cine
        Cine c1 = new Cine("Ocimax", 1000, 10000);
        c1.crearSalas(); //creacion salas
        c1.llenarCine(); //llena el cine
        System.out.println("Ganancias: " + Sala.getGanancias() + " euros"); //
    }
}
