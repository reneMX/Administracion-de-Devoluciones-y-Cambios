/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    private ActionListener escucha;
    
    public Controlador(VistaDC ventana_p, Venta venta){
        this.ventana_p  = ventana_p;
        this.venta      = venta;
        ventana_p.getBtn_cambios().addActionListener(this);
        ventana_p.getBtn_devoluciones().addActionListener(this);
        
    }
    
    public void iniciar(){
        ventana_p.setTitle("Menu");
        //ventana_p.setLocation(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object c = e.getSource();
        if( c.equals(ventana_p.getBtn_cambios()) || c.equals(ventana_p.getBtn_devoluciones()) ) 
        {
            System.out.println("Hola mundo");
            //Pedimos el codigo de barras o el numero del ticket
                
                ventana_p.getLayeredPane().repaint();
                ventana_p.getLayeredPane().revalidate();
                //ventana_p.getLayeredPane().setVisible(true);
                ventana_p.getTxt_num_ticket().setVisible(true);
            
        }        
        
    }
    
    
  
}
