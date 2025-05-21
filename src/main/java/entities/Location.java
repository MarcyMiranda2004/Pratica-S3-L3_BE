package entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String città;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Evento> listaEventi = new ArrayList<>();

    public Location() {}

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    // id
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    // nome
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // città
    public String getCittà() { return città; }
    public void setCittà(String città) { this.città = città; }

    // listaEventi
    public List<Evento> getListaEventi() { return listaEventi; }
    public void setListaEventi(List<Evento> listaEventi) { this.listaEventi = listaEventi; }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
