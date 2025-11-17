package Modelo;

public class Datos{
    
    private Almacen[] almacenes;
    private double[] precios;
    private boolean ventasLeidas;
    private boolean preciosLeidos;
    private double ingresosTotales;
    
    public Datos(){
        almacenes = new Almacen[5];
        for(int i = 0;i<5;i++){
            almacenes[i] = new Almacen();
        }
        precios = new double[2];
        ventasLeidas = false;
        preciosLeidos = false;
        ingresosTotales = 0.0;
    }
    
    public void leerVentas(int[][] datosVentas){
         if (datosVentas.length != 5 || datosVentas[0].length != 2) {
            System.out.println("LA MATRIZ DEBE SER 5X2 AKATUFA");
            System.exit(1);
        }
        for (int i = 0; i < 5; i++) {
            almacenes[i].setVentas(datosVentas[i][0], datosVentas[i][1]);
        }
        ventasLeidas = true;
    }
    
    public void leerPrecios(double[] preciosProductos){
        if(preciosProductos.length!=2){
            System.out.println("Debe haber precios para dos productos");
            System.exit(1);
            }
        precios[0] = preciosProductos[0];
        precios[1] = preciosProductos[1];
        preciosLeidos = true;
    }
    public void calcularIngresos(){
        if(!ventasLeidas||!preciosLeidos){
            throw new IllegalStateException("No se puede calcular los ingresos");
       }
       ingresosTotales=0.0;
       for(Almacen a: almacenes){
           for(int i=0; i<2; i++){
               ingresosTotales += a.getVentaProducto(i)*precios[i];
           }
       }
    }
    public double getIngresosTotales() {
        if (!ventasLeidas || !preciosLeidos) {
            throw new IllegalStateException("No se pueden mostrar ingresos: faltan ventas o precios");
        }
        return ingresosTotales;
    }
    
    public Almacen[] getAlmacenes() {
        return almacenes;
    }

    public double[] getPrecios() {
        return precios;
    }

    public boolean isListoParaCalcular() {
        return ventasLeidas && preciosLeidos;
    }
    
}