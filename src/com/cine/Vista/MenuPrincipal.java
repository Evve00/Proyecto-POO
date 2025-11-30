package com.cine.Vista;
import com.cine.ClasesPrincipales.Cliente;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
public class MenuPrincipal{
    // pa verificar si exixten los usuarios, siendo las claves sus contraseñas
    Hashtable<String,String>Consulta = new Hashtable<>();

    Scanner entrada = new Scanner(System.in);


    public void menuInicio(){
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

         for(String contraseña:Consulta.keySet()){
            if(unCliente.getContraseña().equalsIgnoreCase(contraseña)){
                System.out.println("esa contrasena ya existe porfavor ingrese otra");
                bandera = true;
                break;
            }
             System.out.println(Consulta.get(contraseña));
                String usuario= Consulta.get(contraseña);
                if(unCliente.getNickname().equalsIgnoreCase(usuario)){
                System.out.println("ese usuario ya existe porfavor ingrese otro");
                bandera = true;
                break;
        }
    }// del for
        
        
    }while(Respuesta.equalsIgnoreCase("no") || bandera==true);
    Consulta.put(unCliente.getContraseña(),unCliente.getNickname());
    try{
    Registros unrRegistro = new Registros();
    unrRegistro.Registro(unCliente);
   Thread.sleep(5000);
    }catch(InterruptedException e){
        System.out.println(e.toString());
    }// del catch 

    System.out.println("La informacion se aguardo correctamente:)");
   }

   public void IngresoAlSistema(){
    String contraseña, nickname;
    boolean bandera = true;
    entrada.nextLine();

    if(Consulta.size() == 0){
        System.out.println("Aun no hay ningun usuario registrado");
    }

    else{
    do{
    System.out.println("-----------------------Login---------------------------");
    System.out.println("Nickname:");
    nickname = entrada.nextLine();
    System.out.println("Contraseña:");
    contraseña = entrada.nextLine();
    if(Consulta.containsKey(contraseña)){
        if(Consulta.get(contraseña).equalsIgnoreCase(nickname)){
            System.out.println("se loguea xd");
            bandera = false;
            break;
        }else{
            System.out.println("La contrasenia no corresponde al usuario..");
            bandera = true;
        }// del else si el usuario esta mal
    }else{
        System.out.println("Verifique que su contrasenia este bien...");
        bandera= true;
    }// del else si es que la contrasenia esta mal
    }while(bandera);

    }//del else para verificar si la hay usuarios registrados
   }// del metodo


}
