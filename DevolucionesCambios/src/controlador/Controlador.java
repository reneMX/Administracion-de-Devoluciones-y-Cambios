/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BDD.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Venta;
import vista.Devoluciones;
import vista.VistaDC;

/**
 *
 * @author renemm
 */
public class Controlador implements ActionListener{

    
    private VistaDC ventana_p;
    private Devoluciones ventana_dev;
    private Venta venta;
    private Conexion conexion;
    private ActionListener escucha;
    private LocalDateTime fch_actual;
    
    public Controlador(VistaDC ventana_p, Venta venta, Devoluciones ventana_devoluciones){
        this.ventana_p  = ventana_p;
        this.venta      = venta;
        this.ventana_dev = ventana_devoluciones;
        this.conexion = new Conexion();
        this.fch_actual = LocalDateTime.now();
    }//fin constructor
    
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
                }//fin keyTyped
            }//fin KeyAdapter
        );//fin addKeyListener
        
        ventana_dev.getBtn_regresar().addActionListener(this);
        ventana_dev.getBtn_home().addActionListener(this);
        
        
    }//fin iniciar()
    
    private void txt_num_tckKeyTyped(java.awt.event.KeyEvent evt)
    {                                     
            Object c = evt.getSource();
             
            if( c.equals( ventana_p.getTxt_num_tck() ))
            {
                ventana_p.getLbl_opccion().setVisible(false);
                ventana_p.getBtn_cambios().setVisible(false);
                ventana_p.getBtn_devoluciones().setVisible(false);
                ventana_p.getLbl_num_venta().setText("Ingresa el numero de ticket o venta");
            }//fin if (c.equals( ventana_p.getTxt_num_tck)
    }//fin  txt_num_tckKeyTyped()
    
    //ACCION PARA LA ENTRADA TXT DE VENTA
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
       
       Object c = e.getSource();
       int num_venta = Integer.parseInt(ventana_p.getTxt_num_tck().getText());
       
       try{      
                if(c.equals(ventana_p.getBtn_validar()))//hacemos la validacion
                {  
                    conexion = new Conexion();

                    if( conexion.validaVenta(num_venta) ) //el num_venta es valido
                    {
                         //Informamos de la valides de la venta
                        ventana_p.getLbl_num_venta().setText("Ticket Valido");
                        ventana_p.getPanel_info().setVisible(true);
                        
                        muestraDatosVenta(num_venta);
                        

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
                    conexion.desconectar();
                }//fin if valida boton
           
       }catch(NullPointerException ex){
                        System.out.println("Excepccion de Controlador");
                        System.out.println(ex);
                     }//fin cacth NULL
            

        if( c.equals(ventana_p.getBtn_cambios()) || c.equals(ventana_p.getBtn_devoluciones())  ) 
        {
            ArrayList<String> devolucion =  new ArrayList<String>();
            conexion = new Conexion();
            System.out.println("Hola mundo");
            ventana_p.setVisible(false);
            ventana_dev.setVisible(true);
            ventana_p.repaint();
            
            

        }   
        
        if(c.equals(ventana_dev.getBtn_regresar() ))//hacemos la validacion
        {
           conexion = new Conexion();
            
           ventana_dev.repaint();
           ventana_dev.setVisible(false);
           ventana_p.setVisible(true);
           
           

           
            
            
        }  

        
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






