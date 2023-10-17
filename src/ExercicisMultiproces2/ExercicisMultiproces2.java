package ExercicisMultiproces2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ExercicisMultiproces2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        // L'usuari introdueix un STRING.
        System.out.print("Introduir un STRING: ");
        String frase = scan.nextLine();

        // Configuram la comanda per iniciar un nou proces Java. Indicam el JAR.
        String[] command = {
                "java",
                "-jar",
                "./out/artifacts/ExercisisMultiproces2_jar/ExercisisMultiproces2.jar",
                ""
        };

        // Crida la funció getSon per executar el procés fill amb la comanda i la frase per poder fer el canvi.
        getSon(command, frase);

        // Tencam scanner.
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

            System.out.print("El pare diu: ");

            // Enviam el valor a través de la sortida del procés.
            out.write(value);

            // Tancam BufferedWriter.
            out.close();

            String linea = null;
            try {
                // Llegeix les respostes del procés fill i les mostra a la sortida estàndard.
                while((linea = in.readLine()) != null)
                {
                    System.out.println(linea);
                }
                // Tancam BufferedReader.
                in.close();
            }catch(IOException ex){ // Control d'errors.
                System.out.println("Error al mostrar el proces fill");
            }
        } catch (IOException ex) { // Control d'errors.
            System.err.println("Hay un problema por parte del padre a la hora de la comunicacion");
        }
    }
}