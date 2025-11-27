package Controlador;

import Modelo.Modelo;
import Modelo.Libro;
import Vista.Vista;
import java.util.Collection;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch(opcion) {
                case 1: // Agregar
                    Libro nuevo = vista.pedirDatosLibro();
                    if(modelo.agregarLibro(nuevo)) {
                        vista.mostrarMensaje("Libro agregado");
                    } else {
                        vista.mostrarMensaje("El libro ya esta");
                    }
                    break;
                case 2: // Modificar
                    String isbnMod = vista.pedirISBN();
                    Libro existente = modelo.buscarLibro(isbnMod);
                    if(existente != null) {
                        Libro actualizado = vista.pedirDatosLibro();
                        modelo.actualizarLibro(isbnMod, actualizado);
                        vista.mostrarMensaje("Libro actualizado");
                    } else {
                        vista.mostrarMensaje("El libro no esta");
                    }
                    break;
                case 3: 
                    Collection<Libro> libros = modelo.getTodosLosLibros();
                    vista.mostrarLibros(libros);
                    break;
                case 4:
                    String isbnDel = vista.pedirISBN();
                    Libro aEliminar = modelo.buscarLibro(isbnDel);
                    if(aEliminar != null) {
                        modelo.eliminarLibro(isbnDel);
                        vista.mostrarMensaje("Libro eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("El libro no existe.");
                    }
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion incorrecta");
            }
        } while(opcion != 5);
    }
}
