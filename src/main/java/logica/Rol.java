
package logica;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {
    
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    
    private long id;
    private String NombreR;
    private String descripcion;
    @OneToMany (mappedBy="unRol")
    private List<Usuario> listaUsuarios;

    public Rol() {
    }

    public Rol(long id, String NombreR, String descripcion, List<Usuario> listaUsuarios) {
        this.id = id;
        this.NombreR = NombreR;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreR() {
        return NombreR;
    }

    public void setNombreR(String NombreR) {
        this.NombreR = NombreR;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}    
  