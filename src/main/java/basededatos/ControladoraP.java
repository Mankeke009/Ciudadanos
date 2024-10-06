package basededatos;

import basededatos.exceptions.NonexistentEntityException;
//import static java.lang.constant.ConstantDescs.NULL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Rol;
import logica.Usuario;

public class ControladoraP {

    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    
    public List<Usuario> TraerUsuarios() {
        List<Usuario> listaU = usuJpa.findUsuarioEntities();
        return listaU;
    }
    
    public void guardarUsuario(Usuario usuario) {
        try {
            usuJpa.create(usuario);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    public List<Rol> TraerRoles() {
        return rolJpa.findRolEntities();   // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void borrarUsuario(long id_u) throws NonexistentEntityException {
       try{
           usuJpa.destroy(id_u);
       }catch(NonexistentEntityException ex){
           Logger.getLogger(ControladoraP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario TraerUsuario(long id_u) {
        return usuJpa.findUsuario(id_u); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            Logger.getLogger(ControladoraP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}





