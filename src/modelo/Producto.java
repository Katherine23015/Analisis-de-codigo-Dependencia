package modelo;

public class Producto {
    private int cantidad;
    private int precioUnitario;
    private String nombre;

    public Producto(int cantidad, int precioUnitario) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombre = "Producto";
    }

    public Producto(int cantidad, int precioUnitario, String nombre) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " - Cantidad: " + cantidad + " x $" + precioUnitario;
    }
}
