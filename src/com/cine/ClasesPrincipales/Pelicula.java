package com.cine.ClasesPrincipales;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase para las peliculas
 */
public class Pelicula {
    private String nombreDeLaPelicula;
    private String generos;
    private String sinopsis;
    private LocalTime duracion;

    // para poner el formato a la duración de las peliculas
    private static final DateTimeFormatter FORMAT_HHMM = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Contructor de la clase Pelicula
     * 
     * @param String    nombre
     * @param String    generos
     * @param String    sinopsis
     * @param LocalTime duracion
     * 
     */
    public Pelicula(String nombre, String generos, String sinopsis, String duracionHHMM) {
        this.nombreDeLaPelicula = nombre;
        this.generos = generos;
        this.sinopsis = sinopsis;
        this.duracion = LocalTime.parse(duracionHHMM, FORMAT_HHMM);
    }

    /**
     * Metodos para acceder a los atributos privados
     *
     * @return atributos privados
     */

    public String getNombreDeLaPelicula() {
        return nombreDeLaPelicula;
    }

    public String getGeneros() {
        return generos;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public String toFileString() {
        return nombreDeLaPelicula + "|" + generos + "|" + sinopsis + "|" + duracion;
    }

    public String toString() {
        return "Pelicula:" + nombreDeLaPelicula + "\n" + "Generos:" + generos + "\n" + "Sinopsis:" + sinopsis + "\n"
                + "Duración:" + duracion;
    }
}
