package CuestionII;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "preguntasHito.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            Scanner scanner = new Scanner(System.in);
            String pregunta;
            
            while ((pregunta = br.readLine()) != null) {
                System.out.println(pregunta);
                scanner.nextLine(); 
            }
            
            System.out.println("¡Eso es todo! Gracias por responder.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
