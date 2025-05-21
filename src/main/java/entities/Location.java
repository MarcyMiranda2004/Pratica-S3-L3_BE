package entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20,nullable = false)
    private String nome;

    @Column(length = 20,nullable = false)
    private String città;

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    //id
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    //nome
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    //città
    public String getCittà() {return città;}
    public void setCittà(String città) {this.città = città;}

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
