package Parte2v20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {
    //asiento
    Asiento asiento = new Asiento(10, 20);
    @Test
    void setOcupadoTest(){
        asiento.setOcupado(true, new Espectador());
        assertTrue(asiento.isOcupado());
        asiento.setOcupado(false, new Espectador());
        assertFalse(asiento.isOcupado());
    }
}