package com.cine.ClasesPrincipales;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se compone de las clases sala,boleto y pelicula
 * los objetos sala y pelicula ya deben estar creados
 * boleto se crea a partir de esta clase
 */
public class Funcion {
    private Pelicula pelicula;
    private Sala sala;
    private List<Boleto> boletosTotales;
    private List<Boleto> boletosVendidos;
    private LocalDate fecha;
    private LocalTime horario;
    private double precio;
    private String claveFuncion;

    /**
     * Contructor de la clase Funcion
     */
    public Funcion(Sala sala, Pelicula pelicula,
            LocalDate fecha, LocalTime horario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.boletosTotales = new ArrayList<>();
        this.boletosVendidos = new ArrayList<>();
        this.fecha = fecha;
        this.horario = horario;
        this.precio = sala.getPrecio();
        this.claveFuncion = generarClaveFuncion();
        generarBoletos();
    }

    /**
     * Crea los objetos Boletos dependiendo de la sala
     * 
     */

    private void generarBoletos() {
        List<String> asientos = sala.getAsientos();

        for (String asiento : asientos) {
            Boleto boleto = new Boleto(
                    pelicula.getNombreDeLaPelicula(),
                    fecha,
                    horario,
                    sala.getTipoDeSala(),
                    asiento,
                    precio,
                    null// abajo genera la clave
            );

            // genera clave
            String clave = boleto.generarClave(pelicula.getNombreDeLaPelicula());
            boleto.setClave(clave);
            boletosTotales.add(boleto);
        }
    }

    /**
     * Genera la clave única de la funcion
     * Formato: InicialesDelTítulo:AAAAMMDD:hhmm:Sala:Asiento
     * Es publico porque se accede desde la clase Funcion
     * 
     * @return La clave generada para la funcion
     */
    public String generarClaveFuncion() {
        String iniciales = obtenerIniciales(pelicula.getNombreDeLaPelicula());

        String fechaStr = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String horaStr = horario.format(DateTimeFormatter.ofPattern("HHmm"));

        return iniciales + ":" + fechaStr + ":" + horaStr + ":" + sala.getTipoDeSala();
    }

    /**
     * Metodo para obtener las iniciales de la pelicula
     * 
     * @param titulo nombre de la pelicula
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
     * Verifica si el asiento ya esta vendido, si no esta vendido
     * lo guarda en la lista de asientos vendidos
     * 
     * @param asiento asiento que el cliente quiere comprar
     * @return true si la venta fue exitosa, false si el asiento no existe o ya está
     *         vendido
     */
    public boolean venderBoleto(String asiento) {

        // Buscar en la lista de boletos totales
        for (Boleto b : boletosTotales) {

            if (b.getAsiento().equalsIgnoreCase(asiento)) {

                // verifica si esta vendido
                if (boletosVendidos.contains(b)) {
                    return false; // si ya se vendio regresa false
                }

                // se agrega a vendidos
                boletosVendidos.add(b);

                return true; // Venta exitosa
            }
        }

        // Si el asiento no existe, regresa este false
        return false;
    }

    /**
     * Metodos get
     * 
     */

    public String getClaveFuncion() {
        return claveFuncion;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public LocalTime getHorario() {
        return this.horario;
    }

    public Sala getSala() {
        return this.sala;
    }

    public Pelicula getPelicula() {
        return this.pelicula;
    }

    public String toString() {
        return "Pelicula:" + pelicula.getNombreDeLaPelicula() + "\n" + "Sala:" + sala.getTipoDeSala() + "\n" + "Fecha:"
                + fecha + "\n" + "Horario de inicio:" + horario;
    }

}