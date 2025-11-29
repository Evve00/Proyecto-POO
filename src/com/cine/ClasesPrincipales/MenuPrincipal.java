package com.cine.ClasesPrincipales;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuPrincipal{
    ArrayList<String>contraseñas = new ArrayList<>();
    ArrayList<String>Usuarios = new ArrayList<>();

    Scanner entrada = new Scanner(System.in);


    public void menuInicio(){
    	int eleccion;
    	Cliente elCliente = new Cliente();
        //ArrayList<Cliente>lista = new ArrayList<>();

        System.out.println("Inicio");
        System.out.println("1.- Nuevo registro de cliente.");
        System.out.println("2.- Ingreso al sistema.");
        eleccion = entrada.nextInt();

        if (eleccion == 1){
        	menuNuevoRegistroDeCliente(elCliente);
        }else if(eleccion ==2){


        }else{
            System.out.println("Opcion invalida....");
        }

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
        System.out.println("Son correctos los datos ingresados? :");
        System.out.println(unCliente.toString());
        Respuesta = entrada.nextLine();

        for(String validar:contraseñas){
            if(unCliente.getContraseña().equalsIgnoreCase(validar)){
                System.out.println("esa contrasena ya existe porfavor ingrese otra");
                bandera = true;
                break;
            }

        }
        
        for(String validar:Usuarios){
            if(unCliente.getNickname().equalsIgnoreCase(validar)){
                System.out.println("ese usuario ya existe porfavor ingrese otra");
                bandera = true;
                break;
            }
        }

    }while(Respuesta.equalsIgnoreCase("no") || bandera==true);
    contraseñas.add(unCliente.getContraseña());
    Usuarios.add(unCliente.getNickname());
    Registros unrRegistro = new Registros();
    unrRegistro.Registro(unCliente); 
}

}
