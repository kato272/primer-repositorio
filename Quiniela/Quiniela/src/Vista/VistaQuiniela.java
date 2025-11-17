package Vista;

import java.util.Scanner;
import Modelo.Quiniela;
import Modelo.Partido;

public class VistaQuiniela {

    private Scanner sc;

    public VistaQuiniela() {
        sc = new Scanner(System.in);
    }

    public void mostrarTabla(Quiniela quiniela) {
        System.out.println(quiniela.obtenerTablaQuiniela());
    }

    public Partido pedirDatosPartido() {
        System.out.print("Equipo local: ");
        String local = sc.nextLine();
        System.out.print("Equipo visitante: ");
        String visitante = sc.nextLine();
        System.out.print("Goles equipo local: ");
        int golesLocal = sc.nextInt();
        System.out.print("Goles equipo visitante: ");
        int golesVisitante = sc.nextInt();
        sc.nextLine(); 
        return new Partido(local, visitante, golesLocal, golesVisitante);
    }

    public boolean confirmarContinuar() {
        System.out.print("¿Desea introducir otro partido? S/N: ");
        char c = sc.nextLine().toUpperCase().charAt(0);
        return c == 'S';
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
