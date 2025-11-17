package Modelo;

import java.util.ArrayList;

public class Quiniela {

    private ArrayList<Partido> partidos;

    public Quiniela() {
        partidos = new ArrayList<>();
    }

    public void addPartido(Partido p) {
        partidos.add(p);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public String obtenerTablaQuiniela() {
        String tabla = "";
        int totalLength = Partido.COLUMNAS[0] + Partido.COLUMNAS[1] + Partido.COLUMNAS[2] + 10; 
        String lineaCabecera = "|" + " ".repeat((totalLength - 10) / 2) + "QUINIELA" + " ".repeat((totalLength - 10) / 2) + "|";
        String lineaSeparacion = "+" + "-".repeat(totalLength - 3) + "+";

        tabla += lineaSeparacion + "\n";
        tabla += lineaCabecera + "\n";
        tabla += lineaSeparacion + "\n";

        for (Partido partido : partidos) {
            tabla += partido.asRowTable() + "\n";
        }

        tabla += lineaSeparacion + "\n";
        return tabla;
    }
    
}
