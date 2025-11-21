package com.cine.ClasesPrincipales;

public class Administrador extends Empleado {

    private String tipoAdmin;

    public Administrador(String nombre, String apellidoPaterno, String apellidoMaterno,
                         String nickname, String contraseña, String correo,
                         String celular, String edad, String turno, String tipoAdmin) {

        super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad, turno);
        this.tipoAdmin = tipoAdmin;
    }

    public String getTipoAdmin() {
        return tipoAdmin;
    }

    public void setTipoAdmin(String tipoAdmin) {
        this.tipoAdmin = tipoAdmin;
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
           "Tipo de administrador: " + tipoAdmin + "\n";
    }
}
