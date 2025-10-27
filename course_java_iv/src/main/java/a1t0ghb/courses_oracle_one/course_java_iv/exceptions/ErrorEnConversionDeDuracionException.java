/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv.exceptions;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.

/**
 *
 * @author a1t0ghb
 */
public class ErrorEnConversionDeDuracionException extends RuntimeException {

    //  ATTRIBUTES DECLARATION.
    @SuppressWarnings("FieldMayBeFinal")
    private String mensaje;

    //  CONSTRUCTOR.
    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    //  ATTRIBUTE'S 'GETTERS'.
    public String getMensaje() {
        return mensaje;
    }

    //  ATTRIBUTE'S 'SETTERS': usually, public.

    //  INHERITED METHODS TO OVERRIDE: custom definitions for CURRENT class.

    //  Overrides from class 'RuntimeException'.
    //  - IMPORT: unnecessary.
    //  - Ref.: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/RuntimeException.html'.
    @Override
    public String getMessage() {
        // return super.getMessage();      //  Default definition.
        return getMensaje();
    }

    //  METHODS FROM 'IMPLEMENTS'.

    //  REGULAR METHODS.

}