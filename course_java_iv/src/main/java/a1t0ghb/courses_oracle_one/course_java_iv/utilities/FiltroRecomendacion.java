/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv.utilities;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Shortcut for importing ALL Java Utils: 'import java.util.*;'.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.

/**
 *
 * @author a1t0ghb
 */
public class FiltroRecomendacion {

    //  ATTRIBUTES DECLARATION.
    // private String recomendacion;

    //  ATTRIBUTE'S 'GETTERS'.

    //  ATTRIBUTE'S 'SETTERS': usually, public.
    //  - 'this' protected keyword, is used to refer to CURRENT object, just to avoid confusions with parameters (in case those have the same name).
    
    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.

    //  METHODS FROM 'IMPLEMENTS'.

    //  REGULAR METHODS.

    public void filtra(Clasificacion clasificacion) {
        
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Está entre los favoritos del momento.");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Bien evaluado actualmente.");
        } else {
            System.out.println("Colocalo en tu lista para verlo después.");
        }
        
    }

}
//  EOF.