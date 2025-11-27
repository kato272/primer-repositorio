package com.gestorlibros.view;
import com.gestorlibros.model.GestorLibrosModel;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.coti.tools.DiaUtil;
import com.coti.tools.Esdia;
import com.gestorlibros.controller.Controller;
import com.gestorlibros.model.Libro;

public class View implements Serializable {

    Controller c;

    public void startMenu() throws IOException, ClassNotFoundException{

        // Bucle infinito con Esdia

        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar el listado de libros en formato tabla.");
            System.out.println("2. Añadir nuevo libro al modelo.");
            System.out.println("3. Eliminar libro de una lista de libros disponibles.");
            System.out.println("4. Modificar libro de una lista de libros disponibles.");
            System.out.println("5. Exportar libros en formato delimitado por comas CSV.");
            System.out.println("6. Exportar libros en formato JSON.");
            System.out.println("7. Exportar libros en formato XML.");
            System.out.println("8. Importar libros de un fichero JSON.");
            System.out.println("9. Importar libros de un fichero XML.");
            System.out.println("10. Importar libros de un fichero en formato delimitado por comas CSV.");
            System.out.println("11. Salir del programa.");
            System.out.println("12. Importar de fichero en binario");

            int option = Esdia.readInt("Ingrese una opción: ", 1, 12);

            switch (option) {
                case 1:
                    mostrarLibrosModelo(false);
                    break;
                case 2:
                    anadirLibroAlModelo();
                    break;
                case 3:
                    borrarLibroDelModelo();
                    break;
                case 4:
                    editarLibroDelModelo();
                    break;
                case 5:
                    exportarBooksCSV();
                    break;
                case 6:
                    exportarBooksJSON();
                    break;
                case 7:
                    exportBooksToXML();
                    break;
                case 8:
                    importarBooksJSON();
                    break;
                case 9:
                    importarBooksXML();
                    break;
                case 10:
                    importBooksFromCSV();
                    break;
                case 11:
                    exit = true;
                    //c.saveBooks();
                    break;
                case 12:
                    loadStateOfTheApp();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }


    }

    private void importBooksFromCSV() throws FileNotFoundException {
        int resu = c.importBooksFromCSV();
    }

    private void importarBooksXML() throws FileNotFoundException {
         // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'importarBooksXML'");
    }

    private void importarBooksJSON() throws IOException {
        int resu = c.importBooksFromJSON();
    }

    private void exportBooksToXML() {
        int resu = c.exportBooksToXML();
    }

    private void exportarBooksJSON() {
        c.exportBooksToJSON();
    }

    private void exportarBooksCSV() throws IOException {
       int res =  c.exportBooksToCSV();
    }

    private void loadStateOfTheApp() throws ClassNotFoundException, IOException{
        int res = c.loadStateOfTheApp();
    }

    private void editarLibroDelModelo() {
        ArrayList<Libro> libros = c.getLibros();

        if (libros.isEmpty()) {
        System.out.println("No se pueden modificar los libros, no existen");
        return;
        }
        mostrarLibrosModelo(true);
        int indice = Esdia.readInt("Ingrese numero de indice del libro: ", 1, libros.size());

        Libro libroEditar = libros.get(indice-1);
        String titulo = Esdia.readString_ne("Introduzca el título del libro: ");
        String autor = Esdia.readString_ne("Introduzca el autor del libro: ");
        String isbn = Esdia.readString_ne("Introduzca el ISBN del libro: ");
        String editorial = Esdia.readString_ne("Introduzca la editorial del libro: ");
        int anyoPublicacion = Esdia.readInt("Introduzca el año de publicación del libro: ");
        int numPaginas = Esdia.readInt("Introduzca el número de páginas del libro: ");
        float precio = Esdia.readFloat("Introduzca el precio del libro: ");
        
        libroEditar.setAnyoPublicacion(anyoPublicacion);
        libroEditar.setTitulo(titulo);
        libroEditar.setAutor(autor);
        libroEditar.setEditorial(editorial);
        libroEditar.setISBN(isbn);
        libroEditar.setNumPaginas(numPaginas);
        libroEditar.setPrecio(precio);

    }

    private void borrarLibroDelModelo() {

         ArrayList<Libro> libros = c.getLibros();

        if (libros.isEmpty()) {
        System.out.println("No hay libros que eliminar");
        return;
        }

        mostrarLibrosModelo(true);

        // Pedir al usuario el índice del libro a eliminar
        int indice = Esdia.readInt("Ingrese el numero del libro a eliminar: ", 1, libros.size());

        Libro libroAEliminar = libros.get(indice - 1);
        boolean confirmar = Esdia.yesOrNo("¿Estas seguro de que desea eliminar este libro? (true/false): ");

        if (confirmar) {
            c.removeLibro(libroAEliminar);
            System.out.println("Libro eliminado correctamente");
        } else {
            System.out.println("Operacion cancelada");
        }
    }

    private void anadirLibroAlModelo() {
        // Pedir información al usuario sobre el libro:
        String titulo = Esdia.readString_ne("Introduzca el título del libro: ");
        String autor = Esdia.readString_ne("Introduzca el autor del libro: ");
        String isbn = Esdia.readString_ne("Introduzca el ISBN del libro: ");
        String editorial = Esdia.readString_ne("Introduzca la editorial del libro: ");
        int anyoPublicacion = Esdia.readInt("Introduzca el año de publicación del libro: ");
        int numPaginas = Esdia.readInt("Introduzca el número de páginas del libro: ");
        float precio = Esdia.readFloat("Introduzca el precio del libro: ");

        // Crear el libro
        Libro l = new Libro(isbn, titulo, autor, editorial, anyoPublicacion, numPaginas, precio);

        // Comprobar si el libro existe en el modelo
        if (c.getLibros().contains(l)) {
            System.out.println("El libro ya existía en el modelo.");
        } else {
            // Añadir el libro al modelo
            c.addLibro(l);
            System.out.println("Libro añadido correctamente.");
        }
    }

    private void mostrarLibrosModelo(boolean showIndex) {
        // Obtener los libros del modelo
        ArrayList<Libro> books = c.getLibros();
        // Comprobar cuantos libros hay y mostrar mensjae
        if (books.size() == 0) {
            System.out.println("No hay libros disponibles.");
        } else {
            // Mostrar los libros
            // Cabecera
            if(showIndex) {
                System.out.println(String.format("| %6s ","Indice") + Libro.tableHeader());
            } else {
                System.out.println(Libro.tableHeader());
            }
            // Cuerpo
            for (Libro l : books) {
                if(showIndex) {
                    System.out.println(String.format("| %6d.", books.indexOf(l)+1) + l.asTableRow());
                } else {
                    System.out.println(l.asTableRow());
                }
            }
        }
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public void showInfoMessage(String string) {
        System.out.println(string);
    }

    public void showErrorMessage(String string) {
        System.err.println(string);
    }
    
}
