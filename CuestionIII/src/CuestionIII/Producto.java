package CuestionIII;

import java.time.LocalDate;

public class Producto {
    private int idProducto;
    private String nombre;
    private LocalDate fechaEnvasado;
    private int unidades;
    private double precio;
    private boolean disponible;

    public Producto(String nombre, String fechaEnvasado, int unidades, double precio, boolean disponible) {
        this.nombre = nombre;
        this.fechaEnvasado = LocalDate.parse(fechaEnvasado);
        this.unidades = unidades;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
