public class App {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Error: 2 argumentos requeridos");
            return;
        }

            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            int suma = num1 + num2;

            System.out.println("La suma es:" + suma);

    }
}