import java.util.Scanner;

public class App {
  public static void main(String args[]) {

    int eleccion = 0;
    Scanner escan = new Scanner(System.in);

    Coche[] coches = new Coche[100];
    int numCoches = 0;

    do {

      System.out.printf("-----------------------------------\n");
      System.out.printf("MENU CONCESIONARIO                 \n");
      System.out.printf("-----------------------------------\n");
      System.out.printf("1. AÑADIR COCHE NUEVO              \n");
      System.out.printf("2. MOSTRAR TODOS LOS COCHES        \n");
      System.out.printf("3. MODIFICAR DATOS DEL COCHE       \n");
      System.out.printf("4. ELIMINAR COCHE                  \n");
      System.out.printf("5. SALIR DEL PROGRAMA              \n");
      System.out.printf("-----------------------------------\n");

      System.out.println("Elige una ocpión (1-5): \n");

      eleccion = escan.nextInt();
      escan.nextLine();

      switch (eleccion) {

      case 1:
        System.out.println("Has elegido la opción 1:\n");

        System.out.print("Introduce la marca: ");
        String marca = escan.nextLine();

        System.out.print("Introduce el modelo: ");
        String modelo = escan.nextLine();

        System.out.print("Introduce el año: ");
        int anio = escan.nextInt();

        System.out.print("Introduce el precio: ");
        double precio = escan.nextDouble();

        System.out.print("Introduce la cantidad en stock: ");
        int cantidadStock = escan.nextInt();

        escan.nextLine();

        System.out.print("Introduce el ID del coche: ");
        String ID = escan.nextLine();

        coches[numCoches] = new Coche();
        coches[numCoches].setMarca(marca);
        coches[numCoches].setModelo(modelo);
        coches[numCoches].setAnio(anio);
        coches[numCoches].setPrecio(precio);
        coches[numCoches].setCantidadStock(cantidadStock);
        coches[numCoches].setID(ID);

        numCoches++;

        System.out.println("\nCoche añadido correctamente.\n");
        break;

      case 2:
        System.out.println("Has elegido la opción 2:\n");
        System.out.println("Listado de coches en el concesionario:\n");

        boolean hayCoches = false;

        for (Coche coche: coches) {
          if (coche != null) {
            System.out.println(coche);
            hayCoches = true;
          }
        }

        if (!hayCoches) {
          System.out.println("No hay coches registrados todavía.\n");
        }

        break;

      case 3:
        System.out.println("Has elegido la opción 3:\n");

        System.out.print("Introduce el ID del coche que quieres modificar: ");
        String idBuscar = escan.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < numCoches; i++) {
          if (coches[i] != null && coches[i].getID().equals(idBuscar)) {
            encontrado = true;
            System.out.println("Coche encontrado: " + coches[i]);

            System.out.println("\n¿Qué quieres modificar?");
            System.out.println("1. Marca");
            System.out.println("2. Modelo");
            System.out.println("3. Año");
            System.out.println("4. Precio");
            System.out.println("5. Cantidad en stock");
            System.out.println("6. ID");
            System.out.print("Elige opción (1-6): ");
            int opcionMod = escan.nextInt();
            escan.nextLine();

            switch (opcionMod) {
            case 1:
              System.out.print("Introduce nueva marca: ");
              coches[i].setMarca(escan.nextLine());
              break;
            case 2:
              System.out.print("Introduce nuevo modelo: ");
              coches[i].setModelo(escan.nextLine());
              break;
            case 3:
              System.out.print("Introduce nuevo año: ");
              coches[i].setAnio(escan.nextInt());
              escan.nextLine();
              break;
            case 4:
              System.out.print("Introduce nuevo precio: ");
              coches[i].setPrecio(escan.nextDouble());
              escan.nextLine();
              break;
            case 5:
              System.out.print("Introduce nueva cantidad en stock: ");
              coches[i].setCantidadStock(escan.nextInt());
              escan.nextLine();
              break;
            case 6:
              System.out.print("Introduce nuevo ID: ");
              coches[i].setID(escan.nextLine());
              break;
            default:
              System.out.println("Opción no válida.");
            }

            System.out.println("\nCoche modificado correctamente.");
            break;
          }
        }

        if (!encontrado) {
          System.out.println("No se encontró ningún coche con ese ID.");
        }

        break;

      case 4:
        System.out.println("Has elegido la opción 4:\n");

        escan.nextLine();
        System.out.print("Introduce el ID del coche que quieres eliminar: ");
       
        String idEliminar = escan.nextLine();

        boolean encontradoEliminar = false;

        for (int i = 0; i < numCoches; i++) {
          if (coches[i] != null && coches[i].getID().equals(idEliminar)) {
            encontradoEliminar = true;

            System.out.println("Coche encontrado: " + coches[i]);

            for (int j = i; j < numCoches - 1; j++) {
              coches[j] = coches[j + 1];
            }

            coches[numCoches - 1] = null;
            numCoches--;

            System.out.println("\nCoche eliminado correctamente.");
            break;
          }
        }

        if (!encontradoEliminar) {
          System.out.println(" No se encontró ningún coche con ese ID.");
        }

        break;

      case 5:

        System.out.println("Has elegido la opcion 5:");
        System.out.println("Saliendo del programa...");
        System.exit(0);

      }

    } while (eleccion != 5);

  }
}