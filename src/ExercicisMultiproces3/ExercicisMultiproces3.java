package ExercicisMultiproces3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExercicisMultiproces3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String missatge = "-1";

        // Bucle per demanar dades fins que s'introduesqui 'exit'.
        while (true) {

            System.out.print("Introdeix un missatge (o 'exit' per finalitzar): ");
            missatge = scan.nextLine();

            // Si s'escriu 'exit' finalitza el bucle i el programa.
            if (missatge.equals("exit")) {
                break;
            }

            // Configuram la comanda per iniciar un nou proces Java. Indicam el JAR.
            String[] command = {
                    "java",
                    "-jar",
                    "./out/artifacts/ExercisisMultiproces3_jar/ExercisisMultiproces3.jar",
                    ""
            };

            // Crida la funció getSon per executar el procés fill amb la comanda i el missatge.
            getSon(command, missatge);

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

            System.out.println("Pare: envia el missatges al fill");

            // Enviam el valor a través de la sortida del procés.
            out.write(value);

            // Tancam BufferedWriter.
            out.close();

            String linea = null;
            String linea2 = null;

            try{
                // Llegeix les respostes del procés fill i les mostra.
                while((linea = in.readLine()) != null)
                {
                    System.out.println(linea);
                    linea2 = linea;
                }
                // Tancam BufferedReader.
                in.close();

                // Finalitzam procés fill.
                proces.destroy();

                // Mostram el missatge del fill.
                System.out.println("Pare: rep missatge del fill \"" + linea2.substring(linea2.indexOf("pare: ") + 6) + "\"");
                System.out.println();
            }catch(IOException ex){ // Control d'errors.
                System.out.println("Error al mostrar el proces fill");
            }
        } catch (IOException ex) { // Control d'errors.
            System.err.println("Hi ha un problema de part del pare amb la comunicacio!");
        }
    }
}
