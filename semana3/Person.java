


public class Person {
 
    public float calcularIMC() {
        if (this.altura <= 0 || this.peso <= 0) {
            return -1f; s
        }
        return this.peso / (this.altura * this.altura);
    }

    String nombre;
    float altura;
    int peso;

    public void setAltura(float altura){
        this.altura = altura;
    }
    public float getAltura() {
        return altura;
    }
    public Person() {
        this.nombre = "Javier";
        this.altura = 1.80f;
        this.peso = 75;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getPeso() {
        return peso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
