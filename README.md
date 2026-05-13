# Evidencia: Análisis de Código & Dependencia 

## 1. Identificación de Clases y Contexto
A partir del análisis del código fuente proporcionado, se identificaron dos clases principales:

* **Clase `Calculadora`**: Representa una unidad lógica de procesamiento. Su función es realizar operaciones aritméticas básicas (suma y multiplicación) de forma independiente.
* **Clase `CarroCompra`**: Representa una entidad de gestión de negocio. Administra una matriz de productos (cantidades y precios) y orquesta el proceso de cálculo del total de una compra.

**Contexto Problema:** El sistema busca resolver el cálculo financiero de un carrito de compras. El problema principal es la separación de responsabilidades: el `CarroCompra` conoce los datos de los productos, pero no sabe cómo realizar cálculos matemáticos complejos, por lo cual debe delegar esa tarea a una clase especializada (`Calculadora`).

## 2. Análisis de Atributos, Métodos y Relaciones
### Atributos y Métodos
* **Calculadora**: Posee atributos privados `n1` y `n2`, constructores y métodos operativos (`sumar`, `multiplicar`).
* **CarroCompra**: Posee una matriz privada `productos[][]`. Sus métodos incluyen la inicialización de datos, el cálculo de subtotales y la visualización del total general.

### Relación de Dependencia
Se ha identificado una **Relación de Dependencia** de `CarroCompra` hacia `Calculadora`. 
* **Justificación:** La clase `CarroCompra` no contiene a `Calculadora` como un atributo global. En su lugar, crea una instancia local de `Calculadora` dentro del método `subTotal(int cant, int precio)`. La relación es transitoria; existe solo durante la ejecución del método para realizar la multiplicación de los valores.

## 3. Diagrama de Clases UML
El modelado se realizó en **Visual Paradigm**, representando la dependencia con una línea punteada y una flecha abierta que apunta hacia la clase proveedora del servicio (`Calculadora`).
