package com.cine.Vista;
import com.cine.ClasesPrincipales.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
public class MenuPrincipal{
    Hashtable<String, Persona> usuarios = new Hashtable<>();
    Administrador elAdmin = new Administrador("a", "a", "a", "elAdministrador", "3l4dm1n", "a", "a", "a", "a", "SI");
    Scanner entrada = new Scanner(System.in);

    public MenuPrincipal() {
        usuarios.put(elAdmin.getNickname(), elAdmin);  
        usuarios.put(elVendedor.getNickname(), elVendedor);
    }

    public void menuInicio(){
        do{
        int eleccion;
        Cliente elCliente = new Cliente();

        System.out.println("Inicio");
        System.out.println("1.- Nuevo registro de cliente.");
        System.out.println("2.- Ingreso al sistema.");
        eleccion = entrada.nextInt();

        if (eleccion == 1){
            menuNuevoRegistroDeCliente(elCliente);
        }else if(eleccion ==2){
            IngresoAlSistema();
        }else{
            System.out.println("Opcion invalida....");
        }
    }while(true);
    }

    public void menuNuevoRegistroDeCliente(Cliente unCliente){

        boolean bandera = true;
        String Respuesta;
        entrada.nextLine();

        do{
        bandera = false;
        System.out.println("Ingrese su nombre: ");
        unCliente.setNombre(entrada.nextLine());

        System.out.println("Ingrese su apellido paterno: ");
        unCliente.setApellidoPaterno(entrada.nextLine());

        System.out.println("Ingrese su apellido materno: ");
        unCliente.setApellidoMaterno(entrada.nextLine());

        System.out.println("Ingrese su edad: ");
        unCliente.setEdad(entrada.nextLine());

        System.out.println("Ingrese su nickname: ");
        unCliente.setNickname(entrada.nextLine());

        System.out.println("Ingrese su contraseña: ");
        unCliente.setContraseña(entrada.nextLine());

        System.out.println("Ingrese su correo electronico: ");
        unCliente.setCorreo(entrada.nextLine());

        System.out.println("Ingrese su numero de celular: ");
        unCliente.setCelular(entrada.nextLine());

        System.out.println("Ingrese su numero de tarjeta bancaria: ");
        unCliente.setTarjeta(entrada.nextLine());
        System.out.println("------------------------------------------------------");
        System.out.println(unCliente.toString());
        System.out.println("Son correctos los datos ingresados? :");

        Respuesta = entrada.nextLine();

if (usuarios.containsKey(unCliente.getNickname())) {
    System.out.println("Ese nickname ya existe, ingresa otro.");
    bandera = true;
}

for (Persona p : usuarios.values()) {
    if (p.getContraseña().equalsIgnoreCase(unCliente.getContraseña())) {
        System.out.println("Esa contraseña ya existe, ingresa otra.");
        bandera = true;
        break;
    }
}

        
        
    }while(Respuesta.equalsIgnoreCase("no") || bandera==true);
    usuarios.put(unCliente.getNickname(), unCliente);

    try{
    Registros unrRegistro = new Registros();
    unrRegistro.Registro(unCliente);
   Thread.sleep(5000);
    }catch(InterruptedException e){
        System.out.println(e.toString());
    }// del catch 

    System.out.println("La informacion se aguardo correctamente:)");
   }

public void IngresoAlSistema() {
    String contraseña, nickname;
    entrada.nextLine();

    if (usuarios.size() == 0) {
        System.out.println("Aun no hay ningún usuario registrado");
        return;
    }

    while (true) {
        System.out.println("-----------------------Login---------------------------");
        System.out.println("Nickname:");
        nickname = entrada.nextLine();

        System.out.println("Contraseña:");
        contraseña = entrada.nextLine();

        if (usuarios.containsKey(nickname)) {

            Persona p = usuarios.get(nickname);

            if (p.getContraseña().equals(contraseña)) {

                System.out.println("Inicio de sesión exitoso.\n");

                if (p instanceof Administrador) {
                    menuAdministrador((Administrador)p);
                } else if (p instanceof Vendedor) {
                    menuVendedor((Vendedor)p);
                } else if (p instanceof Cliente) {
                    menuCliente((Cliente)p);
                }

                break;

            } else {
                System.out.println("Contraseña incorrecta.");
            }

        } else {
            System.out.println("El nickname no existe.");
        }
    }
}

public void menuAdministrador(Administrador admin) {
    System.out.println("=== MENU ADMINISTRADOR ===");
    System.out.println("1. Registrar nuevo administrador");
    System.out.println("2. Registrar nuevo vendedor");
    System.out.println("3. Ver usuarios");
    System.out.println("4. Salir");
}

public void menuVendedor(Vendedor vendedor) {
    System.out.println("=== MENU VENDEDOR ===");
    System.out.println("Aquí van las opciones del vendedor...");
}

public void menuCliente(Cliente cliente) {
    System.out.println("=== MENU CLIENTE ===");
    System.out.println("Aquí van las opciones del cliente...");
}
}
