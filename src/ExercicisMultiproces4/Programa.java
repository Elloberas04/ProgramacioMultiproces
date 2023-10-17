package ExercicisMultiproces4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {
    public static void main(String[] args)
    {
        // BufferedReader per introduir l'arxiu.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Try-with-resource
        try (br)
        {
            System.out.print("Introdueix un nom per a l'arxiu (p.e. sortida.txt): ");
            // Indicam l'arxiu.
            String nomArxiu = br.readLine();

            // Cream un objecte ProcessBuilder per executar l'arxiu "ExecutarDir.java" amb l'arxiu com a parametre.
            ProcessBuilder PBdir = new ProcessBuilder("java", "src/ExercicisMultiproces4/ExecutarDir.java", nomArxiu);

            // Redirigim la sortida al procés pare.
            PBdir.inheritIO();

            // Iniciam el procés fill.
            Process dirProcess = PBdir.start();

            // Esperam a que finalitzi.
            int dirExitCode = dirProcess.waitFor();

            // IF de control.
            if (dirExitCode != 0) {
                System.err.println("ERROR amb l'execució de ExecutarDir.");
                System.exit(-1);
            }

            // Finalitzam el procés dirProcess.
            dirProcess.destroy();

            // Cream un objecte ProcessBuilder per executar l'arxiu "ExecutarFind.java" amb l'arxiu com a parametre.
            ProcessBuilder PBfind = new ProcessBuilder("java", "src/ExercicisMultiproces4/ExecutarFind.java", nomArxiu);

            // Redirigim la sortida al procés pare.
            PBfind.inheritIO();

            // Iniciam el procés fill.
            Process findProcess = PBfind.start();

            // Esperam a que finalitzi.
            int findExitCode = findProcess.waitFor();

            // Finalitzam el procés findProcess.
            findProcess.destroy();

            // IF de control.
            if (findExitCode != 0) {
                System.err.println("ERROR amb l'execució de ExecutarFind.");
                System.exit(-1);
            }

        } catch (IOException | InterruptedException e) { // Control d'errors.
            e.printStackTrace();
        }
    }
}
