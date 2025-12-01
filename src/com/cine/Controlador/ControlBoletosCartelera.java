package com.cine.Controlador;
import java.io.*;
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
        int i = 0;
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

    public void mostrarInformacionPeliculas(Pelicula p) {
        System.out.println(p.toString());// pa que me muestra la que quiero
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
     * Metodo para mostrar los asientos
     * Punto 7.2
     * 
     * @param Funcion recibe una funcion y muestra los asientos de la sala A
     */

    public void mostrarAsientosSalaA(Funcion funcion) {

        List<String> todos = funcion.getSala().getAsientos();
        List<Boleto> vendidos = funcion.getBoletosVendidos();

        int columnas = funcion.getSala().getNumeroColumnas();
        int filas = funcion.getSala().getNumeroFilas();

        System.out.println("\n");
        System.out.println("O = disponible   |   X = ocupado\n");

        int index = 0;

        for (int f = 0; f < filas; f++) {
            char letra = (char) ('A' + f);
            System.out.print(letra + "  ");

            for (int c = 1; c <= columnas; c++) {
                String asiento = todos.get(index);

                boolean ocupado = false;

                for (Boleto b : vendidos) {
                    if (b.getAsiento().equals(asiento)) {
                        ocupado = true;
                        break;
                    }
                }

                System.out.print(ocupado ? "X " : "O ");
                index++;

            }

            System.out.println(); // salto de línea
        }
    }

    /**
     * Metodo para mostrar los asientos
     * Punto 7.2
     * 
     * @param Funcion recibe una funcion y muestra los asientos de la sala B
     */

    public void mostrarAsientosSalaB(Funcion funcion) {

        List<String> todos = funcion.getSala().getAsientos();
        List<Boleto> vendidos = funcion.getBoletosVendidos();

        int filas1 = funcion.getSala().getNumeroFilas();
        int columnas1 = funcion.getSala().getNumeroColumnas();

        int filas2 = funcion.getSala().getNumeroFilasDos();
        int columnas2 = funcion.getSala().getNumeroColumnasDos();

        System.out.println("\nO = Disponible   |   X = ocupado\n");

        int index = 0;

        System.out.println("--------");
        System.out.printf("%4s", "");
        for (int c = 1; c <= columnas1; c++) {
            System.out.printf("%3d", c);
        }
        System.out.println();
        for (int f = 0; f < filas1; f++) {

            char letra = (char) ('A' + f);
            System.out.printf("%-4s", letra);

            for (int c = 1; c <= columnas1; c++) {

                String asiento = todos.get(index);

                boolean ocupado = false;
                for (Boleto b : vendidos) {
                    if (b.getAsiento().equals(asiento)) {
                        ocupado = true;
                        break;
                    }
                }

                System.out.printf("%3s", ocupado ? "X" : "O");
                index++;
            }
            System.out.println();
        }

        System.out.println("\n");

        System.out.printf("%4s", "");
        for (int c = 1; c <= columnas2; c++) {
            System.out.printf("%3d", c);
        }
        System.out.println();

        for (int f = 0; f < filas2; f++) {

            char letra = (char) ('A' + filas1 + f); // Sigue después de la zona 1
            System.out.printf("%-4s", letra);

            for (int c = 1; c <= columnas2; c++) {

                String asiento = todos.get(index);

                boolean ocupado = false;
                for (Boleto b : vendidos) {
                    if (b.getAsiento().equals(asiento)) {
                        ocupado = true;
                        break;
                    }
                }

                System.out.printf("%3s", ocupado ? "X" : "O");
                index++;
            }
            System.out.println();
        }
    }

    /**
     * Metodo para mostrar los asientos
     * Punto 7.2
     * 
     * @param Funcion recibe una funcion y muestra los asientos de la sala Vip
     */

    public void mostrarAsientosSalaVip(Funcion funcion) {

        List<String> todos = funcion.getSala().getAsientos();
        List<Boleto> vendidos = funcion.getBoletosVendidos();

        int columnas = funcion.getSala().getNumeroColumnas();
        int filas = funcion.getSala().getNumeroFilas();

        System.out.println("\n");
        System.out.println("O = disponible   |   X = ocupado\n");

        int index = 0;

        for (int f = 0; f < filas; f++) {
            char letra = (char) ('A' + f);
            System.out.print(letra + "  ");

            for (int c = 1; c <= columnas; c++) {
                String asiento = todos.get(index);

                boolean ocupado = false;

                for (Boleto b : vendidos) {
                    if (b.getAsiento().equals(asiento)) {
                        ocupado = true;
                        break;
                    }
                }

                System.out.print(ocupado ? "X " : "O ");
                index++;
                // Para separar las columnas
                if (c % 2 == 0) {
                    System.out.print(" "); // espacio de separación
                }

            }

            System.out.println(); // salto de línea
        }
    }

    /**
     * Metodo para vender boletos
     * Primero revisa que no este vendido, despues procede a hacer el pago bancario
     * y hacer el resumen
     * Solo se tiene que ejecutar este metodo y los demas los ejecuta este
     * Punto 7.2
     * 
     * @param Funcion recibe una funcion a la que se quiere comprar boletos
     * @param String  recibe una cadena de asientos que se quieren comprar
     * @return True si se pudieron comprar los boletos
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

        // si los boletos estaban disponibles, se ponen en la lista de boletos vendidos
        // y
        // se llama al metodo de cargo bancario de una vez
        cargoBancario();

        // muestra el resumen de compra al final
        resumenDeCompra(funcion, asientos);

        return true;
    }

    /**
     * Metodo para simular el cargo bancario
     * Punto 7.2
     */

    public void cargoBancario() {
        // crea los hilos y carga necesita a hilo para arrancar
        HiloBanco hilo = new HiloBanco();
        BarraCarga carga = new BarraCarga(hilo);
        hilo.start();
        carga.start();

        try {
            hilo.join();
            carga.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cuando ya termino de hcaer el cargo bancario muestra el resumen de compra

    }

    /**
     * Metodo para mostrar un resumen de compra
     * Punto 7.2
     */

    public void resumenDeCompra(Funcion funcion, String[] asientosComprados) {
        System.out.println("\n======= RESUMEN DE COMPRA =======\n");
        System.out.println("Película: " + funcion.getPelicula().getNombreDeLaPelicula());
        System.out.println("Fecha:    " + funcion.getFecha());
        System.out.println("Horario:  " + funcion.getHorario());
        System.out.println("Sala:     " + funcion.getSala().getTipoDeSala());
        System.out.println("\nAsientos comprados:");

        List<Boleto> vendidos = funcion.getBoletosVendidos();

        for (String buscado : asientosComprados) {
            for (Boleto b : vendidos) {
                if (b.getAsiento().equalsIgnoreCase(buscado)) {
                    System.out.println("Clave: " + b.getClaveBoleto());
                }
            }
        }

        double total = asientosComprados.length * funcion.getPrecio();
        System.out.println("\nTotal pagado: $" + total);

        System.out.println("\n=================================\n");
    }

    // Metodos get

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

}
