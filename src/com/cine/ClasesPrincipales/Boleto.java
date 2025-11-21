package com.cine.ClasesPrincipales;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Boleto {
    private String nombreDeLaPelicula;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipoDeSala;
    private String asiento;
    private double precio;
    private String claveBoleto;

    /**
     * Contructor de la clase
     * no parsea los datos hora y fecha, recibe los objetos directamente
     * 
     * @param tituloPelicula Título de la película
     * @param fecha          Fecha de la función
     * @param hora           Hora de la función
     * @param sala           Sala donde se proyecta
     * @param asiento        Asiento elegido (ej. H7)
     * @param precio         Precio del boleto
     * @return La clave generada para este boleto
     */
    public Boleto(String nombreDeLaPelicula,
            LocalDate fecha,
            LocalTime hora,
            String tipoDesala,
            String asiento,
            double precio,
            String claveBoleto) {
        this.nombreDeLaPelicula = nombreDeLaPelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoDeSala = tipoDesala;
        this.asiento = asiento;
        this.precio = precio;
        this.claveBoleto = generarClave(nombreDeLaPelicula);
    }

    /**
     * Genera la clave única del boleto.
     * Formato: InicialesDelTítulo:AAAAMMDD:hhmm:Sala:Asiento
     * Es publico porque se accede desde la clase Funcion
     * 
     * @return La clave generada para este boleto
     */
    public String generarClave(String nombreDeLaPelicula) {
        String iniciales = obtenerIniciales(nombreDeLaPelicula);

        String fechaStr = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String horaStr = hora.format(DateTimeFormatter.ofPattern("HHmm"));

        return iniciales + ":" + fechaStr + ":" + horaStr + ":" + tipoDeSala + ":" + asiento;
    }

    /**
     * Metodo para obtener las iniciales de la pelicula
     *
     * @return iniciales de la pelicula
     */
    private String obtenerIniciales(String titulo) {
        String[] palabras = titulo.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String p : palabras) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0)));
            }
        }
        return sb.toString();
    }

    /**
     * Metodos para acceder a los atributos privados
     *
     * @return atributos privados
     */
    public String getNombreDeLaPelicula() {
        return nombreDeLaPelicula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getSala() {
        return tipoDeSala;
    }

    public String getAsiento() {
        return asiento;
    }

    public String getClaveBoleto() {
        return claveBoleto;
    }

    public double getPrecio() {
        return precio;
    }

    /**
     * Metodos para poner clave al boleto
     *
     */

    public void setClave(String claveBoleto) {
        this.claveBoleto = claveBoleto;
    }

}
