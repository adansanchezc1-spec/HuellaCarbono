/**
 * Interfaz de dominio que expone el cálculo de huella de carbono.
 * Permite tratar objetos distintos de manera polimórfica.
 */
public interface HuellaCarbono {

    /**
     * Retorna la huella de carbono anual estimada en kg de CO2e.
     */
    double getHuellaCarbono();
}
