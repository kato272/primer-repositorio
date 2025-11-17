import com.coti.tools.Esdia;

public class MediaFlotantes {
    public static void main(String[] args) {
        int N = 0;

        // Solicitar un entero mayor que cero
        while (N <= 0) {
            System.out.print("Ingrese un número entero mayor que 0: ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N <= 0) {
                    System.err.println("Error: el número debe ser mayor que 0.");
                }
            } else {
                System.err.println("Error: debe ingresar un número entero.");
                scanner.next(); // descarta la entrada inválida
            }
        }

        double suma = 0.0;

        // Solicitar N números de coma flotante
        for (int i = 1; i <= N; i++) {
            double num;
            while (true) {
                System.out.print("Ingrese el número " + i + ": ");
                if (scanner.hasNextDouble()) {
                    num = scanner.nextDouble();
                    break;
                } else {
                    System.err.println("Error: debe ingresar un número de coma flotante.");
                    scanner.next(); // descarta entrada inválida
                }
            }
            suma += num;
        }

        double media = suma / N;
        System.out.printf("La media aritmética de los %d números es: %.2f\n", N, media);

        scanner.close();
    }
}
