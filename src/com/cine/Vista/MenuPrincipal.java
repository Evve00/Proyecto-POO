package com.cine.Vista;
import com.cine.ClasesPrincipales.*;
import com.cine.Controlador.*;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
public class MenuPrincipal{
    Hashtable<String, Persona> usuarios = new Hashtable<>();
    Administrador elAdmin = new Administrador("a", "a", "a", "elAdministrador", "3l4dm1n", "a", "a", "a", "a", "SI");
    Scanner entrada = new Scanner(System.in);
    ControlBoletosCartelera unBoleto = new ControlBoletosCartelera();


    public MenuPrincipal() {
        usuarios.put(elAdmin.getNickname(), elAdmin);  
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
    int opcion;

    while (true) {
        System.out.println("=== MENU ADMINISTRADOR ===");
        System.out.println("1. Dar de alta una pelicula");
        System.out.println("2. Dar de alta una funcion");
        System.out.println("3. Registrar una nueva cuenta de empleado");
        System.out.println("4. Ver las películas para las que un cliente ha comprado boletos");
        System.out.println("5. Salir de sesión");

        opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                // método para registrar pelicula
                System.out.println("Dar de alta una película...");
            
                break;

            case 2:
                // método para registrar función
                System.out.println("Dar de alta una función...");
                break;

            case 3:
                // registrar cuenta de vendedor o admin
                System.out.println("Registrar una nueva cuenta de empleado...");
                break;

            case 4:
                // ver películas compradas por un cliente
                System.out.println("Ver películas compradas por un cliente...");
                break;

            case 5:
                System.out.println("Cerrando sesión...");
                return; // regresa al menú principal

            default:
                System.out.println("Opción inválida.");
        }
    }
}


public void menuVendedor(Vendedor vendedor) {
    int opcion;

    while (true) {
        System.out.println("=== MENU VENDEDOR ===");
        System.out.println("1.- Mostrar lista de peliculas programadas");
        System.out.println("2.- Salir de sesión");

        opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                // mostrar películas programadas
                System.out.println("Mostrando lista de películas programadas...");
                break;

            case 2:
                System.out.println("Cerrando sesión...");
                return;

            default:
                System.out.println("Opción inválida.");
        }
    }
}


public void menuCliente(Cliente cliente) {
    ArrayList <Funcion>Tem = new ArrayList<>();

    int opcion;
    // pruebas....
  //  ControlBoletosCartelera unBoleto = new ControlBoletosCartelera();
   Pelicula unPelicula = new Pelicula("resplandor", "misterio", "Se mueren todos", "02:30");
   Pelicula otraPelicula = new Pelicula("IT", "terror", "Se come a los ninios", "01:40");
    SalaA sala = new SalaA();
    try{
       unBoleto.registrarFuncion(unPelicula, sala, LocalDate.of(2000,5,3), LocalTime.of(13,0,0)); 
       unBoleto.registrarFuncion(otraPelicula, sala, LocalDate.of(2026,9,5), LocalTime.of(12, 0, 0));
    }catch(ExcepcionFunciones e){
        System.out.println(e.toString());
    }
        // peliculas de pruebaas...

    while (true) {
        System.out.println("=== MENU CLIENTE ===");
        System.out.println("1.- Mostrar lista de peliculas programadas");
        System.out.println("2.- Compra de boletos para una funcion");
        System.out.println("3.- Comprar en dulcería");
        System.out.println("4.- Revisar notificaciones");
        System.out.println("5.- Salir de sesión");

        opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                int Opcion;
                String Respuesta;
                do{
                System.out.println("Mostrando lista de películas programadas...");
                unBoleto.mostrarPeliculasProgramadas();
                System.out.println("Opcion:");
                if(entrada.hasNextInt()){// pa ver que escribe
                    Opcion = entrada.nextInt();
                    unBoleto.mostrarInformacionPeliculas(Opcion);
                    System.out.println("Presione enter para seguir.......");
                    entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("------------------------------------------------------");
                }else{
                Respuesta = entrada.nextLine();
                if(Respuesta.equalsIgnoreCase("Regresar")){
                    break;
                }// del if regresar
                else{
                    System.out.println("Opcion invalida");
                }
            }// del else
            }while (true);
                break;

            case 2:
                int num;
                //ArrayList <Funcion>Tem = new ArrayList<>();
                System.out.println("Compra de boletos...");
                System.out.println("Para que fecha desea comprar las entradas (AAAA-MM-DD):");
                String Fecha= entrada.nextLine();
                LocalDate fecha = LocalDate.parse(Fecha);

                Tem = unBoleto.mostrarFuncionesProgamadasParaUnaFecha(fecha);
                
                System.out.println("------------------------------------------------------");
                
                System.out.println("Ingrese el numero de la pelicula para comprar boletos \nIngrese 0 si desea regresar:");
                
                num =entrada.nextInt();
                
                entrada.nextLine();
                
                if(num == 0){
                    break;
                }else{

                    if(Tem.get(num-1).getSala() instanceof SalaA){
                        boolean bandera;
                        do{
                      unBoleto.mostrarAsientosSalaA(Tem.get(num-1));
                       System.out.println("Ingrese los asientos que desea comprar, Ejemplo (H7, H8, H9):");

                      String asientos = entrada.nextLine();
                      bandera =unBoleto.comprarBoletos(Tem.get(num-1),asientos);
                    }while(bandera);
                }
                    if(Tem.get(num-1).getSala() instanceof SalaB){
                        boolean bandera;
                        do{
                         unBoleto.mostrarAsientosSalaB(Tem.get(num-1));
                         System.out.println("Ingrese los asientos que desea comprar, Ejemplo (H7, H8, H9):");

                         String asientos = entrada.nextLine();
                         bandera =unBoleto.comprarBoletos(Tem.get(num-1),asientos);
                    }while(bandera);
                }
                    if(Tem.get(num-1).getSala() instanceof SalaVip){
                        boolean bandera;
                        do{
                         unBoleto.mostrarAsientosSalaVip(Tem.get(num-1));
                         System.out.println("Ingrese los asientos que desea comprar, Ejemplo (H7, H8, H9):");
                         String asientos = entrada.nextLine();
                         bandera =unBoleto.comprarBoletos(Tem.get(num-1),asientos);
                    }while(bandera);
                }
                 
                }
                break;

            case 3:
                System.out.println("Comprando en dulcería...");
                break;

            case 4:
                System.out.println("Revisando notificaciones...");
                break;

            case 5:
                System.out.println("Cerrando sesión...");
                return;

            default:
                System.out.println("Opción inválida.");
        }
    }
}

}