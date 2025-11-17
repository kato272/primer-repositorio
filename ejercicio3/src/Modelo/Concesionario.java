package Modelo;
import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Coche> coches;

    public Concesionario() {
        coches = new ArrayList<>();
    }

    public void agregarCoche(Coche c) {
        coches.add(c);
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public Coche buscarPorID(int id) {
        for (Coche c : coches) {
            if (c.getID() == id) return c;
        }
        return null;
    }

    public boolean eliminarCoche(int id) {
        Coche c = buscarPorID(id);
        if (c != null) {
            coches.remove(c);
            return true;
        }
        return false;
    }
}
