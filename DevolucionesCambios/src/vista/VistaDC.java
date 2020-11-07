/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author renemm
 */
public class VistaDC extends javax.swing.JFrame {

    /**
     * Creates new form VistaDC
     */
    public VistaDC() {
        initComponents();
        contenPane.setPreferredSize(new Dimension(400,400));
        //scbar_inicio.addAdjustmentListener((AdjustmentListener) this);
        
        
        
         
        
    }
    

    public JPanel getPanel_info() {
        return panel_info;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        scbar_inicio = new javax.swing.JScrollPane();
        contenPane = new javax.swing.JPanel();
        btn_cambios = new javax.swing.JButton();
        btn_dev = new javax.swing.JButton();
        lbl_num_venta = new javax.swing.JLabel();
        txt_num_tck = new javax.swing.JTextField();
        lbl_icon = new javax.swing.JLabel();
        lbl_opccion = new javax.swing.JLabel();
        btn_validar = new javax.swing.JButton();
        panel_info = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_info = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scbar_inicio.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        contenPane.setBackground(new java.awt.Color(255, 255, 255));

        btn_cambios.setText("Cambios");
        btn_cambios.setToolTipText("Solo presiona una vez");
        btn_cambios.setVisible(false);

        btn_dev.setText("Devoluciones");
        btn_dev.setToolTipText("Solo presiona una vez");
        btn_dev.setVisible(false);

        lbl_num_venta.setText("Ingresa el numero de ticket o venta");

        txt_num_tck.setText("18749");
        txt_num_tck.setToolTipText("Deben de ser 5 digitos");
        txt_num_tck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_num_tckActionPerformed(evt);
            }
        });
        txt_num_tck.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_num_tckKeyTyped(evt);
            }
        });

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LineClothesLogoIcon.jpg"))); // NOI18N
        lbl_icon.setToolTipText("");
        lbl_icon.setMaximumSize(new java.awt.Dimension(140, 140));
        lbl_icon.setMinimumSize(new java.awt.Dimension(140, 140));

        lbl_opccion.setText("Selecciona Lo que deseas realizar");
        lbl_opccion.setVisible(false);

        btn_validar.setText("Validar");

        tbl_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Num venta", "Empleado", "Tienda", "Direccion", "Total"
            }
        ));
        jScrollPane2.setViewportView(tbl_info);

        panel_info.setVisible(false);

        javax.swing.GroupLayout panel_infoLayout = new javax.swing.GroupLayout(panel_info);
        panel_info.setLayout(panel_infoLayout);
        panel_infoLayout.setHorizontalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel_infoLayout.setVerticalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenPaneLayout = new javax.swing.GroupLayout(contenPane);
        contenPane.setLayout(contenPaneLayout);
        contenPaneLayout.setHorizontalGroup(
            contenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenPaneLayout.createSequentialGroup()
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lbl_num_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txt_num_tck, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btn_validar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(contenPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panel_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(contenPaneLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(btn_dev)
                .addGap(175, 175, 175)
                .addComponent(btn_cambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_opccion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        contenPaneLayout.setVerticalGroup(
            contenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenPaneLayout.createSequentialGroup()
                .addGroup(contenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(contenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_num_venta)
                            .addComponent(txt_num_tck)
                            .addComponent(btn_validar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_opccion, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );

        scbar_inicio.setViewportView(contenPane);

        jScrollPane3.setViewportView(scbar_inicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_num_tckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_num_tckActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_txt_num_tckActionPerformed

    private void txt_num_tckKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_num_tckKeyTyped
//        // TODO add your handling code here:
//         Object c = evt.getSource();
//        if(c.equals(txt_num_tck))
//        {
//            lbl_opccion.setVisible(false);
//            btn_cambios.setVisible(false);
//            btn_dev.setVisible(false);
//            lbl_num_venta.setText("Ingresa el numero de ticket o venta");
//        }
    }//GEN-LAST:event_txt_num_tckKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VistaDC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaDC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaDC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaDC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaDC().setVisible(true);
//            }
//        });
//    } 

    public JButton getBtn_cambios() {
        return btn_cambios;
    }

    public void setBtn_cambios(JButton btn_cambios) {
        this.btn_cambios = btn_cambios;
    }

    public JButton getBtn_devoluciones() {
        return btn_dev;
    }

    public void setBtn_devoluciones(JButton btn_devoluciones) {
        this.btn_dev = btn_devoluciones;
    }

    public JButton getBtn_validar() {
        return btn_validar;
    }

    public JLabel getLbl_opccion() {
        return lbl_opccion;
    }

    public JLabel getLbl_num_venta() {
        return lbl_num_venta;
    }

    public JTextField getTxt_num_tck() {
        return txt_num_tck;
    }

   
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cambios;
    private javax.swing.JButton btn_dev;
    private javax.swing.JButton btn_validar;
    private javax.swing.JPanel contenPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_num_venta;
    private javax.swing.JLabel lbl_opccion;
    private javax.swing.JPanel panel_info;
    private javax.swing.JScrollPane scbar_inicio;
    private javax.swing.JTable tbl_info;
    private javax.swing.JTextField txt_num_tck;
    // End of variables declaration//GEN-END:variables

  


    
}//fin clase
