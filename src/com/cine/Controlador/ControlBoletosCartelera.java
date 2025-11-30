package com.cine.Controlador;

import com.cine.ClasesPrincipales.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ControlBoletosCartelera {
    private List<Pelicula> peliculas;
    private List<Funcion> funciones;

    public ControlBoletosCartelera() {
        peliculas = new ArrayList<>();
        funciones = new ArrayList<>();
    }

    /**
     * Metodo para registrar peliculas
     * Punto 6.1
     * 
     * @param Pelicula objeto de tipo Pelicula
     */
    public void registrarPelicula(Pelicula p) {
        peliculas.add(p);
    }

    /**
     * Metodo para mostrar peliculas al admin
     * Punto 6.2
     */

    public void mostrarPeliculas() {
        int i = 1;
        for (Pelicula p : peliculas) {
            System.out.println(i + ". " + p.getNombreDeLaPelicula());
            i++;
        }
    }

    /**
     * Metodo para mostrar las funciones segun una fecha dada y una sala dada
     * Punto 6.2
     * 
     * @param fecha recibe una fecha, que es un objeto de tipo LocalDate
     * @param Sala  recibe la sala para comparar con las funciones existentes
     */

    public void mostrarFuncionesPorFecha(Sala sala, LocalDate fecha) {
        System.out.println("Funciones programadas:");

        for (Funcion f : funciones) {
            if (f.getFecha().equals(fecha) && f.getSala().getTipoDeSala().equals(sala.getTipoDeSala())) {
                System.out.println(". " + f.toString());
                System.out.println("--------------------");
            }
        }
    }

    /**
     * Metodo para dar de alta una funcion, revisa que no haya otra en la misma sala
     * en el mismo horario
     * Punto 6.2
     * 
     * @param Pelicula  recibe un objeto de tipo pelicula
     * @param Sala      recibe un objeto de tipo sala, es la sala a la que se le
     *                  quiere programar una funcion
     * @param LocalDate recibe una fecha de tipo LocalDate
     * @param LocalTime recibe un horario de tipo LocalTime
     */
    public void registrarFuncion(Pelicula pelicula, Sala sala,
            LocalDate fecha, LocalTime hora) throws ExcepcionFunciones {

        // 1. Valida que no choque con horarios existentes
        for (Funcion f : funciones) {
            if (f.getSala().getTipoDeSala().equals(sala.getTipoDeSala())
                    && f.getFecha().equals(fecha)) {

                // diferencia en minutos, despues se implementa la EXCEPCION
                int diff = Math.abs(f.getHorario().toSecondOfDay() - hora.toSecondOfDay()) / 60;

                if (diff < 30) {
                    throw new ExcepcionFunciones();
                }
            }
        }

        // 2. Crear la función
        Funcion nueva = new Funcion(
                sala,
                pelicula,
                fecha,
                hora);

        funciones.add(nueva);
        GestorArchivosFunciones.guardarFuncionesPorFecha(fecha, funciones);

        System.out.println("Función registrada con éxito.");
    }

    /**
     * Metodo para mostrar las peliculas que ya tienen funcion programada
     * Punto 7.1
     * 
     */

    public void mostrarPeliculasProgramadas() {
        int i = 0;
        List<String> peliculasMostradas = new ArrayList<>();
        System.out.println("Peliculas programadas");
        for (Funcion f : funciones) {
            if (!peliculasMostradas.contains(f.getPelicula().getNombreDeLaPelicula())) {
                System.out.println(i + ". " + f.getPelicula().getNombreDeLaPelicula());
                System.out.println("   Géneros:" + f.getPelicula().getGeneros());
                System.out.println("---------------------------");
                i += 1;
                peliculasMostradas.add(f.getPelicula().getNombreDeLaPelicula());
            }
        }
    }

    /**
     * Metodo para mostrar la informacion de la pelicula seleccionada
     * Punto 7.1
     * 
     * @param Pelicula recibe el objeto de tipo pelicula, no el nombre
     */

    public void mostrarInformacionPeliculas(Pelicula pelicula) {
        System.out.println(pelicula.toString());

    }

    /**
     * Metodo para mostrar las funciones segun una fecha dada
     * Punto 7.2
     * 
     * @param fecha recibe una fecha, para mostrar las funciones de ese dia
     */

    public void mostrarFuncionesProgamadasParaUnaFecha(LocalDate fecha) {
        System.out.println("Funciones programadas:");
        int i = 1;
        for (Funcion f : funciones) {
            if (f.getFecha().equals(fecha)) {
                System.out.println(i + ":");
                System.out.println(". " + f.getPelicula().getNombreDeLaPelicula());
                System.out.println(". " + f.getPelicula().getGeneros());
                System.out.println(". " + f.getHorario());
                System.out.println(". " + f.getSala().getTipoDeSala());
                System.out.println("--------------------");
                i += 1;
            }
        }
    }

    /**
     * Metodo para vender boletos
     * Primero revisa que no este vendido
     * Punto 7.2
     * 
     * @param Funcion recibe una funcion a la que se quiere comprar boletos
     * @param String  recibe una cadena de asientos que se quieren comprar
     */

    public boolean comprarBoletos(Funcion funcion, String asientoSeleccionados) {
        asientoSeleccionados = asientoSeleccionados.trim();
        String[] asientos = asientoSeleccionados.split("\\s+");

        // Primero se validan todos los boletos
        for (String asiento : asientos) {
            if (!funcion.estaDisponible(asiento)) {
                System.out.println("El asiento " + asiento + " ya está vendido.");
                return false;
            }
        }

        // SI no hay vendidos, se venden todos
        for (String asiento : asientos) {
            funcion.venderBoleto(asiento);
        }

        return true;
    }
    // Metodos get

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

}
