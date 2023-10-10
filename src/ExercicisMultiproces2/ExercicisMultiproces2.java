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


        // L'usuari introdueix un valor
        System.out.print("Introduir un STRING: ");
        String sortida = scan.nextLine();

        String[] command = {
                "java",
                "-jar",
                "./out/artifacts/ExercisisMultiproces2_jar/ExercisisMultiproces2.jar",
                ""
        };

        System.out.println(getSon(command, sortida)); //L'hi envi la sortida per poder fer la consulta

        scan.close();
    }

    private static String getSon(String[] command, String value) {
        String read = "";

        try {
            Runtime r = Runtime.getRuntime();

            Process proces = r.exec(command);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(proces.getInputStream()));

            System.out.print("El pare diu: ");
            out.write(value);
            out.close();
            String linea = null;
            try{
                while((linea = in.readLine()) != null)
                {
                    System.out.println(linea);
                }
                in.close();
            }catch(IOException ex){
                System.out.println("Error al mostrar el proces fill");
            }
        } catch (IOException ex) {
            System.err.println("Hay un problema por parte del padre a la hora de la comunicacion");
        }

        return read;
    }
}