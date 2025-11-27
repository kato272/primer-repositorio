public class EdadConsole {
    public static void main(String[] args) {
        java.io.Console console = System.console();

        if (console == null) {
            System.out.println("No se puede acceder a la consola.");
            return;
        }

        String nacimientoStr = console.readLine("Introduce tu año de nacimiento: ");
        String actualStr = console.readLine("Introduce el año actual: ");

        // Convertir de String a int usando Integer.parseInt
        int nacimiento = Integer.parseInt(nacimientoStr);
        int actual = Integer.parseInt(actualStr);

        int edad = actual - nacimiento;

        System.out.printf("Tienes %d años.\n", edad);
    }

}
