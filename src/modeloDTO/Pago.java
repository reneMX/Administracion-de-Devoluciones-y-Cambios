package modeloDTO;



/**
 * 
 */
public class Pago {

    public Pago(String nombre,double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    /**
     * Default constructor
     */
    public Pago() {
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private double monto;

    /**
     * 1 para tarjeta de Credito 
     * 0 para efectivo
     */
    private int tipo_pago;

    /**
     * @return
     */
    public String damePago() {
        // TODO implement here
        return "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" + "nombre=" + nombre + ", monto=" + monto + '}';
    }

    public int getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(int tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    

}