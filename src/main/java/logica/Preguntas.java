package logica;

import javax.persistence.*;

@Entity
public class Preguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;

    public Preguntas() {
    }

    public Preguntas(String texto, Tema tema) {
        this.texto = texto;
        this.tema = tema;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", texto='" + texto + '\'' + ", tema=" + tema.getNombre() + '}';
    }
}