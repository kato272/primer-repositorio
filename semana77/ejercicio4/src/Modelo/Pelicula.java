package Modelo;

public class Pelicula {
    
    private String titulo;
    private int anioEstreno;
    private int duracion;   
    private double valoracion;
    private Director director;

    public Pelicula(String titulo, int anioEstreno, int duracion, double valoracion, Director director) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.director = director;
    }
  
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public int getAnioEstreno(){
        return anioEstreno;
    }
    public void setAnioEstreno(int anioEstreno){
        this.anioEstreno = anioEstreno;
    }
    public int getDuracion(){
        return duracion;
    }
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    public double getValoracion(){
        return valoracion;
    }
    public void setValoracion(double valoracion){
         if (valoracion >= 0 && valoracion <= 10) {
            this.valoracion = valoracion;
        }
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public double getTiempoVisionado(double velocidad) {
        return duracion / velocidad;
    }
    
    @Override
    public String toString() {
        return titulo + " (" + anioEstreno + ") - " + director.toString();
    }
}
