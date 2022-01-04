package it.ternali.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "autore")
    private String autore;
    @ManyToOne
    @JoinColumn(name = "genere_id")
    private Genere genere;
    @Column(name = "anno")
    private LocalDate anno;
    @Column(name = "stato")
    private Stato stato;
    private String image;

    public Libro() {
    }

    public Libro(int id, String titolo, String autore, Genere genere, LocalDate anno, Stato stato) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.anno = anno;
        this.stato = stato;
    }
}
