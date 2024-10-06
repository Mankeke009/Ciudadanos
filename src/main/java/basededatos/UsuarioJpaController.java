package basededatos;

import basededatos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import logica.Rol;
import logica.Usuario;

public class UsuarioJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("LoginPU");  // Asegúrate de que el nombre coincide con el de tu persistence.xml
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            // Relacionamos el usuario con su Rol si existe
            Rol unRol = usuario.getUnRol();
            if (unRol != null) {
                unRol = em.getReference(unRol.getClass(), unRol.getId());
                usuario.setUnRol(unRol);
            }
            em.persist(usuario);
            if (unRol != null) {
                unRol.getListaUsuarios().add(usuario);
                em.merge(unRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Rol oldRol = persistentUsuario.getUnRol();
            Rol newRol = usuario.getUnRol();
            if (newRol != null) {
                newRol = em.getReference(newRol.getClass(), newRol.getId());
                usuario.setUnRol(newRol);
            }
            usuario = em.merge(usuario);
            if (oldRol != null && !oldRol.equals(newRol)) {
                oldRol.getListaUsuarios().remove(usuario);
                em.merge(oldRol);
            }
            if (newRol != null && !newRol.equals(oldRol)) {
                newRol.getListaUsuarios().add(usuario);
                em.merge(newRol);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("El usuario con id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El usuario con id " + id + " no existe.");
            }
            Rol unRol = usuario.getUnRol();
            if (unRol != null) {
                unRol.getListaUsuarios().remove(usuario);
                em.merge(unRol);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            var root = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(root));
            return em.createQuery(cq).getSingleResult().intValue();
        } finally {
            em.close();
        }
    }
}
