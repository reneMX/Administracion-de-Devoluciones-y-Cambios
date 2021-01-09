package modeloDTO;


import java.util.*;

/**
 * 
 */
public class Tarjeta extends Pago {

    /**
     * 
     */
    private String numero;
    
    /**
     * 
     */
    private String fch_exp;


    
    /**
     * Default constructor
     */
    public Tarjeta(String nombre,double monto, String numero, String fch_exp ){
        super(nombre,monto);
        this.numero = numero;
        this.fch_exp = fch_exp;   
    }//fin constructor
   
    public Tarjeta() {
    }

    public String getNumero() {
        return numero;
    }

    public String getFch_exp() {
        return fch_exp;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFch_exp(String fch_exp) {
        this.fch_exp = fch_exp;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", fch_exp=" + fch_exp + '}';
    }
    
    

    
   

}