/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BDD.Conexion;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modeloDAO.VentaDAO;
import modeloDTO.Pago;
import modeloDTO.Producto;
import modeloDTO.Venta;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.w3c.dom.Document;
import vista.VistaDevoluciones;
import vista.VistaDC;
//import org.apache.pdfbox.
/**
 *
 * @author renemm
 */
public class Controlador implements ActionListener {

    private VistaDC ventana_p;
    private VistaDevoluciones ventana_dev;
    private Venta venta;
    private Conexion conexion;
    private ActionListener escucha;
    private LocalDateTime fch_actual;
    private VentaDAO venta_dao;
    private Pago pago;

    public Controlador() {
        this.pago = new Pago();
        this.fch_actual = LocalDateTime.now();
        this.venta_dao = new VentaDAO();
        this.venta = new Venta();
        this.ventana_p = new VistaDC();
        this.ventana_dev = new VistaDevoluciones();
        ventana_p.setVisible(true);
        System.out.println("Entramos al Constructor del Boton");
    }//fin constructor

    public void iniciar(){
        try{
            ventana_p.setTitle("Cambios y Devoluciones");
            ventana_p.getBtn_validar().addActionListener(this);
            ventana_p.getBtn_cambios().addActionListener(this);
            ventana_p.getBtn_devoluciones().addActionListener(this);
            ventana_dev.getBtn_regresar().addActionListener(this);
            ventana_dev.getBtn_home().addActionListener(this);
            ventana_dev.getBtn_genera_reporte().addActionListener(this);
        }catch(NullPointerException ex){
           ex.printStackTrace(System.out);
        }//fin catch
        
        ventana_p.getTxt_num_tck().addKeyListener(
                new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_num_tckKeyTyped(evt);
            }//fin keyTyped
        }//fin KeyAdapter
        );//fin addKeyListener
    }//fin iniciar()

    private void txt_num_tckKeyTyped(java.awt.event.KeyEvent evt) {
        Object c = evt.getSource();

        if (c.equals(ventana_p.getTxt_num_tck())) {
            ventana_p.getLbl_opccion().setVisible(false);
            ventana_p.getBtn_cambios().setVisible(false);
            ventana_p.getBtn_devoluciones().setVisible(false);
            ventana_p.getLbl_num_venta().setText("Ingresa el numero de ticket o venta");
        }//fin if (c.equals( ventana_p.getTxt_num_tck)
    }//fin  txt_num_tckKeyTyped()

    //ACCION PARA LA ENTRADA TXT DE VENTA
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        Object c = e.getSource();
        int num_venta = Integer.parseInt(ventana_p.getTxt_num_tck().getText());
        System.out.println("Entramos a la accion del boton");
                if (c.equals(ventana_p.getBtn_validar()))//hacemos la validacion
                {
                    System.out.println("Entramos a la validacion del Boton");
                    if (venta_dao.validaVenta(num_venta)) //el num_venta es valido
                    {
                        //Informamos de la valides de la venta
                        ventana_p.getLbl_num_venta().setText("Ticket Valido");
                        ventana_p.getPanel_info().setVisible(true);

                        muestraDatosVenta(num_venta);
                        ventana_p.getLbl_opccion().setVisible(true);
                        ventana_p.getBtn_cambios().setVisible(true);
                        ventana_p.getBtn_devoluciones().setVisible(true);
                    }//fin if venta
                    else
                    {
                        ventana_p.getLbl_num_venta().setText("El numero de venta no existe");
                        ventana_p.getPanel_info().setVisible(false);
                        ventana_p.getLbl_opccion().setVisible(false);
                        ventana_p.getBtn_cambios().setVisible(false);
                        ventana_p.getBtn_devoluciones().setVisible(false);
                        //El num_venta no esta en la base de datos
                    }//fin else 
                }//fin if valida boton

        //MOSTRAMOS DEVOLUCIONES O CAMBIOS
        if(  c.equals(ventana_p.getBtn_devoluciones())  ) 
        {
//            ArrayList<String> devolucion =  new ArrayList<String>();
//            conexion = new Conexion();
//            System.out.println("Hola mundo");
            ventana_p.setVisible(false);
            ventana_dev.setVisible(true);
            ventana_p.repaint();
            muestraFormulario(num_venta);

        }//fin if boton devoluciones

        
        if(  c.equals(ventana_dev.getBtn_genera_reporte()) )
        {  
            generaReporte(num_venta);
            
        } //fin if boton genera reporte

        
        if(c.equals(ventana_p.getBtn_cambios()) ){
            
        }//fin if boton cambios
        
        //MOSTRAMOS LA VENTANA DE DEVOLUCIONES
        if(c.equals(ventana_dev.getBtn_regresar() ))//hacemos la validacion
        {
           ventana_dev.repaint();
           ventana_dev.setVisible(false);
           ventana_p.setVisible(true);
    
        } //fin boton regresar de ventana_dev
       
    }//fin metodo actionPerformed()

    
    public void generaReporte(int num_venta){
          
        try {        
                PDDocument doc = new PDDocument();
                PDPage pagina = new PDPage(PDRectangle.A6);

                doc.addPage(pagina);
                
                PDPageContentStream contenido = new PDPageContentStream(doc, pagina);
                
                
                contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_BOLD, 30);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 52);
                    contenido.showText("LineClothes");
                contenido.endText();
                
                contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_BOLD, 20);
                    contenido.newLineAtOffset(50, pagina.getMediaBox().getHeight() - 80);
                    contenido.showText("Reporte de Devolucion");
                contenido.endText();
                
                contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 130);
                    contenido.showText("Nombre del Empleado que Atendio: " + ventana_dev.getTxt_nom_empleado().getText());
                contenido.endText();    
                
                
                
                
                contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 140);
                    contenido.showText("Productos: " + venta.getProductos().get(1).getNombre());
                contenido.endText();
                
