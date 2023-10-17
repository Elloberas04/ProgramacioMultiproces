package ExercicisMultiproces2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        // BufferedReader per llegir les dades del procés pare.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Try-with-resources.
        try (in){
            // Llegim la paraula o frase.
            String paraula = in.readLine();

            // Modificam l'STRING.
            String modifiedLine = paraula.toUpperCase().replaceAll("[AEIOUaeiou]", "_");

            // Mostram el resultat a través del procés pare.
            System.out.println("El fill diu: " + modifiedLine);

        } catch (IOException e) { // Control d'errors.
            System.err.println("ERROR");
        }
    }
}
