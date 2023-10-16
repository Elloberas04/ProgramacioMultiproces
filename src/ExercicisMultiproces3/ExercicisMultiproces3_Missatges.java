package ExercicisMultiproces3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces3_Missatges {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (in){
            String paraula = in.readLine();

            System.out.println("     Fill: rep el missatge \"" + paraula + "\"");
            System.out.print("     Fill: envia el mateix missatge al pare: " + paraula.toUpperCase());
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }
}
