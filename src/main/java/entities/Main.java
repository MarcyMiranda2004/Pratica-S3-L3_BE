package entities;

import Dao.EventoDao;
import Dao.LocationDao;
import Dao.PartecipazioneDao;
import Dao.PersonaDao;
import eunum.Sesso;
import eunum.Stato;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Inizializzo i DAO
        PersonaDao personaDao = new PersonaDao();
        LocationDao locationDao = new LocationDao();
        EventoDao eventoDao = new EventoDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();

        // Creo una persona
        Persona persona = new Persona("Mario", "Rossi", "m.rossi@email.com", LocalDate.of(2000, 5, 21), Sesso.M);
        personaDao.save(persona);
        System.out.println("Persona salvata con ID: " + persona.getId());

        // Creo una location
        Location location = new Location("Stadio San Paolo", "Napoli");
        locationDao.save(location);
        System.out.println("Location salvata con ID: " + location.getId());

        // Creo un evento collegato alla location
        Evento evento = new Evento("Concerto", LocalDate.now(), "Concerto rock", TipoEvento.PUBBLICO, 2000);
        evento.setLocation(location);
        eventoDao.save(evento);
        System.out.println("Evento salvato con ID: " + evento.getId());

        // Creo una partecipazione che collega la persona all'evento
        Partecipazione partecipazione = new Partecipazione(persona, evento, Stato.CONFERMATA);
        partecipazioneDao.save(partecipazione);
        System.out.println("Partecipazione salvata con ID: " + partecipazione.getId());

        // Chiudo i DAO
        personaDao.close();
        locationDao.close();
        eventoDao.close();
        partecipazioneDao.close();
    }
}
