package Cuestion1;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Madrid");
        vector.add("Barcelona");
        vector.add("Alicante");
        
        System.out.println("Elementos del vector:");
        for (String elemento : vector) {
            System.out.println(elemento);
        }
    }
}