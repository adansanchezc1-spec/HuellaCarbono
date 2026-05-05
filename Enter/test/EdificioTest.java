import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EdificioTest {

    private static final double DELTA = 0.001;

    @Test
    public void getHuellaCarbono_conConsumosValidos_retornaCalculoEsperado() {
        Edificio edificio = new Edificio("Biblioteca", 1000, 10000, 500, 80);

        double resultado = edificio.getHuellaCarbono();

        assertEquals(3350.0, resultado, DELTA);
    }

    @Test
    public void getEnergyIntensity_conAreaYEnergiaValidas_retornaKwhPorMetroCuadrado() {
        Edificio edificio = new Edificio("Laboratorio", 500, 25000, 0, 25);

        double resultado = edificio.getEnergyIntensity();

        assertEquals(50.0, resultado, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_conMetroCuadradosCero_lanzaExcepcion() {
        new Edificio("Edificio invalido", 0, 1000, 10, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_conNombreVacio_lanzaExcepcion() {
        new Edificio(" ", 100, 1000, 10, 5);
    }
}
