/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Venta;
import vista.VistaDC;

/**
 *
 * @author renemm
 */
  
    public  class Principal{
        
        /*
        *@param args  the command
        */
        public  static void main(String[] args){
            Venta venta = new Venta();
            VistaDC vista =  new VistaDC();

            Controlador controlador = new Controlador(vista,venta);
            controlador.iniciar();
            vista.setVisible(true);
        }
    }