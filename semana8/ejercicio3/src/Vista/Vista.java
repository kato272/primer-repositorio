package Vista;
import java.util.Scanner;
import Modelo.Coche;
import java.util.ArrayList;

public class Vista {
    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }

    public int sacarMenu() {
        System.out.println("\n----- MENu CONCESIONARIO -----");
        System.out.println("1. Añadir coche nuevo");
        System.out.println("2. Enseñar todos los coches");
        System.out.println("3. Modificar datos coche");
        System.out.println("4. Eliminar coche");
        System.out.println("5. Salir");
        System.out.print("Elige una opción 1-5: ");
        return sc.nextInt();
    }

    public Coche pedirDatitos() {
        sc.nextLine(); 
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Año: ");
        int año = sc.nextInt();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Cantidad stock: ");
        int stock = sc.nextInt();
        System.out.print("ID: ");
        int ID = sc.nextInt();
        return new Coche(marca, modelo, año, precio, stock, ID);
    }

    public int pedirID() {
        System.out.print("Introduce ID del coche: ");
        return sc.nextInt();
    }

    public void mostrarCoches(ArrayList<Coche> coches) {
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            for (Coche c : coches) {
                System.out.println(c);
            }
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void cerrarScanner() {
        sc.close();
    }
}
