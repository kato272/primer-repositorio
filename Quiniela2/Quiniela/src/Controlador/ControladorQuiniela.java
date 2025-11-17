package Controlador;

import Modelo.Partido;
import Modelo.Quiniela;
import Vista.VistaQuiniela;
import java.io.*;
import java.util.Scanner;

public class ControladorQuiniela {

    private Quiniela quiniela;
    private VistaQuiniela vista;

    public ControladorQuiniela(VistaQuiniela vista) {
        this.vista = vista;
        this.quiniela = new Quiniela();
    }
    public void run() {
        cargarPartidosDesdeArchivo();
        for (Partido p : quiniela.getPartidos()) {
            vista.pedirGoles(p);
        }
        vista.mostrarTabla(quiniela);
    }

    private void cargarPartidosDesdeArchivo() {
        try {
            String home = System.getProperty("user.home");
            File archivo = new File(home + "/Desktop/datos/equipos.txt");
            Scanner sc = new Scanner(archivo);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.trim().isEmpty()) continue;
                String[] equipos = linea.split("-");
                if (equipos.length != 2) continue;
                Partido partido = new Partido(equipos[0].trim(), equipos[1].trim());
                quiniela.addPartido(partido);
            }
            sc.close();
            vista.mostrarMensaje("Partidos cargados desde fichero correctamente.");
        } catch (FileNotFoundException e) {
            vista.mostrarMensaje("No se pudo encontrar el archivo equipos.txt en Desktop/datos.");
        }
    }
}
