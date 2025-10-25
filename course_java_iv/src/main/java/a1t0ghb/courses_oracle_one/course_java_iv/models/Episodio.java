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
public class Episodio implements Clasificacion {

    //  ATTRIBUTES DECLARATION.
    private int numero;
    private String nombre;
    private Serie serie;
    private int totalVisualizaciones;

    //  CONSTRUCTOR.

    //  ATTRIBUTE'S 'GETTERS'.
    public int getNumero() {
        return numero;
    }
    public String getNombre(){
        return nombre;
    }
    public Serie getSerie(){
        return serie;
    }
    public int getTotalVisualizaciones(){
        return totalVisualizaciones;
    }
    
    //  ATTRIBUTE'S 'SETTERS': usually, public.
    //  - 'this' protected keyword, is used to refer to CURRENT object, just to avoid confusions with parameters (in case those have the same name).
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.
    
    //  Overrides from superclass 'Titulo'.
    //  - IMPORT: needed, IF referenced class / interface is in different package.
    //  - Method to get star rating (integer, 0 to 5), using as reference the note's average of 'calcularMedia()' (double, 0.0 to 10.0), from 'parent' class 'Titulo'.
    @Override
    public int getClasificacion() {
        if (totalVisualizaciones > 100) {
            return 4;
        } else {
            return 2;
        }
    }

    //  METHODS FROM 'IMPLEMENTS'.

    //  REGULAR METHODS.

}
//  EOF.