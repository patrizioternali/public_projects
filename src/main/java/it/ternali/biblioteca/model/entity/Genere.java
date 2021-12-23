package it.ternali.biblioteca.model.entity;

public class Genere {

    private int id;
    private String genere;

    public Genere() {
    }

    public Genere(int id, String genere) {
        this.id = id;
        this.genere = genere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
