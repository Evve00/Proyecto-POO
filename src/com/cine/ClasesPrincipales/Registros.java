package com.cine.ClasesPrincipales;
import java.io.*;
public class Registros{
    public void Registro(Cliente unCliente){
       try{
        File ArchivoDestino = new File("Registro.txt");
        FileWriter flujoSalida = new FileWriter(ArchivoDestino,true);
        BufferedWriter buffer = new BufferedWriter(flujoSalida);
        PrintWriter objetoEscritor = new PrintWriter(buffer);
        objetoEscritor.printf("%s:%s:%s:%s:%s:%s:%s:%s %n",unCliente.getNombre(),unCliente.getApellidoPaterno(),unCliente.getApellidoMaterno(),unCliente.getEdad(),unCliente.getNickname(),unCliente.getContraseña(),unCliente.getCorreo(),unCliente.getCelular());
        objetoEscritor.close();
       } catch(IOException e){
        System.out.println(e.toString());
       }

    }
}