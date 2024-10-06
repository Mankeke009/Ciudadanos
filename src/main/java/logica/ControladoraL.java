package logica;

import basededatos.ControladoraP;
import basededatos.RolJpaController;
import basededatos.UsuarioJpaController;
import basededatos.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class ControladoraL {
    
    ControladoraP controlP;
    @PersistenceContext
    private EntityManager em;
    private List<Usuario> listaUsuarios;
   
    
    public ControladoraL(){
        controlP = new ControladoraP();
    }

    public Usuario validarUsuario(String usuario, String contrasena) {
   
        Usuario user = null;
        List<Usuario> listaUsuario = controlP.TraerUsuarios();
     
        for(Usuario i : listaUsuario){ 
            
            if(i.getNombreU().equals(usuario)){
                
                if(i.getContrasenaU().equals(contrasena)){
                   
                    user = i;
                    break;
                }
                else{
                    
                    user = null;
                    break;
                }
                
            }
            else{
                user = null;
                                       
            }
        }
        return user;
    }
    public String registrarUsuario(String nombreU, String contrasenaU) {
        
        UsuarioJpaController controlP = new UsuarioJpaController();
        List<Usuario> listaUsuarios = controlP.findUsuarioEntities();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreU().equals(nombreU)) {
                return "El usuario ya existe.";
            }
        }

        
        RolJpaController rolJpa = new RolJpaController();
        Rol rolVisitante = rolJpa.findRolById(2L); 

        if (rolVisitante == null) {
            return "No se encontró el rol de Visitante.";
        }

        
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreU(nombreU);
        nuevoUsuario.setContrasenaU(contrasenaU);
        nuevoUsuario.setUnRol(rolVisitante);
        nuevoUsuario.setId(maxID());

        guardarUsuario(nuevoUsuario);  

        return "Registro exitoso!";
    }

   
    public void guardarUsuario(Usuario usuario) {
        UsuarioJpaController usuarioJpa = new UsuarioJpaController();
        usuarioJpa.create(usuario);
    }
    public List<Usuario> TraerUsuarios() {    
        return controlP.TraerUsuarios(); 
    }
    public List<Rol> TraerRoles() {    
        return controlP.TraerRoles(); 
    }

    public void crearUsuario(String usuario, String contra, String rol) {
        Usuario usu = new Usuario();
        usu.setNombreU(usuario);
        usu.setContrasenaU(contra);
        
        Rol rolE = new Rol();
        rolE = this.EncontrarRol(rol);
        if(rolE != null){
            usu.setUnRol(rolE);
        }
        
        long id = this.buscarUltimaIdU();
        usu.setId(id+1);
        
        
        controlP.crearUsuario(usu);
        
    }

    private Rol EncontrarRol(String rol) {
        List<Rol> listaRoles = controlP.TraerRoles();
        for(Rol i : listaRoles){
            if(i.getNombreR().equals(rol)){
                return i;
                
            }
        }
        return null;
        
    }

    private long buscarUltimaIdU() {
        List<Usuario> listaU = this.TraerUsuarios(); 
        
        Usuario usu = listaU.get(listaU.size()-1);
        return usu.getId();
        
    }

    public void borrarUsuario(long id_u) throws NonexistentEntityException {
        controlP.borrarUsuario(id_u); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario TraerUsuario(long id_u) {
        return controlP.TraerUsuario(id_u); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rol) {
        usu.setNombreU(usuario);
        usu.setContrasenaU(contra);
        
        Rol rolE = new Rol();
        rolE = this.EncontrarRol(rol);
        if(rolE != null){
            usu.setUnRol(rolE);
        }
        controlP.editarUsuario(usu);
    }

    private long maxID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
    
}

