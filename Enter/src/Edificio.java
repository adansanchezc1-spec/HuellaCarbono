public class Edificio implements HuellaCarbono {

    private String nombre;
    private double metroCuadrados;
    private double energiaActualKwh;      // electricity consumption
    private double usoGasAnual; // natural gas consumption
    private int ocupantes;

    public Edificio(String nombre, double metroCuadrados,
                    double energiaActualKwh, double usoGasAnual, int occupants) {
        this.nombre = nombre;
        this.metroCuadrados = metroCuadrados;
        this.energiaActualKwh = energiaActualKwh;
        this.usoGasAnual = usoGasAnual;
        this.ocupantes = ocupantes;
    }

    public void mantenimiento() {
        System.out.println(nombre + " está en mantenimiento.");
    }

    public double getEnergyIntensity() {
        return energiaActualKwh / metroCuadrados; // kWh per m²
    }

    @Override
    public double getHuellaCarbono() {
        // Electricity: 0.233 kg CO2e per kWh (average grid factor)
        // Natural gas: 2.04 kg CO2e per cubic metre
        double electricityCO2 = energiaActualKwh * 0.233;
        double gasCO2 = usoGasAnual * 2.04;
        return electricityCO2 + gasCO2;
    }

    @Override
    public String toString() {
        return String.format("Edificio[nombre=%s, %.0f m², %d ocupantes]",
                nombre, metroCuadrados, ocupantes);
    }
}