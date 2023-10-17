package ExercicisMultiproces1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {

        // BufferedReader per llegir les dades del procés pare.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Try-with-resources.
        try (in) {

            // Llegim una línia d'entrada que hauria de contenir un nombre enter.
            int num = Integer.parseInt(in.readLine());

            // Comprovem si el nombre és parell o senar i mostrem el resultat.
            if (num % 2 == 0) {
                System.out.println("Parell");
            } else {
                System.out.println("Senar");
            }

        } catch (IOException e) {
            // Capturam una excepció en cas d'error d'entrada/sortida.
            System.err.println("ERROR");
        }
    }
}
