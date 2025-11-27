package modelo;

import java.util.ArrayList;

public class Videoteca {
    private ArrayList<Pelicula> peliculas;
    private double velocidad;
    private int capacidad;

    public Videoteca(int capacidad) {
        this.capacidad = capacidad;
        this.peliculas = new ArrayList<>();
        this.velocidad = 1.0; // velocidad por defecto
    }

    public int getNumPeliculas() {
        return peliculas.size();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void anadirPelicula(Pelicula pelicula) {
        if (peliculas.size() < capacidad) {
            peliculas.add(pelicula);
        } else {
            System.out.println(" La videoteca está llena");
        }
    }

    public void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas");
            return;
        }

        System.out.println("\n|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| PELÍCULAS EN LA VIDEOTECA                                                                                                   |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-20s | %-12s | %-25s | %-13s | %-15s | %-20s | %-10s |\n",
                "Título", "Año Estreno", "Director", "Oscar ganado", "Duracion", "Tiempo visionado", "Valoracion");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");

        double totalDuracion = 0;
        double totalValoracion = 0;

        for (Pelicula p : peliculas) {
            double tiempoVisionado = p.getTiempoVisionado(velocidad);
            totalDuracion += tiempoVisionado;
            totalValoracion += p.getValoracion();

            System.out.printf("| %-20s | %-12d | %-25s | %-13s | %-15d | %-20.2f | %-10.2f |\n",
                    p.getTitulo(),
                    p.getAnioEstreno(),
                    p.getDirector().getNombre() + " " + p.getDirector().getApellidos(),
                    p.getDirector().isOscarGanado() ? "Sí" : "No",
                    p.getDuracion(),
                    tiempoVisionado,
                    p.getValoracion());
        }

        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| Tiempo de visualizado< total de la videoteca: %-60.2f | Valoracion: %-10.2f |\n",
                totalDuracion, totalValoracion / peliculas.size());
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
    }
}