//                contenido.beginText();
//                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 150);
//                    contenido.showText("Forma de Pago: " + venta_dao. );
//                contenido.endText();
//                
//                contenido.beginText();
//                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 160);
//                    contenido.showText("Total Devuelto: " + venta_dao.obtenPago(num_venta).getMonto() );
//                contenido.endText();
//                
//                contenido.beginText();
//                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 170);
//                    contenido.showText("Numero de Venta: " + venta.getNum_venta());
//                contenido.endText();
//                
//                contenido.beginText();
//                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 180);
//                    contenido.showText("La tienda " + venta.getNom_tienda() + "Lamenta esta devolucion y se encargara\n de trabajar con mayor responsabilidad para la felicida de en la moda de sus clientes");
//                contenido.endText();
//                
//                contenido.beginText();
//                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 190);
//                    contenido.showText("Fecha de Devolucion: " + venta.getFecha());
//                contenido.endText();
//                
//                contenido.beginText();
//                    contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//                    contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 200);
//                    contenido.showText("Direccion:"+ venta.getDireccion());
//                contenido.endText();
//                
                
                
                
                
                
                
                contenido.close();
                doc.save("/Users/renemm/Desktop/Aseguramiento/Line.pdf");
                doc.close();
            } catch (IOException  ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }//fin generaReporte
    
   public void muestraDatosVenta(int num_venta)
    {
        
        DefaultTableModel modelo = new DefaultTableModel ();
        List<Producto> productos = new ArrayList<Producto>();
        Object [] filas;
        String fch_venta;
        
       
        modelo.addColumn("Numero de Venta ");
        modelo.addColumn("Fecha de compra");
        modelo.addColumn("Nombre de Productos");
        modelo.addColumn("Total");
        modelo.addColumn("Empleado");  
        modelo.addColumn("Tienda");
        
        ventana_p.getTbl_info().setModel(modelo);
        ventana_p.getTbl_info().enable(false); 
        filas = new Object[6];

            productos   = venta_dao.productosAsociados(num_venta);
            venta       = venta_dao.ventaValida(num_venta);
            if( productos.size() > 0 )
            {
                System.out.println("Tamanio de productos: "+productos.size());
                for (int i = 0 ; i < productos.size() ; i++)
                {
                    if( i == 0){
                        filas[0] =   venta.getNum_venta();
                        filas[1] =   productos.get(i).getNombre() ;
                        filas[2] =   venta.getFecha();
                        filas[3] =   venta.getTotal();
                        filas[4] =   venta.getNom_Empleado();
                        filas[5] =   venta.getNom_tienda();
                    }
                    else
                    {
                        filas[0] =   "";
                        filas[1] =   productos.get(i).getNombre() ;
                        filas[2] =   "";
                        filas[3] =   "";
                        filas[4] =   "";
                        filas[5] =   "";
                        
                    }//fin else
                    modelo.addRow(filas);
                }//fin for
            }//fin productos.size() > 0
    }//fin muestraDatosVenta();    
   
   
   
   public void muestraFormulario(int num_venta){
       
       ////
       DefaultTableModel modelo = new DefaultTableModel ();
       
       
       modelo.addColumn("Productos");
       
       Object [] filas;
       int tam =  venta.getProductos().size();
       filas = new Object[tam];
        ventana_dev.getTbl_nombres().setModel(modelo);
        ventana_dev.getTbl_nombres().enable(false); 
       //LLenamos la Tabla 
        if( tam > 0 )
        {
            int i = 0;
            int j = 0;
            int [] aux = new int[2];
            for(i = 0 ; i < tam ; i++)
            {
                aux[i] = aux[i] + i;
                
                filas[i]    =  venta.getProductos().get(j).getNombre();
                modelo.addRow(filas);
                j++;
              
            }//fin for
//            System.out.println(""+filas[0] + ""+filas[1]);
            
            
        }//fin tam > 0 
        
        ventana_dev.getTxt_nom_empleado_primero().setText(venta.getNom_Empleado());
        ventana_dev.getTxt_num_venta().setText(""+venta.getNum_venta());
        ventana_dev.getTxt_direccion().setText(venta_dao.seleccionar().getDireccion());
//        ventana_dev.getTxt_nom_pago().setText( );
        ventana_dev.getTxt_total().setText(""+venta_dao.seleccionar().getTotal());
        
        //    venta.getTotal();
        //    venta.getDireccion();
    }
   
   
} //Fin clase Controlador


