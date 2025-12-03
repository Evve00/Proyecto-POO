package com.cine.Controlador;

import com.cine.ClasesPrincipales.*;

import java.util.StringTokenizer;
import java.time.LocalDateTime;

/**
 * Clase que controlará todas las clases para generar y atender una orden de
 * dulceria
 * 
 * @author Jiménez Martínez Fabricio
 * @author Cortés Hernández Aldo Eduardo
 * @author Maldonado Rodrigez Ángel Daniel
 * @author Cruz Crispín Uriel
 * @author Barrancos Parada Tiago
 * @author Romero Sánchez Ulises Uriel
 * @version 1.0
 */

public class ControlDulceria {

    HiloCarga carga = new HiloCarga();
    HiloPago pago = new HiloPago(carga);
    OrdenDulceria dulceria = new OrdenDulceria();
    private String codigo;
    String ordenFinal;
    private Vendedor vendedorActual;

    /**
     * Método constructor para establecer el objeto vendedor
     * 
     * @param vendedor El objeto de tipo vendedor
     */
    public ControlDulceria(Vendedor vendedor) {
        this.vendedorActual = vendedor;
    }

    /**
     * Método para establecer el objeto vendedor
     * 
     * @param nuevoVendedor El nuevo objeto de tipo vendedor
     */
    public void setVendedor(Vendedor nuevoVendedor) {
        this.vendedorActual = nuevoVendedor;
    }

    /**
     * Método para generar el codigo de la compra
     * 
     * @param nombr      Nombre del cliente
     * @param apellidoPP Apellido paterno del cliente
     * @param apellidoMM Apelliido materno del cliente
     */
    public void generarCodigo(String nombr, String apellidoPP, String apellidoMM) {
        LocalDateTime actual = LocalDateTime.now();

        StringTokenizer division = new StringTokenizer(nombr, " ");
        String no1 = "";
        while (division.hasMoreTokens()) {
            String particion = division.nextToken();
            String inicial = String.valueOf(particion.charAt(0));
            no1 = no1 + inicial;
        }
        String ap1, ap2;
        if (apellidoPP != null && apellidoPP.length() > 0) {
            ap1 = String.valueOf(apellidoPP.charAt(0));
        } else {
            ap1 = "X";

        }
        if (apellidoMM != null && apellidoMM.length() > 0) {
            ap2 = String.valueOf(apellidoMM.charAt(0));
        } else {
            ap2 = "X";

        }

        int anio = actual.getYear();
        int mes = actual.getMonthValue();
        int dia = actual.getDayOfMonth();
        int hora = actual.getHour();
        int minuto = actual.getMinute();

        this.codigo = no1 + ap1 + ap2 + ":" + anio + mes + dia + ":" + hora + minuto;
    }

    /**
     * Método que obtiene el código de compra generado
     * 
     * @return codigo de compra
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método que obtiene el tipo de compra hecha
     * 
     * @return tipo de pedido
     */
    public String obtenerTipo() {
        String tipo = dulceria.getTipo();
        return tipo;
    }

    /**
     * Método que retorna un String de un resumen de la orden
     * 
     * @return resumen de orden
     */
    public String getOrden() {
        return ordenFinal;
    }

    /**
     * Método que imprime el genera la orden, la imprime junto con el codigo,hace el
     * cobro y maneja al objeto vendedor para que atienda la orden
     * 
     * @param nombre    Nombre del cliente
     * @param apellidoP Apellido paterno del cliente
     * @param apellidoM Apellido materno del cliente
     */
    public void obtenerOrden(String nombre, String apellidoP, String apellidoM) {
        String orden1;
        dulceria.generarOrden();
        System.out.println("Precio a pagar: " + dulceria.getTotal());
        System.out.println("Inserte su tarjeta bancaria");

        try {
            pago.start();
            pago.join();

        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        orden1 = dulceria.retornarOrden();
        StringTokenizer imprime = new StringTokenizer(orden1, "|");
        System.out.println("Orden: ");

        while (imprime.hasMoreTokens()) {
            System.out.println(imprime.nextToken());
        }

        generarCodigo(nombre, apellidoP, apellidoM);
        System.out.println("Codigo: " + this.codigo);
        // Checar que n o este vacio
        String nicknameCliente = "";
        if (nombre != null) {
            if (nombre.length() > 0) {
                nicknameCliente = nicknameCliente + nombre.charAt(0);
            }
        }
        if (apellidoP != null) {
            if (apellidoP.length() > 0) {
                nicknameCliente = nicknameCliente + apellidoP.charAt(0);
            }
        }
        if (nicknameCliente.equals("")) {
            nicknameCliente = "Esta vacioooooooooooo aaaaaa";
        }

        vendedorActual.atenderPedido(dulceria, this.codigo, nicknameCliente);
        System.out.println("Revisa la seccio de notificaciones para saber cuando tu orden este lista =)");
        this.ordenFinal = orden1;
    }
}