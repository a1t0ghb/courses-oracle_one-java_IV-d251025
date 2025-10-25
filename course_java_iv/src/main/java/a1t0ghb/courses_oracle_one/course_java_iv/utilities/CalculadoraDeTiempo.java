/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv.utilities;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Shortcut for importing ALL Java Utils: 'import java.util.*;'.
//  Interface 'Comparable' DOESN'T REQUIRE import.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv.models.Titulo;

/**
 *
 * @author a1t0ghb
 */
public class CalculadoraDeTiempo {

    //  ATTRIBUTES DECLARATION.
    private int tiempoTotal;

    //  ATTRIBUTE'S 'GETTERS'.
    public int getTiempoTotal() {
        return tiempoTotal;
    }

    //  ATTRIBUTE'S 'SETTERS': usually, public.
    //  - 'this' protected keyword, is used to refer to CURRENT object, just to avoid confusions with parameters (in case those have the same name).
    //  Private setter.
    private void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.

    //  METHODS FROM 'IMPLEMENTS'.

    //  REGULAR METHODS.

    //  Accumulates duration of titles added. A 'title' can be an instance of class 'Titulo' or ANY of it's 'child', such as 'Pelicula' or 'Serie'.
    //  - The fact the method can be used with a class or any of its 'child' classes, refers to POLYMORPHISM.
    public void incluido(Titulo titulo) {
        // //  NOT RECOMMENDED: specially for 'parent' classes, use direct access / call to attributes.
        // tiempoTotal += titulo.getDuracionEnMinutos();
        //  RECOMMENDED: use base 'getters' and 'setters' of attributes, so they are context / class AWARE.
        System.out.println("Agregando duración en minutos de " + titulo);
        setTiempoTotal(getTiempoTotal() + titulo.getDuracionEnMinutos());
    }

}
//  EOF.