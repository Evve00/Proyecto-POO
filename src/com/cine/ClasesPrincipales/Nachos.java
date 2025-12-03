/**
  * Clase que creará los objetos de tipo Nacho si es que el cliente los pide en dulceria 
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
  * @version 1.0
*/
package com.cine.ClasesPrincipales;

public class Nachos {
	String tamaño;
	int precio;
	int cantidad;

	/**
	 * Método constructor en caso de que no se incluya nachos en la compra
	 */
	public Nachos() {
		this.tamaño = "No incluyó nachos";
		this.precio = 0;
		this.cantidad = 0;
	}

	/**
	 * Método que modifica el tamaño deseado para los nachos
	 * 
	 * @param tamaño El tamaño para los nachos
	 */
	public void setTam(String tamaño) {
		this.tamaño = tamaño;

	}

	/**
	 * Método que modifica el precio de los nachos
	 * 
	 * @param precio El precique tendrán los nachos
	 */
	public void setPre(int precio) {
		this.precio = precio;
	}

	/**
	 * Método que modifica la cantidad de nachos
	 * 
	 * @param cantidad La cantidad de nachos solicitados
	 */
	public void setCan(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método que obtiene el tamaño establecido de los nachos
	 * 
	 * @return tamaño de nachos
	 */
	public String getTam() {
		return tamaño;
	}

	/**
	 * Método que otiene el precio de los nachos
	 * 
	 * @return precio de nachos
	 */
	public int getPre() {
		return precio;
	}

	/**
	 * Método que obtiene la cantidad de nachos
	 * 
	 * @return cantidad de nachos
	 */
	public int getCan() {
		return cantidad;
	}
}