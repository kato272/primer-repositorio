public class Usuario {
    String nombre;
    double peso;
    double altura;
    
    public Usuario(String nombre, double peso, double altura){
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura; 
    }
    
    public double calcularIMC(){
        return peso / (altura * altura);
    }
    
    static Usuario fromArgs(String[] args){
        return new Usuario(
            args[0],
            Double.parseDouble(args[1]),
            Double.parseDouble(args[2])
        );
    }
}