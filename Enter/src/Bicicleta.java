/**
 * Representa una bicicleta y calcula su huella de carbono anual.
 * Diferencia entre bicicletas eléctricas y convencionales.
 */
public class Bicicleta implements HuellaCarbono {

    private static final double HUELLA_BASE_BICICLETA = 5.0;
    private static final double HUELLA_BASE_BICICLETA_ELECTRICA = 30.0;
    private static final double FACTOR_ALIMENTACION_POR_KM = 0.021;
    private static final double FACTOR_EMISION_ELECTRICIDAD = 0.233;
    private static final double CALORIAS_POR_KM = 40.0;
    private static final double CALORIAS_POR_KM_ELECTRICA = 10.0;

    private final String marca;
    private final String tipo;
    private final double anchoRuedaPulgadas;
    private final double kmAnuales;
    private final boolean isElectrica;
    private final double potenciaBateriaKwhPer100Km;

    /**
     * Constructor con validaciones claras de cada entrada.
     */
    public Bicicleta(String marca, String tipo, double anchoRuedaPulgadas,
                     double kmAnuales, boolean isElectrica, double potenciaBateriaKwhPer100Km) {
        this.marca = validarTexto(marca, "marca");
        this.tipo = validarTexto(tipo, "tipo");
        this.anchoRuedaPulgadas = validarMayorQueCero(anchoRuedaPulgadas, "anchoRuedaPulgadas");
        this.kmAnuales = validarNoNegativo(kmAnuales, "kmAnuales");
        this.isElectrica = isElectrica;
        this.potenciaBateriaKwhPer100Km = validarBateria(isElectrica, potenciaBateriaKwhPer100Km);
    }

    /**
     * Simula el sonido de la campana de la bicicleta.
     */
    public void ringBell() {
        System.out.println(marca + " cicla hace: Ring ring!");
    }

    /**
     * Retorna la estimación de calorías quemadas por año.
     */
    public double getCaloriesBurned() {
        return isElectrica ? kmAnuales * CALORIAS_POR_KM_ELECTRICA : kmAnuales * CALORIAS_POR_KM;
    }

    @Override
    public double getHuellaCarbono() {
        if (!isElectrica) {
            return HUELLA_BASE_BICICLETA + (kmAnuales * FACTOR_ALIMENTACION_POR_KM);
        }

        double electricidadCo2 = (kmAnuales / 100.0)
                * potenciaBateriaKwhPer100Km
                * FACTOR_EMISION_ELECTRICIDAD;
        return HUELLA_BASE_BICICLETA_ELECTRICA + electricidadCo2;
    }

    @Override
    public String toString() {
        return String.format("Bicicleta[%s %s, %.0f pulgadas, %.0f km/anio, electrica=%b]",
                marca, tipo, anchoRuedaPulgadas, kmAnuales, isElectrica);
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacio.");
        }
        return valor.trim();
    }

    private static double validarMayorQueCero(double valor, String campo) {
        if (valor <= 0) {
            throw new IllegalArgumentException(campo + " debe ser mayor que cero.");
        }
        return valor;
    }

    private static double validarNoNegativo(double valor, String campo) {
        if (valor < 0) {
            throw new IllegalArgumentException(campo + " no puede ser negativo.");
        }
        return valor;
    }

    private static double validarBateria(boolean isElectrica, double valor) {
        if (isElectrica && valor <= 0) {
            throw new IllegalArgumentException("potenciaBateriaKwhPer100Km debe ser mayor que cero.");
        }
        if (!isElectrica && valor != 0) {
            throw new IllegalArgumentException("potenciaBateriaKwhPer100Km debe ser cero para bicicletas no electricas.");
        }
        return valor;
    }
}
