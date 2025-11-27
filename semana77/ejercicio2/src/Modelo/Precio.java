package Modelo;

public class Precio {
    private double[] precios;

    public Precio() {
        precios = new double[2];
    }

    public void setPrecios(double precio1, double precio2) {
        precios[0] = precio1;
        precios[1] = precio2;
    }

    public void setPrecio(int indice, double precio) {
        if (indice < 0 || indice >= precios.length) {
            throw new IllegalArgumentException("Índice de producto inválido");
        }
        precios[indice] = precio;
    }

    public double getPrecio(int indice) {
        if (indice < 0 || indice >= precios.length) {
            throw new IllegalArgumentException("Índice de producto inválido");
        }
        return precios[indice];
    }

    public double[] getPrecios() {
        return precios;
    }

    @Override
    public String toString() {
        return "Producto 1: " + precios[0] + " €, Producto 2: " + precios[1] + " €";
    }
}
