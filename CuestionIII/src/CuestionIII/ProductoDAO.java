package CuestionIII;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private Connection conexion;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertarProducto(Producto producto) {
        try {
            PreparedStatement statement = conexion.prepareStatement(
                    "INSERT INTO Productos (nombre, fechaEnvasado, unidades, precio, disponible) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, producto.getNombre());
            statement.setDate(2, Date.valueOf(producto.getFechaEnvasado()));
            statement.setInt(3, producto.getUnidades());
            statement.setDouble(4, producto.getPrecio());
            statement.setBoolean(5, producto.isDisponible());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        try {
            PreparedStatement statement = conexion.prepareStatement(
                    "UPDATE Productos SET nombre = ?, fechaEnvasado = ?, unidades = ?, precio = ?, disponible = ? WHERE idProducto = ?");
            statement.setString(1, producto.getNombre());
            statement.setDate(2, Date.valueOf(producto.getFechaEnvasado()));
            statement.setInt(3, producto.getUnidades());
            statement.setDouble(4, producto.getPrecio());
            statement.setBoolean(5, producto.isDisponible());
            statement.setInt(6, producto.getIdProducto());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM Productos WHERE idProducto = ?");
            statement.setInt(1, idProducto);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void mostrarProductos() {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Productos");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("idProducto") + ", " +
                                resultSet.getString("nombre") + ", " +
                                resultSet.getDate("fechaEnvasado") + ", " +
                                resultSet.getInt("unidades") + ", " +
                                resultSet.getDouble("precio") + ", " +
                                resultSet.getBoolean("disponible")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

