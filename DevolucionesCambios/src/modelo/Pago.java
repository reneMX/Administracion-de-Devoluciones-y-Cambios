package modelo;
import java.util.*;

/**
 * 
 */
public class Pago {

    /**
     * Default constructor
     */
    public Pago() {
    }

    public Pago(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private double monto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


}