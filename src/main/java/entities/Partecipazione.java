package entities;

import eunum.Stato;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato", nullable = false, length = 20)
    private Stato stato;

    public Partecipazione() {}

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    //id
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    //persona
    public Persona getPersona() {return persona;}
    public void setPersona(Persona persona) {this.persona = persona;}

    //evento
    public Evento getEvento() {return evento;}
    public void setEvento(Evento evento) {this.evento = evento;}

    //stato
    public Stato getStato() {return stato;}
    public void setStato(Stato stato) {this.stato = stato;}

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
