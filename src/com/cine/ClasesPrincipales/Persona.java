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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
