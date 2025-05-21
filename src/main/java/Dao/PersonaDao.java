package Dao;

import entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDao {
    private EntityManager em;

    public PersonaDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Name_Pratica-S3-L3");
        em = emf.createEntityManager();
    }

    public void save(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);
    }

    public void remove(long id) {
        Persona p = getById(id);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Persona con id " + id + " rimossa.");
        } else {
            System.out.println("Persona con id " + id + " non trovata.");
        }
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
