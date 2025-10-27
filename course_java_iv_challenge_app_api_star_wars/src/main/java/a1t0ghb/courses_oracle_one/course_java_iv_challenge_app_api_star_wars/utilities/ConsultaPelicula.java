/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.utilities;

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.

//  HTTP requests:
//  - Client: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html'.
//  - HTTP response: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpResponse.html'.
import java.net.http.HttpClient;                //  HTTP requests.
import java.net.http.HttpRequest;               //  HTTP requests.
import java.net.URI;                            //  HTTP requests.
import java.net.http.HttpResponse;              //  HTTP requests.
// import java.io.IOException;                     //  To handle IO exceptions (i.e. possible errors); e.g. when making an HTTP request, from method '.send()'.

//  JSON:
//  - 'Gson': 'https://github.com/google/gson', 'https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html'.
import com.google.gson.Gson;                    //  JSON transformations.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.models.Pelicula;

/**
 *
 * @author a1t0ghb
 */
public class ConsultaPelicula {

    @SuppressWarnings({"unused", "UseSpecificCatch"})
    public Pelicula buscaPelicula(int numeroDePelicula) {

        URI direccion = URI.create(
            "https://swapi.dev/api/films/" + numeroDePelicula);         //  Uses an instance of class 'URI'. Requires IMPORT package 'java.net.URI'.

        //  HTTP request.
        HttpClient client = HttpClient.newHttpClient();                 //  Creates http client. Requires IMPORT package 'java.net.http.HttpClient'.
        HttpRequest request = HttpRequest.newBuilder()                  //  Creates http request, using pattern BUILDER. 'HttpRequest' is NOT a class, more likey an interface, which means an instance of it CAN'T be created as a regular class. Requires IMPORT class 'java.net.http.HttpRequest'.
            .uri(direccion)
            .build();                                                   //  Instruction from pattern BUILDER. Way to recognize it.
                
        try {

            HttpResponse<String> response = client                      //  Creates http response. Requires IMPORT package 'java.net.http.HttpResponse'.
                .send(request, HttpResponse.BodyHandlers.ofString());   //  Method '.send()' requires handle EXCEPTIONS. For now, will be added to 'public static void main(String[] args) { ... }'.

            return new Gson().fromJson(response.body(), Pelicula.class);//  Returns a new instance of 'Pelicula', using HTTP request response and transforming JSON with Gson.

        // } catch (IOException | InterruptedException e) {            //  Multi-catch, for exceptions.
        } catch (Exception e) {                                         //  General exception catch.

            throw new RuntimeException("Error; no encontré esa película: " + e);
            
        }
        
    }
}
