package modeloDTO;

/**
 * Clase Devolucion Contiene la informacion de las Devoluciones realizadas
 *
 * @author René Martínez M.
 * @version 0.0.0.1
 */
public class Devolucion {
    //Atributos
    /**
     * numero de ticket o de la venta que se convierte en devolucion
     */
    private int numero_venta;

    /**
     * fecha en que se realiza la devolucion
     */
    private String fecha_venta;

    /**
     * nombre del empleado que realizo la devolucion
     */
    private String nombre_empleado;

    /**
     * Nombre de la tienda.
     */
    private String nombre_tienda;

    /**
     * Direccion de la tienda donde se hizo la devolucion.
     */
    private String direccion_tienda;

    /**
     * Total en reales, de la devolucion.
     */
    private double total_venta;

    /**
     * Se menciona el un comentario o motivo de devolucion Principalmente para
     * tener retroalimentacion
     */
    private String motivo;

    
    //Constructor(s)
    
    /**
     * Constructor simple
     */
    public Devolucion() {
    }

    //Get's and Set's
    
    /**
     * Devuelve el numero de venta
     * @return numero_venta 
     */
    public int getNumero_venta() {
        return numero_venta;
    }
    
    /**
     * Modificamos el valor del numero de venta
     * @param numero_venta 
     */
    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }
    
    /**
     * Obtenemos la fecha en que se realiza o realizó
     * la devolucion
     @return fecha_venta
     */
    public String getFecha_venta() {
        return fecha_venta;
    }

    /**
     * Modificamos la fecha en que se realiza o realizó 
     * la devolucion
     * @param fecha_venta
     */
    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    /**
     * Obtenemos el nombre del 
     * empleado que realizó la devolución
     * @return nombre_empleado
     */
    public String getNombre_empleado() {
        return nombre_empleado;
    }
    
    /**
     * Modificamos el nombre
     * del empleado que 
     * realiza o realizó la devolución
     * @param nombre_empleado
     */
    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }
    
    /**
     * Obtenemos el nombre de la tienda 
     * @return nombre_tienda
     */
    public String getNombre_tienda() {
        return nombre_tienda;
    }

    /**
     * Modificamos el nombre de la tienda
     * @param nombre_tienda
     */
    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    /**
     * Obtenemos la direcion de la tienda
     * donde se realizo la devolución
     * @return direccion_tienda
     */
    public String getDireccion_tienda() {
        return direccion_tienda;
    }

    public void setDireccion_tienda(String direccion_tienda) {
        this.direccion_tienda = direccion_tienda;
    }

    /**
     * Obtenemos el total de la venta que se 
     * habia realizado
     * @return total_venta
     */
    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    /**
     * Obtenemos los comentarios
     * o motivos por el que 
     * se realizo la devolución
     * @return motivo
     */
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}//fin clase Devolucion
