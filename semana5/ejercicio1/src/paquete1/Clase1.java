package paquete1;

public class Clase1 {


    public int atributoPublico = 1;
    int atributoDefault = 2;           
    protected int atributoProtegido = 3;
    private int atributoPrivado = 4;


    public void metodoPublico() {
        System.out.println("Método público");
    }

    void metodoDefault() {
        System.out.println("Método sin modificador (package-private)");
    }

    protected void metodoProtegido() {
        System.out.println("Método protegido");
    }

    private void metodoPrivado() {
        System.out.println("Método privado");
    }
}
