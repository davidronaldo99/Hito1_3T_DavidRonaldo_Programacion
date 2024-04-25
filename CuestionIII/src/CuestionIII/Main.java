package CuestionIII;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TiendaHito", "root", "");
            ProductoDAO productoDAO = new ProductoDAO(con);

            Scanner scanner = new Scanner(System.in);

            int opcion;
            do {
                System.out.println("Menú:");
                System.out.println("1. Añadir producto");
                System.out.println("2. Mostrar productos");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Salir");
                System.out.print("Ingrese la opción deseada: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la fecha de envasado (YYYY-MM-DD): ");
                        String fechaEnvasado = scanner.nextLine();
                        System.out.print("Ingrese la cantidad de unidades: ");
                        int unidades = scanner.nextInt();
                        System.out.print("Ingrese el precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("¿Está disponible? (true/false): ");
                        boolean disponible = scanner.nextBoolean();

                        Producto nuevoProducto = new Producto(nombre, fechaEnvasado, unidades, precio, disponible);
                        if (productoDAO.insertarProducto(nuevoProducto)) {
                            System.out.println("Producto agregado correctamente.");
                        } else {
                            System.out.println("Error al agregar el producto.");
                        }
                        break;
                    case 2:
                        System.out.println("Lista de productos:");
                        productoDAO.mostrarProductos();
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del producto a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese la nueva fecha de envasado (YYYY-MM-DD): ");
                        fechaEnvasado = scanner.nextLine(); // Asignamos el valor a la variable
                        System.out.print("Ingrese la nueva cantidad de unidades: ");
                        int nuevasUnidades = scanner.nextInt();
                        System.out.print("Ingrese el nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        System.out.print("¿Está disponible? (true/false): ");
                        boolean nuevoDisponible = scanner.nextBoolean();

                        Producto productoActualizar = new Producto(nuevoNombre, fechaEnvasado, nuevasUnidades, nuevoPrecio, nuevoDisponible);
                        productoActualizar.setIdProducto(idActualizar);

                        if (productoDAO.actualizarProducto(productoActualizar)) {
                            System.out.println("Producto actualizado correctamente.");
                        } else {
                            System.out.println("Error al actualizar el producto.");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese el ID del producto a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        if (productoDAO.eliminarProducto(idEliminar)) {
                            System.out.println("Producto eliminado correctamente.");
                        } else {
                            System.out.println("Error al eliminar el producto.");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } while (opcion != 5);

            // Cerrar el scanner y la conexión a la base de datos
            scanner.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}


