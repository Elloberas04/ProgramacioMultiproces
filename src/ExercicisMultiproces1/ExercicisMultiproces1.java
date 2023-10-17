package ExercicisMultiproces1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ExercicisMultiproces1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numero = "-1";

        // Bucle per demanar dades fins que s'introduesqui 'exit'.
        while (true) {

            System.out.print("Introduir un nombre enter (o 'exit' per finalitzar): ");
            numero = scan.nextLine();

            // Si s'escriu 'exit' finalitza el bucle i el programa.
            if (numero.equals("exit")) {
                break;
            }

            // Try per intentar convertir el numero a un INT.
            try {
                int num = Integer.parseInt(numero);

                // Configuram la comanda per iniciar un nou proces Java. Indicam el JAR.
                String[] command = {
                        "java",
                        "-jar",
                        "./out/artifacts/ExercisisMultiproces1_jar/ExercisisMultiproces1.jar",
                        ""
                };

                // Crida la funció getSon per executar el procés fill amb la comanda i el numero per poder fer la consulta.
                getSon(command, numero);

            } catch (NumberFormatException e) { // Petit control d'errors.
                System.out.println("ERROR: S'ha d'introduir un nombre (INT)");
                System.out.println();
            }
        };
        // Tancam Scanner.
        scan.close();
    }

    // Funció getSon().
    private static void getSon(String[] command, String value) {

        try {
            Runtime r = Runtime.getRuntime();

            // Iniciam un nou procés mitjançant la comanda especificada.
            Process proces = r.exec(command);

            // Configuram els canals de comunicació amb el procés fill.
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(proces.getInputStream()));

            // Enviam el valor a través de la sortida del procés.
            out.write(value);

            // Tancam BufferedWriter.
            out.close();

            String linea = null;
            try {
                // Llegeix les respostes del procés fill i les mostra.
                while ((linea = in.readLine()) != null) {
                    System.out.println(linea);
                }
                // Tancam BufferedReader.
                in.close();
            } catch (IOException ex) { // Control d'errors.
                System.out.println("Error al mostrar el procés fill");
            }
        } catch (IOException ex) { // Control d'errors.
            System.err.println("Hi ha un problema per part del pare a l'hora de la comunicació");
        }
    }
}
