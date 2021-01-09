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
import modeloDAO.DevolucionDAO;
import modeloDAO.PagoDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import modeloDTO.Efectivo;
import modeloDTO.Pago;
import modeloDTO.Venta;
import vista.VistaDC;
import modeloDTO.Producto;
import modeloDTO.Tarjeta;
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
            LocalDateTime fecha     = LocalDateTime.now();
            Efectivo pago           = new Efectivo(12002,"Dinero", 926);
            Producto pantalon       = new Producto("Jeans Vans",30,1200);
            PagoDAO pago_dao        = new PagoDAO();
            
         
            Pago tarjeta = new Tarjeta();
            Pago efectivo1 = new Efectivo();
            Pago pago1 = new Pago();
            
//            pago1        = pago_dao.dameTipoPago(9029);
            //PAGOS CON TARJETA
//            pago_dao.obtenPago(9029);
//            pago_dao.obtenPago(87325);
//            pago_dao.obtenPago(9029);
            // PAGOS EN EFECTIVO

//              pago_dao.dameDatosTarjeta(5);
                      

//        pago1 = pago_dao.obtenPago(9029);
//        pago1 = pago_dao.obtenPago(87324);
                      
//            VentaDAO venta_dao = new VentaDAO();
//            venta_dao.validaVenta(0)

            
           
            Controlador controlador = new Controlador();
            controlador.iniciar();


            
            
//            List<Producto> productos = new ArrayList<Producto>();
//            
//            productos = producto_dao.seleccionar();
//            
//            productos.forEach((n) -> System.out.println(n.get )); 
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