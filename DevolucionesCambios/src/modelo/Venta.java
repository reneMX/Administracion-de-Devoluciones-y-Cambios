package modelo;
import java.util.*;

/**
 * 
 */
public class Venta {

    /**
     * Default constructor
     */
    public Venta() {
    }

    public Venta(Date fecha, String nom_Empleado, int num_vnta, String nom_tienda, String direccion, double total) {
        this.fecha = fecha;
        this.nom_Empleado = nom_Empleado;
        this.num_vnta = num_vnta;
        this.nom_tienda = nom_tienda;
        this.direccion = direccion;
        this.total = total;
    }

    /**
     * 
     */
    private Date fecha;

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
    public void Operation1() {
        // TODO implement here
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

}