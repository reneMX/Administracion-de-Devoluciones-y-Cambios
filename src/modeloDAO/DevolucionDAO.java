/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import BDD.Conexion;
import static BDD.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modeloDTO.Devolucion;

/**
 *
 * @author renemm
 */
public class DevolucionDAO {
    
    /*
        Atributos
    */
    private String SQL_INSERT;
    private int id_devoluciones;
    private int Producto_id_producto;
    private int numero_venta;
    private String nombre_empleado_realizo;
    private String nombre_empleado_realiza;
    private String nombre_pago;
    private double total_dev;
    private String direccion_tienda;
    private String comentarios;

    /*
        Constuctor
    */
    public DevolucionDAO(int id_devoluciones, int Producto_id_producto, int numero_venta, String nombre_empleado_realizo, String nombre_empleado_realiza, String nombre_pago, double total_dev, String direccion_tienda, String comentarios) {
        this.id_devoluciones = id_devoluciones;
        this.Producto_id_producto = Producto_id_producto;
        this.numero_venta = numero_venta;
        this.nombre_empleado_realizo = nombre_empleado_realizo;
        this.nombre_empleado_realiza = nombre_empleado_realiza;
        this.nombre_pago = nombre_pago;
        this.total_dev = total_dev;
        this.direccion_tienda = direccion_tienda;
        this.comentarios = comentarios;
        this.SQL_INSERT =  "INSERT INTO Devoluciones (Producto_id_producto, numero_venta, nombre_empleado_realizo, nombre_empleado_realiza, nombre_pago, total_dev, dire_tienda, comentarios) VALUES(?,?,?,?,?,?,?,?)";
    }//..fin constructor completo
    
    public DevolucionDAO(int Producto_id_producto, int numero_venta, String nombre_empleado_realizo, String nombre_empleado_realiza, String nombre_pago, double total_dev, String direccion_tienda, String comentarios) {
        
        this.Producto_id_producto = Producto_id_producto;
        this.numero_venta = numero_venta;
        this.nombre_empleado_realizo = nombre_empleado_realizo;
        this.nombre_empleado_realiza = nombre_empleado_realiza;
        this.nombre_pago = nombre_pago;
        this.total_dev = total_dev;
        this.direccion_tienda = direccion_tienda;
        this.comentarios = comentarios;
        this.SQL_INSERT =  "INSERT INTO Devoluciones (Producto_id_producto, numero_venta, nombre_empleado_realizo, nombre_empleado_realiza, nombre_pago, total_dev, dire_tienda, comentarios) VALUES(?,?,?,?,?,?,?,?)";
//                            INSERT INTO Devoluciones (Producto_id_producto`, `numero_venta`, `nombre_empleado_realizo`, `nombre_empleado_realiza`, `nombre_pago`, `total_dev`, `dire_tienda`, `comentarios`) VALUES ('24', '2938', 'sfsf', 'asdffa', 'asdff', '345', 'asdfadsg', 'asdgasdgsd');

        
    }//..fin constructor sin id_devolucion

    public DevolucionDAO() {
        this.SQL_INSERT =  "INSERT INTO Devoluciones (Producto_id_producto, numero_venta, nombre_empleado_realizo, nombre_empleado_realiza, nombre_pago, total_dev, dire_tienda, comentarios) VALUES(?,?,?,?,?,?,?,?)";
    }//..fin constructor simple
    
    

    /*
        OTHER'S METHOD'S
    */
      public void insertaDevolucion(DevolucionDAO devolucion_dao){
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
//            stmt.setString(1, ""+1);
            stmt.setString(1, ""+devolucion_dao.getProducto_id_producto());
            stmt.setString(2, ""+devolucion_dao.getNumero_venta());
            stmt.setString(3, devolucion_dao.getNombre_empleado_realizo());
            stmt.setString(4, devolucion_dao.getNombre_empleado_realiza());
            stmt.setString(5, devolucion_dao.getNombre_pago());
            stmt.setString(6, ""+devolucion_dao.getTotal_dev());
            stmt.setString(7, ""+devolucion_dao.getDireccion_tienda());
            stmt.setString(8, devolucion_dao.getComentarios());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                               
                                                Conexion.close(stmt);
                                                Conexion.close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally

}//fin insertaDevolucion  
    
    
    /*
        GET'S AND SET'S
    */
    public int getId_devoluciones() {
        return id_devoluciones;
    }

    public void setId_devoluciones(int id_devoluciones) {
        this.id_devoluciones = id_devoluciones;
    }

    public int getProducto_id_producto() {
        return Producto_id_producto;
    }

    public void setProducto_id_producto(int Producto_id_producto) {
        this.Producto_id_producto = Producto_id_producto;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }

    public String getNombre_empleado_realizo() {
        return nombre_empleado_realizo;
    }

    public void setNombre_empleado_realizo(String nombre_empleado_realizo) {
        this.nombre_empleado_realizo = nombre_empleado_realizo;
    }

    public String getNombre_empleado_realiza() {
        return nombre_empleado_realiza;
    }

    public void setNombre_empleado_realiza(String nombre_empleado_realiza) {
        this.nombre_empleado_realiza = nombre_empleado_realiza;
    }

    public String getNombre_pago() {
        return nombre_pago;
    }

    public void setNombre_pago(String nombre_pago) {
        this.nombre_pago = nombre_pago;
    }

    public double getTotal_dev() {
        return total_dev;
    }

    public void setTotal_dev(double total_dev) {
        this.total_dev = total_dev;
    }

    public String getDireccion_tienda() {
        return direccion_tienda;
    }

    public void setDireccion_tienda(String direccion_tienda) {
        this.direccion_tienda = direccion_tienda;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
    
}// fin clase DevolucionDAO
