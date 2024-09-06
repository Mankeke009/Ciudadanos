import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ciudadanos {
    private static List<Votante> votantes = new ArrayList<>();
    private static List<ConsultaCiudadana> consultas = new ArrayList<>();
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
                    crearConsulta(scanner);
                    break;
                case 3:
                    mostrarResultados();
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
    private static void crearConsulta(Scanner scanner) {
        System.out.println("Nombre de la consulta:");
        String nombre = scanner.nextLine();
        ConsultaCiudadana consulta = new ConsultaCiudadana(nombre);
        consultas.add(consulta);
        System.out.println("Consulta creada con éxito.");
    }

    private static void mostrarResultados() {
    for (ConsultaCiudadana consulta : consultas) {
        System.out.println("Resultados de la consulta: " + consulta.getNombre());
        consulta.mostrarResultados();
    }
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
class ConsultaCiudadana {
    private String nombre;
    private List<Tema> temas;

    public ConsultaCiudadana(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

    public void agregarTema(Tema tema) {
        this.temas.add(tema);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public void mostrarResultados() {
        for (Tema tema : temas) {
            tema.mostrarResultados();
        }
    }
}
class Tema {
    private String nombre;
    private List<Pregunta> preguntas;

    public Tema(String nombre) {
        this.nombre = nombre;
        this.preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void mostrarResultados() {
        for (Pregunta pregunta : preguntas) {
            System.out.println("Resultados para la pregunta: " + pregunta.getTexto());
            pregunta.mostrarResultados();
        }
    }
}
class Pregunta {
    private String texto;
    private Map<String, Integer> resultados;

    public Pregunta(String texto) {
        this.texto = texto;
        this.resultados = new HashMap<>();
    }

    public void agregarRespuesta(String respuesta) {
        resultados.put(respuesta, resultados.getOrDefault(respuesta, 0) + 1);
    }

    public String getTexto() {
        return texto;
    }

    public Map<String, Integer> getResultados() {
        return resultados;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setResultados(Map<String, Integer> resultados) {
        this.resultados = resultados;
    }

    public void mostrarResultados() {
        for (Map.Entry<String, Integer> entrada : resultados.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}

   