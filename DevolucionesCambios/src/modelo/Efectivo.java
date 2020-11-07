package modelo;
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

    public Efectivo(String nombre, double monto) {
        super(nombre, monto);
    }

    
    
    /**
     * 
     */
    private int num_serie;

    public int getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }

    
}