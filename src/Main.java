import controlador.CarroControlador;
import modelo.CarroCompra;
import vista.CarroVista;

public class Main {
    public static void main(String[] args) {
        System.out.println("================");
        System.out.println(" SISTEMA DE CARRITO DE COMPRAS - MVC");
        System.out.println("    Demostración de relación de DEPENDENCIA");
        System.out.println("================");

        CarroCompra modelo = new CarroCompra();
        CarroVista vista = new CarroVista();

        CarroControlador controlador = new CarroControlador(modelo, vista);
        controlador.iniciar();
    }
}