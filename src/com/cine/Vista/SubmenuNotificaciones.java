package com.cine.Vista;

import java.util.Scanner;

public class SubmenuNotificaciones {
    public void mostrarSubmenu() {
        boolean continuar = true;
        Scanner entrada = new Scanner(System.in);
        String opcion;
        System.out.println("A .Revisar ordenes de compra para una funcion");
        System.out.println("B .Revisar notificaciones de dulcería.");
        System.out.println("C .Regresar al menu principal.");
        opcion = entrada.nextLine();
        switch (opcion) {
            case "A":
                // controlUsuario.mostrarHistorialBoletos(usuarioActual);
                System.out.println("Mostrando lista de funciones compradas..."); // Placeholder
                break;
            case "B":
                // controlDulceria.verEstadoDulceria(usuarioActual);
                System.out.println("Mostrando estado de pedidos de dulcería..."); // Placeholder
                break;
            case "R":
                continuar = false;
                break;
            default:
                System.out.println("Opción no válida.");
        }

    }

}
