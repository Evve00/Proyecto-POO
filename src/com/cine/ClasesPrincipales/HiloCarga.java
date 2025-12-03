/**
  * Clase que generará el hilo que simula la carga del pago
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
  * @version 1.0
*/
package com.cine.ClasesPrincipales;

public class HiloCarga extends Thread {

	/**
	 * Método que hace que el hilo imprima * simulando la carga
	 */
	@Override
	public void run() {
		while (true) {
			System.out.print("*");
			try {
				Thread.sleep(500);

			} catch (InterruptedException e) {
				break;
			}

		}

	}
}