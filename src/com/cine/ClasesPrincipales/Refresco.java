/**
  * Clase que creará los objetos de tipo refresco si es que el cliente lo pide en dulceria
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
*/
package com.cine.ClasesPrincipales;

public class Refresco {
	String tamaño;
	String sabor;
	int precio;
	int cantidad;

	/**
	 * Método constructor en caso de que no se incluya refresco en la compra
	 */
	public Refresco() {
		this.tamaño = "No incluyó refresco";
		this.sabor = "";
		this.precio = 0;
		this.cantidad = 0;
	}

	/**
	 * Método que establece el tamaño del refresco
	 * 
	 * @param tamaño Tamaño del refresco
	 */
	public void setTam(String tamaño) {
		this.tamaño = tamaño;

	}

	/**
	 * Método que establece el sabor del refresco
	 * 
	 * @param sabor Sabor del refresco
	 */
	public void setSab(String sabor) {
		this.sabor = sabor;
	}

	/**
	 * Método que establece el precio del refresco
	 * 
	 * @param precio Precio del refresco
	 */
	public void setPre(int precio) {
		this.precio = precio;
	}

	/**
	 * Método que establece la cantidad de refrescos
	 * 
	 * @param cantidad Cantidad de refrescos
	 */
	public void setCan(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método que obtiene el tamaño del refresco
	 * 
	 * @return tamaño del refresco
	 */
	public String getTam() {
		return tamaño;
	}

	/**
	 * Método que obtiene el sabor del refresco
	 * 
	 * @return sabor de refresco
	 */
	public String getSab() {
		return sabor;
	}

	/**
	 * Método que obtiene el precio del refresco
	 * 
	 * @return precio del refresco
	 */
	public int getPre() {
		return precio;
	}

	/**
	 * Método que obtiene la cantidad de refrescos
	 * 
	 * @return cantidad de refrescos
	 */
	public int getCan() {
		return cantidad;
	}
}