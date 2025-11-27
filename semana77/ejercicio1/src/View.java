import java.util.Scanner;

public class View {

    private Scanner scan = new Scanner(System.in);

    public void showMenu() {
        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Leer los números");
        System.out.println("2. Calcular la suma");
        System.out.println("3. Mostrar el resultado");
        System.out.println("q. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int getNumberInput(String prompt) {
        System.out.print(prompt);
        int num = scan.nextInt();
        scan.nextLine(); // limpiar buffer
        return num;
    }

    public String getUserOpt() {
        return scan.nextLine();
    }

    public void showResult(int result) {
        System.out.println("El resultado de la suma es: " + result);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
