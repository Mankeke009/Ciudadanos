package basededatos;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.Preguntas;

public class PreguntasJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public PreguntasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Preguntas pregunta) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pregunta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Preguntas encontrarPregunta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Preguntas.class, id);
        } finally {
            em.close();
        }
    }

    // Otros mÃ©todos como eliminar, actualizar, etc.
}