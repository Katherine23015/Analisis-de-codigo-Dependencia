package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class CarroVista {
    private Scanner scanner;

    public CarroVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CARRITO DE COMPRAS ===");
        System.out.println("1. Ver carrito");
        System.out.println("2. Mostrar total de compra");
        System.out.println("3. Agregar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Vaciar carrito");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("\nEl carrito está vacío.");
            return;
        }

        System.out.println("\n=== PRODUCTOS EN EL CARRITO ===");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println((i+1) + ". " + p.toString() +
                    " | Subtotal: $" + (p.getCantidad() * p.getPrecioUnitario()));
        }
        System.out.println("Total de productos: " + productos.size());
    }

    public void mostrarTotal(int total) {
        System.out.println("\n=================================");
        System.out.println("EL TOTAL DE LA COMPRA ES: $" + total);
        System.out.println("=================================");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("ERROR: " + error);
    }

    public String[] solicitarProducto() {
        System.out.println("\n=== AGREGAR NUEVO PRODUCTO ===");
        String[] datos = new String[3];

        System.out.print("Nombre del producto: ");
        datos[0] = scanner.nextLine();

        System.out.print("Cantidad: ");
        datos[1] = scanner.nextLine();

        System.out.print("Precio unitario: $");
        datos[2] = scanner.nextLine();

        return datos;
    }

    public int solicitarIndiceProducto(int maximo) {
        System.out.print("Número de producto a eliminar (1-" + maximo + "): ");
        try {
            int indice = scanner.nextInt();
            scanner.nextLine();
            if (indice >= 1 && indice <= maximo) {
                return indice - 1;
            }
        } catch (Exception e) {
            mostrarError("Entrada inválida");
            scanner.nextLine();
        }
        return -1;
    }

    public boolean confirmar(String pregunta) {
        System.out.print(pregunta + " (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("si");
    }

    public int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}