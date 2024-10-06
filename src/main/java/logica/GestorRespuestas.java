package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorRespuestas {
    
    private String nombreUsuario;

    public GestorRespuestas(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void guardarRespuestas(String tema, String pregunta, String respuesta) {
        String formatoRespuesta = nombreUsuario + ";" + tema + ";" + pregunta + ";" + respuesta;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("respuestas.txt", true))) {
            bw.write(formatoRespuesta);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

