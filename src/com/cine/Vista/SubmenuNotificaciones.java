package com.cine.Vista;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.cine.ClasesPrincipales.Cliente;

public class SubmenuNotificaciones {
    public void mostrarSubmenu(Cliente uncliente) {
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
                System.out.println("Mostrando lista de funciones compradas...");
                uncliente.mostrarFunciones(); // Placeholder

                break;
            case "B":
                // controlDulceria.verEstadoDulceria(usuarioActual);
                System.out.println("Mostrando estado de pedidos de dulcería...");// Placeholder
                String clv =uncliente.mostrarclv();
                File archivo = new File(uncliente.getArchv());
                
               boolean terminado = false;
              String fechaTerminado = "";

                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {

            // Si encuentra la línea de terminado, activamos la bandera
            if (linea.contains("Se termino el pedido")) {
                try(BufferedReader leer = new BufferedReader(new FileReader(uncliente.getNotf()))){
                    String leida;
                    while ((leida = leer.readLine()) != null) {
                        System.out.println(leida);
                    }


                }catch(IOException e){
                        System.out.println(e.toString());
                    }

                terminado = true;
            }

            // Si ya encontró "Se termino..." ahora busca la fecha
            if (linea.contains("Fecha y hora de se termino el pedido:")) {
                fechaTerminado = linea.replace("Fecha y hora de se termino el pedido:", "").trim();
            }
        }

        // Mostrar mensaje según estado
        if (terminado) {
            System.out.println("✔ Tu pedido ya está terminado.");
            System.out.println("Fecha de finalización: " + fechaTerminado);
        } else {
            System.out.println("⌛ Estamos trabajando en tu pedido, por favor espera...");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

                

                break;
            case "R":
                continuar = false;
                break;
            default:
                System.out.println("Opción no válida.");
        }

    }
}


