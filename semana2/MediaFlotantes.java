import com.coti.tools.Esdia;

public class MediaFlotantes {
    public static void main(String[] args) {
        int N = 0;

        while (N <= 0) {
            System.out.print("Ingrese un numero entero mayor que 0: ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N <= 0) {
                    System.err.println("Error: el numero tiene que ser mayor que 0.");
                }
            } else {
                System.err.println("Error: debe ingresar un entero.");
                scanner.next(); 
            }
        }

        double suma = 0.0;

        
        for (int i = 1; i <= N; i++) {
            double num;
            while (true) {
                System.out.print("Ingrese el número "+i+ ": ");
                if (scanner.hasNextDouble()) {
                    num = scanner.nextDouble();
                    break;
                } else {
                    System.err.println("Error: debe ingresar un numero de coma flotante.");
                    scanner.next(); 
                }
            }
            suma += num;
        }

        double media = suma / N;
        System.out.printf("La media de los %d números es: %.2f\n", N, media);

        scanner.close();
    }
}

