package modelo;

import java.util.ArrayList;
import java.util.List;

public class CarroCompra {
    private List<Producto> productos;
    private static final int CAPACIDAD_MAXIMA = 5;

    public CarroCompra() {
        this.productos = new ArrayList<>();
        for (int i = 0; i < CAPACIDAD_MAXIMA; i++) {
            productos.add(new Producto(1, 1000, "Producto " + (i+1)));
        }
    }

    public CarroCompra(List<Producto> productos) {
        this.productos = productos;
    }

    public int calcularTotal() {
        int total = 0;
        for (Producto producto : productos) {
            total += calcularSubtotal(producto);
        }
        return total;
    }

    private int calcularSubtotal(Producto producto) {
        // DEPENDENCIA: se crea un objeto Calculadora localmente
        Calculadora calc = new Calculadora(producto.getCantidad(), producto.getPrecioUnitario());
        return calc.multiplicar();
    }

    public boolean agregarProducto(Producto producto) {
        if (productos.size() < CAPACIDAD_MAXIMA) {
            return productos.add(producto);
        }
        return false;
    }

    public Producto eliminarProducto(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            return productos.remove(indice);
        }
        return null;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public int getCantidadProductos() {
        return productos.size();
    }

    public void vaciarCarrito() {
        productos.clear();
    }
}