/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BDD.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Venta;
import vista.VistaDC;

/**
 *
 * @author renemm
 */
public class Controlador implements ActionListener{

    private VistaDC ventana_p;
    private Venta venta;
    private Conexion conexion;
   // private ActionListener escucha;
    
    public Controlador(VistaDC ventana_p, Venta venta){
        this.ventana_p  = ventana_p;
        this.venta      = venta;
        conexion = new Conexion();
    }
    public void iniciar()
    {
        
        ventana_p.setTitle("Cambios y Devoluciones");
        ventana_p.getBtn_validar().addActionListener(this);
        ventana_p.getBtn_cambios().addActionListener(this);
        ventana_p.getBtn_devoluciones().addActionListener(this);  
        ventana_p.getTxt_num_tck().addKeyListener
        (
            new java.awt.event.KeyAdapter()
            {
                public void keyTyped(java.awt.event.KeyEvent evt)
                {
                    txt_num_tckKeyTyped(evt);
                }
            }
        );
//        conexion.guardarVenta(venta);
        
        
        
        
    }
    
    private void txt_num_tckKeyTyped(java.awt.event.KeyEvent evt)
    {                                     
       
            Object c = evt.getSource();
             
            if( c.equals( ventana_p.getTxt_num_tck() ) )
            {
                ventana_p.getLbl_opccion().setVisible(false);
                ventana_p.getBtn_cambios().setVisible(false);
                ventana_p.getBtn_devoluciones().setVisible(false);
                ventana_p.getLbl_num_venta().setText("Ingresa el numero de ticket o venta");
            }
             

    } 
    
    //ACCION PARA LA ENTRADA TXT DE VENTA
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        
        Object c = e.getSource();
        DefaultTableModel modelo = new DefaultTableModel();
        
        if(c.equals(ventana_p.getBtn_validar())   )//hacemos la validacion
        {   
                    conexion.guardarVenta(venta);
         try{
 
                if( conexion.validaVenta(Integer.parseInt(ventana_p.getTxt_num_tck().getText())))//el num_venta es valido
                {


                    //Informamos de la valides de la venta
                    ventana_p.getLbl_num_venta().setText("Ticket Valido");
                    ventana_p.getPanel_info().setVisible(true);

                    try{
                            int num_columnas =  conexion.getResultMeta().getColumnCount();
                            ventana_p.getTbl_info().setModel(modelo);
                            ventana_p.getTbl_info().enable(false); ;


                                modelo.addColumn("Fecha");
//                                modelo.addColumn("Tiempo Expirado");
                                modelo.addColumn("Numero de Venta ");
                                modelo.addColumn("Empleado");  
                                modelo.addColumn("Tienda");
                                modelo.addColumn("Direccion");
                                modelo.addColumn("Total");

                                while(conexion.getResultSet().next())
                                {
                                    Object [] filas = new Object[num_columnas];
                                    String fchVenta = conexion.getResultSet().getString("fch_venta");

                                    filas[0] = conexion.getResultSet().getObject("fch_venta");
//                                     filas[1] = dameExpiracion(fchVenta);
                                    filas[1] = conexion.getResultSet().getObject("num_venta");
                                    filas[2] = conexion.getResultSet().getObject("nombre_empleado");
                                    filas[3] = conexion.getResultSet().getObject("nombre_tienda");
                                    filas[4] = conexion.getResultSet().getObject("direccion_tienda");
                                    filas[5] = conexion.getResultSet().getObject("total_venta");
                                    modelo.addRow(filas);
                                    conexion.desconectar();
                                }
                        }catch(SQLException ex)
                                               {
                                                    System.out.println(e);
                                               }//fin catch SQL

                    ventana_p.getLbl_opccion().setVisible(true);
                    ventana_p.getBtn_cambios().setVisible(true);
                    ventana_p.getBtn_devoluciones().setVisible(true);
                }//valida venta
                else
                {
                    ventana_p.getLbl_num_venta().setText("El numero de venta no existe");
                    modelo.setRowCount(0);
                    //El num_venta no esta en la base de datos
                }
                            
            }catch(NumberFormatException format)
                                               {
                                                    System.out.println(format);
                                                }//fin catch format                  
                            
        }//fin if valida boton
                
           
           
       
       
       
//        if( c.equals(ventana_p.getBtn_cambios()) || c.equals(ventana_p.getBtn_devoluciones())  ) 
//        {
//            System.out.println("Hola mundo");
//            
//            //Pedimos el codigo de barras o el numero del ticket
////               ventana_p.repaint();
//                
//              //  ventana_p.getTxt_num_ticket().setVisible(true);
//            
//        }       
        
        

    }//fin metodo actionPerformed
    
    
    
    
        private int dameExpiracion(String fch_venta )
    {
        int j = 0;
        LocalDateTime fchActual = LocalDateTime.now();
        
        
        
        //Dividimos la cadena para obtener el dia
        // Formato de la Fecha: [Dia Mes dia Hora:Minutos:Segundos CST Año] 
        String [] campos = fch_venta.split("\\s+");
        while(j<campos.length)
        {
            j++;
            
        }
//        fchVenta = new Date();
//        fchVenta.se
//        System.out.println(campos[0]);
//        System.out.println(campos[1]);
//        System.out.println(campos[2]);
//         fchVenta =  new Date(campos[]);
        
        
        
//        int aux = fchActual.getDay();
    return  Integer.parseInt(campos[2]);
    }
    
  

    
    
    
    
    
    
    
    
    
    
}  //fin clase Controlador
