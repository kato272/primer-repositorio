import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner escan = new Scanner(System.in);

        System.out.print("Da el número de alumnos del curso: ");
        int nalumnos = escan.nextInt();
        Alumno[] alumnos = new Alumno[nalumnos];

        float suma1 = 0, suma2 = 0, sumafinal = 0;

        for (int i = 0; i < nalumnos; i++) {
            alumnos[i] = new Alumno(); 

            System.out.printf("Da la nota del 1er examen del alumno %d: ", i + 1);
            alumnos[i].nota1 = escan.nextFloat();
            System.out.printf("Da la nota del 2º examen del alumno %d: ", i + 1);
            alumnos[i].nota2 = escan.nextFloat();
            System.out.printf("Da la nota final del alumno %d: ", i + 1);
            alumnos[i].notafinal = escan.nextFloat();

            suma1 += alumnos[i].nota1;
            suma2 += alumnos[i].nota2;
            sumafinal += alumnos[i].notafinal;
        }

        float media1 = suma1 / nalumnos;
        float media2 = suma2 / nalumnos;
        float mediaFinal = sumafinal / nalumnos;

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Alumno | Examen 1 | Examen 2 | Nota Final");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < nalumnos; i++) {
            System.out.printf("%6d | %8.2f | %8.2f | %10.2f%n",
                    (i + 1), alumnos[i].nota1, alumnos[i].nota2, alumnos[i].notafinal);
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf(" Media | %8.2f | %8.2f | %10.2f%n", media1, media2, mediaFinal);

        escan.close();
    }
}