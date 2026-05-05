import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarroTest {

    private static final double DELTA = 0.001;

    @Test
    public void getHuellaCarbono_conDatosValidos_retornaCalculoEsperado() {
        Carro carro = new Carro("Toyota", "Camry", 2020, 2.5, 18000, 8.5);

        double resultado = carro.getHuellaCarbono();

        assertEquals(3534.3, resultado, DELTA);
    }

    @Test
    public void getCostoCombustible_conPrecioValido_retornaCostoAnual() {
        Carro carro = new Carro("Mazda", "3", 2021, 2.0, 10000, 7.0);

        double resultado = carro.getCostoCombustible(4000);

        assertEquals(2800000.0, resultado, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_conAnioInvalido_lanzaExcepcion() {
        new Carro("Ford", "Modelo", 1800, 1.8, 1000, 7.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_conRendimientoNegativo_lanzaExcepcion() {
        new Carro("Ford", "Fiesta", 2018, 1.6, 1000, -1.0);
    }
}
