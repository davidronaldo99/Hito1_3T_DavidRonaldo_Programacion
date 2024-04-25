package CuestionII;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Respuestas {
    public static void main(String[] args) {
        String preguntasArchivo = "preguntasHito.txt";
        String respuestasArchivo = "respuestasHito.txt";
        
        try (
            BufferedReader preguntasReader = new BufferedReader(new FileReader(preguntasArchivo));
            BufferedReader respuestasReader = new BufferedReader(new FileReader(respuestasArchivo));
            Scanner scanner = new Scanner(System.in)
        ) {
            int puntuacion = 0;
            String pregunta;
            String respuesta;
            
            while ((pregunta = preguntasReader.readLine()) != null && (respuesta = respuestasReader.readLine()) != null) {
                System.out.println(pregunta);
                String respuestaUsuario = scanner.nextLine().trim();
                
                if (respuestaUsuario.equalsIgnoreCase(respuesta)) {
                    System.out.println("¡Respuesta correcta!");
                    puntuacion++;
                } else {
                    System.out.println("Respuesta incorrecta. La respuesta correcta es: " + respuesta);
                    puntuacion -= 0.5;
                }
            }
            
            System.out.println("¡Eso fue todo! Tu puntuación final es: " + puntuacion);
            if (puntuacion >= 5) {
                System.out.println("¡Felicidades, has aprobado!");
            } else {
                System.out.println("Lo siento, no has alcanzado la nota mínima para aprobar.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
