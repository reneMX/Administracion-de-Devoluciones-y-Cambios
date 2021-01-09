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
import java.sql.ResultSet;
import java.sql.SQLException;
import modeloDTO.Efectivo;
import modeloDTO.Pago;
import modeloDTO.Tarjeta;

/**
 *
 * @author renemm
 */
public class PagoDAO {
    
    /**
    *
    * Atributos
    */
    private static final String SQL_SELECT              = "SELECT * FROM Pagos";   
    private static final String SQL_SELECT_PAGOS        = "SELECT  * FROM Pagos RIGHT JOIN Ventas ON Pagos.id_pagos = Ventas.Pago_id_pago WHERE Ventas.num_venta =";    
    private static final String SQL_SELECT_TARJETAS     = "SELECT  *  FROM Tarjetas  WHERE Tarjetas.id_tarjeta = ";   
    private static final String SQL_SELECT_EFECTIVOS    = "SELECT  *  FROM Efectivos WHERE Efectivos.id_efectivo = ";   
    private int Tarjeta_id_tarjeta;
    private int Efectivo_id_efectivo;
    private double monto;
    private int id_pagos;
    
    
    /**
    *
    * Constructor
    */
    public PagoDAO(int Tarjeta_id_tarjeta, int Efectivo_id_efectivo, double monto, int id_pagos)
    {
        this.Tarjeta_id_tarjeta = Tarjeta_id_tarjeta;
        this.Efectivo_id_efectivo = Efectivo_id_efectivo;
        this.monto = monto;
        this.id_pagos = id_pagos;
    }    

    public PagoDAO()
    {
        
    }
    
    /**
     *
     * Metodos
     */
    public Pago obtenPago(  int num_venta  )
    {
        Connection conn             = null;
        PreparedStatement stmt      = null;
        ResultSet rs                = null;
        Pago tarjeta    = null;
        Pago efectivo   = null;
        Pago pago       = null;
        
        
//        int id_tarjeta;
//        int id_efectivo;
//        double monto;
        String fecha;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PAGOS+num_venta);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Tarjeta_id_tarjeta  = rs.getInt("Tarjeta_id_tarjeta");
                Efectivo_id_efectivo = rs.getInt("Efectivo_id_efectivo");
                monto = rs.getDouble("monto");
                fecha = rs.getString("fch_venta");
                
                //Se hizo pago con Tarjeta
                if(  Tarjeta_id_tarjeta != 0 )
                {
                    tarjeta = dameDatosTarjeta(Tarjeta_id_tarjeta);
                    tarjeta.setMonto(monto);
                    tarjeta.setTipo_pago(1);
                    pago =   tarjeta;
                }//fin val1!=0
                //Se hizo pago con Efectivo
                else
                {
                    efectivo = dameDatosEfectivo(Efectivo_id_efectivo);
                    efectivo.setMonto(monto);
                    efectivo.setTipo_pago(0);
                    pago =  efectivo;
                }//fin val1!==0
            
            }//fin while
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return pago;
    }//fin dameTipoPago()
    
    public Efectivo dameDatosEfectivo(int id_efectivo)
    {
        Connection conn         = null;
        PreparedStatement stmt  = null;
        ResultSet rs            = null;
        Efectivo efectivo       = null;
        String nombre;
        
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EFECTIVOS+id_efectivo);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
               nombre = rs.getString("nombre");
               efectivo = new Efectivo();
               efectivo.setNombre(nombre);
            }    
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
                    try {
                        Conexion.close(rs);
                        Conexion.close(stmt);
                        Conexion.close(conn);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }//fin try-catch interno
                }//fin del finally
        
        return efectivo ;
    }//fin dameDatosEfectivo(id_efectivo)
    
    
    public Tarjeta dameDatosTarjeta(int id_tarjeta){
   
        Connection conn         = null;
        PreparedStatement stmt  = null;
        ResultSet rs            = null;
        Tarjeta tarjeta         = null;
        String numero;
        String nombre;
    
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_TARJETAS+id_tarjeta);
            rs = stmt.executeQuery();
            
            while( rs.next() )
            {
                numero = rs.getString("numero");
                nombre = rs.getString("nombre");
                tarjeta = new Tarjeta();
                tarjeta.setNumero(numero);
                tarjeta.setNombre(nombre);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }//fin catch
        finally {
                    try {
                        Conexion.close(rs);
                        Conexion.close(stmt);
                        Conexion.close(conn);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }//fin try-catch interno
                }//fin del finally
        
        return tarjeta;
    }//fin dameDatosTarjeta
    
}//fin clase PagoDAO
