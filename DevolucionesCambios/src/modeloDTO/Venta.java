package modeloDTO;


import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Venta {

     /**
     * 
     */
    private String fecha;

    /**
     * 
     */
    private String nom_Empleado;

    /**
     * 
     */
    private int num_venta;

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
    private  List<Producto> productos;
    
    
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
    
    public Venta(String  fecha_venta, String nombre_empleado , String nombre_tienda, String direccion_tienda, double total_venta) {

        this.fecha = fecha_venta;
        this.nom_Empleado = nombre_empleado;
        this.nom_tienda = nombre_tienda;
        this.direccion = direccion_tienda;
        this.total = total_venta;
    }
    
    
    

    public Venta(int numero_venta, String fecha,ArrayList<Producto> productos, double total, String nom_Empleado, String nom_tienda) {
        this.num_venta = numero_venta;
        this.fecha = fecha;
        this.productos = productos;
        this.total = total;
        this.nom_Empleado = nom_Empleado;        
        this.nom_tienda = nom_tienda;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNom_Empleado() {
        return nom_Empleado;
    }

    public void setNom_Empleado(String nom_Empleado) {
        this.nom_Empleado = nom_Empleado;
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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
        return "Venta{" + "fecha=" + fecha + ", nom_Empleado=" + nom_Empleado + ", num_vnta=" + num_venta + ", nom_tienda=" + nom_tienda + ", direccion=" + direccion + ", total=" + total + ", productos=" + productos + ", pago=" + pago + ", id_ventas=" + id_ventas + ", id_producto=" + id_producto + ", id_pago=" + id_pago + '}';
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public int getId_producto() {
        return id_producto;
    }

    public int getId_pago() {
        return id_pago;
    }

    
    //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
//        LocalDateTime fch = LocalDateTime.parse(fecha_venta, formatter);
    
    
    
}