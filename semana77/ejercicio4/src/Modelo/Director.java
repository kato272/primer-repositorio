
package Modelo;

public class Director{
    
    private String nombre;
    private String apellidos;
    private Boolean oscarGanado;
    
    
    public Director(String nombre, String apellidos, Boolean oscarGanado){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oscarGanado = oscarGanado;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setOscar(Boolean oscarGanado){
        this.oscarGanado = oscarGanado;  
    }
    public Boolean getOscar(){
        return oscarGanado;
    }
    public boolean isOscarGanado() {
        return oscarGanado;
    }

     @Override
    public String toString() {
        return nombre + " " + apellidos + " (Oscar: " + (oscarGanado ? "Sí" : "No") + ")";
    }
}