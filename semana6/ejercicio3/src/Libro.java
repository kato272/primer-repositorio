public class Libro {
        
    private String ISBN;
    private String titulo;
    private int anio;
    private String autor;
    
    public Libro(String ISBN, String titulo, int anio, String autor){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.anio = anio;
        this.autor = autor;
    }
    
    public String getISBN(){
        return ISBN;
    }
    public String getTitulo(){
        return titulo;
    }    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + " Título: " + titulo + " Autor: " + autor + " Año: " + anio;
    }
}
