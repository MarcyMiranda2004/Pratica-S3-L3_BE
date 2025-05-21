package entities;

import eunum.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20,nullable = false)
    private String nome;

    @Column(length = 20,nullable = false)
    private String cognome;

    @Column(length = 30,nullable = false)
    private String email;

    @Column(name = "data_nascita")
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING) // Indica che l'enum sarà salvato come Stringa nel DB (es. "M", "F")
    @Column(name = "sesso", nullable = false, length = 1)
    private Sesso sesso;

    @OneToMany(mappedBy = "partecipazione")
    @Column(nullable = false)
    private List<Partecipazione> listaPartecipazione;

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso, List<Partecipazione> listaPartecipazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
        this.listaPartecipazione = listaPartecipazione;
    }

    //id
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    //nome
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    //cognome
    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    //email
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    //dataDiNascita
    public LocalDate getDataDiNascita() {return dataDiNascita;}
    public void setDataDiNascita(LocalDate dataDiNascita) {this.dataDiNascita = dataDiNascita;}

    //sesso
    public Sesso getSesso() {return sesso;}
    public void setSesso(Sesso sesso) {this.sesso = sesso;}

    //listaPartecipazioni
    public List<Partecipazione> getListaPartecipazione() {return listaPartecipazione;}
    public void setListaPartecipazione(List<Partecipazione> listaPartecipazione) {this.listaPartecipazione = listaPartecipazione;}

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                ", listaPartecipazione=" + listaPartecipazione +
                '}';
    }
}
