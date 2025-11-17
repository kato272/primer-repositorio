package Controlador;
import Modelo.Quiniela;
import Modelo.Partido;
import Vista.VistaQuiniela;

public class ControladorQuiniela {

    private Quiniela quiniela;
    private VistaQuiniela vista;

    public ControladorQuiniela(VistaQuiniela vista) {
        this.vista = vista;
        this.quiniela = new Quiniela();
    }

    public void run() {
        boolean continuar;
        int numeroPartidos = quiniela.getNUMERO_PARTIDOS();
        Partido[] partidos = new Partido[numeroPartidos];

        int i = 0;
        do {
            if (i >= numeroPartidos) {
                vista.mostrarMensaje("Ya se han introducido todos los partidos.");
                break;
            }
            partidos[i] = vista.pedirDatosPartido();
            i++;
            continuar = i < numeroPartidos && vista.confirmarContinuar();
        } while (continuar);

        quiniela.setPartidos(partidos);
        vista.mostrarTabla(quiniela);
    }
}
