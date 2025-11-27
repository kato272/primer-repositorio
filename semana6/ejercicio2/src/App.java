import java.util.Scanner;
import modelo.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner escan = new Scanner(System.in);
        Videoteca videoteca = null;  
        int opcion;

        do {
            System.out.printf("|----------------------------------------------|\n");
            System.out.printf("| MI VIDEOTECA                                 |\n");
            System.out.printf("| 1)  Nueva videoteca de películas             |\n");
            System.out.printf("| 2)  Configurar velocidad de reproducción     |\n");
            System.out.printf("| 3)  Añadir una nueva película a la videoteca |\n");
            System.out.printf("| 4)  Mostrar información actual de películas  |\n");
            System.out.printf("| 5)  Salir (se borrará toda la información)   |\n");
            System.out.printf("|----------------------------------------------|\n");
            System.out.print("Seleccione una opción (1-5): ");
            opcion = escan.nextInt();
            escan.nextLine(); // limpiar buffer

            switch(opcion){

                case 1: {
                    System.out.print("Determina el número de películas que quieres almacenar: ");
                    int numPeliculas = escan.nextInt();
                    escan.nextLine(); // limpiar buffer
                    videoteca = new Videoteca(numPeliculas);
                    System.out.println("Nueva videoteca creada con capacidad para " + numPeliculas + " películas.");
                    break;
                }

                case 2: {
                    if (videoteca != null) {
                        System.out.print("Introduce la velocidad de reproducción deseada: ");
                        double velocidad = escan.nextDouble();
                        escan.nextLine(); // limpiar buffer
                        videoteca.setVelocidad(velocidad);
                        System.out.println("Velocidad configurada a x" + velocidad);
                    } else {
                        System.out.println("Primero debes crear una videoteca");
                    }
                    break;
                }

                case 3: {
                    if (videoteca == null) {
                        System.out.println("Primero debes crear una videoteca");
                    } else if (videoteca.getNumPeliculas() == videoteca.getCapacidad()) {
                        System.out.println("Videoteca llena");
                    } else {
                        escan.nextLine(); 
                        System.out.print("Titulo: ");
                        String titulo = escan.nextLine();
                        System.out.print("Año estreno: ");
                        int anio = escan.nextInt();
                        System.out.print("Duracion: ");
                        int duracion = escan.nextInt();
                        System.out.print("Valoracion: ");
                        double valoracion = escan.nextDouble();
                        escan.nextLine(); // limpiar buffer

                        System.out.print("Nombre del director: ");
                        String nombre = escan.nextLine();
                        System.out.print("Apellidos del director: ");
                        String apellidos = escan.nextLine();
                        System.out.print("¿Ha ganado un Óscar? pon true/false: ");
                        boolean oscar = escan.nextBoolean();
                        escan.nextLine(); // limpiar buffer

                        Director director = new Director(nombre, apellidos, oscar);
                        Pelicula pelicula = new Pelicula(titulo, anio, duracion, valoracion, director);
                        videoteca.anadirPelicula(pelicula);

                        System.out.println("Película añadida de forma correcta");
                    }
                    break;
                }

                case 4: {
                    if (videoteca == null) {
                        System.out.println("Primero debes crear una videoteca");
                    } else {
                        videoteca.mostrarPeliculas();
                    }
                    break;
                }

                case 5: {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        escan.close();
    }
}
