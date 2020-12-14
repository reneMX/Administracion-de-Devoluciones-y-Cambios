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


/**
 *
 * @author renemm
 */
public class Conexion {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "#include.H20";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lineclohtes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    private Connection connection;

    public Conexion() {

//        try{
//                Class.forName(JDBC_DRIVER);
//                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//                if(connection != null )
//                {
//                    System.out.println("Conectado a la base de datos SQLite [ " + this.JDBC_URL + "]");
//                }//if
//            }catch(SQLException | ClassNotFoundException e){
//                            System.out.println("Error al conectar, Excepccion:" + e);
//                }//fin catch    
//        
    }//fin constructor Conexion

    
      public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
//    }//fin cerrar
    
//    public boolean guardarVenta(Venta venta)
//    {
//        boolean res = false;
//        PreparedStatement ps = null;
//        
//        try {
//            ps = connection.prepareStatement("insert into ventas (id_ventas,id_productos, id_pagos, num_venta, fch_venta, nombre_empleado,nombre_tienda,direccion_tienda,total_venta) values (?,?,?,?,?,?,?,?,?)");
////            ps.setString(1,generaSecuencia("id_ventas") + "");
////            ps.setString(2,generaSecuencia("id_productos") +  "");
////            ps.setString(3,generaSecuencia("id_pagos") +  "");
//            ps.setString(4,venta.getNum_vnta()+"");
//            ps.setString(5,venta.getFecha() + "");
//            ps.setString(6,venta.getNom_Empleado());
//            ps.setString(7,venta.getNom_tienda());
//            ps.setString(8,venta.getDireccion());
//            ps.setString(9,venta.getTotal()+"");
//            ps.execute();
//            System.out.println("Datos agregados a la base son correctos");
//            res = true;
//            connection.close();
//         }catch(SQLException e){
//            System.out.println(e);
//        }
//      return res;
//    }//fin guardarVenta()
//     
//     
//     public boolean validaVenta(int num_venta)
//     {
//        int val = 0;
//        boolean bandera = false;
//        //System.out.println("Entra a validaVenta, venta "+num_venta);
//        try
//        {
//                String sql = "select num_venta from ventas where num_venta = " + num_venta;
//                PreparedStatement ps = connection.prepareStatement(sql);
//                resultSet = ps.executeQuery();
//                val = resultSet.getInt("num_venta");
//                System.out.println("EL valor obtenido es " + val);
//                System.out.println("Pasamos los resulset ");
//                if ( val > 0 ) 
//                {
//                    if(val == num_venta)
//                    {   
//                        resultMeta =  resultSet.getMetaData();
//                        bandera =  true; 
//                    }//fin id val
//                }//fin if val
//                System.out.println("Entra al try, y esta antes del close()");
//                
//         }catch(SQLException e){
//                                System.out.println("Excepccion de Conexion");   
//                                System.out.println(e);
//                            }//fin catch
//      
//         return bandera;
//     }//Fin metodo busqueda
//
//     
//     public void getVenta(int num_venta)
//     {
//        System.out.println("Si entra a getVenta"); 
//        try{
//           String sql       = "select * from ventas where num_venta = " + num_venta ;
//            prepared  = connection.prepareStatement(sql);
//            resultSet = prepared.executeQuery(); 
//        }catch(SQLException e){
//                            System.out.println(e);
//                        }//fin catch
//        
//     }//fin getVenta();
//     
//    public ResultSet getResultSet() {
//        return resultSet;
//    }//fin getResultSet()
//
//    public ResultSetMetaData getResultMeta() {
//        return resultMeta;
//    }//fin getretulrSetMeta()
//     
//     
//     
//     
//    
//    
//     
//     
//    public void desconectar()
//    {
//        try {
//            resultSet.close();
//            statement.close();
//            connection.close();
//            
//            System.out.println("Desconectado de la base de datos [ " + this.JDBC_URL+ "]");
//        }
//        catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }//fin desconectar()
//
//    public Statement getStatement() {
//        return statement;
//    }
//
//    public PreparedStatement getPrepared() {
//        return prepared;
//    }
//    
//    
//    
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
