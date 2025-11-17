package Controlador;
import Modelo.*;
import Vista.Vista;

public class Controlador {
    private Concesionario modelo;
    private Vista vista;

    public Controlador() {
        modelo = new Concesionario();
        vista = new Vista();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.sacarMenu();
            switch (opcion) {
                case 1:
                    Coche c = vista.pedirDatitos();
                    modelo.agregarCoche(c);
                    vista.mostrarMensaje("Coche añadido correctamente.");
                    break;
                case 2:
                    vista.mostrarCoches(modelo.getCoches());
                    break;
                case 3:
                    int id = vista.pedirID();
                    Coche cMod = modelo.buscarPorID(id);
                    if (cMod != null) {
                        Coche nuevo = vista.pedirDatitos();
                        modelo.eliminarCoche(id);
                        modelo.agregarCoche(nuevo);
                        vista.mostrarMensaje("Coche modificado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se encontró coche con ese ID.");
                    }
                    break;
                case 4:
                    int idEliminar = vista.pedirID();
                    if (modelo.eliminarCoche(idEliminar)) {
                        vista.mostrarMensaje("Coche eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se encontró coche con ese ID.");
                    }
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    vista.cerrarScanner();
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }
}
