import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BicicletaTest {

    private static final double DELTA = 0.001;

    @Test
    public void getHuellaCarbono_conBicicletaNoElectrica_retornaCalculoEsperado() {
        Bicicleta bicicleta = new Bicicleta("Giant", "road", 28, 5000, false, 0);

        double resultado = bicicleta.getHuellaCarbono();

        assertEquals(110.0, resultado, DELTA);
    }

    @Test
    public void getHuellaCarbono_conBicicletaElectrica_retornaCalculoEsperado() {
        Bicicleta bicicleta = new Bicicleta("Trek", "electric", 28, 3000, true, 1.2);

        double resultado = bicicleta.getHuellaCarbono();

        assertEquals(38.388, resultado, DELTA);
    }

    @Test
    public void getCaloriesBurned_conBicicletaNoElectrica_retornaCaloriasEstimadas() {
        Bicicleta bicicleta = new Bicicleta("Giant", "road", 28, 5000, false, 0);

        double resultado = bicicleta.getCaloriesBurned();

        assertEquals(200000.0, resultado, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_conBicicletaElectricaSinBateria_lanzaExcepcion() {
        new Bicicleta("Trek", "electric", 28, 3000, true, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_conBicicletaNoElectricaConBateria_lanzaExcepcion() {
        new Bicicleta("Giant", "road", 28, 3000, false, 1.2);
    }
}
