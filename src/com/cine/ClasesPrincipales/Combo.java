/**
  * Clase que une los productos individuales en un combo
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

public class Combo {
    Scanner entrada = new Scanner(System.in);
    String tipo;
    Producto unProducto = new Producto();
    Precios unPrecio = new Precios();
    double precioTotal;
    String ordenFinal;
    int ban = 0;

    /**
     * Método que genera un productos de acuerdo al combo Amix
     */
    public void comboAmix() {
        int sab;
        String sabo = "", sabo2 = "";
        unPrecio.CalcularPrecios();
        this.tipo = "Combo Amix";
        while (ban == 0) {
            try {
                entrada.nextLine();
                ban = 1;
                do {
                    System.out.println("Que sabor de palomitas?(escribe el número correspondiente)");
                    System.out.println("|| 1-Mantequilla || 2-Queso  || 3-Jalapeño ||");
                    sab = entrada.nextInt();
                } while (sab > 3 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo = "Mantequilla";
                        break;
                    case 2:
                        sabo = "Queso";
                        break;
                    case 3:
                        sabo = "Jalapeño";
                        break;
                }

                do {
                    System.out.println("Que sabor de refresco?(escribe el número correspondiente)");
                    System.out.println("|| 1-Cola || 2-Cola-Light || 3-Naranja || 4-Manzana || 5-Toronja ||");
                    sab = entrada.nextInt();
                } while (sab > 5 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo2 = "Cola";
                        break;
                    case 2:
                        sabo2 = "Cola-Light";
                        break;
                    case 3:
                        sabo2 = "Naranja";
                        break;
                    case 4:
                        sabo2 = "Manzana";
                        break;
                    case 5:
                        sabo2 = "Toronja";
                        break;
                }

                unProducto.getPalomitas().setTam("Jumbo");
                unProducto.getPalomitas().setSab(sabo);
                unProducto.getPalomitas().setPre(unPrecio.precioPalJmb);
                unProducto.getPalomitas().setCan(1);

                unProducto.getRefresco().setTam("Jumbo");
                unProducto.getRefresco().setSab(sabo2);
                unProducto.getRefresco().setCan(2);
                unProducto.getRefresco().setPre(unPrecio.precioRefJmb * 2);

                int precioTotalTMP = unPrecio.precioPalJmb + unPrecio.precioRefJmb * 2;
                this.precioTotal = (unPrecio.precioPalJmb + unPrecio.precioRefJmb * 2) - (precioTotalTMP * 0.10);
                this.ordenFinal = "Palomitas y dos refrescos tamaño jumbo";
            } catch (InputMismatchException e) {
                ban = 0;
                System.out.println("Dato introducido erróneo");
                System.out.println("Vuelve a generar tu orden");
                System.out.println(e.toString());
                System.out.print("\n");

            }
        }
    }

    /**
     * Método que genera un productos de acuerdo al combo Nachos
     */
    public void comboNachos() {
        int sab;
        String sabo = "", sabo2 = "";
        unPrecio.CalcularPrecios();
        this.tipo = "Combo Nachos";
        while (ban == 0) {
            try {
                ban = 1;
                entrada.nextLine();
                do {
                    System.out.println("Que sabor de palomitas?(escribe el número correspondiente)");
                    System.out.println("|| 1-Mantequilla || 2-Queso  || 3-Jalapeño ||");
                    sab = entrada.nextInt();
                } while (sab > 3 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo = "Mantequilla";
                        break;
                    case 2:
                        sabo = "Queso";
                        break;
                    case 3:
                        sabo = "Jalapeño";
                        break;
                }

                do {
                    System.out.println("Que sabor de refresco?(escribe el número correspondiente)");
                    System.out.println("|| 1-Cola || 2-Cola-Light || 3-Naranja || 4-Manzana || 5-Toronja ||");
                    sab = entrada.nextInt();
                } while (sab > 5 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo2 = "Cola";
                        break;
                    case 2:
                        sabo2 = "Cola-Light";
                        break;
                    case 3:
                        sabo2 = "Naranja";
                        break;
                    case 4:
                        sabo2 = "Manzana";
                        break;
                    case 5:
                        sabo2 = "Toronja";
                        break;
                }

                unProducto.getPalomitas().setTam("Jumbo");
                unProducto.getPalomitas().setSab(sabo);
                unProducto.getPalomitas().setPre(unPrecio.precioPalJmb);
                unProducto.getPalomitas().setCan(1);

                unProducto.getRefresco().setTam("Jumbo");
                unProducto.getRefresco().setSab(sabo2);
                unProducto.getRefresco().setCan(2);
                unProducto.getRefresco().setPre(unPrecio.precioRefJmb * 2);

                unProducto.getNachos().setTam("Jumbo");
                unProducto.getNachos().setPre(unPrecio.precioNacJmb);
                unProducto.getNachos().setCan(1);

                int precioTotalTMP = unPrecio.precioPalJmb + unPrecio.precioRefJmb * 2 + unPrecio.precioNacJmb;
                this.precioTotal = (unPrecio.precioPalJmb + unPrecio.precioRefJmb * 2 + unPrecio.precioNacJmb)
                        - (precioTotalTMP * 0.10);
                this.ordenFinal = "Palomitas , dos refrescos y nachos tamaño jumbo";
            } catch (InputMismatchException e) {
                ban = 0;
                System.out.println("Dato introducido erróneo");
                System.out.println("Vuelve a generar tu orden");
                System.out.println(e.toString());
                entrada.nextLine();
                System.out.print("\n");
            }
        }
    }

    /**
     * Método que genera un productos de acuerdo al combo Buen Trio
     */
    public void comboBuenTrio() {
        int sab;
        String sabo = "", sabo2 = "";
        unPrecio.CalcularPrecios();
        this.tipo = "Combo Buen Trio";
        while (ban == 0) {
            try {
                entrada.nextLine();
                ban = 1;
                do {
                    System.out.println("Que sabor de palomitas?(escribe el número correspondiente)");
                    System.out.println("|| 1-Mantequilla || 2-Queso  || 3-Jalapeño ||");
                    sab = entrada.nextInt();
                } while (sab > 3 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo = "Mantequilla";
                        break;
                    case 2:
                        sabo = "Queso";
                        break;
                    case 3:
                        sabo = "Jalapeño";
                        break;
                }

                do {
                    System.out.println("Que sabor de refresco?(escribe el número correspondiente)");
                    System.out.println("|| 1-Cola || 2-Cola-Light || 3-Naranja || 4-Manzana || 5-Toronja ||");
                    sab = entrada.nextInt();
                } while (sab > 5 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo2 = "Cola";
                        break;
                    case 2:
                        sabo2 = "Cola-Light";
                        break;
                    case 3:
                        sabo2 = "Naranja";
                        break;
                    case 4:
                        sabo2 = "Manzana";
                        break;
                    case 5:
                        sabo2 = "Toronja";
                        break;
                }

                unProducto.getPalomitas().setTam("Mega");
                unProducto.getPalomitas().setSab(sabo);
                unProducto.getPalomitas().setPre(unPrecio.precioPalMeg);
                unProducto.getPalomitas().setCan(1);

                unProducto.getRefresco().setTam("Mega");
                unProducto.getRefresco().setSab(sabo2);
                unProducto.getRefresco().setCan(3);
                unProducto.getRefresco().setPre(unPrecio.precioRefMeg * 3);

                unProducto.getNachos().setTam("Mega");
                unProducto.getNachos().setPre(unPrecio.precioNacMeg);
                unProducto.getNachos().setCan(1);

                int precioTotalTMP = unPrecio.precioPalMeg + unPrecio.precioRefMeg * 3 + unPrecio.precioNacMeg;
                this.precioTotal = (unPrecio.precioPalMeg + unPrecio.precioRefMeg * 3 + unPrecio.precioNacMeg)
                        - (precioTotalTMP * 0.10);
            } catch (InputMismatchException e) {
                ban = 0;

                System.out.println("Dato introducido erróneo");
                System.out.println("Vuelve a generar tu orden");
                System.out.println(e.toString());
                entrada.nextLine();
                System.out.print("\n");
            }
        }
    }

    /**
     * Método que genera un productos de acuerdo al combo Que Me Ves
     */
    public void comboQueMeVes() {
        int sab;
        String sabo = "", sabo2 = "";
        unPrecio.CalcularPrecios();
        this.tipo = "Combo Que me ves";
        while (ban == 0) {
            try {
                entrada.nextLine();
                ban = 1;
                do {
                    System.out.println("Que sabor de palomitas?(escribe el número correspondiente)");
                    System.out.println("|| 1-Mantequilla || 2-Queso  || 3-Jalapeño ||");
                    sab = entrada.nextInt();
                } while (sab > 3 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo = "Mantequilla";
                        break;
                    case 2:
                        sabo = "Queso";
                        break;
                    case 3:
                        sabo = "Jalapeño";
                        break;
                }

                do {
                    System.out.println("Que sabor de refresco?(escribe el número correspondiente)");
                    System.out.println("|| 1-Cola || 2-Cola-Light || 3-Naranja || 4-Manzana || 5-Toronja ||");
                    sab = entrada.nextInt();
                } while (sab > 5 || sab < 1);
                switch (sab) {
                    case 1:
                        sabo2 = "Cola";
                        break;
                    case 2:
                        sabo2 = "Cola-Light";
                        break;
                    case 3:
                        sabo2 = "Naranja";
                        break;
                    case 4:
                        sabo2 = "Manzana";
                        break;
                    case 5:
                        sabo2 = "Toronja";
                        break;
                }

                unProducto.getPalomitas().setTam("Jumbo");
                unProducto.getPalomitas().setSab(sabo);
                unProducto.getPalomitas().setPre(unPrecio.precioPalJmb);
                unProducto.getPalomitas().setCan(1);

                unProducto.getRefresco().setTam("Jumbo");
                unProducto.getRefresco().setSab(sabo2);
                unProducto.getRefresco().setCan(1);
                unProducto.getRefresco().setPre(unPrecio.precioRefJmb);

                unProducto.getNachos().setTam("Jumbo");
                unProducto.getNachos().setPre(unPrecio.precioNacJmb);
                unProducto.getNachos().setCan(1);

                int precioTotalTMP = unPrecio.precioPalJmb + unPrecio.precioRefJmb + unPrecio.precioNacJmb;
                this.precioTotal = (unPrecio.precioPalJmb + unPrecio.precioRefJmb + unPrecio.precioNacJmb)
                        - (precioTotalTMP * 0.10);
            } catch (InputMismatchException e) {
                ban = 0;
                System.out.println("Dato introducido erróneo");
                System.out.println("Vuelve a generar tu orden");
                System.out.println(e.toString());
                System.out.print("\n");
                entrada.nextLine();
            }
        }
    }

    /**
     * Método que obtiene el producto generado por los combos
     * 
     * @return objeto Producto generado
     */
    public Producto getProductoCombo() {
        return unProducto;
    }
}
