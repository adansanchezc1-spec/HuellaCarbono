
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        // --- Create objects ---
        Edificio office = new Edificio(
                "GreenTower Office", 2500, 180_000, 3_200, 120);

        Carro sedan = new Carro(
                "Toyota", "Camry", 2020, 2.5, 18_000, 8.5);

        Bicicleta eBike = new Bicicleta(
                "Trek", "electric", 28, 3_000, true, 1.2);

        Bicicleta roadBike = new Bicicleta(
                "Giant", "road", 28, 5_000, false, 0.0);

        // --- Populate ArrayList<HuellaCarbono> ---
        ArrayList<HuellaCarbono> items = new ArrayList<>();
        items.add(office);
        items.add(sedan);
        items.add(eBike);
        items.add(roadBike);

        // --- Polymorphic iteration ---
        System.out.println("=".repeat(60));
        System.out.printf("%-45s %s%n", "Object", "Huella de Carbono (kg CO2e/year)");
        System.out.println("=".repeat(60));

        for (HuellaCarbono item : items) {
            System.out.printf("%-45s %,.2f kg%n",
                    item.toString(), item.getHuellaCarbono());
        }

        System.out.println("=".repeat(60));

        // Show a unique behaviour from each concrete class
        System.out.println("\n--- comportamientos ---");
        office.mantenimiento();
        sedan.pitar();
        eBike.ringBell();
        System.out.printf("Cicla de caminos arde approx. %.0f kcal/year%n",
                roadBike.getCaloriesBurned());
    }
}