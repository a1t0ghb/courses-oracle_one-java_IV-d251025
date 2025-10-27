/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.
import java.util.Scanner;                       //  User input via console / terminal.

//  HTTP requests:
//  - Client: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html'.
//  - HTTP response: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpResponse.html'.
import java.net.http.HttpClient;                //  HTTP requests.
import java.net.http.HttpRequest;               //  HTTP requests.
import java.net.URI;                            //  HTTP requests.
import java.net.http.HttpResponse;              //  HTTP requests.
import java.io.IOException;                     //  To handle IO exceptions (i.e. possible errors); e.g. when making an HTTP request, from method '.send()'.

//  JSON:
//  - 'Gson': 'https://github.com/google/gson', 'https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html'.
import com.google.gson.Gson;                    //  JSON transformations.
import com.google.gson.GsonBuilder;             //  For JSON field naming support: 'https://github.com/google/gson/blob/main/UserGuide.md#json-field-naming-support'
import com.google.gson.FieldNamingPolicy;       //  For JSON field naming support: 'https://github.com/google/gson/blob/main/UserGuide.md#json-field-naming-support'

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.
import a1t0ghb.courses_oracle_one.course_java_iv.models.TituloOmdb;
import a1t0ghb.courses_oracle_one.course_java_iv.models.Titulo;

/**
 *
 * @author a1t0ghb
 */
public class AppConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {
        // System.out.println("Hello World!");

        //  INITIALIZATION OF INSTANCES.
        
        //  'Scanner' as class to receive input of user from console.
        //  - Use in conjunction with try-with-resources, to AUTOMATICALLY close resources and manage try-cath exceptions. Ref: 'https://www.w3schools.com/java/java_try_catch_resources.asp'.
        try (Scanner lectura = new Scanner(System.in)) {

            System.out.println("Escriba el nombre de una película: ");
            var busqueda = lectura.nextLine();                          //  Method from class 'Scanner' to receive a String (default) as an input.

            //  Creates string for API search.
            var direccion = "https://www.omdbapi.com/?apikey=d4d0bf92&t=" + busqueda;

            //  HTTP request.
            HttpClient client = HttpClient.newHttpClient();             //  Creates http client. Requires IMPORT package 'java.net.http.HttpClient'.
            HttpRequest request = HttpRequest.newBuilder()              //  Creates http request, using pattern BUILDER. 'HttpRequest' is NOT a class, more likey an interface, which means an instance of it CAN'T be created as a regular class. Requires IMPORT class 'java.net.http.HttpRequest'.
                .uri(URI.create(direccion))                             //  Uses an instance of class 'URI'. Requires IMPORT package 'java.net.URI'.
                .build();                                               //  Instruction from pattern BUILDER. Way to recognize it.
            
            HttpResponse<String> response = client                      //  Creates http response. Requires IMPORT package 'java.net.http.HttpResponse'.
                .send(request, HttpResponse.BodyHandlers.ofString());   //  Method '.send()' requires handle EXCEPTIONS. For now, will be added to 'public static void main(String[] args) { ... }'.

            //  Prints body of HTTP request; i.e. JSON, in raw format.
            String json = response.body();
            System.out.println(json);

            // //  Create instance for JSON tranformations (APPROACH 1: direct JSON mapping, without RECORD file 'TituloOmdb').
            // Gson gson = new Gson();
            // //  NOTE: to match class attributes vs. JSON fields, it requires to use ANNOTATIONS in class; i.e. 'Titulo'.
            // Titulo miTitulo = gson.fromJson(json, Titulo.class);
            // // System.out.println("Titulo: " + miTitulo.getNombre());      //  When not having defined method of '.toString()'.
            // System.out.println(miTitulo);

            //  Create instance for JSON tranformations (APPROACH 2: using JSON naming for JSON mapping, with RECORD file 'TituloOmdb').
            Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)       //  To avoid manual mapping. Transform parameters according to policy, for easier matching.
                .create();
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println("\nClase intermedia (Record) 'TituloOmdb':\n" + miTituloOmdb + "\n");

            //  Try-catch exception 'e'. Cases:
            //  - 'NumberFormatException': if a String can't be converted to Integer.
            try {
                Titulo miTitulo = new Titulo(miTituloOmdb);                 //  This approach requires a NEW CONSTRUCTOR for 'Titulo' that receives an instace of 'TituloOmdb'.
                System.out.println("Info. titulo:\n" + miTitulo + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println("Finalizó ejecución del programa.");
            
        }

    }
    
}
//  EOF.