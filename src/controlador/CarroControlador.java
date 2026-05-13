package controlador;

import modelo.CarroCompra;
import modelo.Producto;
import vista.CarroVista;

public class CarroControlador {
    private CarroCompra modelo;
    private CarroVista vista;

    public CarroControlador(CarroCompra modelo, CarroVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean ejecutando = true;

        while (ejecutando) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    verProductos();
                    break;
                case 2:
                    mostrarTotal();
                    break;
                case 3:
                    agregarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    vaciarCarrito();
                    break;
                case 6:
                    ejecutando = salir();
                    break;
                default:
                    vista.mostrarError("Opción no válida");
            }
        }
    }

    private void verProductos() {
        vista.mostrarProductos(modelo.getProductos());
    }

    private void mostrarTotal() {
        int total = modelo.calcularTotal();
        vista.mostrarTotal(total);

        vista.mostrarMensaje("\n[Dependencia DEMOSTRADA]");
        vista.mostrarMensaje("El total se calcula usando Calculadora.multiplicar()");
        vista.mostrarMensaje("CarroCompra DEPENDE de Calculadora (relación temporal)");
    }

    private void agregarProducto() {
        String[] datos = vista.solicitarProducto();

        if (datos[0].isEmpty()) {
            vista.mostrarMensaje("Operación cancelada");
            return;
        }

        try {
            String nombre = datos[0];
            int cantidad = Integer.parseInt(datos[1]);
            int precio = Integer.parseInt(datos[2]);

            Producto nuevoProducto = new Producto(cantidad, precio, nombre);

            if (modelo.agregarProducto(nuevoProducto)) {
                vista.mostrarMensaje("✓ Producto agregado exitosamente");
            } else {
                vista.mostrarError("No se puede agregar más productos (máximo 5)");
            }
        } catch (NumberFormatException e) {
            vista.mostrarError("Cantidad y precio deben ser números válidos");
        }
    }

    private void eliminarProducto() {
        int cantidad = modelo.getCantidadProductos();
        if (cantidad == 0) {
            vista.mostrarMensaje("No hay productos para eliminar");
            return;
        }

        vista.mostrarProductos(modelo.getProductos());
        int indice = vista.solicitarIndiceProducto(cantidad);

        if (indice != -1) {
            Producto eliminado = modelo.eliminarProducto(indice);
            if (eliminado != null) {
                vista.mostrarMensaje("✓ Producto eliminado: " + eliminado.getNombre());
            }
        } else {
            vista.mostrarMensaje("Operación cancelada o índice inválido");
        }
    }

    private void vaciarCarrito() {
        if (modelo.getCantidadProductos() == 0) {
            vista.mostrarMensaje("El carrito ya está vacío");
            return;
        }

        if (vista.confirmar("¿Está seguro de vaciar el carrito?")) {
            modelo.vaciarCarrito();
            vista.mostrarMensaje("✓ Carrito vaciado completamente");
        }
    }

    private boolean salir() {
        if (vista.confirmar("¿Desea salir?")) {
            vista.mostrarMensaje("¡Gracias por usar el sistema!");
            vista.mostrarMensaje("\n--- RESUMEN DE DEPENDENCIA ---");
            vista.mostrarMensaje("La clase CarroCompra (MODELO) depende de Calculadora");
            vista.mostrarMensaje("Esta dependencia ocurre en el método calcularSubtotal()");
            vista.mostrarMensaje("Se crea un objeto Calculadora localmente → multiplicar()");
            vista.mostrarMensaje("No existe atributo Calculadora en CarroCompra");
            vista.mostrarMensaje("Es una relación TEMPORAL y DÉBIL (DEPENDENCIA)");
            return false;
        }
        return true;
    }
}
