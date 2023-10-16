package ExercicisMultiproces4;

import java.io.*;

public class ExecutarDir {
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

        try {
            // Ruta del directori de l'escriptori.
            String directoriEscriptori = System.getProperty("user.home") + "\\Desktop";

            // Cream un objecte ProcessBuilder per executar la comanda "dir".
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir", directoriEscriptori);

            // Redirigim la sortida estàndard a un fitxer de text.
            processBuilder.redirectOutput(new File(fitxer));

            // Iniciam el procés.
            Process process = processBuilder.start();

            // Esperam a que el procés acabi.
            int codiSortida = process.waitFor();

            // IF de control.
            if (codiSortida == 0) {
                System.out.println("Fitxer creat");

                // Destruim el procés fill.
                process.destroy();
            } else {
                System.out.println("Error en executar la comanda dir");
            }

        } catch (IOException | InterruptedException e) { // Control d'errors.
            e.printStackTrace();
        }
    }
}