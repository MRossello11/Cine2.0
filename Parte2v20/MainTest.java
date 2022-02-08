package Parte2v20;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static int s = 10;
    public static int a = 30;
    static Cine c = new Cine("Arteseis", s, a);

    @BeforeAll
    static void primero(){
        c.crearSalas();
        c.llenarCine();
    }

    @Test
    void crearSalasTest(){
        assertEquals(s, c.getNumSalas()); //el numero de salas es el previsto
        assertEquals(s, c.getSalas().length); //el array de salas tiene la cantidad de elementos esperados
    }

    @Test
    void salaGenerarAsientosTest(){
        //se comprueba que el numero de asientos de cada sala sea el correspondiente
        for (int i = 0; i < s; i++){
            assertEquals(a, c.getSalas()[i].getNumAsientos());
        }
    }

    @Test
    void gananciasTest(){
        double g = 0;

        for (int i = 0; i < s; i++){
            //calculo de ganancias por sala (precio de la pelicula * asientos ocupados)
            g += c.getSalas()[i].getP().getPrecio() * (c.getSalas()[i].getNumAsientos()-c.getSalas()[i].getAsientosDisponibles().size());
        }

        //se comprueba que las ganancias son las esperadas (con precision de 2 decimales)
        assertEquals(Math.floor(g * 100) / 100 , Math.floor(Sala.getGanancias() * 100) / 100);
    }

}