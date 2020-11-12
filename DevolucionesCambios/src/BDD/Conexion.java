/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Venta;

/**
 *
 * @author renemm
 */
public class Conexion {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private ResultSetMetaData resultMeta = null;
    private Statement statement = null;
    private String db = "/Users/renemm/Desktop/Aseguramiento/LineClothes/DevolucionesCambios/DevolucionesCambios/src/BDD/DevolucionesCambios.db";
    
    private int secuencia;
    
    
    
    
    /**

     * @deprecated
     * Constructor para instanciar una conexion a SQLite

     */
     public Conexion()
    {
      try{
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:" + this.db );
         System.out.println("Conectado a la base de datos SQLite [ " + this.db + "]");
         
      }catch(Exception e){
         System.out.println(e);
      }
      secuencia = 0;
      
    }
   
     
     public boolean guardarVenta(Venta venta)
    {
        boolean res = false;
       
        try {
            PreparedStatement ps = connection.prepareStatement("insert into ventas (fch_venta,num_venta,nombre_Empleado,nombre_tienda,direccion_tienda,total_venta) values (?,?,?,?,?,?)");
                        
            
//            ps.setString(1,secuencia +  "");
            ps.setString(1,venta.getFecha() + "");
            ps.setString(2,venta.getNum_vnta()+"");
            ps.setString(3,venta.getNom_Empleado());
            ps.setString(4,venta.getNom_tienda());
            ps.setString(5,venta.getDireccion());
            ps.setString(6,venta.getTotal()+"");
            ps.executeUpdate();
            
            res = true;
            
         }catch(SQLException e){
            System.out.println(e);
        }catch(NullPointerException nu){
                System.out.println(nu);
            }
        
      return res;
    }
     
     
     public boolean validaVenta(int num_venta)
     {
        int val = 0;
        boolean bandera = false;
        
        
        try
        {

                PreparedStatement ps = connection.prepareStatement("select * from ventas where num_venta="+num_venta);
                resultSet = ps.executeQuery();
                val = resultSet.getInt(3) ;

                if ( val > 0 ) 
                {
                    if(val == num_venta)
                    {   
                        resultMeta =  resultSet.getMetaData();
                        bandera =  true;
                    }
                }
                
         }catch(SQLException e  ){
                System.out.println(e);
            }catch(NullPointerException nu){
                System.out.println(nu);
            }
      
         return bandera;
     }//Fin metodo busqueda

    public ResultSet getResultSet() {
        return resultSet;
    }

    public ResultSetMetaData getResultMeta() {
        return resultMeta;
    }
     
     
     
     
    
    
     
     
    public void desconectar()
    {
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Desconectado de la base de datos [ " + this.db + "]");
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
    
}


//                 while (resultSet.next())
//                        {
//                            System.out.print("ID: ");
//                            System.out.println(resultSet.getInt("id_venta"));
//
//                            System.out.print("Fecha: ");
//                            System.out.println(resultSet.getString("fch_venta"));
//                            venta.setFecha(resultSet.getDate("fch_venta"));
//
//                            System.out.print("Numero de Venta: ");
//                            System.out.println(resultSet.getString("num_venta"));
//                            venta.setNum_vnta(resultSet.getInt("num_venta"));
//
//                            System.out.println("=======================");
//                        }
