package Dao;

import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {
    private EntityManager em;

    public LocationDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Name_Pratica-S3-L3");
        em = emf.createEntityManager();
    }

    public void save(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void remove(long id) {
        Location loc = getById(id);
        if (loc != null) {
            em.getTransaction().begin();
            em.remove(loc);
            em.getTransaction().commit();
            System.out.println("Location con id " + id + " rimossa.");
        } else {
            System.out.println("Location con id " + id + " non trovata.");
        }
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
