package com.cine.ClasesPrincipales;

import java.util.ArrayList;
import java.util.List;

public class SalaVip extends Sala {

    private static final int filas = 8; // A–H
    private static final int columnas = 6;

    private static final double precio = 150.0;

    /**
     * Contructor de la sala VIP
     */
    public SalaVip() {
        super("Sala VIP", precio);
    }

    /**
     * Crea la cantidad de asientos de la sala VIP
     */
    public List<String> getAsientos() {
        List<String> listaNombres = new ArrayList<>();

        for (int x = 0; x < filas; x++) {
            char letraFila = (char) ('A' + x); // 0='A', 1='B', etc.

            for (int y = 1; y <= columnas; y++) {
                // Concatena Letra + Número (ej: "A1")
                listaNombres.add(letraFila + String.valueOf(y));
            }
        }
        return listaNombres;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoDeSala() {
        return tipoDeSala;
    }
}