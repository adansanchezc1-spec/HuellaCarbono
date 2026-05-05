public class Carro implements HuellaCarbono {

    private static final double FACTOR_EMISION_GASOLINA = 2.31;
    private static final int PRIMER_AUTO_MODERNO = 1886;

    private final String hace;
    private final String modelo;
    private final int anio;
    private final double litrosMotor;
    private final double kmAnuales;
    private final double litrosPor100Km;

    public Carro(String hace, String modelo, int anio,
                 double litrosMotor, double kmAnuales, double litrosPor100Km) {
        this.hace = validarTexto(hace, "hace");
        this.modelo = validarTexto(modelo, "modelo");
        this.anio = validarAnio(anio);
        this.litrosMotor = validarMayorQueCero(litrosMotor, "litrosMotor");
        this.kmAnuales = validarNoNegativo(kmAnuales, "kmAnuales");
        this.litrosPor100Km = validarMayorQueCero(litrosPor100Km, "litrosPor100Km");
    }

    public void pitar() {
        System.out.println(hace + " " + modelo + " hace: Beep beep!");
    }

    public double getCostoCombustible(double precioPorLitro) {
        return calcularLitrosAnuales() * validarNoNegativo(precioPorLitro, "precioPorLitro");
    }

    @Override
    public double getHuellaCarbono() {
        return calcularLitrosAnuales() * FACTOR_EMISION_GASOLINA;
    }

    @Override
    public String toString() {
        return String.format("Carro[%d %s %s, %.1fL motor, %.0f km/anio]",
                anio, hace, modelo, litrosMotor, kmAnuales);
    }

    private double calcularLitrosAnuales() {
        return (kmAnuales / 100.0) * litrosPor100Km;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacio.");
        }
        return valor.trim();
    }

    private static int validarAnio(int valor) {
        if (valor < PRIMER_AUTO_MODERNO) {
            throw new IllegalArgumentException("anio debe ser mayor o igual a " + PRIMER_AUTO_MODERNO + ".");
        }
        return valor;
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
}
