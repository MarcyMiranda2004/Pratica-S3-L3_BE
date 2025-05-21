package entities;

public class Main {

    public static void main(String[] args) {

        EventoDao dao = new EventoDao();

        Evento e1 = new Evento("Titolo evento", java.time.LocalDate.now(), "Descrizione evento", TipoEvento.PUBBLICO, 100);
        Evento e2 = new Evento("Hot Show", java.time.LocalDate.now(), "SUS", TipoEvento.PRIVATO, 50);

        dao.save(e1);
        System.out.println("Evento salvato con ID: " + e1.getId());

        dao.save(e2);
        System.out.println("Evento salvato con ID: " + e2.getId());

        dao.close();
    }
}
