import java.util.Scanner;


public class Ciudadanos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("1. Registrar Votante");
            System.out.println("2. Crear Consulta");
            System.out.println("3. Mostrar Resultados");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    //registrarVotante(scanner);
                    break;
                case 2:
                    //crearConsulta(scanner);
                    break;
                case 3:
                    //mostrarResultados();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
        
        scanner.close();
    }
}
   