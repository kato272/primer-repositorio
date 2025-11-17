import java.util.Scanner;

public class EdadScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu año de nacimiento: ");
        int nacimiento = sc.nextInt();

        System.out.print("Introduce el año actual: ");
        int actual = sc.nextInt();

        int edad = actual - nacimiento;

        // printf permite formatear la salida (como en C)
        System.out.printf("Tienes %d años.\n", edad);

        sc.close();
    }
}
