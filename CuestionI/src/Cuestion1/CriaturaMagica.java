package Cuestion1;
//Clase base (superclase)
class CriaturaMagica {
 String nombre;
 
 // Constructor de la superclase
 public CriaturaMagica(String nombre) {
     this.nombre = nombre;
 }
 
 // Sobrecarga del método emitirSonido()
 public void emitirSonido() {
     System.out.println(nombre + " emite un sonido misterioso.");
 }
 
 // Sobrecarga del método emitirSonido() con un parámetro adicional
 public void emitirSonido(String intensidad) {
     System.out.println(nombre + " emite un sonido " + intensidad + ".");
 }
}

//Subclase que hereda de CriaturaMagica
class Dragon extends CriaturaMagica {
 // Constructor de la subclase Dragon
 public Dragon(String nombre) {
     super(nombre);
 }
 
 // Sobreescritura del método emitirSonido() para el dragón
 @Override
 public void emitirSonido() {
     System.out.println(nombre + " ruge con furia.");
 }
}

//Subclase adicional
class Hada extends CriaturaMagica {
 // Constructor de la subclase Hada
 public Hada(String nombre) {
     super(nombre);
 }
 
 // Sobreescritura del método emitirSonido() para el hada
 @Override
 public void emitirSonido() {
     System.out.println(nombre + " canta una melodía encantadora.");
 }
}

