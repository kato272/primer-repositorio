public class Suma {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Error: Debes poner 3 argumentos: nombre, peso y altura.");
            return; 
        }

        Usuario usuario = Usuario.fromArgs(args);

        System.out.printf("%-15s %-10s %-10s %-10s\n", "Nombre", "Peso ", "Altura", "IMC");
        System.out.printf("-----------------------------------------------------------\n");


        System.out.printf("%-15s %-10.2f %-10.2f %-10.2f\n",
            usuario.nombre, usuario.peso, usuario.altura, usuario.calcularIMC());
    }
}
