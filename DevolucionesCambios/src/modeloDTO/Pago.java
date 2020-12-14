package modeloDTO;



/**
 * 
 */
public class Pago {

    public Pago(String nombre, double monto) {
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
    

}