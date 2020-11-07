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
    private Statement statement = null;
    private String db= "/Users/renemm/Desktop/Aseguramiento/LineClothes/DevolucionesCambios/BasesDatos/DevolucionesCambios.db";
    
    private int secuencia;
    
    

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
     
     public void  generaSecuencia()
     {
        try {
            PreparedStatement st = connection.prepareStatement("select * from ventas order by id_venta desc limit 1");
            resultSet = st.executeQuery();
            secuencia = 1 + resultSet.getInt("id_venta");
            connection.close();
        } catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     
     public boolean guardarVenta(Venta venta)
    {
        boolean res = false;
        //generamos una secuencia para la PK.
        generaSecuencia();
        
        try {
            
            PreparedStatement st = connection.prepareStatement("insert into ventas (id_venta,fch_venta,num_venta,nombre_Empleado,nombre_tienda,direccion_tienda,total_venta) values (?,?,?,?,?,?,?)");
            st.setString(1,secuencia +  "");
            st.setString(2,venta.getFecha() + "");
            st.setString(3,venta.getNum_vnta()+"");
            st.setString(4,venta.getNom_Empleado());
            st.setString(5,venta.getNom_tienda());
            st.setString(6,venta.getDireccion());
            st.setString(7,venta.getTotal()+"");
            st.execute();
            
            res = true;
            connection.close();
         }catch(SQLException e){
            System.out.println(e);
        }
      return res;
    }
     
     
     public int buscaVenta(int num_venta)
     {
        int val = 0;
        try {
            PreparedStatement st = connection.prepareStatement("select * from ventas where num_venta="+num_venta);
            resultSet = st.executeQuery();
            val =resultSet.getInt(3) ;
            
            if ( val > 0 ) 
            {
                
//               while (resultSet.next()) {
//                System.out.print("ID: ");
//                System.out.println(resultSet.getInt("id_venta"));
//
//                System.out.print("Nombre: ");
//                System.out.println(resultSet.getString("fch_venta"));
//
//                System.out.print("Apellidos: ");
//                System.out.println(resultSet.getString("num_venta"));
//
//                System.out.println("=======================");
//            }
                return val;
            }
             connection.close();
         }catch(SQLException e){
            System.out.println(e);
            
        }
      return val;
          
     }
     
     
//     public boolean buscar(int id){
//         boolean res = false;
//         
//         try {
//                PreparedStatement pst = connection.prepareStatement("SELECT id_emp,pass,nombre,id_empleado FROM Empleado WHERE id_emp=?");
//                pst.setString(1, "id_emp" ) ;
//                res = true;
//        }catch(Exception e){
//             System.out.print(e);
//             res = false;
//         }
//      return    res;
//     }
    
    
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
        }
    }
    
}
