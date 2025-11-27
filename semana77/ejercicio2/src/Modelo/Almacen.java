package Modelo;

public class Almacen{
    
    private int[] ventas;
    
    public Almacen() {
        ventas = new int[2];
    }
    
    public void setVentas(int producto1, int producto2){
        ventas[0]=producto1;
        ventas[1]=producto2;
    }
    
    public int getVentaProducto(int indice){
        if(indice<0 || indice>= ventas.length){
            throw new IllegalArgumentException("Indice de producto invalido");
        }
    return ventas[indice];
    }
    
    public void setVentaProducto(int indice, int cantidad){
        if(indice<0||indice>=ventas.length){
            throw new IllegalArgumentException("Indice de producto invalido");
        }
        ventas[indice] = cantidad;
    }
    
    public int[]getVentas(){
        return ventas;
    }
    
    @Override
    public String toString(){
        return "Producto 1: "+ventas[0]+" unidades, Producto 2: "+ventas[1]+" unidades";
    }
    
    
}