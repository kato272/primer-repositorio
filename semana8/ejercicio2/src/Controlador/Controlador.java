package Controlador;
import Modelo.*;
import Vista.*;

public class Controlador{
    
    private Datos modelo;
    private Vista vista;
    
    public Controlador(){
        modelo=new Datos();
        vista = new Vista();
    }
    public void iniciar(){
    char opcion;
    do{
        opcion = vista.mostrarMenu();
    switch (opcion){
        
        case '1':
            System.out.println("Has elegido leer tabla de ventas");
            int[][] matriz = vista.leerVentas();
            modelo.leerVentas(matriz);
            break;
        case '2':
            System.out.println("Has elegido leer la tabla de precios");
            double[] precios = vista.leerPrecios();
            modelo.leerPrecios(precios);
            break;
        case '3':
            System.out.println("Has elegido calcular los ingresos totales");
            if(modelo.isListoParaCalcular()){
                modelo.calcularIngresos();
            } else {
                vista.mostrarError("Faltan ventas o precios para calcular ingresos");
            }
            break;
        case '4':
            if(modelo.isListoParaCalcular()){
                vista.mostrarResultados(modelo.getAlmacenes(), modelo.getPrecios(), modelo.getIngresosTotales());
            } else {
                vista.mostrarError("No se puede mostrar resultados antes de calcular ingresos");
            }
            break;
        case 'q':
            vista.mostrarInfo("Saliendo...");
            break;
        default:
            vista.mostrarError("Opción no válida");
    }
        
    }while(opcion!='q');
    
    }
    
}