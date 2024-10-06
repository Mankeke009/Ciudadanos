
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Usuario implements Serializable {
    
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
        
    private long id;
    private String NombreU;
    private String contrasenaU;
    @ManyToOne 
    @JoinColumn(name="Rol_id")
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(long id, String NombreU, String contrasenaU, Rol unRol) {
        this.id = id;
        this.NombreU = NombreU;
        this.contrasenaU = contrasenaU;
        this.unRol = unRol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreU() {
        return NombreU;
    }

    public void setNombreU(String NombreU) {
        this.NombreU = NombreU;
    }

    public String getContrasenaU() {
        return contrasenaU;
    }

    public void setContrasenaU(String contrasenaU) {
        this.contrasenaU = contrasenaU;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    
}

