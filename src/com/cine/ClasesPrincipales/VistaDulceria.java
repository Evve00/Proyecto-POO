/**
  * Clase que muestra los diferentes menus al cliente
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

public class VistaDulceria {

    /**
     * Método que mostrará el menú general de la dulcería
     */
    public void mostrarMenuD() {
        System.out.println("=====Menú Dulcería======");
        System.out.println(" A. Combo amix: Palomitas y dos refrescos tamaño jumbo");
        System.out.println(" B. Combo nachos: Palomitas, dos refrescos y nachos tamaño mega");
        System.out.println(" C. Combo buen trio: Palomitas, tres refrescos, y nachos tamaño mega");
        System.out.println(" D. Combo que me ves: Palomitas, refresco y nachos jumbo");
        System.out.println(" E. Orden personalizada");
    }

    /**
     * Método que lee los precios del archivo txt para imprimir los costos, en caso
     * de una orden personalizada
     */
    public void menuPers() {
        try {
            File aPrecios = new File("PreciosDulceria.txt");
            FileReader entradaC = new FileReader(aPrecios);
            BufferedReader bufferD = new BufferedReader(entradaC);
            String preciosLeidos = bufferD.readLine(); // lee el archivo txt de los precios

            while (preciosLeidos != null) {
                System.out.println(preciosLeidos);
                preciosLeidos = bufferD.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
