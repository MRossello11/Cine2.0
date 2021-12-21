/**
 * @author MRossello11
 * @version 2.1
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
    public static void inicializar() {
        Cine c1 = new Cine("Ocimax", 2, 400); //crear objeto Cine
        c1.crearSalas(); //creacion salas
        c1.llenarCine(); //llena el cine
        System.out.println("Ganancias: " + Sala.getGanancias() + " euros"); //ganancias totales
        System.out.println("Espectadores: " + c1.getNumEspectadores()); //espectadores que han querido entrar

        //comprobaciones de si se ha llenado todo el cine bien
        if (c1.getNumEspectadoresSinSentar() < 0) { //si ha habido demasiado espectadores
            System.out.println(c1.getNumEspectadoresSinSentar() + " espectadores se han quedado fuera");

        }
        if (c1.getAsientosLibres() > 0){ //si han faltado espectadores
            System.out.println(c1.getAsientosLibres() + " asientos se han quedado libres");

        } else{ //si han venido tantos espectadores como asientos teniamos
            System.out.println("Se han ocupado todos los asientos sin problema");
        }

        System.out.println(Sala.getEspectadoresSinDineroOEdad() + " espectadores no han entrado por falta de dinero o edad");
    }
}
