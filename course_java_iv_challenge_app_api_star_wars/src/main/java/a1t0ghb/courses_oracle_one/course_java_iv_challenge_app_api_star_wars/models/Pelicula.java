/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

//  Package location definition.
package a1t0ghb.courses_oracle_one.course_java_iv_challenge_app_api_star_wars.models;

//  IMPORTS - UTILITIES.
//  Java utilities:
//  - Shortcut for importing ALL Java Utils: 'import java.util.*;'.

//  IMPORTS - CUSTOM CLASSES AND CUSTOM INTERFACES.

/**
 *
 * @author a1t0ghb
 */
public record Pelicula(String title, int episode_id, String opening_crawl, String director, String producer, String release_date) {
    //  NOTE: Class parameters come from picking JSON fields, based on HTTP request testing of API; e.g. on Postman or Apidog.
    //  - Test URL: 'https://swapi.dev/api/films/1'.
}
