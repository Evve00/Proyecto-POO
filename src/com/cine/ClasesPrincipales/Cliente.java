package com.cine.ClasesPrincipales;

public class Cliente extends Persona {

    private String tarjeta;

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno,
                   String nickname, String contraseña, String correo,
                   String celular, String edad, String tarjeta) {

        super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad);
        this.tarjeta = tarjeta;
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
