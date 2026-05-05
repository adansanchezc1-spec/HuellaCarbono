import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class App {

    private static final String RUTA_REPORTE = "reporte_huella_carbono.txt";

    public static void main(String[] args) {
        Edificio office = new Edificio(
                "GreenTower Office", 2500, 180_000, 3_200, 120);

        Carro sedan = new Carro(
                "Toyota", "Camry", 2020, 2.5, 18_000, 8.5);

        Bicicleta eBike = new Bicicleta(
                "Trek", "electric", 28, 3_000, true, 1.2);

        Bicicleta roadBike = new Bicicleta(
                "Giant", "road", 28, 5_000, false, 0.0);

        ArrayList<HuellaCarbono> items = new ArrayList<>();
        items.add(office);
        items.add(sedan);
        items.add(eBike);
        items.add(roadBike);

        imprimirReporte(items);
        guardarReporte(items, RUTA_REPORTE);
        mostrarComportamientos(office, sedan, eBike, roadBike);
    }

    public static void guardarReporte(ArrayList<HuellaCarbono> items, String rutaArchivo) {
        validarReporte(items, rutaArchivo);

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            writer.println("Reporte de Huella de Carbono");
            writer.println("=".repeat(60));
            writer.printf("%-45s %s%n", "Objeto", "Huella de Carbono (kg CO2e/anio)");
            writer.println("=".repeat(60));

            for (HuellaCarbono item : items) {
                writer.printf("%-45s %,.2f kg%n", item.toString(), item.getHuellaCarbono());
            }

            writer.println("=".repeat(60));
            System.out.println("Reporte guardado en: " + rutaArchivo);
        } catch (IOException exception) {
            System.out.println("No fue posible guardar el reporte: " + exception.getMessage());
        }
    }

    private static void imprimirReporte(ArrayList<HuellaCarbono> items) {
        System.out.println("=".repeat(60));
        System.out.printf("%-45s %s%n", "Objeto", "Huella de Carbono (kg CO2e/anio)");
        System.out.println("=".repeat(60));

        for (HuellaCarbono item : items) {
            System.out.printf("%-45s %,.2f kg%n", item.toString(), item.getHuellaCarbono());
        }

        System.out.println("=".repeat(60));
    }

    private static void mostrarComportamientos(Edificio office, Carro sedan,
                                               Bicicleta eBike, Bicicleta roadBike) {
        System.out.println("\n--- comportamientos ---");
        office.mantenimiento();
        sedan.pitar();
        eBike.ringBell();
        System.out.printf("Bicicleta de ruta quema aproximadamente %.0f kcal/anio%n",
                roadBike.getCaloriesBurned());
    }

    private static void validarReporte(ArrayList<HuellaCarbono> items, String rutaArchivo) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("items no puede estar vacio.");
        }
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("rutaArchivo no puede estar vacia.");
        }
    }
}
