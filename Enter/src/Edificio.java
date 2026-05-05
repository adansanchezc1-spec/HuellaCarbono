public class Edificio implements HuellaCarbono {

    private static final double FACTOR_EMISION_ELECTRICIDAD = 0.233;
    private static final double FACTOR_EMISION_GAS = 2.04;

    private final String nombre;
    private final double metroCuadrados;
    private final double energiaActualKwh;
    private final double usoGasAnual;
    private final int ocupantes;

    public Edificio(String nombre, double metroCuadrados,
                    double energiaActualKwh, double usoGasAnual, int ocupantes) {
        this.nombre = validarTexto(nombre, "nombre");
        this.metroCuadrados = validarMayorQueCero(metroCuadrados, "metroCuadrados");
        this.energiaActualKwh = validarNoNegativo(energiaActualKwh, "energiaActualKwh");
        this.usoGasAnual = validarNoNegativo(usoGasAnual, "usoGasAnual");
        this.ocupantes = validarEnteroNoNegativo(ocupantes, "ocupantes");
    }

    public void mantenimiento() {
        System.out.println(nombre + " esta en mantenimiento.");
    }

    public double getEnergyIntensity() {
        return energiaActualKwh / metroCuadrados;
    }

    @Override
    public double getHuellaCarbono() {
        double electricidadCo2 = energiaActualKwh * FACTOR_EMISION_ELECTRICIDAD;
        double gasCo2 = usoGasAnual * FACTOR_EMISION_GAS;
        return electricidadCo2 + gasCo2;
    }

    @Override
    public String toString() {
        return String.format("Edificio[nombre=%s, %.0f m2, %d ocupantes]",
                nombre, metroCuadrados, ocupantes);
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

    private static int validarEnteroNoNegativo(int valor, String campo) {
        if (valor < 0) {
            throw new IllegalArgumentException(campo + " no puede ser negativo.");
        }
        return valor;
    }
}
