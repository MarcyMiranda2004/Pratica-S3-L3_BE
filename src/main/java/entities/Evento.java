package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20,nullable = false)
    private String titolo;

    @Column(name = "data_nascita")
    private LocalDate dataEvento;

    @Column(length = 30,nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "numero_max_persone")
    private int numeroMaxPartecipanti;

    @Column(name = "partecipazioni")
    private List<Partecipazione> listaPartecipazioni;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
        this.listaPartecipazioni = li
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

