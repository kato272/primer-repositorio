package Vista;

import java.util.Scanner;
import Modelo.Almacen;

public class Vista {
    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }

    public char mostrarMenu() {
        System.out.println("\n----- MENÚ -----");
        System.out.println("1.- Leer tabla de ventas");
        System.out.println("2.- Leer tabla de precios");
        System.out.println("3.- Calcular ingresos totales");
        System.out.println("4.- Mostrar resultados");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
        String linea = sc.nextLine();
        return linea.isEmpty() ? ' ' : linea.charAt(0);
    }

    public int[][] leerVentas() {
        int[][] ventas = new int[5][2];
        System.out.println("Introduce las ventas de cada almacén y producto:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Almacén " + (i+1) + " - Producto 1: ");
            ventas[i][0] = leerEntero();
            System.out.print("Almacén " + (i+1) + " - Producto 2: ");
            ventas[i][1] = leerEntero();
        }
        return ventas;
    }

    public double[] leerPrecios() {
        double[] precios = new double[2];
        System.out.println("Introduce los precios de los productos:");
        System.out.print("Producto 1: ");
        precios[0] = leerDouble();
        System.out.print("Producto 2: ");
        precios[1] = leerDouble();
        return precios;
    }

    public void mostrarResultados(Almacen[] almacenes, double[] precios, double ingresosTotales) {
        System.out.println("\n--- RESULTADOS ---");
        for (int i = 0; i < almacenes.length; i++) {
            System.out.println("Almacén " + (i+1) + ": " + almacenes[i].toString());
        }
        System.out.println("Precios: Producto 1 = " + precios[0] + " €, Producto 2 = " + precios[1] + " €");
        System.out.println("Ingresos totales: " + ingresosTotales + " €");
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido, introduce un número entero: ");
            }
        }
    }

    private double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido, introduce un número válido: ");
            }
        }
    }

    public void mostrarError(String msg) {
        System.out.println("ERROR: " + msg);
    }

    public void mostrarInfo(String msg) {
        System.out.println(msg);
    }
}
