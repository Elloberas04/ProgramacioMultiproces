package ExercicisMultiproces4;

import java.io.*;
import java.util.Scanner;

public class ExecutarFind {
    public static void main(String[] args) {
        String fitxer = null;

        // Control d'errors per si no hi ha cap argument.
        if (args.length != 1) {
            System.err.println("NOMES S'HA D'INTRODUIR EL NOM DE L'ARXIU");
            System.exit(-1);
        } else {
            // Indicam l'arxiu si es correcte.
            fitxer = args[0];
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Introdueix una paraula a buscar: ");
        // Text a buscar.
        String textABuscar = "\"" + sc.nextLine() + "\"";

        try {
            // Crear un objecte ProcessBuilder per executar la comanda "find".
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "find", "/i", textABuscar, "\"" + fitxer + "\"");

            // Redirigim la sortida estàndard a la consola.
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            // Iniciam el procés.
            Process process = processBuilder.start();

            // Esperam a que el procés acabi.
            int codiSortida = process.waitFor();

            // IF de control.
            if (codiSortida == 0) {
                System.out.println();
                System.out.println("La comanda 'find' s'ha executat amb èxit.");

                // Destruim el procés fill.
                process.destroy();
            } else {
                System.out.println();
                System.err.println("No s'ha trobat la paraula o ERROR en executar la comanda 'find'.");
            }

        } catch (IOException | InterruptedException e) { // Control d'errors.
            e.printStackTrace();
        }
    }
}
