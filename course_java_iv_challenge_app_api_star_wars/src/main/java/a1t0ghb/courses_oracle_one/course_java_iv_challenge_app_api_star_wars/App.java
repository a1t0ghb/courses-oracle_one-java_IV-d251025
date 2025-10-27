/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.
import java.util.Scanner;                       //  User input via console / terminal.
import java.io.IOException;

//  IMPORTS - CUSTOM CLASSES.
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.utilities.ConsultaPelicula;
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.models.Pelicula;
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.utilities.GeneradorDeArchivo;

/**
 *
 * @author a1t0ghb
 */
public class App {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        //  INITIALIZATION OF INSTANCES.
        //  'Scanner' as class to receive input of user from console.
        //  - Use in conjunction with try-with-resources, to AUTOMATICALLY close resources and manage try-cath exceptions. Ref: 'https://www.w3schools.com/java/java_try_catch_resources.asp'.
        try (Scanner lectura = new Scanner(System.in)) {

            ConsultaPelicula consulta = new ConsultaPelicula();
            System.out.println("Escriba número de la película: ");

            // //  Pelicula existente.
            // Pelicula pelicula1 = consulta.buscaPelicula(1);
            // System.out.println(pelicula1);
            // //  Pelicula in-existente.
            // Pelicula pelicula2 = consulta.buscaPelicula(9);
            // System.out.println(pelicula2);

            try {

                var numeroDePelicula = Integer.valueOf(lectura.nextLine());
                Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
                System.out.println(pelicula);
                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarJson(pelicula);

            } catch (NumberFormatException e) {

                System.out.println("Número no encontrado: " + e.getMessage());

            } catch (RuntimeException | IOException e) {

                System.out.println(e.getMessage());
                System.out.println("Finalizó ejecución del programa.\n");
            }
        
        }

    }
    
}
//  EOF.