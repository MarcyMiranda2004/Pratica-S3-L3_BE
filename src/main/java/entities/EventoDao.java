package entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {
private EntityManager em;

public EventoDao() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Name_Pratica-S3-L2");
    em = emf.createEntityManager();
}

    //dovrà salvare nel database l'evento che gli viene passato
public void save(Evento evento) {
    em.getTransaction().begin(); //inizio la transazione
    em.persist(evento); //dico al jpa di salvare l'evento sul database
    em.getTransaction().commit(); //il salvataggio effettivo avverrà solo al commit
}

public Evento getById(long id) {
    return em.find(Evento.class,id);
}

public void remove(long id) {
    Evento e = getById(id);

    if(e!=null) {
        em.getTransaction().begin();
        em.remove(e);//dico al jpa di rimuovere l'evento sul database
        em.getTransaction().commit();
        System.out.println("Evento con id " + id + "trovato e rimosso.");
    } else {
        System.out.println("Id evento " + id + " non trovato");
    }
}

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
