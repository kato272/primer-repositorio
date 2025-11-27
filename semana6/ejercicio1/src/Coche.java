public class Coche {

  private String marca;
  private String modelo;
  private int anio;
  private double precio;
  private int cantidadStock;
  private String ID;

  public Coche() {}

  public Coche(String marca, String modelo, int anio, double precio, int cantidadStock, String ID) {
    this.marca = marca;
    this.modelo = modelo;
    this.anio = anio;
    this.precio = precio;
    this.cantidadStock = cantidadStock;
    this.ID = ID;
  }

  public String getMarca() {
    return marca;
  }
  public String getModelo() {
    return modelo;
  }
  public int getAnio() {
    return anio;
  }
  public double getPrecio() {
    return precio;
  }
  public int getCantidadStock() {
    return cantidadStock;
  }
  public String getID() {
    return ID;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }
  public void setAnio(int anio) {
    this.anio = anio;
  }
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  public void setCantidadStock(int cantidadStock) {
    this.cantidadStock = cantidadStock;
  }
  public void setID(String ID) {
    this.ID = ID;
  }

  @Override
  public String toString() {
    return "Coche : " +
      "marca='" + marca + '\'' +
      ", modelo='" + modelo + '\'' +
      ", anio=" + anio +
      ", precio=" + precio +
      ", cantidadStock=" + cantidadStock +
      ", ID='" + ID + '\'';
  }
}