/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import static BDD.Conexion.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modeloDTO.Producto;


/**
 *
 * @author renemm
 */
public class ProductoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Productos (nom_producto, talla, precio) VALUES(?,?,?)";
    private static final String SQL_SELECT_ID = "SELECT id_productos FROM Productos WHERE id_productos=";
    private static final String SQL_SELECT = "SELECT * FROM Productos";

    public ProductoDAO() {
    
    }//fin constructor
    
    

public int insertaProducto(Producto producto){
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, ""+producto.getTalla());
            stmt.setDouble(3, producto.getPrecio());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                                close(stmt);
                                                close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally
        
        return registros;
}//fin insertaProducto



public List<Producto> seleccionar()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;        
        List<Producto> productos = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String nom_producto   = rs.getString("nom_producto");
                int talla       = rs.getInt("talla");
                double precio   = rs.getInt("precio");
                
                producto.setNombre(nom_producto);
                producto.setTalla(talla);
                producto.setPrecio(precio);

                productos.add(producto);
            }//fin while
        } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            } finally {
                                            try {
                                                close(rs);
                                                close(stmt);
                                                close(conn);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace(System.out);
                                            }//fin try-catch interno
                                        }//fin del finally
        return productos;
    }//fin seleccionar()
    
    

    
//public Venta validaVenta(int num_venta)
//    {
//        
//       
//        
//        return venta;
//
//    }




}//fin clase ProductoDAO
