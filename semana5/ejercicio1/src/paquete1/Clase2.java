package paquete1;

class Clase2 {

    public int atributoPublico = 10;
    int atributoDefault = 20;
    protected int atributoProtegido = 30;
    private int atributoPrivado = 40;

    public void metodoPublico() {
        System.out.println("Método público en Clase2");
    }

    void metodoDefault() {
        System.out.println("Método sin modificador en Clase2");
    }

    protected void metodoProtegido() {
        System.out.println("Método protegido en Clase2");
    }

    private void metodoPrivado() {
        System.out.println("Método privado en Clase2");
    }
}
