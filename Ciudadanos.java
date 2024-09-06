import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ciudadanos {
    private static List<Votante> votantes = new ArrayList<>();
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
                    registrarVotante(scanner);
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
    private static void registrarVotante(Scanner scanner) {
        System.out.println("Nombre del votante:");
        String nombre = scanner.nextLine();
        System.out.println("Identificación:");
        String id = scanner.nextLine();
        votantes.add(new Votante(nombre, id));
        System.out.println("Votante registrado con éxito.");
    }

}
class Votante {
    private String nombre;
    private String identificacion;

    public Votante(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
   