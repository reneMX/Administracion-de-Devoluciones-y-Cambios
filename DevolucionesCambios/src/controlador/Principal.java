/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BDD.Conexion;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import modeloDTO.Efectivo;
import modeloDTO.Venta;
import vista.VistaDC;
import modeloDTO.Producto;
import vista.VistaDevoluciones;

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
            
           
            Controlador controlador = new Controlador();
//            
//            vista.setVisible(true);
            controlador.iniciar();

            
            
            List<Producto> productos = new ArrayList<Producto>();
//            productos.add(pantalon);
//            
            
            
            
            
//            Venta venta = new Venta(fecha,"Rene",9029,"Sucursal Las Antenas","Iztapalapa,18,29",1829,productos,pago);
            
            //VistaDevoluciones dev = new VistaDevoluciones();
            
            //Conexion conexion = new Conexion();
            //Venta venta = new Venta(fecha, "Jose Alfredo","Lineclothes","Iztapalapa 18",192.3 );
//            VentaDAO ventaDao = new VentaDAO();
//            Venta venta = new Venta();
//            venta = ventaDao.ventaValida(9029);
//            
//            venta.getProductos().forEach((n) -> System.out.println(n.getTalla()) ); 
//             productos.forEach((n) -> System.out.println(n.getNombre())); 
//            boolean val = ventaDao.validaVenta(9029);
//            System.out.println(val);
                       
//            ventaDao.validaVenta(12345);
//            ventaDao.toString();
        
//            System.out.println(val );
            
            
            //conexion.guardarVenta(venta);
            
//            try {
//                conexion.validaVenta(87323);
//                conexion.validaVenta(9029);
//                conexion.getVenta(9029);
//                System.out.println("valores: "+conexion.getResultSet().getInt("num_venta")  );
//            } catch (SQLException ex) {
//                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
      //      dev.setVisible(true);
      
            
            
        }
    }