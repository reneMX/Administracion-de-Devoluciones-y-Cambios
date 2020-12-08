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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ActionListener escucha;
    private LocalDateTime fch_actual;
    
    public Controlador(VistaDC ventana_p, Venta venta){
        this.ventana_p  = ventana_p;
        this.venta      = venta;
        conexion = new Conexion();
        fch_actual = LocalDateTime.now();
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
        
        
        
        
        
    }
    
    private void txt_num_tckKeyTyped(java.awt.event.KeyEvent evt) {                                     
       
            Object c = evt.getSource();
             
            if( c.equals( ventana_p.getTxt_num_tck() ))
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
       int num_venta = Integer.parseInt(ventana_p.getTxt_num_tck().getText());
       conexion = new Conexion();
           

       try{
           
                if(c.equals(ventana_p.getBtn_validar()))//hacemos la validacion
                {  
//                    conexion.guardarVenta(venta);

                    if( conexion.validaVenta(num_venta) ) //el num_venta es valido
                    {
                        //System.out.println("Entra a la validacion");

                        
                         //Informamos de la valides de la venta
                        ventana_p.getLbl_num_venta().setText("Ticket Valido");
                        ventana_p.getPanel_info().setVisible(true);
                        muestraDatosVenta(num_venta);
                        

                        try{
                                //int num_columnas =  conexion.getResultMeta().getColumnCount();
                                
                                
                                //DefaultTableModel modelo = new DefaultTableModel();
                                
                                
                                //System.out.println("valores: "+conexion.getResultSet().getInt("num_venta")  );
                                //System.out.println("Valor de num_venta" + conexion.getResultSet().getInt("num_venta"));
                                
                                
                                
//                                ventana_p.getTbl_info().setModel(modelo);
//                                ventana_p.getTbl_info().enable(false); 
                             
//                                modelo.addColumn("Numero de Venta ");
//                                modelo.addColumn("Fecha de compra");
//                                modelo.addColumn("Producto");
//                                modelo.addColumn("Total");
//                                modelo.addColumn("Empleado");  
//                                modelo.addColumn("Tienda");
//                                
//                                ventana_p.getTbl_info().setModel(modelo);
//                                ventana_p.getTbl_info().enable(false); 
                                
                                System.out.println("Antes del while");
                                System.out.println("Valor de num_venta" + conexion.getResultSet().getInt("num_venta"));
                                
//                                conexion.getVenta(9029);
                                
//                                while(conexion.getResultSet().next() )
//                                {
//                                    Object [] filas = new Object[7];
//                                    String fch_venta = conexion.getResultSet().getString("fch_venta");
//                                    System.out.println("fecha en base de datos " + fch_venta);
//                                    filas[0] = conexion.getResultSet().getObject("num_venta");
//                                    filas[1] = conexion.getResultSet().getObject("fch_venta");
//                                    filas[2] = conexion.getResultSet().getObject("id_productos");
//                                    filas[3] = conexion.getResultSet().getObject("total_venta");
//                                    filas[4] = conexion.getResultSet().getObject("nombre_empleado");
//                                    filas[5] = conexion.getResultSet().getObject("nombre_tienda");
//                                    
//                                    modelo.addRow(filas);
//                                }
                            }catch(SQLException ex){
                                                       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                                                    }

                        ventana_p.getLbl_opccion().setVisible(true);
                        ventana_p.getBtn_cambios().setVisible(true);
                        ventana_p.getBtn_devoluciones().setVisible(true);
                    }//valida venta
                    else
                    {
                        ventana_p.getLbl_num_venta().setText("El numero de venta no existe");
                        ventana_p.getPanel_info().setVisible(false);
                        ventana_p.getLbl_opccion().setVisible(false);
                        ventana_p.getBtn_cambios().setVisible(false);
                        ventana_p.getBtn_devoluciones().setVisible(false);
                        //El num_venta no esta en la base de datos
                    }
                }//fin if valida boton
           
       }catch(NullPointerException ex){
                        System.out.println("Excepccion de Controlador");
                        System.out.println(ex);
           
                     }//fin cacth NULL
            
       
       
       
       
//        if( c.equals(ventana_p.getBtn_cambios()) || c.equals(ventana_p.getBtn_devoluciones())  ) 
//        {
//            System.out.println("Hola mundo");
//            
//            //Pedimos el codigo de barras o el numero del ticket
//               ventana_p.repaint();
//                
//              //  ventana_p.getTxt_num_ticket().setVisible(true);
//            
//        }       

        
    }//fin metodo actionPerformed()
    
    public void muestraDatosVenta(int num_venta)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        Object [] filas;
        String fch_venta;
        
        modelo.addColumn("Numero de Venta ");
        modelo.addColumn("Fecha de compra");
        modelo.addColumn("Producto");
        modelo.addColumn("Total");
        modelo.addColumn("Empleado");  
        modelo.addColumn("Tienda");
        
        ventana_p.getTbl_info().setModel(modelo);
        ventana_p.getTbl_info().enable(false); 
        
        filas = new Object[7];

        try {    
                conexion.getVenta(num_venta);
                fch_venta = conexion.getResultSet().getString("fch_venta");
                System.out.println("fecha en base de datos " + fch_venta);
                filas[0] = conexion.getResultSet().getObject("num_venta");
                filas[1] = conexion.getResultSet().getObject("fch_venta");
                filas[2] = conexion.getResultSet().getObject("id_productos");
                filas[3] = conexion.getResultSet().getObject("total_venta");
                filas[4] = conexion.getResultSet().getObject("nombre_empleado");
                filas[5] = conexion.getResultSet().getObject("nombre_tienda");

                modelo.addRow(filas);
            
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//fin muestraDatosVenta();

   
    
    
    
    
    
    
    
    
} //Fin clase Controlador






