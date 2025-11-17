package Modelo;

public class Coche {

    private String marca;
    private String modelo;
    private int año;
    private double precio;
    private int cantidadStock;
    private int ID;

    public Coche() {
    }

    public Coche(String marca, String modelo, int año, double precio, int cantidadStock, int ID) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.ID = ID;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return año; }
    public double getPrecio() { return precio; }
    public int getCantidadStock() { return cantidadStock; }
    public int getID() { return ID; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAnio(int año) { this.año = año; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
    public void setID(int ID) { this.ID = ID; }

    @Override
    public String toString() {
        return "Coche : " +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + año +
                ", precio=" + precio +
                ", cantidadStock=" + cantidadStock +
                ", ID='" + ID + '\'';
    }
}
