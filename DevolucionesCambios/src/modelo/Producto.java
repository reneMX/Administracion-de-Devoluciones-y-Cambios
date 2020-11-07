package modelo;


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

}