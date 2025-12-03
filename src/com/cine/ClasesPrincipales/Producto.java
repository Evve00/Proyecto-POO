/**
  * Clase que une los diferentes productos de dulceria individualmente
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
  * @version 1.0
*/
package com.cine.ClasesPrincipales;

public class Producto {
	Palomitas unasPalomitas;
	Refresco unRefresco;
	Nachos unNacho;

	/**
	 * Método constructor que genera los objetos para cada tipo de producto
	 */
	public Producto() {
		unasPalomitas = new Palomitas();
		unRefresco = new Refresco();
		unNacho = new Nachos();

	}

	/**
	 * Método que obtiene el objeto Palomitas
	 * 
	 * @return objeto Palomitas
	 */
	public Palomitas getPalomitas() {

		return unasPalomitas;
	}

	/**
	 * Método que obtiene el objeto Refresco
	 * 
	 * @return objeto Refresco
	 */
	public Refresco getRefresco() {

		return unRefresco;
	}

	/**
	 * Método que obtiene el objeto Nachos
	 * 
	 * @return objeto Nachos
	 */
	public Nachos getNachos() {

		return unNacho;
	}

}