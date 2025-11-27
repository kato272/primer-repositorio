import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       
    Person persona1 = new Person();
    Scanner scanner = new Scanner(System.in);

    Person personaprueba = new Person();
    System.out.println(personaprueba.nombre);
        
    System.out.println("Ingrese el nombre de la persona 1:");
    persona1.setNombre(scanner.nextLine());
    System.out.println("Ingrese la altura de la persona 1:");
    persona1.setAltura(scanner.nextFloat());
    System.out.println("Ingrese el peso de la persona 1:");
    persona1.setPeso(scanner.nextInt());
    scanner.nextLine(); 

    Person persona2 = new Person();
    System.out.println("Ingrese el nombre de la persona 2:");
    persona2.setNombre(scanner.nextLine());
    System.out.println("Ingrese la altura de la persona 2:");
    persona2.setAltura(scanner.nextFloat());
    System.out.println("Ingrese el peso de la persona 2:");
    persona2.setPeso(scanner.nextInt());
    scanner.nextLine(); 

    Person persona3 = new Person();
    System.out.println("Ingrese el nombre de la persona 3:");
    persona3.setNombre(scanner.nextLine());
    System.out.println("Ingrese la altura de la persona 3:");
    persona3.setAltura(scanner.nextFloat());
    System.out.println("Ingrese el peso de la persona 3:");
    persona3.setPeso(scanner.nextInt());
    scanner.nextLine(); 
    
    Person tallest = persona1;
    if (persona2.getAltura() > tallest.getAltura()) {
        tallest = persona2;
    }
    if (persona3.getAltura() > tallest.getAltura()) {
        tallest = persona3;
    }
    System.out.println("La persona mas alta es: " + tallest.getNombre());

    Person heaviest = persona1;
    if (persona2.getPeso() > heaviest.getPeso()) {
        heaviest = persona2;
    }
    if (persona3.getPeso() > heaviest.getPeso()) {
        heaviest = persona3;
    }
    System.out.println("La persona que mas pesa es: " + heaviest.getNombre());

}}


