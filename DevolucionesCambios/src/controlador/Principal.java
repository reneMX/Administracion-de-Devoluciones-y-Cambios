/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BDD.Conexion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
            Date fecha = new Date();
            Efectivo pago = new Efectivo(12002,"Dinero", 926);
            Producto pantalon = new Producto("Jeans Vans",30,1200);
            ArrayList<Producto> productos = new ArrayList<Producto>();
            productos.add(pantalon);
            Venta venta = new Venta(fecha,"Luis",12345,"Sucursal Las Antenas","Iztapalapa,18,29",1829,productos,pago);
//            Venta venta1 = new Venta(fecha,"Fabian",82736,"Sucursal Las Antenas","Iztapalapa,18,29",2921,productos,pago);
//            Venta venta2 = new Venta(fecha,"Karla",29384,"Sucursal Las Antenas","Iztapalapa,18,29",9813,productos,pago);
//            
            VistaDC vista =  new VistaDC();
            
            
            Controlador controlador = new Controlador(vista,venta);
            
//            Conexion con = new Conexion();
//            con.guardarVenta(venta);
//            con.guardarVenta(venta1);
//            con.guardarVenta(venta2);
////           
            controlador.iniciar();
            vista.setVisible(true);
            
            
        }
    }