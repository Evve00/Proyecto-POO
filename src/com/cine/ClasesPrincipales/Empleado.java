package com.cine.ClasesPrincipales;

public class Empleado extends Persona {

    private String turno;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno,
                    String nickname, String contraseña, String correo,
                    String celular, String edad, String turno) {

        super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
           "Turno: " + turno + "\n";
}
// }package com.cine.ClasesPrincipales;

// public class Empleado extends Persona {

//     private String turno;

//     public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno,
//                     String nickname, String contraseña, String correo,
//                     String celular, String edad, String turno) {

//         super(nombre, apellidoPaterno, apellidoMaterno, nickname, contraseña, correo, celular, edad);
//         this.turno = turno;
//     }

//     public String getTurno() {
//         return turno;
//     }

//     public void setTurno(String turno) {
//         this.turno = turno;
//     }

// }

