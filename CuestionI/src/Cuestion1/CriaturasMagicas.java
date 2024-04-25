package Cuestion1;

public class CriaturasMagicas {
String nombre;
    
    public CriaturasMagicas(String nombre) {
        this.nombre = nombre;
    }
    
    public void volar() {
        System.out.println("¡" + nombre + " está volando!");
    }
}


class Dragon extends CriaturasMagicas {
    public Dragon(String nombre) {
        super(nombre);
    }
    
    public void lanzarFuego() {
        System.out.println("¡" + nombre + " lanza fuego!");
    }
}


class Hada extends CriaturasMagicas {
    public Hada(String nombre) {
        super(nombre);
    }
    
    public void lanzarPolvoDeHadas() {
        System.out.println("¡" + nombre + " lanza polvo de hadas!");
    }
}

