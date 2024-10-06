package basededatos;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.Respuestas;

public class RespuestasJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public RespuestasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Respuestas respuesta) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(respuesta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Respuestas encontrarRespuesta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Respuestas.class, id);
        } finally {
            em.close();
        }
    }

    // Otros mÃ©todos para eliminar, actualizar, etc.
}