package modelo;


import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Venta {

     /**
     * 
     */
    private LocalDateTime fecha;

    /**
     * 
     */
    private String nom_Empleado;

    /**
     * 
     */
    private int num_vnta;

    /**
     * 
     */
    private String nom_tienda;

    /**
     * 
     */
    private String direccion;

    /**
     * 
     */
    private double total;
    
    /**
     * 
     */
    private  ArrayList<Producto> productos;
    
    
    /**
     * 
     */
    private Pago pago;

    /**
     * 
     */
    private int id_ventas;
    
    /**
     * 
     */
    private int id_producto;
    
    /**
     * 
     */
    private int id_pago;
    
    /**
     * Default constructor
     */
    public Venta()
    {
        
    }

    public Venta(int id_ventas, int id_producto, int id_pago) {
        this.id_ventas = id_ventas;
        this.id_producto = id_producto;
        this.id_pago = id_pago;
    }
    

    public Venta(LocalDateTime fecha, String nom_Empleado, int num_vnta, String nom_tienda, String direccion, double total, ArrayList<Producto> productos, Pago pago) {
        this.fecha = fecha;
        this.nom_Empleado = nom_Empleado;
        this.num_vnta = num_vnta;
        this.nom_tienda = nom_tienda;
        this.direccion = direccion;
        this.total = total;
        this.productos = productos;
        this.pago = pago;
    }

   

   


    /**
     * @return
     */
    public boolean agregarVenta() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean modificarVenta() {
        // TODO implement here
        return false;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNom_Empleado() {
        return nom_Empleado;
    }

    public void setNom_Empleado(String nom_Empleado) {
        this.nom_Empleado = nom_Empleado;
    }

    public int getNum_vnta() {
        return num_vnta;
    }

    public void setNum_vnta(int num_vnta) {
        this.num_vnta = num_vnta;
    }

    public String getNom_tienda() {
        return nom_tienda;
    }

    public void setNom_tienda(String nom_tienda) {
        this.nom_tienda = nom_tienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Venta{" + "fecha=" + fecha + ", nom_Empleado=" + nom_Empleado + ", num_vnta=" + num_vnta + ", nom_tienda=" + nom_tienda + ", direccion=" + direccion + ", total=" + total + ", productos=" + productos + ", pago=" + pago + ", id_ventas=" + id_ventas + ", id_producto=" + id_producto + ", id_pago=" + id_pago + '}';
    }

    
    
    
}