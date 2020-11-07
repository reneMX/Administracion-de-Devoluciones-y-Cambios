/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BDD.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public void actionPerformed(java.awt.event.ActionEvent e) {

       Object c = e.getSource();
       if(c.equals(ventana_p.getBtn_validar()))//hacemos la validacion
       {
           //conexion.guardarVenta(venta);
           //Hacemos la busqueda
           //Le pasamos el numero del TXT que esta en la interfaz
           //El valor se pasa al metodo 'buscaVenta()' de la clase 'Conexion'
           int busqueda = conexion.buscaVenta(Integer.parseInt(ventana_p.getTxt_num_tck().getText()));
           if( busqueda > 0)//el num_venta es valido
           {
                ventana_p.getLbl_num_venta().setText("Ticket Valido");
                ventana_p.getPanel_info().setVisible(true);
                //System.out.println(ventana_p.getTxt_num_tck().getText());
                ventana_p.getLbl_opccion().setVisible(true);
                ventana_p.getBtn_cambios().setVisible(true);
                ventana_p.getBtn_devoluciones().setVisible(true);
           }
           else
           {
               ventana_p.getLbl_num_venta().setText("El numero de venta no existe");
               //El num_venta no esta en la base de datos
           }
       }
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
    }
    
    
  
}
