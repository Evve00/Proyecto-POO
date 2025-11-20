package com.cine.ClasesPrincipales;

public class Empleado extends Persona {

    private String turno;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno,
                    String nickname, String contraseña, String correo,
                    String celular, String edad, String turno) {

        super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad);
        this.turno = turno;
    }
}
