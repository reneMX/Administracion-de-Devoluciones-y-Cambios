/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.Efectivo;
import modelo.Venta;
import vista.VistaDC;
import modelo.Producto;

/**
 *
 * @author renemm
 */
  
    public  class Principal{
        
        /*
        *@param args  the command
        */
        public  static void main(String[] args){
            LocalDateTime fecha = LocalDateTime.now();
            Efectivo pago = new Efectivo(12002,"Dinero", 926);
            Producto pantalon = new Producto("Jeans Vans",30,1200);
            ArrayList<Producto> productos = new ArrayList<Producto>();
            productos.add(pantalon);
            Venta venta = new Venta(fecha,"Rene",9029,"Sucursal Las Antenas","Iztapalapa,18,29",1829,productos,pago);
            VistaDC vista =  new VistaDC();
            
            
            Controlador controlador = new Controlador(vista,venta);
            
            controlador.iniciar();
            vista.setVisible(true);
            
            
        }
    }