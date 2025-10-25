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

/**
 *
 * @author a1t0ghb
 */
public class Serie extends Titulo {

    //  ATTRIBUTES DECLARATION.
    private int temporadas;
    private boolean activa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    //  CONSTRUCTOR
    //  - Same name as Class, and custom definition.
    //  - If we define a constructor for the superclass, now ALL OF ITS SUBCLASSES must have a MATCHING constructor.
    public Serie(String nombre, int fechaDeLanzamiento) {
        // super();             //  Default definition.
        super(nombre, fechaDeLanzamiento);
    }

    //  ATTRIBUTE'S 'GETTERS'.
    public int getTemporadas() {
        return temporadas;
    }
    public boolean isActiva() {
        return activa;
    }
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    //  ATTRIBUTE'S 'SETTERS': usually, public.
    //  - 'this' protected keyword, is used to refer to CURRENT object, just to avoid confusions with parameters (in case those have the same name).
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.

    //  Overrides from superclass 'Object'.
    //  - IMPORT: unnecessary.
    @Override
    public String toString() {
        // return super.toString();         //  Default definition.
        return "Serie: " + super.getNombre() + " (" + super.getFechaDeLanzamiento() + ")";
    }

    //  Overrides from superclass 'Titulo'.
    //  - IMPORT: needed, IF referenced class / interface is in different package.
    @Override                                       //  Annotation.
    public int getDuracionEnMinutos() {
        // return super.getDuracionEnMinutos();        //  Default: 'super' refers to 'parent' / 'super' class, from which current class inherits.
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    //  METHODS FROM 'IMPLEMENTS'.

    //  REGULAR METHODS.

}
//  EOF.