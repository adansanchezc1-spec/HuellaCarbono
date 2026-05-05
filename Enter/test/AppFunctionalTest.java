import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Pruebas funcionales para la clase App.
 * Verifica el comportamiento de generación de reportes.
 */
public class AppFunctionalTest {

    @Test
    public void guardarReporte_conListaPolimorfica_creaArchivoConContenidoEsperado() throws Exception {
        ArrayList<HuellaCarbono> items = new ArrayList<>();
        items.add(new Edificio("GreenTower Office", 2500, 180000, 3200, 120));
        items.add(new Carro("Toyota", "Camry", 2020, 2.5, 18000, 8.5));
        items.add(new Bicicleta("Trek", "electric", 28, 3000, true, 1.2));

        File reporte = File.createTempFile("reporte_huella_carbono_test", ".txt");

        App.guardarReporte(items, reporte.getAbsolutePath());

        String contenido = new String(Files.readAllBytes(reporte.toPath()), StandardCharsets.UTF_8);
        assertTrue(contenido.contains("Reporte de Huella de Carbono"));
        assertTrue(contenido.contains("GreenTower Office"));
        assertTrue(contenido.contains("Toyota"));
        assertTrue(contenido.contains("Trek"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardarReporte_conListaVacia_lanzaExcepcion() {
        App.guardarReporte(new ArrayList<HuellaCarbono>(), "reporte_vacio.txt");
    }
}
