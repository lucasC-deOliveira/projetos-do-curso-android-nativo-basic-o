package com.example.recyclerview.model;

public class Filme {

    private String Filme;
    private String genero;
    private String ano;

    public Filme(String filme, String genero, String ano) {
        Filme = filme;
        this.genero = genero;
        this.ano = ano;
    }

    public String getFilme() {
        return Filme;
    }

    public void setFilme(String filme) {
        Filme = filme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
