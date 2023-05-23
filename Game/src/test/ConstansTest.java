package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import logica.Constans;

class ConstansTest {

    @Test
    void testConstantValues() {
        Assertions.assertEquals(10, Constans.TAMANNO);
        Assertions.assertEquals(5, Constans.NUM_ROCAS);
        Assertions.assertEquals(5, Constans.NUM_GEMAS);
        Assertions.assertEquals(3, Constans.NUM_POCIONES);
        Assertions.assertEquals(2, Constans.NUM_DINERO);
        Assertions.assertEquals(1, Constans.ROCA);
        Assertions.assertEquals(2, Constans.GEMA);
        Assertions.assertEquals(3, Constans.POCION);
        Assertions.assertEquals(4, Constans.DINERO);
        Assertions.assertEquals(5, Constans.ELFO);
        Assertions.assertEquals(6, Constans.MAGO);
        Assertions.assertEquals(7, Constans.GUERRERO);
        Assertions.assertEquals(8, Constans.OGRO);
        Assertions.assertEquals(4, Constans.NUM_JUGADORES);
        Assertions.assertArrayEquals(new char[] {'X', 'Y', 'Z', 'U'}, Constans.NOMBRE_JUGADORES);
        Assertions.assertEquals(7, Constans.ELFO_VELOCIDAD);
        Assertions.assertEquals(6, Constans.ELFO_MAGIA);
        Assertions.assertEquals(5, Constans.ELFO_FUERZA);
        Assertions.assertEquals(4, Constans.OGRO_VELOCIDAD);
        Assertions.assertEquals(4, Constans.OGRO_MAGIA);
        Assertions.assertEquals(7, Constans.OGRO_FUERZA);
        Assertions.assertEquals(5, Constans.GUERRERO_VELOCIDAD);
        Assertions.assertEquals(5, Constans.GUERRERO_MAGIA);
        Assertions.assertEquals(6, Constans.GUERRERO_FUERZA);
        Assertions.assertEquals(6, Constans.MAGO_VELOCIDAD);
        Assertions.assertEquals(7, Constans.MAGO_MAGIA);
        Assertions.assertEquals(4, Constans.MAGO_FUERZA);
        Assertions.assertEquals(0, Constans.EMPATE);
        Assertions.assertEquals(1, Constans.GANA_USA_POCIMA);
        Assertions.assertEquals(2, Constans.GANA_DINERO);
        Assertions.assertEquals(3, Constans.GANA_MUERE);
        Assertions.assertEquals(4, Constans.PIERDE_USA_POCIMA);
        Assertions.assertEquals(5, Constans.PIERDE_DINERO);
        Assertions.assertEquals(6, Constans.PIERDE_MUERE);
        Assertions.assertEquals(0, Constans.ROMPE_ROCA_CON_GEMA);
        Assertions.assertEquals(1, Constans.GANA_A_LA_ROCA);
        Assertions.assertEquals(2, Constans.PIERDE_A_LA_ROCA);
    }
}
