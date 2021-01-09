/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

//import's
import BDD.Conexion;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modeloDAO.DevolucionDAO;
import modeloDAO.PagoDAO;
import modeloDAO.VentaDAO;
import modeloDTO.Efectivo;
import modeloDTO.Pago;
import modeloDTO.Producto;
import modeloDTO.Tarjeta;
import modeloDTO.Venta;
import vista.VistaDevoluciones;
import vista.VistaDC;

/**
 *Clase encargada de Controlar el flujo de informacion entre las
 *clases Vistas(Front-end), donde se interactua con el usuario
 *y las clases encargadas de interpretar los datos guardados en 
 *la base de datos DAO(Back-end)
 *Ademas de instanciar en el momento adecuado las clases Modelo
 *Mediante el uso de patron de arquitectura Modelo-Vista-Controlador
 * @author renemm
 * Version 2.0.0
 */
public class Controlador implements ActionListener {

    private VistaDC ventana_p;
    private VistaDevoluciones ventana_dev;
    private Venta venta;
    private Conexion conexion;
    private ActionListener escucha;
    private LocalDateTime fch_actual;
    private VentaDAO venta_dao;
    private PagoDAO pago_dao;
    private Pago pago;
    private DevolucionDAO devolucion_dao;

    public Controlador() {
        this.pago = new Pago();
        this.fch_actual = LocalDateTime.now();
        this.venta_dao = new VentaDAO();
        this.pago_dao = new PagoDAO();
        this.venta = new Venta();
        this.ventana_p = new VistaDC();
        this.ventana_dev = new VistaDevoluciones();
        this.devolucion_dao = new DevolucionDAO();
        ventana_p.setVisible(true);
        System.out.println("Entramos al Constructor del Boton");
    }//fin constructor

