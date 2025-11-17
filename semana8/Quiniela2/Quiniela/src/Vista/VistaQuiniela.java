package Vista;

import Modelo.Partido;
import Modelo.Quiniela;
import java.util.Scanner;

public class VistaQuiniela {

    private Scanner sc;

    public VistaQuiniela() {
        sc = new Scanner(System.in);
    }

    public void mostrarTabla(Quiniela quiniela) {
        System.out.println(quiniela.obtenerTablaQuiniela());
    }

    public void pedirGoles(Partido partido) {
        System.out.println("Introduce resultado para el partido: " + partido.getEquipoLocal() + " - " + partido.getEquipoVisitante());
        System.out.print("Goles " + partido.getEquipoLocal() + ": ");
        int golesLocal = sc.nextInt();
        System.out.print("Goles " + partido.getEquipoVisitante() + ": ");
        int golesVisitante = sc.nextInt();
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
