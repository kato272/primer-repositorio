import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Da el precio sin IVA de las manzanas HOY: ");
        double precioManzanaSinIva = scan.nextDouble();
        System.out.println("Da el precio sin IVA de las peras HOY: ");
        double precioPeraSinIva = scan.nextDouble();

        Producto[] productos = new Producto[2];
        productos[0] = new Producto("Manzana", precioManzanaSinIva);
        productos[1] = new Producto("Pera", precioPeraSinIva);

        int numeroCliente = 1;
        boolean continuar = true;

        while (continuar) {

            System.out.println("Cliente NO" + numeroCliente);
            double[] cantidades = new double[2];

            for (int i = 0; i < productos.length; i++) {
                System.out.print("Introduce cantidad de " + productos[i].nombre + " en kg: ");
                cantidades[i] = scan.nextDouble();
            }

            String header = String.format("%-12s %10s %20s %15s", "Producto", "Cantidad", "Precio Kg", "Total");
            System.out.println(header);
            System.out.println("-----------------------------------------------------------");

            double totalFactura = 0;

            for (int i = 0; i < productos.length; i++) {
                double totalProducto = productos[i].precioTotal(cantidades[i]);
                totalFactura += totalProducto;

                System.out.printf("%-12s %10.2f %20.2f %15.2f\n",
                        productos[i].nombre, cantidades[i], productos[i].precioConIVA, totalProducto);
            }

            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-40s %15.2f\n", "Total con IVA", totalFactura);
            System.out.println("-----------------------------------------------------------");

            numeroCliente++;

            System.out.print("Nuevo cliente?: ");
            String respuesta = scan.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        scan.close();
    }
}
