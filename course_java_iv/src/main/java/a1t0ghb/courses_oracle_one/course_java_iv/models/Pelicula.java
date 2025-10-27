/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv.models;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Shortcut for importing ALL Java Utils: 'import java.util.*;'.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv.utilities.Clasificacion;

/**
 *
 * @author a1t0ghb
 */
public class Pelicula extends Titulo implements Clasificacion {

    //  ATTRIBUTES DECLARATION.
    private String director;

    //  CONSTRUCTOR
    //  - Same name as Class, and custom definition.
    //  - If we define a constructor for the superclass, now ALL OF ITS SUBCLASSES must have a MATCHING constructor.

    // //  CONSTRUCTOR (predetermined, 'empty')
    // - Although it's useful to initialize attributes with default values.
    // public Pelicula() {
    // }

    //  CONSTRUCTOR (custom definition)
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        // super();             //  Default definition.
        super(nombre, fechaDeLanzamiento);
    }

    //  ATTRIBUTE'S 'GETTERS'.
    public String getDirector() {
        return director;
    }

    //  ATTRIBUTE'S 'SETTERS': usually, public.
    //  - 'this' protected keyword, is used to refer to CURRENT object, just to avoid confusions with parameters (in case those have the same name).
    public void setDirector(String director) {
        this.director = director;
    }

    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.

    //  Overrides from superclass 'Object'.
    //  - IMPORT: unnecessary.
    @Override
    public String toString() {
        // return super.toString();         //  Default definition.
        return "Pelicula: '" + super.getNombre() + "' ('" + super.getFechaDeLanzamiento() + "').";
    }
    
    //  Overrides from superclass 'Titulo'.
    //  - IMPORT: needed, IF referenced class / interface is in different package.
    //  - Method to get star rating (integer, 0 to 5), using as reference the note's average of 'calcularMedia()' (double, 0.0 to 10.0), from 'parent' class 'Titulo'.
    @Override
    public int getClasificacion() {
        return (int) (calculaMediaEvaluaciones() / 2);
    }

    //  METHODS FROM 'IMPLEMENTS'.

    //  REGULAR METHODS.

}
//  EOF.