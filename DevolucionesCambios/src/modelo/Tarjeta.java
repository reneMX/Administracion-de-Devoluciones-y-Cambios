package modelo;
import java.util.*;

/**
 * 
 */
public class Tarjeta extends Pago {

    /**
     * Default constructor
     */
    public Tarjeta() {
    }

    public Tarjeta(int numero, String nombre, String tipo_tarjeta, Date fch_exp) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo_tarjeta = tipo_tarjeta;
        this.fch_exp = fch_exp;
    }

    /**
     * 
     */
    private int numero;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String tipo_tarjeta;

    /**
     * 
     */
    private Date fch_exp;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_tarjeta() {
        return tipo_tarjeta;
    }

    public void setTipo_tarjeta(String tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public Date getFch_exp() {
        return fch_exp;
    }

    public void setFch_exp(Date fch_exp) {
        this.fch_exp = fch_exp;
    }
    

}