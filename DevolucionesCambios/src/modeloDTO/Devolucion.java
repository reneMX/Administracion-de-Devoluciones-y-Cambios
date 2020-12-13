package modeloDTO;


import java.util.*;

/**
 * 
 */
public class Devolucion {

    
    /**
     * 
     */
    private int numero_venta;

    /**
     * 
     */
    private String fecha_venta;

    /**
     * 
     */
    private String nombre_empleado;

    /**
     * 
     */
    private String nombre_tienda;

    /**
     * 
     */
    private String direccion_tienda;

    /**
     * 
     */
    private double total_venta;

    /**
     * 
     */
    private String motivo;
 
 
    
    
    /**
     * Default constructor
     */
    public Devolucion() {
    }
   
    

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getDireccion_tienda() {
        return direccion_tienda;
    }

    public void setDireccion_tienda(String direccion_tienda) {
        this.direccion_tienda = direccion_tienda;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
    
    

}//fin clase Devolucion