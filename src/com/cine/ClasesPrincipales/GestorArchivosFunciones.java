package com.cine.ClasesPrincipales;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.cine.ClasesPrincipales.*;
import com.cine.Controlador.ControlBoletosCartelera;

public class GestorArchivosFunciones {

    private static final String RUTA_BASE = "ArchivosAplicacion" + File.separator;// Para linux

    public static void guardarFuncionesPorFecha(LocalDate fecha, List<Funcion> funciones) {
        String nombreArchivo = "funciones_" + fecha.toString() + ".txt";
        File archivo = new File(RUTA_BASE + nombreArchivo);

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {

            for (Funcion f : funciones) {

                if (f.getFecha().equals(fecha)) {
                    pw.println("SALA:" + f.getSala().getTipoDeSala());
                    pw.println(f.getClaveFuncion());
                    pw.println("Pelicula=" + f.getPelicula().getNombreDeLaPelicula());
                    pw.println("Generos=" + f.getPelicula().getGeneros());
                    pw.println("Sinopsis=" + f.getPelicula().getSinopsis());
                    pw.println("Duracion=" + f.getPelicula().getDuracion());
                    pw.println("Fecha=" + f.getFecha());
                    pw.println("Hora=" + f.getHorario().format(DateTimeFormatter.ofPattern("HHmm")));
                    pw.println("Asientos=");

                    // imprime cada asiento y si ya se vendió
                    for (Boleto b : f.getBoletosTotales()) {

                        boolean vendido = false;

                        // Recorre la lista de boletos vendidos y compara con un boleto.
                        for (Boleto v : f.getBoletosVendidos()) {
                            if (v.getAsiento().equals(b.getAsiento())) {
                                vendido = true;
                                break;
                            }
                        }

                        if (vendido) {
                            pw.println(b.getAsiento() + ":Vendido");
                        } else {
                            pw.println(b.getAsiento() + ":Libre");
                        }
                    }

                    pw.println(""); // separación entre funciones
                }

            }

        } catch (IOException e) {
            System.out.println("Error guardando funciones: " + e.getMessage());
        }
    }
    // solo necesita a el objeto de tipo control para cargar datos, los busca en el
    // directorio

    public static void cargarDatos(ControlBoletosCartelera control) {
        File carpeta = new File(RUTA_BASE);

        // Filtra solo los archivos de funciones
        File[] archivos = carpeta.listFiles((dir, name) -> name.startsWith("funciones_") && name.endsWith(".txt"));

        if (archivos != null) {
            for (File archivo : archivos) {
                cargarArchivoIndividual(archivo, control);
            }
        }
    }

    // carga todas las funciones(peliculas y boletos) que estan en los archivos
    private static void cargarArchivoIndividual(File archivo, ControlBoletosCartelera control) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("SALA:")) {

                    // 1. Leerlos datos
                    String tipoSala = linea.substring(5).trim();
                    String idFuncion = br.readLine();

                    String nombrePeli = extraerValor(br.readLine());
                    String generos = extraerValor(br.readLine());
                    String sinopsis = extraerValor(br.readLine());
                    String duracion = extraerValor(br.readLine());

                    String fechaStr = extraerValor(br.readLine());
                    String horaStr = extraerValor(br.readLine());

                    // Buscamos si la película ya existe en el sistema para no duplicarla
                    Pelicula pelicula = null;
                    boolean existe = false;

                    for (Pelicula p : control.getPeliculas()) {
                        if (p.getNombreDeLaPelicula().equalsIgnoreCase(nombrePeli)) {
                            pelicula = p; // Usamos la existente
                            existe = true;
                            break;
                        }
                    }

                    // Si no existe, la creamos y registramos
                    if (!existe) {
                        pelicula = new Pelicula(nombrePeli, generos, sinopsis, duracion);
                        control.registrarPelicula(pelicula);
                    }

                    Sala sala = null;
                    switch (tipoSala.toUpperCase()) {
                        case "A":
                            sala = new SalaA();
                            break;
                        case "B":
                            sala = new SalaB();
                            break;
                        case "VIP":
                            sala = new SalaVip();
                            break; // Asegúrate que tu clase se llama SalaVip o SalaVIP
                        default:
                            sala = new SalaA();
                            break; // Default por seguridad
                    }

                    // Conversiones de tipos
                    LocalDate fecha = LocalDate.parse(fechaStr);
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HHmm");
                    LocalTime hora = LocalTime.parse(horaStr, formatoHora);

                    // 4. Crear funcion
                    Funcion funcion = new Funcion(sala, pelicula, fecha, hora);
                    funcion.setClaveFuncion(idFuncion);

                    String cabeceraAsientos = br.readLine();
                    if (cabeceraAsientos != null && cabeceraAsientos.startsWith("Asientos=")) {
                        while (true) {
                            br.mark(200);
                            String lineaAsiento = br.readLine();
                            if (lineaAsiento == null || lineaAsiento.trim().isEmpty()) {
                                break;
                            }
                            String[] partes = lineaAsiento.split(":");
                            if (partes.length == 2 && partes[1].equalsIgnoreCase("Vendido")) {
                                funcion.venderBoleto(partes[0]);
                            }
                        }
                    }

                    // Agregamos la función cargada
                    control.getFunciones().add(funcion);
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando archivo " + archivo.getName() + ": " + e.getMessage());
        }
    }

    // Método para obtener el valor después del =
    private static String extraerValor(String linea) {
        if (linea != null && linea.contains("=")) {
            String[] partes = linea.split("=", 2);
            return partes.length > 1 ? partes[1] : "";
        }
        return "";
    }
}
