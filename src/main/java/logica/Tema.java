package logica;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Tema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "tema")
    private List<Preguntas> preguntas;

    public Tema() {
    }

    public Tema(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "Tema{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }

    
}