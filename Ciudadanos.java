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
            System.out.println("4. Ver Votantes");
            System.out.println("5. Salir");
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
                    verVotantes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
        
        scanner.close();
    }
    private static boolean soloLetras(String nombre){
        for (char c : nombre.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    private static boolean soloNumeros(String id){
        for (char c : id.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private static boolean repiteId(String id) {
        for (Votante v : votantes) {
            if (v.getIdentificacion().equals(id)) {
                return true;
            }
        }
        return false;
    }
    private static void registrarVotante(Scanner scanner) {
        String nombre;
        while (true){ 
            System.out.println("Nombre del votante:");
            nombre = scanner.nextLine();
            if (soloLetras(nombre)) {
                break;
            }
            System.out.println("Nombre inválido. Debe contener solo letras.");
        }
        String id;
        while (true){ 
            System.out.println("Identificación:");
            id = scanner.nextLine();
            if (soloNumeros(id) && !repiteId(id)) {
                break;
            }
            if(repiteId(id)){
                System.out.println("Identificación inválida. id existente.");     
            }
            else{
                System.out.println("Identificación inválida. Debe contener solo números.");
            }
        }

        votantes.add(new Votante(nombre, id));
        System.out.println("Votante registrado con éxito.");
    }
    private static void crearConsulta(Scanner scanner) {
        String nombre;
        while (true){
            System.out.println("Nombre de la consulta:");
            nombre = scanner.nextLine();
            if (soloLetras(nombre)) {
                break;
            }
            System.out.println("Consulta inválida. Debe contener solo letras.");
        }
        ConsultaCiudadana consulta = new ConsultaCiudadana(nombre);
        consultas.add(consulta);
        System.out.println("Consulta creada con éxito.");
    }

    private static void mostrarResultados() {
        if (consultas.isEmpty()) {
            System.out.println("No hay consultas disponibles.");
            return;
        }
        for (ConsultaCiudadana consulta : consultas) {
            System.out.println("Resultados de la consulta: " + consulta.getNombre());
            consulta.mostrarResultados();
        }
    }
    private static void verVotantes() {
        if (votantes.isEmpty()) {
            System.out.println("No hay votantes registrados.");
            return;
        }
        
        System.out.println("Votantes registrados:");
        for (Votante votante : votantes) {
            System.out.println("Nombre: " + votante.getNombre() + ", Identificación: " + votante.getIdentificacion());
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

   