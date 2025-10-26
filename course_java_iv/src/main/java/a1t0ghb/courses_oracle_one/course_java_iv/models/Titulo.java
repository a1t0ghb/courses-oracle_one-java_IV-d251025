/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv.models;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.
//  - Interface 'Comparable' DOESN'T REQUIRE import.

//  JSON:
//  - 'Gson': 'https://github.com/google/gson', 'https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html'.
import com.google.gson.annotations.SerializedName;                  //  JSON transformations: match class attributes to JSON fields.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.

/**
 *
 * @author a1t0ghb
 */
public class Titulo implements Comparable<Titulo> {

    //  ATTRIBUTES DECLARATION.
    //  - Declaration of basic ATTRIBUTES of any title (movie or series). Level of access; i.e. 'private', 'public', 'protected' (or default, if not specified), usually comes from 'business rules'.
    @SerializedName("Title")                    //  Gson: matches JSON field to class attribute.
    private String nombre;
    @SerializedName("Year")                     //  Gson: matches JSON field to class attribute.
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;       //  According to 'new business rule', users now can rate a title (movie or series).
    private int totalDeLasEvaluaciones;         //  Counter for amount of ratings.

    //  CONSTRUCTOR
    //  - Same name as Class, and custom definition.
    //  - If we define a constructor for the superclass, now ALL OF ITS SUBCLASSES must have a MATCHING constructor.
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    //  ATTRIBUTE'S 'GETTERS'.
    public String getNombre() {
        return nombre;
    }
    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }
    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }
    public double getSumaDeLasEvaluaciones() {
        return sumaDeLasEvaluaciones;
    }
    public int getTotalDeEvaluaciones() {
        return totalDeLasEvaluaciones;
    }

    //  ATTRIBUTE'S 'SETTERS': usually, public.
    //  - 'this' protected keyword, is used to refer to CURRENT object, just to avoid confusions with parameters (in case those have the same name).
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }
    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }
    //  Private setter.
    private void setSumaDeLasEvaluaciones(double sumaDeLasEvaluaciones) {
        this.sumaDeLasEvaluaciones = sumaDeLasEvaluaciones;
    }
    //  Private setter.
    private void setTotalDeLasEvaluaciones(int totalDeLasEvaluaciones) {
        this.totalDeLasEvaluaciones = totalDeLasEvaluaciones;
    }

    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.

    //  Overrides from superclass 'Object'.
    //  - IMPORT: unnecessary.
    @Override
    public String toString() {
        // return super.toString();         //  Default definition.
        return "Titulo: " + getNombre() + " (" + getFechaDeLanzamiento() + ")";
    }

    //  METHODS FROM 'IMPLEMENTS'.

    //  Overrides from interface 'Comparable'.
    //  - IMPORT: unnecessary.
    //  - Method to compare 2 instances of same CURRENT class.
    //  - When implementing this method, always look for using method '.compareTo()', available in clases listed in 'https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html'.
    //  - e.g. If value to sort is a primitive 'double', CAST IT to class 'Double' (with is casting method '.valueOf()'), so method '.compareTo()' can be used.
    @Override
    public int compareTo(Titulo otroTitulo) {
        // return 0;                                                           //  Default definition.
        //  Use 'nombre'; i.e. a title's name, as criteria, using default behaviour ASC of '.compareTo()'.
        return getNombre().compareTo(otroTitulo.getNombre());
    }

    //  REGULAR METHODS.

    //  Function or method to print attributes values. 'void' implies method DOESN'T RETURN anything.
    public void muestraFichaTecnica() {
        // //  NOT RECOMMENDED: specially for 'parent' classes, use direct access / call to attributes.
        // System.out.println("Nombre de la película: " + nombre);
        // System.out.println("Año de lanzamiento: " + fechaDeLanzamiento);
        // System.out.println("Duración en minutos: " + duracionEnMinutos);
        //  RECOMMENDED: use base 'getters' and 'setters' of attributes, so they are context / class AWARE.
        System.out.println("Nombre de la película: " + getNombre());
        System.out.println("Año de lanzamiento: " + getFechaDeLanzamiento());
        // System.out.println("Duración en minutos: " + getDuracionEnMinutos());
    }

    //   Void funtion to update 'sumaDeLasEvaluaciones' and 'totalDeLasEvaluaciones'. regarding title (movie or series) ratings from users.
    public void evalua(double nota) {
        //  Accumulates ratings, and amount of times title (movie or series) has been rated.
        // //  NOT RECOMMENDED: specially for 'parent' classes, use direct access / call to attributes.
        // sumaDeLasEvaluaciones += nota;
        // totalDeLasEvaluaciones++;
        //  RECOMMENDED: use base 'getters' and 'setters' of attributes, so they are context / class AWARE.
        setSumaDeLasEvaluaciones(getSumaDeLasEvaluaciones() + nota);
        setTotalDeLasEvaluaciones(getTotalDeEvaluaciones() + 1);

    }

    //  Function to RETURN a double value; i.e. the average of the ratings.
    public double calculaMediaEvaluaciones() {
        // //  NOT RECOMMENDED: specially for 'parent' classes, use direct access / call to attributes.
        // return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
        //  RECOMMENDED: use base 'getters' and 'setters' of attributes, so they are context / class AWARE.
        return (getSumaDeLasEvaluaciones() / getTotalDeEvaluaciones());
    }

}
//  EOF.