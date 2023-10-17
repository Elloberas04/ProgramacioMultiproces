package ExercicisMultiproces3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces3_Missatges {
    public static void main(String[] args) {
        // BufferedReader per llegir les dades del procés pare.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Try-with-resources.
        try (in){
            // Llegim la paraula.
            String paraula = in.readLine();

            // Missatge del fill que rep la paraula.
            System.out.println("     Fill: rep el missatge \"" + paraula + "\"");

            // Missatge del fill que torna a enviar la paraula en majuscules.
            System.out.print("     Fill: envia el mateix missatge al pare: " + paraula.toUpperCase());
        } catch (IOException e) { // Capturam una excepció en cas d'error d'entrada/sortida.
            System.err.println("ERROR");
        }
    }
}
