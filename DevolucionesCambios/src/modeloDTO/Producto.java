package modeloDTO;


import java.util.*;

/**
 * 
 */
public class Producto {

    
    public Producto(String nombre, int talla, double precio) {
        this.nombre = nombre;
        this.talla = talla;
        this.precio = precio;
    }
    /**
     * Default constructor
     */
    public Producto() {
    }

  

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private int talla;

    /**
     * 
     */
    private double precio;


    /**
     * 
     */
    
    
    public void Producto() {
        // TODO implement here
    }

    /**
     * @return
     */
    public double calculaRebaja() {
        // TODO implement here
        return 0.0d;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    
}