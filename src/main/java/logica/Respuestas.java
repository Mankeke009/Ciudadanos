/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Respuestas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Preguntas pregunta;

    private String respuestaTexto;

    public Respuestas() {
    }

    public Respuestas(Usuario usuario, Preguntas pregunta, String respuestaTexto) {
        this.usuario = usuario;
        this.pregunta = pregunta;
        this.respuestaTexto = respuestaTexto;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Preguntas getPregunta() {
        return pregunta;
    }

    public void setPregunta(Preguntas pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "id=" + id + ", usuario=" + usuario + ", pregunta=" + pregunta + ", respuestaTexto='" + respuestaTexto + '\'' + '}';
    }
}