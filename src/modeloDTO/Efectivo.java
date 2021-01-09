package modeloDTO;


import java.util.*;

/**
 * 
 */
public class Efectivo extends Pago {

    /**
     * Default constructor
     */
    public Efectivo() {
    }

    public Efectivo(int num_serie, String nombre, double monto) {
        super(nombre, monto);
        this.num_serie = num_serie;
    }

    public Efectivo(int num_serie) {
        this.num_serie = num_serie;
    }

    /**
     * 
     */
    private int num_serie;

    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }

}