/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.utilities;

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.
import java.io.FileWriter;
import java.io.IOException;

//  JSON:
//  - 'Gson': 'https://github.com/google/gson', 'https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html'.
import com.google.gson.Gson;                    //  JSON transformations.
import com.google.gson.GsonBuilder;             //  For JSON field naming support: 'https://github.com/google/gson/blob/main/UserGuide.md#json-field-naming-support'

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.models.Pelicula;

/**
 *
 * @author a1t0ghb
 */
public class GeneradorDeArchivo {

    @SuppressWarnings("ConvertToTryWithResources")
    public void guardarJson(Pelicula pelicula) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(pelicula.title() + ".json");      //  Can throw IOException.
        escritura.write(gson.toJson(pelicula));
        escritura.close();
    }

}
