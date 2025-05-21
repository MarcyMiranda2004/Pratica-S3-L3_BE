package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, nullable = false)
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(length = 30, nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "numero_max_persone")
    private int numeroMaxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Partecipazione> listaPartecipazioni = new ArrayList<>();

    public Evento() {}

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
    }

    //id
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    //titolo
    public String getTitolo() {return titolo;}
    public void setTitolo(String titolo) {this.titolo = titolo;}

    //dataEvento
    public LocalDate getDataEvento() {return dataEvento;}
    public void setDataEvento(LocalDate dataEvento) {this.dataEvento = dataEvento;}

    //descrizione
    public String getDescrizione() {return descrizione;}
    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

    //tipoEvento
    public TipoEvento getTipoEvento() {return tipoEvento;}
    public void setTipoEvento(TipoEvento tipoEvento) {this.tipoEvento = tipoEvento;}

    //numeroMaxPartecipanti
    public int getNumeroMaxPartecipanti() {return numeroMaxPartecipanti;}
    public void setNumeroMaxPartecipanti(int numeroMaxPartecipanti) {this.numeroMaxPartecipanti = numeroMaxPartecipanti;}

    //location
    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}

    //listaPartecipazioni
    public List<Partecipazione> getListaPartecipazioni() {return listaPartecipazioni;}
    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {this.listaPartecipazioni = listaPartecipazioni;}

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                '}';
    }
}

