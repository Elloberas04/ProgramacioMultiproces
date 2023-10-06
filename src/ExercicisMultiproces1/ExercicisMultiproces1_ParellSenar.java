package ExercicisMultiproces1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (in){
                int num = Integer.parseInt(in.readLine());

                if (num % 2 == 0) {
                    System.out.println("Parell");
                } else {
                    System.out.println("Senar");
                }
        } catch (NumberFormatException e) {
            System.err.println("Entrada no vàlida. Si us plau, introdueix un nombre enter positiu.");
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }
}