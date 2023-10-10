package ExercicisMultiproces2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (in){
            String paraula = in.readLine();
            String modifiedLine = paraula.toUpperCase().replaceAll("[AEIOUaeiou]", "_");

            System.out.println("El fill diu: " + modifiedLine);
        } catch (NumberFormatException e) {
            System.err.println("Entrada no vàlida. Si us plau, introdueix un nombre enter positiu.");
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }
}
