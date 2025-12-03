/**
  * Clase que maneja los combos u órdenes de la dulceria y retorna el pedido del cliente 
  * @author Jiménez Martínez Fabricio
  * @author Cortés Hernández Aldo Eduardo
  * @author Maldonado Rodrigez Ángel Daniel
  * @author Cruz Crispín Uriel
  * @author Barrancos Parada Tiago
  * @author Romero Sánchez Ulises Uriel
  * @version 1.0
*/
package com.cine.ClasesPrincipales;

import java.util.Scanner;
import java.util.InputMismatchException;

public class OrdenDulceria {
	String tipodeOrden;
	Combo unCombo;
	Producto dosProducto;
	VistaDulceria unaVista;

	int bandera;
	double suma;

	double precioTotal;

	/**
	 * Método que genera la orden del cliente, ya sea un combo o productos por
	 * separado
	 */
	public void generarOrden() {
		int ban = 0;
		suma = 0;
		Precios unPrecio = new Precios();
		unPrecio.CalcularPrecios();
		unaVista = new VistaDulceria();
		Scanner entrada = new Scanner(System.in);
		String dec;

		unaVista.mostrarMenuD();
		dec = entrada.nextLine();
		while (true) {

			if (dec.equalsIgnoreCase("A") || dec.equalsIgnoreCase("B") || dec.equalsIgnoreCase("C")
					|| dec.equalsIgnoreCase("D") || dec.equalsIgnoreCase("E")) {
				break;
			}
			System.out.println("Opcion incorrecta, vuelve a intentarlo");
			unaVista.mostrarMenuD();
			dec = entrada.nextLine();

		}
		if (dec.equalsIgnoreCase("E")) {
			while (ban == 0) {
				try {
					bandera = 0;
					ban = 1;
					entrada.nextLine();
					this.tipodeOrden = "Personalizada";
					dosProducto = new Producto();
					int numEleg;

					unaVista.menuPers();
					System.out.println("Desea incluir palomitas ?");
					dec = entrada.nextLine();
					if (dec.equalsIgnoreCase("SI")) {
						dosProducto.getPalomitas().setCan(1);

						do {
							System.out.println("Que tamaño de palomitas?(escribe el número correspondiente)");
							System.out.println("|| 1-Medianas || 2-Grandes  || 3-Jumbo || 4-Mega ||");
							numEleg = entrada.nextInt();

						} while (numEleg > 4 || numEleg < 1);

						switch (numEleg) {
							case 1:
								dosProducto.getPalomitas().setTam("Medianas");
								suma = suma + unPrecio.precioPalMed;
								break;
							case 2:
								dosProducto.getPalomitas().setTam("Grandes");
								suma = suma + unPrecio.precioPalGrd;
								break;
							case 3:
								dosProducto.getPalomitas().setTam("Jumbo");
								suma = suma + unPrecio.precioPalJmb;
								break;
							case 4:
								dosProducto.getPalomitas().setTam("Mega");
								suma = suma + unPrecio.precioPalMeg;
								break;
						}

						do {
							System.out.println("Que sabor?(escribe el número correspondiente)");
							System.out.println("|| 1-Mantequilla || 2-Queso ||  3-Jalapeño ||");
							numEleg = entrada.nextInt();
							entrada.nextLine();
						} while (numEleg > 3 || numEleg < 1);

						switch (numEleg) {
							case 1:
								dosProducto.getPalomitas().setSab("Mantequilla");
								break;
							case 2:
								dosProducto.getPalomitas().setSab("Queso");
								break;
							case 3:
								dosProducto.getPalomitas().setSab("Jalapeño");
								break;
						}
					}

					System.out.println("Desea incluir refresco ?");
					dec = entrada.nextLine();
					if (dec.equalsIgnoreCase("SI")) {
						dosProducto.getRefresco().setCan(1);

						do {
							System.out.println("Que tamaño de refresco?(escribe el número correspondiente)");
							System.out.println("|| 1-Mediano || 2-Grande  || 3-Jumbo || 4-Mega ||");
							numEleg = entrada.nextInt();

						} while (numEleg > 4 || numEleg < 1);

						switch (numEleg) {
							case 1:
								dosProducto.getRefresco().setTam("Mediano");
								suma = suma + unPrecio.precioRefMed;
								break;
							case 2:
								dosProducto.getRefresco().setTam("Grande");
								suma = suma + unPrecio.precioRefGrd;
								break;
							case 3:
								dosProducto.getRefresco().setTam("Jumbo");
								suma = suma + unPrecio.precioRefJmb;
								break;
							case 4:
								dosProducto.getRefresco().setTam("Mega");
								suma = suma + unPrecio.precioRefMeg;
								break;
						}

						do {
							System.out.println("Que sabor?(escribe el número correspondiente)");
							System.out.println("|| 1-Cola || 2-Cola-Light || 3-Naranja || 4-Manzana || 5-Toronja ||");
							numEleg = entrada.nextInt();
							entrada.nextLine();
						} while (numEleg > 5 || numEleg < 1);

						switch (numEleg) {
							case 1:
								dosProducto.getRefresco().setSab("Cola");
								break;
							case 2:
								dosProducto.getRefresco().setSab("Cola-Light");
								break;
							case 3:
								dosProducto.getRefresco().setSab("Naranja");
								break;
							case 4:
								dosProducto.getRefresco().setSab("Manzana");
								break;
							case 5:
								dosProducto.getRefresco().setSab("Toronja");
								break;
						}
					}

					System.out.println("Desea agregar nachos?");
					dec = entrada.nextLine();
					if (dec.equalsIgnoreCase("SI")) {
						dosProducto.getNachos().setCan(1);

						do {
							System.out.println("Que tamaño de nachos?(escribe el número correspondiente)");
							System.out.println("|| 1-Personal || 2-Jumbo || 3-Mega ||");
							numEleg = entrada.nextInt();

						} while (numEleg > 4 || numEleg < 1);

						switch (numEleg) {
							case 1:
								dosProducto.getNachos().setTam("Personal");
								suma = suma + unPrecio.precioNacPers;
								break;
							case 2:
								dosProducto.getNachos().setTam("Jumbo");
								suma = suma + unPrecio.precioNacJmb;
								break;
							case 3:
								dosProducto.getNachos().setTam("Mega");
								suma = suma + unPrecio.precioNacMeg;
								break;
						}
					}
					this.precioTotal = suma;

				} catch (InputMismatchException e) {
					ban = 0;
					System.out.println("Dato introducido erróneo");
					System.out.println("Vuelve a generar tu orden");
					System.out.println(e.toString());
					System.out.print("\n");

				}
			}
		}

		if (dec.equalsIgnoreCase("A")) {
			bandera = 1;
			this.tipodeOrden = "Combo Amix";
			unCombo = new Combo();
			unCombo.comboAmix();
			this.precioTotal = unCombo.precioTotal;
		}
		if (dec.equalsIgnoreCase("B")) {
			bandera = 1;
			this.tipodeOrden = "Combo Nachos";
			unCombo = new Combo();
			unCombo.comboNachos();
			this.precioTotal = unCombo.precioTotal;
		}
		if (dec.equalsIgnoreCase("C")) {
			bandera = 1;
			this.tipodeOrden = "Combo Buen Trio";
			unCombo = new Combo();
			unCombo.comboBuenTrio();
			this.precioTotal = unCombo.precioTotal;
		}
		if (dec.equalsIgnoreCase("D")) {
			bandera = 1;
			this.tipodeOrden = "Combo Que Me Ves";
			unCombo = new Combo();
			unCombo.comboQueMeVes();
			this.precioTotal = unCombo.precioTotal;
		}
	}

