package Controlador;
import Modelo.*;
import Vista.*;

public class Controlador {

    private Vista vista;
    private Videoteca videoteca;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.videoteca = null;
    }

    public void run() {
        boolean continuar;
        do {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    int numPeliculas = vista.pedirNumeroPeliculas();
                    videoteca = new Videoteca(numPeliculas);
                    vista.mostrarMensaje("Nueva videoteca creada con capacidad para " + numPeliculas + " películas.");
                    break;
                case 2:
                    if (videoteca != null) {
                        double velocidad = vista.pedirVelocidad();
                        videoteca.setVelocidad(velocidad);
                    } else {
                        vista.mostrarMensaje("Primero debes crear una videoteca (opción 1).");
                    }
                    break;
                case 3:
                    if (videoteca == null) {
                        vista.mostrarMensaje("Primero debes crear una videoteca (opción 1).");
                    } else if (videoteca.getNumPeliculas() == videoteca.getCapacidad()) {
                        vista.mostrarMensaje("La videoteca está llena. No se pueden añadir más películas.");
                    } else {
                        Pelicula pelicula = vista.pedirDatosPelicula();
                        videoteca.anadirPelicula(pelicula);
                        vista.mostrarMensaje("Película añadida correctamente.");
                    }
                    break;
                case 4:
                    if (videoteca == null) {
                        vista.mostrarMensaje("Primero debes crear una videoteca (opción 1).");
                    } else {
                        vista.mostrarPeliculas(videoteca.getPeliculas(), videoteca.getNumPeliculas(), videoteca.getVelocidad());
                    }
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    vista.mostrarMensaje("Opción incorrecta.");
            }

            continuar = vista.confirmarContinuar();

        } while (continuar);
    }
}
