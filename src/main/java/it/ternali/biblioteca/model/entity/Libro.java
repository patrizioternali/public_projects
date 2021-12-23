package it.ternali.biblioteca.model.entity;

import java.time.LocalDate;

public class Libro {

    private int id;
    private String titolo;
    private String autore;
    private Genere genere;
    private LocalDate anno;
    private Stato stato;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public LocalDate getAnno() {
        return anno;
    }

    public void setAnno(LocalDate anno) {
        this.anno = anno;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
