package com.cine.ClasesPrincipales;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase del vendedor de la dulceria
 * 
 * @author Jiménez Martínez Fabricio
 * @author Cortés Hernández Aldo Eduardo
 * @author Maldonado Rodrigez Ángel Daniel
 * @author Cruz Crispín Uriel
 * @author Barrancos Parada Tiago
 * @author Romero Sánchez Ulises Uriel
 * @version 1.0
 */

public class Vendedor extends Empleado {
    private String diaDescanso;
    private String archivoHistorial;

    /**
     * Método constructor que establece los datos del vendedor
     * 
     * @param nombre          Nombre del vendedor
     * @param apellidoPaterno Apellido paterno del vendedor
     * @param apellidoMaterno Apellido materno del vendedor
     * @param nickname        Nickname del vendedor
     * @param contraseña      Contraseña del vendedor
     * @param correo          Correo del vendedor
     * @param celular         Celular del vendedor
     * @param edad            Edad del vendedor
     * @param turno           Turno del vendedor
     * @param diaDescanso     Dia de descanso del vendedor
     */
    public Vendedor(String nombre, String apellidoPaterno, String apellidoMaterno, String nickname, String contraseña,
            String correo, String celular, String edad, String turno, String diaDescanso) {

        super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad, turno);
        this.diaDescanso = diaDescanso;
        this.archivoHistorial = "historial" + nickname + ".txt";
        crearArchivoHistorial();
    }

    /**
     * Método que obtiene el dia de descanso del vendedor
     * 
     * @return el día de descanso del vendedor
     */
    public String getDiaDescanso() {
        return diaDescanso;
    }

    /**
     * Método que hace que el vendedor atienda el pedido
     * 
     * @param orden           El objeto tipo OrdenDulceria que guarda la orden
     *                        solicitada por el cliente
     * @param codigoCompra    El codigo de la compra hecha por el cliente
     * @param nicknameCliente El nickname del cliente
     */
    public void atenderPedido(OrdenDulceria orden, String codigoCompra, String nicknameCliente) {
        Thread hiloPreparacion = new Thread(new Runnable() {
            public void run() {
                LocalDateTime fechaPedido = LocalDateTime.now();

                try {
                    int pausa1 = ThreadLocalRandom.current().nextInt(20000, 40000);
                    Thread.sleep(pausa1);
                    LocalDateTime fechaAsignacion = LocalDateTime.now();
                    actualizarHistorial("Pedido Aceptado", fechaAsignacion, orden.getTipo(), codigoCompra, fechaPedido);

                    int pausa2 = ThreadLocalRandom.current().nextInt(20000, 30000);
                    Thread.sleep(pausa2);
                    LocalDateTime fechaInicio = LocalDateTime.now();
                    actualizarHistorial("Se empezo apreparar tu pedido:)", fechaInicio, orden.getTipo(), codigoCompra,
                            fechaPedido);

                    int pausa3 = ThreadLocalRandom.current().nextInt(10000, 15000);
                    Thread.sleep(pausa3);
                    LocalDateTime fechaFin = LocalDateTime.now();
                    actualizarHistorial("Se termino el pedido", fechaFin, orden.getTipo(), codigoCompra, fechaPedido);

                    actualizarNotificacionCliente(nicknameCliente, codigoCompra, fechaFin);
                } catch (InterruptedException e) {
                    System.out.println("Error en la preparacion:( " + e.getMessage());
                }
            }
        });// Llave del atender pedido

        hiloPreparacion.start();
    }

    /**
     * Método que accede al archivo txt para registrar el historial de pedidos
     * 
     * @param estado       estado de la compra
     * @param fechaHora    hora en la que se generó la compra
     * @param tipoOrden    Tipo de orden realizada
     * @param codigoCompra El codigo de la compra generada
     * @param fechaPedido  La fecha en que se realizo el pedido
     */
    private void actualizarHistorial(String estado, LocalDateTime fechaHora, String tipoOrden, String codigoCompra,
            LocalDateTime fechaPedido) {
        try (FileWriter fw = new FileWriter(archivoHistorial, true);
                BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(estado);
            bw.newLine();

            if (estado.equals("Pedido Aceptado")) {
                bw.write("---------------------------------------------------------\n"); // Slto pq si no sale pegado
                bw.write("Fecha y hora de la realizacion del pedido: " + fechaPedido);
                bw.newLine();
            }

            bw.write("Fecha y hora de " + estado.toLowerCase() + ": " + fechaHora);
            bw.newLine();
            bw.write("Tipo de orden: " + tipoOrden);
            bw.newLine();
            bw.write("Codigo de la orden: " + codigoCompra);
            bw.newLine();
            bw.write("---------------------------------------------------------");
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al actualizar historial: " + e.getMessage());
        }
    }

    /**
     * Método que actualiza las notificaciones del cliente
     * 
     * @param nicknameCliente  El nickname del cliente
     * @param codigoCompra     El codigo de la compra generada
     * @param fechaTerminacion Fecha en que se terminó de preparar la compra/pedido
     */
    private void actualizarNotificacionCliente(String nicknameCliente, String codigoCompra,
            LocalDateTime fechaTerminacion) {
        String archivoNotificacion = "notificacion" + nicknameCliente + ".txt";

        try (FileWriter fw = new FileWriter(archivoNotificacion);
                BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Holaaaaaa soy " + getNombre() + " " + getApellidoPaterno()
                    + " ya esta listo tu pedido, puedes parar a recogerlo:)");

            String fechaReiniciada = fechaTerminacion.getYear()
                    + String.format("%02d", fechaTerminacion.getMonthValue())
                    + String.format("%02d", fechaTerminacion.getDayOfMonth()) + ":"
                    + String.format("%02d", fechaTerminacion.getHour())
                    + String.format("%02d", fechaTerminacion.getMinute());
            bw.write(fechaReiniciada);

        } catch (IOException e) {
            System.out.println("Error al actualizar la notificacion: " + e.getMessage());
        }
    }

    /**
     * Método que genera el archivo para guardar el historial de los pedidos
     */
    private void crearArchivoHistorial() {
        try {
            File archivo = new File(archivoHistorial);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear archivo del historial: " + e.getMessage());
        }
    }

    /**
     * Método que regresará los datos del cliente
     * 
     * @return datos del cliente
     */
    @Override
    public String toString() {
        return "Cliente:\n" +
                "Nombre: " + getNombre() + "\n" +
                "Apellido Paterno: " + getApellidoPaterno() + "\n" +
                "Apellido Materno: " + getApellidoMaterno() + "\n" +
                "Nickname: " + getNickname() + "\n" +
                "Contraseña: " + getContraseña() + "\n" +
                "Correo: " + getCorreo() + "\n" +
                "Celular: " + getCelular() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Turno: " + getTurno() + "\n" +
                "Dia de descanso: " + diaDescanso + "\n";
    }
}