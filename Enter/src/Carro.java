public class Carro implements HuellaCarbono {

    private String hace; // make
    private String modelo;
    private int anio;
    private double litrosMotor;          // engine size in litres
    private double kmAnuales;            // km driven per year
    private double litrosPor100Km; // litres per 100 km

    public Carro(String hace, String modelo, int anio,
                 double litrosMotor, double kmAnuales, double litrosPor100Km) {
        this.hace = hace;
        this.modelo = modelo;
        this.anio = anio ;
        this.litrosMotor = litrosMotor;
        this.kmAnuales = kmAnuales;
        this.litrosPor100Km = litrosPor100Km;
    }

    public void pitar() {
        System.out.println(hace + " " + modelo + " hace: Beep beep!");
    }

    public double getCostoCombustible(double precioPorLitro) {
        double totalLitros = (kmAnuales / 100.0) * litrosPor100Km;
        return totalLitros * precioPorLitro;
    }

    @Override
    public double getHuellaCarbono() {
        // Petrol combustion: ~2.31 kg CO2e per litre
        double totalLitros = (kmAnuales / 100.0) * litrosPor100Km;
        return totalLitros * 2.31;
    }

    @Override
    public String toString() {
        return String.format("Carro[%d %s %s, %.1fL motor, %.0f km/año]",
                anio, hace, modelo, litrosMotor, kmAnuales);
    }
}