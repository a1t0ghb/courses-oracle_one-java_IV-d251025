/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv;

//  IMPORTS: external classes and interfaces.

//  IMPORTS - Utilities.
//  Shortcut for importing ALL Java Utils: 'import java.util.*;'.
import java.util.Scanner;

//  Imports for HTTP requests.
//  - Client: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html'.
//  - HTTP response: 'https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpResponse.html'.
//  -  Handle exceptions (i.e. possible errors) from method '.send()'.
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.

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
            System.out.println(response.body());

        }

    }
    
}
//  EOF.