package Vista;

import Modelo.Libro;
import java.util.Collection;
import java.util.Scanner;

public class Vista {

    private Scanner escan = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\nMENU GESTOR LIBROS");
        System.out.println("1. Añadir libro");
        System.out.println("2. Modificar libro");
        System.out.println("3. Mostrar libros");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Salir");
        System.out.print("Elige una opción 1-5: ");
        int opcion = escan.nextInt();
        escan.nextLine(); // limpiar buffer
        return opcion;
    }

    public Libro pedirDatosLibro() {
        System.out.println("Introduce los datos del libro:");
        System.out.print("ISBN: ");
        String ISBN = escan.nextLine();
        System.out.print("Título: ");
        String titulo = escan.nextLine();
        System.out.print("Autor: ");
        String autor = escan.nextLine();
        System.out.print("Año: ");
        int anio = escan.nextInt();
        escan.nextLine(); // limpiar buffer
        return new Libro(ISBN, titulo, anio, autor);
    }

    public String pedirISBN() {
        System.out.print("Introduce el ISBN del libro: ");
        return escan.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarLibros(Collection<Libro> libros) {
        if(libros.isEmpty()) {
            System.out.println("No hay libros para mostrar.");
            return;
        }
        System.out.println("\n--- LISTA DE LIBROS ---");
        for(Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
