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

        String sortida = "-1";

        while (true) {
            // L'usuari introdueix un valor
            System.out.print("Introdeix un missatge (o 'exit' per finalitzar): ");
            sortida = scan.nextLine();

            if (sortida.equals("exit")) {
                break;
            }

            String[] command = {
                    "java",
                    "-jar",
                    "./out/artifacts/ExercisisMultiproces3_jar/ExercisisMultiproces3.jar",
                    ""
            };

            getSon(command, sortida); //L'hi envi la sortida per poder fer la consulta.

        };
        scan.close();
    }

    private static void getSon(String[] command, String value) {

        try {
            Runtime r = Runtime.getRuntime();

            Process proces = r.exec(command);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(proces.getInputStream()));

            System.out.println("Pare: envia el missatges al fill");

            out.write(value);
            out.close();

            String linea = null;
            String linea2 = null;

            try{
                while((linea = in.readLine()) != null)
                {
                    System.out.println(linea);
                    linea2 = linea;
                }
                in.close();
                System.out.println("Pare: rep missatge del fill \"" + linea2.substring(linea2.indexOf("pare: ") + 6) + "\"");
                System.out.println();
            }catch(IOException ex){
                System.out.println("Error al mostrar el proces fill");
            }
        } catch (IOException ex) {
            System.err.println("Hi ha un problema de part del pare amb la comunicacio!");
        }
    }
}
