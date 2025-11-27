import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] palabras = new String[5];

        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Introduce la palabra " + (i + 1) + ": ");
            palabras[i] = sc.nextLine();
        }

        Arrays.sort(palabras);

        System.out.println("\nPalabras ordenadas:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        sc.close();
    }
}