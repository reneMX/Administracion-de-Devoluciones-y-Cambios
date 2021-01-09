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
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lineclohtes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    private static final String JDBC_URL = "/Users/renemm/Desktop/Aseguramiento/LineClothes/DevolucionesCambios/DevolucionesCambios/src/BDD/LineClotes.db";
    private Connection connection;

    /**
    *..Constructor de la Conexion a la 
    *..Base de datos
    * @version 0.0.0.1
    */
    public Conexion() {
    }//fin constructor Conexion

    
    
    //..Metodos
   
    /**
    *..Metodo Para obtener la conexion
    *..A la Base de datos.
    * @version 0.0.0.1
    * @return 
    * @throws java.sql.SQLException
    */
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//    }
    
    public static Connection getConnection() throws SQLException {    
        Connection con = null;
        String sURL = "jdbc:mysql:"+JDBC_URL;
        con = DriverManager.getConnection(sURL,JDBC_USER,JDBC_PASSWORD);
        return con;
    }
    
    
    
    /**
    *..Metodo Para cerrar los resultados
    *..De la busqueda en al base de datos
    * @version 0.0.0.1
    * @param rs
    * @throws java.sql.SQLException
    */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    /**
    *..Metodo para cerrar las sentencias SQL
    * @version 0.0.0.1
    * @param smtm
    * @throws SQLException
    */
    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    /**
    *..Metodo para cerrar las sentencias precompiladas SQL
    * @version 0.0.0.1
    * @param smtm
    * @throws java.sql.SQLException
    */
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    /**
    *..Metodo para cerrar la conexion a la Base de Datos
    * @version 0.0.0.1
    * @param conn
    * @throws SQLException
    */
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
  
}//fin clase Conexion

