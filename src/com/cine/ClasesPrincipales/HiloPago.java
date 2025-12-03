/**
  * Clase que generará los hilos para la simulación de pago bancario
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
*/
package com.cine.ClasesPrincipales;

import java.security.SecureRandom;

public class HiloPago extends Thread {

    SecureRandom random = new SecureRandom();
    HiloCarga carga;

    /**
     * Método constructor para asignar el hilo que funcionará concurrentemente
     */
    public HiloPago(HiloCarga carga) {
        this.carga = carga;
    }

    /**
     * Método que imprime los mensajes y espera entre 2 a 5 seg entre cada impresión
     */
    @Override
    public void run() {
        try {
            System.out.println("Tarjeta bancaria ingresada...");
            carga.start();
            int aleatorio = random.nextInt(5000 - 2000 + 1) + 1;
            Thread.sleep(aleatorio);
            System.out.println("\nEstableciendo conexión con el banco...");
            aleatorio = random.nextInt(5000 - 2000 + 1) + 1;
            Thread.sleep(aleatorio);

            System.out.println("\nHaciendo el cargo correspondiente...");
            aleatorio = random.nextInt(5000 - 2000 + 1) + 1;
            Thread.sleep(aleatorio);

            System.out.println("\nTransacción finalizada");
            carga.interrupt();

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}