	/**
	 * Método que retorna la orden generada
	 * 
	 * @return resumen de orden generada
	 */
	public String retornarOrden() {
		String ordenPalomitas;
		String ordenRefresco;
		String ordenNachos;
		String orden = "No se registró orden de dulceria";

		if (bandera == 1) {
			ordenPalomitas = "Palomitas: " + unCombo.getProductoCombo().getPalomitas().getCan() + ","
					+ unCombo.getProductoCombo().getPalomitas().getTam() + ","
					+ unCombo.getProductoCombo().getPalomitas().getSab() + "|";
			ordenRefresco = "Refresco: " + unCombo.getProductoCombo().getRefresco().getCan() + ","
					+ unCombo.getProductoCombo().getRefresco().getTam() + ","
					+ unCombo.getProductoCombo().getRefresco().getSab() + "|";
			ordenNachos = "Nachos: " + unCombo.getProductoCombo().getNachos().getCan() + ","
					+ unCombo.getProductoCombo().getNachos().getTam() + "|";

			orden = this.tipodeOrden + "|" + ordenPalomitas + ordenRefresco + ordenNachos + "| Precio Total: "
					+ String.valueOf(unCombo.precioTotal) + "$";
			return orden;

		} else if (bandera == 0) {
			ordenPalomitas = "Palomitas: " + dosProducto.getPalomitas().getCan() + ","
					+ dosProducto.getPalomitas().getTam() + "," + dosProducto.getPalomitas().getSab() + "|";
			ordenRefresco = "Refresco: " + dosProducto.getRefresco().getCan() + "," + dosProducto.getRefresco().getTam()
					+ "," + dosProducto.getRefresco().getSab() + "|";
			ordenNachos = "Nachos: " + dosProducto.getNachos().getCan() + "," + dosProducto.getNachos().getTam() + "|";

			orden = this.tipodeOrden + "|" + ordenPalomitas + ordenRefresco + ordenNachos + "| Precio total: "
					+ String.valueOf(suma) + "$";
			return orden;
		}

		return orden;
	}

	/**
	 * Método que retorna el tipo de orden generada, ya sea algún comob o
	 * personalizada
	 */
	public String getTipo() {
		return tipodeOrden;
	}

	/**
	 * Método que retorna el costo total de la orden
	 */
	public double getTotal() {
		return precioTotal;
	}
}
