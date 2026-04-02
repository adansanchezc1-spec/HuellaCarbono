public class Bicicleta implements HuellaCarbono {

    private final String marca;
    private final String tipo;           // "road", "mountain", "electric"
    private final double anchoRuedaPulgadas;
    private final double kmAnuales;
    private final boolean isElectrica;
    private final double potenciaBateriaKwhPer100Km; // only relevant if electric

    public Bicicleta(String marca, String tipo, double anchoRuedaPulgadas,
                     double kmAnuales, boolean isElectrica, double potenciaBateriaKwhPer100Km) {
        this.marca = marca;
        this.tipo = tipo;
        this.anchoRuedaPulgadas = anchoRuedaPulgadas;
        this.kmAnuales = kmAnuales;
        this.isElectrica = isElectrica;
        this.potenciaBateriaKwhPer100Km = potenciaBateriaKwhPer100Km;
    }

    public void ringBell() {
        System.out.println(marca + " cicla hace: Ring ring!");
    }

    public double getCaloriesBurned() {
        // ~40 kcal per km for cycling (non-electric)
        return isElectrica ? kmAnuales * 10 : kmAnuales * 40;
    }

    @Override
    public double getHuellaCarbono() {
        if (!isElectrica) {
            // Manufacturing amortised over 10 years: ~5 kg CO2e/year
            // Rider's extra food intake: ~21 g CO2e per km
            return 5.0 + (kmAnuales * 0.021);
        } else {
            // Electric: manufacturing ~30 kg CO2e/year + electricity used
            double electricityCO2 = (kmAnuales / 100.0) * potenciaBateriaKwhPer100Km * 0.233;
            return 30.0 + electricityCO2;
        }
    }

    @Override
    public String toString() {
        return String.format("Bicicleta[%s %s, %.0f\" ruedas, %.0f km/año, electrica=%b]",
                marca, tipo, anchoRuedaPulgadas, kmAnuales, isElectrica);
    }
}