public class Producto {
  String nombre;
  double precioSinIVA;
  double precioConIVA;
  static final double IVA = 0.21;
  public Producto(String nombre, double precioSinIVA) {
    this.nombre = nombre;
    this.precioSinIVA = precioSinIVA;
    this.precioConIVA = precioSinIVA * (1 + IVA);
  }
  public double precioTotal(double cantidad) {
    return precioConIVA * cantidad;
  }
}