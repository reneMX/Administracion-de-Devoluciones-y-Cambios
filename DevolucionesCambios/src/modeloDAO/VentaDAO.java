/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import BDD.Conexion;
import static BDD.Conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modeloDTO.Pago;
import modeloDTO.Producto;
import modeloDTO.Venta;

/**
 *
 * @author renemm
 */
public class VentaDAO {

    private static final String SQL_SELECT = "SELECT * FROM Ventas";    
    private static final String SQL_INSERT = "INSERT INTO Ventas (fch_venta, nombre_empleado, nombre_tienda, direccion_tienda, total_venta) VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_NUM_VENTAS = "SELECT num_venta, fch_venta, total_venta, nombre_empleado, nombre_tienda FROM Ventas WHERE num_venta =";
    private static final String SQL_SELECT_VALID_VENTAS= "SELECT num_venta FROM Ventas WHERE num_venta = ";
    private static final String SQL_SELECT_PAGOS= "SELECT nombre, monto FROM Pagos RIGHT JOIN ventas_productos ON Pagos.id_pagos = ventas_productos.id_producto WHERE ventas_productos.id_venta = ";
    
//    private static final String SQL_SELECT_ID_PAGOS = "SELECT id_pagos FROM Pagos ORDER BY id_pagos DESC LIMIT 1";
    private static final String SQL_SELECT_P_ASOCIADOS= "SELECT * FROM Productos RIGHT JOIN ventas_productos ON Productos.id_productos = ventas_productos.id_producto WHERE ventas_productos.id_venta =";

    

//    private static  String SQL_SELECT = "SELECT num_venta FROM Ventas WHERE num_venta = 9029";

    
public VentaDAO(){
    
}//fin cosntructor
    
    
/*METODOS*/

public Venta seleccionar()
{
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Venta venta = null;
    List<Venta> ventas = new ArrayList<>();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
//    LocalDateTime fch;

    try {
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while (rs.next())
        {
            int num_venta = rs.getInt("num_venta");
            String fch_venta   = rs.getString("fch_venta");
            String nombre_empleado   = rs.getString("nombre_empleado");
            String nombre_tienda   = rs.getString("nombre_tienda");
            String direccion_tienda   = rs.getString("direccion_tienda");
            double total_venta = rs.getInt("total_venta");


            venta = new Venta();
            venta.setNum_venta(num_venta);
            venta.setFecha(fch_venta);
            venta.setNom_Empleado(nombre_empleado);
            venta.setNom_tienda(nombre_tienda);
            venta.setDireccion(direccion_tienda);
            venta.setTotal(total_venta);

        }//fin while
    } catch (SQLException ex) {
                            ex.printStackTrace(System.out);
                        } finally {
                                        try {
                                            Conexion.close(rs);
                                            Conexion.close(stmt);
                                            Conexion.close(conn);
                                        } catch (SQLException ex) {
                                            ex.printStackTrace(System.out);
                                        }//fin try-catch interno
                                    }//fin del finally

    return venta;
}

                
                
                
//                venta = new Venta();
//                venta = new Venta(id_ventas, id_pago, id_producto, numero_venta, fch_venta, nombre_empleado, nombre_tienda, direccion_tienda, total_venta);

public boolean validaVenta(int num_venta)
    {
        Connection conn          = null;
        PreparedStatement stmt   = null;
        ResultSet rs             = null;
        boolean val = false;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_VALID_VENTAS+num_venta);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                int numero_venta = rs.getInt("num_venta");
                if(numero_venta == num_venta ){
                    val = true;
                }
            }//fin while
            
        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                                Conexion.close(rs);
                                                Conexion.close(stmt);
                                                Conexion.close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally
        return val;
    }//fin validaVenta()

public void insertaVenta(Venta venta){
    
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ""+venta.getFecha());
            stmt.setString(2, venta.getNom_Empleado());
            stmt.setString(3, venta.getNom_tienda());
            stmt.setString(4, venta.getDireccion());
            stmt.setDouble(5, venta.getTotal());
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
        
    
    
}//fin insertaVenta

public List<Producto> productosAsociados( int num_venta ){
    
        
        Connection conn          = null;
        PreparedStatement stmt   = null;
        ResultSet rs             = null;
        Producto producto        = null;        
        List<Producto> productos = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_P_ASOCIADOS+num_venta);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String nombre = rs.getString("nom_producto");
                int talla = Integer.parseInt( rs.getString("talla") );
                double precio = rs.getDouble("precio");
                
                producto = new Producto(nombre, talla, precio);
                productos.add(producto);
            }//fin while
        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                                Conexion.close(rs);
                                                Conexion.close(stmt);
                                                Conexion.close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally
        return productos;
}//fin productosAsociados

public Venta ventaValida(int num_venta)
{
        Connection conn          = null;
        PreparedStatement stmt   = null;
        ResultSet rs             = null;
        Venta venta              = null; 
        List<Producto> productos = new ArrayList<Producto>();
        
        boolean val = false;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_NUM_VENTAS+num_venta);
            rs = stmt.executeQuery();
            productos = productosAsociados(num_venta);
            
            int i = 0;
            venta = new Venta();
            while (rs.next())
            {
                
                int numero_venta = rs.getInt("num_venta");
                String fch = rs.getString("fch_venta") ;
//                String nombre_p = rs.getString( productos.get(i).getNombre());
                double total = rs.getDouble("total_venta");
                String nombre_e = rs.getString("nombre_empleado");
                String nombre_t = rs.getString("nombre_tienda");

                venta.setNum_venta(numero_venta);
                venta.setFecha(fch);
                venta.setTotal(total);
                venta.setNom_Empleado(nombre_e);
                venta.setNom_tienda(nombre_t);
                
                
            }//fin while
            venta.setProductos(productos);
            
        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                                Conexion.close(rs);
                                                Conexion.close(stmt);
                                                Conexion.close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally
        return venta;    
    
    
}//fin ventaValida()



public Pago obtenPago(int num_venta)
{
        Connection conn          = null;
        PreparedStatement stmt   = null;
        ResultSet rs             = null;
        Pago pago    =    new Pago() ; 

        
        boolean val = false;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PAGOS+num_venta);
            rs = stmt.executeQuery();
           
            int i = 0;
            
            while (rs.next())
            {
                
                String nombre = rs.getString("nombre");
                double monto = rs.getDouble("monto") ;
                
                pago.setNombre(nombre);
                pago.setMonto(monto);
                

            }//fin while

        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                                Conexion.close(rs);
                                                Conexion.close(stmt);
                                                Conexion.close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally
        return pago;    
    
    
}//fin ventaValida()







}//fin VentaDAO
