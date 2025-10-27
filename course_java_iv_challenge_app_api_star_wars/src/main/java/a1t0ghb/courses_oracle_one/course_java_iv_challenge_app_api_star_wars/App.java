/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.

//  IMPORTS - CUSTOM CLASSES.
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.models.ConsultaPelicula;
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.models.Pelicula;

/**
 *
 * @author a1t0ghb
 */
public class App {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        //  INITIALIZATION OF INSTANCES.
        ConsultaPelicula consulta = new ConsultaPelicula();

        //  Pelicula existente.
        Pelicula pelicula = consulta.buscaPelicula(1);
        System.out.println(pelicula);
        //  Pelicula in-existente.
        Pelicula pelicula2 = consulta.buscaPelicula(9);
        System.out.println(pelicula2);

    }
    
}
//  EOF.