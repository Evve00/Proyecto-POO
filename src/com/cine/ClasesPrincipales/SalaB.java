package com.cine.ClasesPrincipales;

import java.util.ArrayList;
import java.util.List;

public class SalaB extends Sala {
    private static final int filas1 = 4; // A–D
    private static final int columnas1 = 7;

    private static final int filas2 = 6; // E-J
    private static final int columnas2 = 15;

    private static final double precio = 100.0;

    /**
     * Contructor de la sala B
     */
    public SalaB() {
        // se crea con mas asientos pero despues se pueden quitar
        super("Sala B", precio);

    }

    /**
     * Crea la cantidad de asientos de la sala B
     */
    public List<String> getAsientos() {
        List<String> asientos = new ArrayList<>();

        for (int x = 0; x < filas1; x++) {
            char fila = (char) ('A' + x);
            for (int y = 1; y <= columnas1; y++) {
                asientos.add(fila + String.valueOf(y));
            }
        }

        for (int a = 0; a < filas2; a++) {
            char fila = (char) ('A' + a);
            for (int b = 1; b <= columnas2; b++) {
                asientos.add(fila + String.valueOf(b));
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
