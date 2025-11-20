package com.cine.ClasesPrincipales;

public abstract class Persona {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nickname;
    private String contraseña;
    private String correo;
    private String celular;
    private String edad;

    public Persona() {
        this.nombre = "Si ves esto es pq algo hicimos mal:c";
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno,
                   String nickname, String contraseña, String correo,
                   String celular, String edad) {

        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.correo = correo;
        this.celular = celular;
        this.edad = edad;
    }

}


