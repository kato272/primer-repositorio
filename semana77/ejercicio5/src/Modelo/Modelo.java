package Modelo;

import java.util.HashMap;
import java.util.Collection;

public class Modelo {

    private HashMap<String, Libro> libros = new HashMap<>();

    public boolean agregarLibro(Libro libro) {
        if(libros.containsKey(libro.getISBN())) {
            return false; // ya existe
        }
        libros.put(libro.getISBN(), libro);
        return true;
    }

    public Libro buscarLibro(String isbn) {
        return libros.get(isbn); // HashMap permite buscar directamente
    }

    public void actualizarLibro(String isbn, Libro libroActualizado) {
        if(libros.containsKey(isbn)) {
            libros.put(isbn, libroActualizado);
        }
    }

    public void eliminarLibro(String isbn) {
        libros.remove(isbn);
    }

    public Collection<Libro> getTodosLosLibros() {
        return libros.values();
    }
}
