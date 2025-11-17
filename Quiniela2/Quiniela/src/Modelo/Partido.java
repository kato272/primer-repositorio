package Modelo;

public class Partido {
    public static final int[] COLUMNAS = { 20, 20, 1 };

    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public String getResultado() {
        if (golesLocal > golesVisitante) return "1";
        else if (golesLocal < golesVisitante) return "2";
        else return "X";
    }

    public String asRowTable() {
        return String.format("| %-" + COLUMNAS[0] + "s | %-" + COLUMNAS[1] + "s | %-" + COLUMNAS[2] + "s |",
                equipoLocal, equipoVisitante, getResultado());
    }

    // Getters y setters
    public String getEquipoLocal() { 
        return equipoLocal; 
    }
    public String getEquipoVisitante() { 
        return equipoVisitante; 
    }
    public int getGolesLocal() { 
        return golesLocal; 
    }
    public int getGolesVisitante() { 
        return golesVisitante; 
    }

    public void setGolesLocal(int golesLocal) { 
        this.golesLocal = golesLocal; 
    }
    public void setGolesVisitante(int golesVisitante) {
         this.golesVisitante = golesVisitante; 
        }
}
