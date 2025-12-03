package com.cine.ClasesPrincipales;
import java.util.Scanner;
import java.util.ArrayList;

public class Cliente extends Persona {
    Scanner entrada = new Scanner(System.in);
    private String tarjeta;
    ArrayList<Boleto>historial= new ArrayList<>();

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno,
                   String nickname, String contraseña, String correo,
                   String celular, String edad, String tarjeta) {

        super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad);
        this.tarjeta = tarjeta;
    }
    public void compra(Boleto unBoleto){
        historial.add(unBoleto);
    }

    public Cliente(){
        super(null,null,null,null,null,null,null,null);
        this.tarjeta = null;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    public void mostrarBoletos(){
        for(Boleto f:historial){
            System.out.println(f.toString());
        }
    }
    public void mostrarFunciones(){
        int i =0;
        for(Boleto s:historial){
            System.out.println(i+":"+s.getNombreDeLaPelicula());
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Seleccione una opcion para ver informacion completa:");
        int j = entrada.nextInt();
        System.out.println(historial.get(j).toString());
    }



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
           "Tarjeta: " + tarjeta + "\n";
    }

}
