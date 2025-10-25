/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - Utilities.
//  Shortcut for importing ALL Java Utils: 'import java.util.*;'.
import java.util.ArrayList;

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv.utilities.CalculadoraDeTiempo;
import a1t0ghb.courses_oracle_one.course_java_iv.utilities.FiltroRecomendacion;
import a1t0ghb.courses_oracle_one.course_java_iv.models.Episodio;
import a1t0ghb.courses_oracle_one.course_java_iv.models.Pelicula;
import a1t0ghb.courses_oracle_one.course_java_iv.models.Serie;

/**
 *
 * @author a1t0ghb
 */
public class App {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        //  INITIALIZATION OF INSTANCES.

        //  Instance: class 'Pelicula'.
        // Pelicula miPelicula = new Pelicula();                       //  OLD way of 'initializing' Pelicula.
        // miPelicula.setNombre("Encanto");
        // miPelicula.setFechaDeLanzamiento(2021);
        var miPelicula = new Pelicula("Encanto", 2021);                   //  NEW way of 'initializing' Pelicula, using CUSTOM 'Constructor'.
        miPelicula.setDuracionEnMinutos(180);
        // miPelicula.setIncluidoEnElPlan(true);
        //  Validate in console.
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());
        miPelicula.muestraFichaTecnica();

        //  Validation of proper capture of movie ratings.
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        // System.out.println(miPelicula.sumaDeLasEvaluaciones);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMediaEvaluaciones());

        //  Instance: class 'Serie'.
        // Serie lost = new Serie();                       //  OLD way of 'initializing'.
        // lost.setNombre("Lost");                         //  Inherited from class 'Titulo'.
        // lost.setFechaDeLanzamiento(2000);               //  Inherited from class 'Titulo'.
        var lost = new Serie("Lost", 2000);             //  NEW way of 'initializing', using CUSTOM 'Constructor'.
        lost.setTemporadas(10);                         //  From own class 'Serie'.
        lost.setMinutosPorEpisodio(50);                 //  From own class 'Serie'.
        lost.setEpisodiosPorTemporada(10);              //  From own class 'Serie'.
        //  Validate in console.
        lost.muestraFichaTecnica();                     //  Inherited from class 'Titulo'.
        System.out.println("Duracion de la serie: " + lost.getDuracionEnMinutos());         //  Initally inherited from class 'Titulo', but later custom OVERRIDED in own class 'Serie'.

        //  Instance: class 'Pelicula'.
        // Pelicula otraPelicula = new Pelicula();                     //  OLD way of 'initializing' Pelicula.
        // otraPelicula.setNombre("Avatar");
        // otraPelicula.setFechaDeLanzamiento(2023);
        var otraPelicula = new Pelicula("Avatar", 2023);                  //  NEW way of 'initializing' Pelicula, using CUSTOM 'Constructor'.
        otraPelicula.setDuracionEnMinutos(200);
        // //  Validate in console.
        // otraPelicula.muestraFichaTecnica();

        //  Instance: class 'CalculadoraDeTiempo'.
        //+ It can be seen as a class with computations for classes 'Titulo' and its 'childs'.
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluido(miPelicula);               //  A 'Pelicula'; child of class 'Titulo'.
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);                     //  A 'Serie'; child of class 'Titulo'.
        System.out.println("Tiempo necesario para ver tus títulos: " + calculadora.getTiempoTotal() + " minutos.");

        //  Instance: class 'Episodio'.
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        // episodio.setNombre("La Casa Tragaryen");
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);

        //  Instance: class 'FiltroRecomendacion'.
        //+ To implement based on previous INSTANCES created.
        FiltroRecomendacion filtro = new FiltroRecomendacion();
        //  Get recommendation from intrinsic interface implemented in 'Pelicula' class.
        filtro.filtra(miPelicula);
        //  Get recommendation from intrinsic interface implemented in 'Episodio' class.
        filtro.filtra(episodio);

        // ---
        System.out.println("\n ----- ----- -----");

        //  Reference variable: 'Pelicula'
        // Pelicula peliculaDeBruno = new Pelicula();      //  Regular declaration.
        // var peliculaDeBruno = new Pelicula();           //  Way to 'loosely' declare a variable and its type: Java infers data type, from right-side of declaration. IT CAN'T BE CHANGED LATER; e.g. 'peliculaDeBruno = 2'.
        // peliculaDeBruno.setNombre("El señor de los anillos.");                  //  OLD way of 'initializing' Pelicula.
        // peliculaDeBruno.setFechaDeLanzamiento(2001);
        var peliculaDeBruno = new Pelicula("El señor de los anillos.", 2001);         //  NEW way of 'initializing' Pelicula, using CUSTOM 'Constructor'.
        peliculaDeBruno.setDuracionEnMinutos(180);

        //  Create ArrayList of 'Pelicula' instances.
        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        //  Add instances to array.
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        //  Prints array size (i.e. amount of instances stored).
        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        //  Prints FIRST instance; using get() method, that accepts an integer as parameter, the position of the item. INDEXES START AT 0.
        //  - For this sepcific case, method 'getNombre()' is a method specific of the instance retrieved with 'get()'.
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        //  'Prints' ArrayList: prints instances 'id's (reference to object in memory), separated by comma, inside square brackets [].
        System.out.println(listaDePeliculas);       //  Inherently calls method '.toString()'; i.e. same as 'System.out.println(listaDePeliculas.toString());'

        //  Test method '.toString()' from Object superclass, available for all classes.
        //  - Ref.: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#toString()'.
        System.out.println("Resultado de método '.toString()' de película en posición 0: " + listaDePeliculas.get(0).toString());

    }

}
//  EOF.