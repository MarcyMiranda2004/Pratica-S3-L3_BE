package Dao;

import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDao {
    private EntityManager em;

    public PartecipazioneDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Name_Pratica-S3-L3");
        em = emf.createEntityManager();
    }

    public void save(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void remove(long id) {
        Partecipazione p = getById(id);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Partecipazione con id " + id + " rimossa.");
        } else {
            System.out.println("Partecipazione con id " + id + " non trovata.");
        }
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
