package com.cine.ClasesPrincipales;

import java.util.ArrayList;
import java.util.List;

/**
 * Contructor de la sala A
 */
public class SalaA extends Sala {

    private static final int filas = 10; // A–J
    private static final int columnas = 15;
    private static final double precio = 50.0;

    public SalaA() {
        super("Sala A", precio);
    }

    /**
     * Crea la cantidad de asientos de la sala A
     */
    public List<String> getAsientos() {
        List<String> asientos = new ArrayList<>();

        for (int x = 0; x < filas; x++) {
            char fila = (char) ('A' + x);
            for (int y = 1; y <= columnas; y++) {
                asientos.add(fila + String.valueOf(y));
            }
        }
        return asientos;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoDeSala() {
        return tipoDeSala;
    }
}
