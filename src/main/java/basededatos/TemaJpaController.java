package basededatos;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.Tema;

public class TemaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public TemaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Tema tema) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tema);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Tema encontrarTema(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tema.class, id);
        } finally {
            em.close();
        }
    }

    // Otros mÃ©todos para eliminar, actualizar, etc.
}