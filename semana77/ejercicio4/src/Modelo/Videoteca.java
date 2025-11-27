package Modelo;

public class Videoteca {
    
    private Pelicula[] peliculas;
    private int numPeliculas;
    private double velocidad;
   
    public Videoteca(int tamano){
       peliculas = new Pelicula[tamano];
       numPeliculas = 0;
       velocidad = 1.0;
    }

    public void setVelocidad(double velocidad){
        if(velocidad > 0){
            this.velocidad = velocidad;
        }
    }
    public double getVelocidad(){
        return velocidad;
    }

    public boolean anadirPelicula(Pelicula p){
        if(numPeliculas < peliculas.length){
            peliculas[numPeliculas] = p;
            numPeliculas++;
            return true;
        }
        return false;
    }

    public int getNumPeliculas() {
        return numPeliculas;
    }

    public int getCapacidad() {
        return peliculas.length;
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void vaciar() {
        peliculas = new Pelicula[peliculas.length];
        numPeliculas = 0;
        velocidad = 1.0;
    }
}