    public void iniciar() {
        try {
            ventana_p.setTitle("Cambios y Devoluciones");
            ventana_p.getBtn_validar().addActionListener(this);
            ventana_p.getBtn_cambios().addActionListener(this);
            ventana_p.getBtn_devoluciones().addActionListener(this);
            ventana_dev.getBtn_regresar().addActionListener(this);
            ventana_dev.getBtn_home().addActionListener(this);
            ventana_dev.getBtn_genera_reporte().addActionListener(this);
            ventana_dev.getBtn_eliminar().addActionListener(this);
        } catch (NullPointerException ex) {
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
            ventana_p.getLbl_num_venta().setBorder(BorderFactory.createLineBorder(Color.white));
            ventana_p.getTxt_num_tck().setBorder(BorderFactory.createLineBorder(Color.black));
            ventana_p.getBtn_validar().setBorder(BorderFactory.createLineBorder(Color.GRAY));

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
        Venta venta1 = this.venta;
        boolean validacion;
        int num_venta;
        num_venta = validaComponentesVentanaP();
        
        /*
            Boton Validacion
         */
        if (num_venta != -1) {
            validacion = c.equals(ventana_p.getBtn_validar());
            if (validacion)//hacemos la validacion
            {
                if (venta_dao.validaVenta(num_venta)) //el num_venta es valido
                {
                    //Informamos de la valides de la venta
                    ventana_p.getLbl_num_venta().setText("Ticket Valido");
                    ventana_p.getPanel_info().setVisible(true);
                    ventana_p.getBtn_validar().setBorder(BorderFactory.createLineBorder(Color.green));
                    ventana_p.getLbl_num_venta().setBorder(BorderFactory.createLineBorder(Color.green));
                    muestraDatosVenta(num_venta);
                    ventana_p.getLbl_opccion().setVisible(true);
                    ventana_p.getBtn_cambios().setVisible(true);
                    ventana_p.getBtn_devoluciones().setVisible(true);
                }//fin if venta
                else {
                    ventana_p.getLbl_num_venta().setText("El numero de venta no existe");
                    ventana_p.getBtn_validar().setBorder(BorderFactory.createLineBorder(Color.red));
                    ventana_p.getLbl_num_venta().setBorder(BorderFactory.createLineBorder(Color.red));
                    ventana_p.getTxt_num_tck().setBorder(BorderFactory.createLineBorder(Color.red));
                    ventana_p.getPanel_info().setVisible(false);
                    ventana_p.getLbl_opccion().setVisible(false);
                    ventana_p.getBtn_cambios().setVisible(false);
                    ventana_p.getBtn_devoluciones().setVisible(false);
                    //El num_venta no esta en la base de datos
                }//fin else 
            }//fin if valida boton
        }//fin if validaComponentes

//        System.out.println("Entramos antes de la validacionComponentes");        
//      
        /*
            Boton Devoluciones
         */
        if (c.equals(ventana_p.getBtn_devoluciones())) {
                muestraFormulario(num_venta);
                ventana_p.setVisible(false);
                ventana_dev.setVisible(true);
                ventana_p.repaint();
        }//fin if boton devoluciones

        /*
            Boton GenerarReporte
         */
        if (c.equals(ventana_dev.getBtn_genera_reporte()))
        {
            int op1;    
            if(validaComponentesVentanaD()){
                op1 = JOptionPane.showConfirmDialog(null, "Estas seguro de generar la devolucion", "Confirmacion de Devolucion", JOptionPane.YES_NO_OPTION);
                if (op1 == JOptionPane.YES_OPTION) {
                    if( generarReporte(num_venta) ){
                        JOptionPane.showMessageDialog(ventana_dev, "Reporte generado, revisa el escritorio ahi esta el ");
                        ventana_dev.setVisible(false);
                        ventana_p.setVisible(false);
                        System.exit(0);
                    }
                }
            } //fin if boton genera reporte    

        }//fin validaComponentes
            

        /*
            Boton Cambios
         */
        if (c.equals(ventana_p.getBtn_cambios())) {

        }//fin if boton cambios

        /*
            Boton Devoluciones
         */
        if (c.equals(ventana_dev.getBtn_regresar()))//hacemos la validacion
        {
            ventana_dev.repaint();
            ventana_dev.setVisible(false);
            ventana_p.setVisible(true);

        } //fin boton regresar de ventana_dev

        /*
            Boton Eliminar
         */
        if (c.equals(ventana_dev.getBtn_eliminar())) {
            int fila_selecionada;
            DefaultTableModel model = (DefaultTableModel) ventana_dev.getTbl_nombres().getModel();
            try {
                fila_selecionada = ventana_dev.getTbl_nombres().getSelectedRow();
                if (fila_selecionada == -1 || ventana_dev.getTbl_nombres().getValueAt(fila_selecionada, 0) == null) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un producto, que no deseas devolver", "Atencion", JOptionPane.WARNING_MESSAGE);
                }//fin if fila_selecionada == -1
                else {
                    int opccion;
                    opccion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el producto de la lista de devolucion?", "Eliminar", JOptionPane.YES_NO_OPTION);
                    if (opccion == JOptionPane.YES_OPTION) {

                        double total_dev = (double) ventana_dev.getTbl_nombres().getValueAt(fila_selecionada, 1);
                        this.venta.setTotal(venta1.getTotal() - total_dev);
                        ventana_dev.getTxt_total().setText("" + this.venta.getTotal());
                        devolucion_dao = new DevolucionDAO(
                                this.venta.getId_producto(), this.venta.getNum_venta(),
                                this.venta.getNom_Empleado(), ventana_dev.getTxt_nom_empleado().getText(),
                                this.pago.getNombre(), this.venta.getTotal(),
                                this.venta.getDireccion(), ventana_dev.getTextPane().getText()
                        );
//                        devolucion_dao.insertaDevolucion(devolucion_dao);
                        model.removeRow(fila_selecionada);

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }//fin boton eliminar

    }//fin metodo actionPerformed()

    
    
    public boolean validaComponentesVentanaD(){
        if(ventana_dev.getTxt_nom_empleado().getText().equals("")){
            ventana_dev.getTxt_nom_empleado().setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Debes de colocar el nombre del empleado que realiza la devolucion", "Falta tu nombre", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else{
            return true;
        }        
    }//fin validaComponentesVentanaD
    
    
    public int validaComponentesVentanaP() {
        int num_venta = -1;
        /*
            Validamos solo cuando es nulo
            o el valor no se encuentra en la 
            base de datos
         */
        try {
            if (validaNumeros(ventana_p.getTxt_num_tck().getText()) || ventana_p.getTxt_num_tck().getText().equals(null)) {
                num_venta = Integer.parseInt(ventana_p.getTxt_num_tck().getText());
            } else {
                ventana_p.getTxt_num_tck().setBorder(BorderFactory.createLineBorder(Color.red));
                JOptionPane.showMessageDialog(null, "Debes de ingresar un numero de venta o ticket", "Sin numero de venta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }//fin catch

        return num_venta;
    }//fin validaComponentes

    public void muestraDatosVenta(int num_venta) {

        DefaultTableModel modelo = new DefaultTableModel();
        List<Producto> productos = new ArrayList<Producto>();
        Object[] filas;

        modelo.addColumn("Numero de Venta ");
        modelo.addColumn("Fecha de compra");
        modelo.addColumn("Productos");
        modelo.addColumn("Total");
        modelo.addColumn("Empleado");
        modelo.addColumn("Tienda");

        ventana_p.getTbl_info().setModel(modelo);
        ventana_p.getTbl_info().enable(false);
        filas = new Object[6];

        productos = this.venta_dao.productosAsociados(num_venta);
        this.venta = this.venta_dao.ventaValida(num_venta);
        if (productos.size() > 0) {
            System.out.println("Tamanio de productos: " + productos.size());
            for (int i = 0; i < productos.size(); i++) {
                if (i == 0) {
                    filas[0] = this.venta.getNum_venta();
                    filas[1] = this.venta.getFecha();
                    filas[2] = productos.get(i).getNombre();
                    filas[3] = this.venta.getTotal();
                    filas[4] = this.venta.getNom_Empleado();
                    filas[5] = this.venta.getNom_tienda();
                } else {
                    filas[0] = "";
                    filas[1] = "";
                    filas[2] = productos.get(i).getNombre();
                    filas[3] = "";
                    filas[4] = "";
                    filas[5] = "";
                }//fin else
                modelo.addRow(filas);
            }//fin for
        }//fin productos.size() > 0
    }//fin muestraDatosVenta();    

    public boolean validaNumeros(String cadena) {
        if (cadena.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }//fin validaNumeros

    public void muestraFormulario(int num_venta) {

        Tarjeta tarjeta;
        Efectivo efectivo;
        List<Producto> productos = new ArrayList<Producto>();

        productos = this.venta_dao.productosAsociados(num_venta);
        this.venta = this.venta_dao.ventaValida(num_venta);
        if (productos.size() > 0) {

            for (int i = 0; i < productos.size(); i++) {
                ventana_dev.getTbl_nombres().setValueAt(productos.get(i).getNombre(), i, 0);
                ventana_dev.getTbl_nombres().setValueAt(productos.get(i).getPrecio(), i, 1);
            }//fin for
        }//fin productos.size() > 0

        ventana_dev.getTxt_nom_empleado_primero().setText(this.venta.getNom_Empleado());
        ventana_dev.getTxt_num_venta().setText("" + this.venta.getNum_venta());
        ventana_dev.getTxt_direccion().setText(this.venta_dao.seleccionar().getDireccion());
        ventana_dev.getTxt_total().setText("" + this.venta.getTotal());
        this.pago = this.pago_dao.obtenPago(num_venta);

        if (this.pago.getTipo_pago() == 1) {
//            System.out.println("valores de la tarjeta\n" + pago.getNombre() );
            tarjeta = (Tarjeta) this.pago_dao.obtenPago(num_venta);
            ventana_dev.getLbl_numero().setVisible(true);
            ventana_dev.getLbl_nom_pago().setText("Nombre de la tarjeta");
            ventana_dev.getTxt_numero().setVisible(true);
            ventana_dev.getTxt_nom_pago().setText("" + tarjeta.getNombre());
            ventana_dev.getTxt_numero().setText("" + tarjeta.getNumero());
        } else if (pago.getTipo_pago() == 0) {
            efectivo = (Efectivo) this.pago_dao.obtenPago(num_venta);
            ventana_dev.getTxt_nom_pago().setText("" + efectivo.getNombre());
        }

    }//fin muestraFormulario

    public boolean generarReporte(int num_venta) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(ventana_dev);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }//fin catch
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La devolucion se cancelo");
            return false;
        }
    }

    //
//    public void generaReporte(int num_venta) {
//
//        try {
//            PDDocument doc = new PDDocument();
//            PDPage pagina = new PDPage(PDRectangle.A6);
//
//            doc.addPage(pagina);
//
//            PDPageContentStream contenido = new PDPageContentStream(doc, pagina);
//
//            contenido.beginText();
//            contenido.setFont(PDType1Font.TIMES_BOLD, 30);
//            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 52);
//            contenido.showText("LineClothes");
//            contenido.endText();
//
//            contenido.beginText();
//            contenido.setFont(PDType1Font.TIMES_BOLD, 20);
//            contenido.newLineAtOffset(50, pagina.getMediaBox().getHeight() - 80);
//            contenido.showText("Reporte de Devolucion");
//            contenido.endText();
//
//            contenido.beginText();
//            contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 130);
//            contenido.showText("Nombre del  Empleado que Atendio: " + ventana_dev.getTxt_nom_empleado().getText());
//            contenido.endText();
//
//            contenido.beginText();
//            contenido.setFont(PDType1Font.TIMES_BOLD, 10);
//            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight() - 140);
//            contenido.showText("Productos: " + venta.getProductos().get(1).getNombre());
//            contenido.endText();
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
//            contenido.close();
//            doc.save("/Users/renemm/Desktop/Line.pdf");
//            doc.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }//fin generaReporte
} //Fin clase Controlador

