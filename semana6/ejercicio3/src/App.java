import java.util.HashMap;
import java.util.Scanner;

public class App {

    private HashMap<String, Libro> libros = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.iniciar(); 
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: agregarLibro(); 
                break;
                case 2: buscarLibro(); 
                break;
                case 3: actualizarLibro(); 
                break;
                case 4: eliminarLibro(); 
                break;
                case 5: mostrarLibros(); 
                break;
                case 0: System.out.println("Saliendo..."); 
                break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void agregarLibro() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        if (libros.containsKey(isbn)) {
            System.out.println("El libro ya existe.");
            return;
        }
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        Libro libro = new Libro(isbn, titulo, anio, autor); 
        libros.put(isbn, libro);
        System.out.println("Libro agregado");
    }

    private void buscarLibro() {
        System.out.print("ISBN a buscar: ");
        String isbn = sc.nextLine();
        Libro libro = libros.get(isbn);
        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void actualizarLibro() {
        System.out.print("ISBN a actualizar: ");
        String isbn = sc.nextLine();
        Libro libro = libros.get(isbn);
        if (libro != null) {
            System.out.print("Nuevo título: ");
            libro.setTitulo(sc.nextLine());
            System.out.print("Nuevo autor: ");
            libro.setAutor(sc.nextLine());
            System.out.print("Nuevo año: ");
            libro.setAnio(sc.nextInt());
            sc.nextLine();
            System.out.println("Libro actualizado");
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void eliminarLibro() {
        System.out.print("ISBN a eliminar: ");
        String isbn = sc.nextLine();
        if (libros.remove(isbn) != null) {
            System.out.println("Libro eliminado");
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros");
            return;
        }
        for (Libro libro : libros.values()) {
            System.out.println(libro);
        }
    }
}
