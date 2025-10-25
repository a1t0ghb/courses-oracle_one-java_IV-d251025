/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - Utilities.
//  Shortcut for importing ALL Java Utils: 'import java.util.*;'.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv.models.Pelicula;
import a1t0ghb.courses_oracle_one.course_java_iv.models.Serie;
import a1t0ghb.courses_oracle_one.course_java_iv.models.Titulo;

/**
 *
 * @author a1t0ghb
 */
public class AppConListas {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        //  INITIALIZATION OF INSTANCES.
        
        var miPelicula = new Pelicula("Encanto", 2021);
        var otraPelicula = new Pelicula("Avatar", 2023);
        var peliculaDeBruno = new Pelicula("El señor de los anillos.", 2001);
        var lost = new Serie("Lost", 2000);

        //  Add ratings for 'Pelicula' instances.
        miPelicula.evalua(9);
        otraPelicula.evalua(6);
        peliculaDeBruno.evalua(10);

        //  Create ArrayList of 'Titulo' instances.
        ArrayList<Titulo> lista = new ArrayList<>();            //  Symbols <> are called 'generics'.
        //  Add instances to array.
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(lost);

        //  Traverse items in 'ArrayList'.
        // lista.forEach(item -> System.out.println(item));            //  Compact form 01 (since Java 8): using LAMBDA expresions; i.e. 'item -> System.out.println(item)'.
        // lista.forEach(System.out::println);                  `       //  Compact form 02: using 'Method Reference'', a reduced form of a LAMBDA expression.
        for (Titulo item: lista) {
            // System.out.println(item);                               //  Calling inherently method of '.toString()'
            System.out.println(item.getNombre());
            //  Filter items by class; e.g. if item is of subclass 'Pelicula', and inmmediately makes a CASTING from 'Titulo' to 'Pelicula', called 'pelicula'.
            //+ Also can include aditional conditions.
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println(pelicula.getClasificacion());    //  Calls method specific of instances of class 'Pelicula'.
            }
        }

        // ---
        System.out.println("\n ----- ----- -----");

        //  Create list of 'String's to showcase example of sorting.
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");
        System.out.println("Lista de artistas original: " + listaDeArtistas);

        //  Use (and import) class 'Collections', for sorting methods.
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        // ---
        System.out.println("\n ----- ----- -----");

        //  Sorts list of titles, ASC BY title's name, using 'Collections' class.
        System.out.println("Lista de titulos original: " + lista);
        //  Use (and import) class 'Collections', for sorting methods.
        //  In order to be able to compare 'Titulo's, it's necessary to add interface 'Comparable', so Java can know how to compare instances from class 'Titulo'.
        //  - REQUIRES implement class 'Collections'.
        //  - REQUIRES from class to sort; e.g. 'Titulo', to implement interface 'Comparable'.
        //+ IMPORTANT: 'Collections.sort()' works, AFTER implementing interface 'Comparable' in class we want to sort; i.e. 'Titulo'
        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        //  Use of 'Comparator's class to create additional and different sorting criterias ON-THE-FLY.
        //  - REQUIRES implement class 'Comparator': 'java.util.Comparator'.
        //  - Unlike 'Collections' approach, it DOESN'T REQUIRE other classes to implement any interface.
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista de titulos ordenados (por fecha de lanzamiento): " + lista);

    }

}
//  EOF.