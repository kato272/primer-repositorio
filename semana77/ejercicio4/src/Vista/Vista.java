package Vista;
import Modelo.*;
import java.util.Scanner;

public class Vista {

    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("|----------------------------------------------|");
        System.out.println("| MI VIDEOTECA                                 |");
        System.out.println("| 1) Nueva videoteca de películas              |");
        System.out.println("| 2) Configurar velocidad de reproducción      |");
        System.out.println("| 3) Añadir una nueva película a la videoteca  |");
        System.out.println("| 4) Mostrar información actual de películas   |");
        System.out.println("| 5) Salir (se borrará toda la información)    |");
        System.out.println("|----------------------------------------------|");
        System.out.print("Seleccione una opción (1-5): ");
        return sc.nextInt();
    }

    public int pedirNumeroPeliculas() {
        System.out.print("Determina el número de películas que quieres almacenar: ");
        return sc.nextInt();
    }

    public double pedirVelocidad() {
        System.out.print("Introduce la velocidad de reproducción deseada: ");
        return sc.nextDouble();
    }

    public Pelicula pedirDatosPelicula() {
        sc.nextLine(); // Limpiar buffer
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Año de estreno: ");
        int anio = sc.nextInt();
        System.out.print("Duración (minutos): ");
        int duracion = sc.nextInt();
        System.out.print("Valoración (0-10): ");
        double valoracion = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.print("Nombre del director: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos del director: ");
        String apellidos = sc.nextLine();
        System.out.print("¿Ha ganado un Óscar? (true/false): ");
        boolean oscar = sc.nextBoolean();

        Director director = new Director(nombre, apellidos, oscar);
        return new Pelicula(titulo, anio, duracion, valoracion, director);
    }

    public void mostrarPeliculas(Pelicula[] peliculas, int numPeliculas, double velocidad) {
        if (numPeliculas == 0) {
            System.out.println("\nNo hay películas en la videoteca.");
            return;
        }

        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-20s | %-12s | %-20s | %-12s | %-14s | %-14s | %-10s |\n",
                "Título", "Año", "Director", "Oscar", "Duración", "Tiempo visionado", "Valoración");
        System.out.println("|----------------------------------------------------------------------------------------------------------------|");

        double totalTiempo = 0;
        double totalValoracion = 0;

        for (int i = 0; i < numPeliculas; i++) {
            Pelicula p = peliculas[i];
            double tiempoVisionado = p.getTiempoVisionado(velocidad);
            totalTiempo += tiempoVisionado;
            totalValoracion += p.getValoracion();

            System.out.printf("| %-20s | %-12d | %-20s | %-12s | %-14d | %-14.2f | %-10.2f |\n",
                    p.getTitulo(),
                    p.getAnioEstreno(),
                    p.getDirector().getNombre() + " " + p.getDirector().getApellidos(),
                    p.getDirector().isOscarGanado() ? "Sí" : "No",
                    p.getDuracion(),
                    tiempoVisionado,
                    p.getValoracion());
        }

        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("Tiempo de visionado total: %.2f min | Valoración media: %.2f\n", totalTiempo, totalValoracion / numPeliculas);
    }

    public boolean confirmarContinuar() {
        System.out.print("¿Desea continuar realizando operaciones? S/N: ");
        char c = sc.next().toUpperCase().charAt(0);
        return c == 'S';
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
