/**
  * Clase que lee los precios de los productos dependiendo el tamaño de este 
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
  * @version 1.0
*/
package com.cine.ClasesPrincipales;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Precios {
    int precioPalMed;
    int precioPalGrd;
    int precioPalJmb;
    int precioPalMeg;
    // -----------------------------------
    int precioRefMed;
    int precioRefGrd;
    int precioRefJmb;
    int precioRefMeg;
    // ---------------------------------
    int precioNacPers;
    int precioNacJmb;
    int precioNacMeg;

    /**
     * Método que lee linea por linea del archivo, separa y usa solo los precios
     * para guardar cada uno
     */
    public void CalcularPrecios() {
        try {
            File aPrecios = new File("PreciosDulceria.txt");
            FileReader entradaC = new FileReader(aPrecios);
            BufferedReader bufferD = new BufferedReader(entradaC);
            String preciosLeidos = bufferD.readLine();
            StringTokenizer separador = new StringTokenizer(preciosLeidos, ":");

            // ----------------------------------------------------------------
            separador.nextToken();
            String precioL = separador.nextToken();
            precioPalMed = Integer.parseInt(precioL);

            // ---------------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioPalGrd = Integer.parseInt(precioL);

            // ------------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioPalJmb = Integer.parseInt(precioL);

            // ----------------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioPalMeg = Integer.parseInt(precioL);

            // -----------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioRefMed = Integer.parseInt(precioL);

            // -----------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioRefGrd = Integer.parseInt(precioL);

            // ----------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioRefJmb = Integer.parseInt(precioL);

            // --------------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioRefMeg = Integer.parseInt(precioL);

            // -----------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioNacPers = Integer.parseInt(precioL);

            // -------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioNacJmb = Integer.parseInt(precioL);

            // -----------------------------------------------------------
            preciosLeidos = bufferD.readLine();
            separador = new StringTokenizer(preciosLeidos, ":");
            separador.nextToken();
            precioL = separador.nextToken();
            precioNacMeg = Integer.parseInt(precioL);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
