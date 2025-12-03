/**
  * Clase que creará los objetos de tipo palomitas si es que el cliente lo pide en dulceria
  * @author Jiménez Martínez Fabricio 
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
*/
package com.cine.ClasesPrincipales;

public class Palomitas {
	String tamaño;
	String sabor;
	int precio;
	int cantidad;

	/**
	 * Método constructor en caso de que no se incluya palomitas en la compra
	 */
	public Palomitas() {
		this.tamaño = "No incluyó Palomitas";
		this.sabor = "";
		this.precio = 0;
		this.cantidad = 0;
	}

	/**
	 * Método que establece el tamaño de las palomitas
	 * 
	 * @param tamaño Tamaño de las palomitas
	 */
	public void setTam(String tamaño) {
		this.tamaño = tamaño;

	}

	/**
	 * Método que establece el sabor de las palomitas
	 * 
	 * @param sabor Sabor de las palomitas
	 */
	public void setSab(String sabor) {
		this.sabor = sabor;
	}

	/**
	 * Método que establece el precio de las palomitas
	 * 
	 * @param precio Precio de las palomitas
	 */
	public void setPre(int precio) {
		this.precio = precio;
	}

	/**
	 * Método que establece la cantidad de palomitas
	 * 
	 * @param cantidad Cantidad de palomitas
	 */
	public void setCan(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método que obtiene el tamaño de las palomitas
	 * 
	 * @return Tamaño de las palomitas
	 */
	public String getTam() {
		return tamaño;
	}

	/**
	 * Método que obtiene el sabor de las palomitas
	 * 
	 * @return Sabor de palomitas
	 */
	public String getSab() {
		return sabor;
	}

	/**
	 * Método que obtiene el precio de las palomitas
	 * 
	 * @return precio de palomitas
	 */
	public int getPre() {
		return precio;
	}

	/**
	 * Método que obtiene la cantidad de palomitas
	 * 
	 * @return cantidad de palomitas
	 */
	public int getCan() {
		return cantidad;
	}

}