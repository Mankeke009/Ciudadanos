package basededatos;

import basededatos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import logica.Rol;
import logica.Usuario;

public class RolJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public RolJpaController() {
        emf = Persistence.createEntityManagerFactory("LoginPU");  // Asegúrate de que el nombre coincide con el de tu persistence.xml
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public Rol findRolById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }
    public void create(Rol rol) {
        if (rol.getListaUsuarios() == null) {
            rol.setListaUsuarios(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            // Persistimos cada usuario asociado al rol
            List<Usuario> attachedUsuarios = new ArrayList<>();
            for (Usuario usuario : rol.getListaUsuarios()) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                attachedUsuarios.add(usuario);
            }
            rol.setListaUsuarios(attachedUsuarios);
            em.persist(rol);
            for (Usuario usuario : rol.getListaUsuarios()) {
                Rol oldRol = usuario.getUnRol();
                usuario.setUnRol(rol);
                usuario = em.merge(usuario);
                if (oldRol != null) {
                    oldRol.getListaUsuarios().remove(usuario);
                    oldRol = em.merge(oldRol);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getId());
            List<Usuario> oldUsuarios = persistentRol.getListaUsuarios();
            List<Usuario> newUsuarios = rol.getListaUsuarios();
            List<Usuario> attachedUsuarios = new ArrayList<>();
            for (Usuario usuario : newUsuarios) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                attachedUsuarios.add(usuario);
            }
            newUsuarios = attachedUsuarios;
            rol.setListaUsuarios(newUsuarios);
            rol = em.merge(rol);
            for (Usuario usuario : oldUsuarios) {
                if (!newUsuarios.contains(usuario)) {
                    usuario.setUnRol(null);
                    usuario = em.merge(usuario);
                }
            }
            for (Usuario usuario : newUsuarios) {
                if (!oldUsuarios.contains(usuario)) {
                    Rol oldRol = usuario.getUnRol();
                    usuario.setUnRol(rol);
                    usuario = em.merge(usuario);
                    if (oldRol != null && !oldRol.equals(rol)) {
                        oldRol.getListaUsuarios().remove(usuario);
                        oldRol = em.merge(oldRol);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = rol.getId();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("El rol con id " + id + " no existe.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El rol con id " + id + " no existe.");
            }
            List<Usuario> listaUsuarios = rol.getListaUsuarios();
            for (Usuario usuario : listaUsuarios) {
                usuario.setUnRol(null);
                usuario = em.merge(usuario);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            var root = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(root));
            return em.createQuery(cq).getSingleResult().intValue();
        } finally {
            em.close();
        }
    }
}