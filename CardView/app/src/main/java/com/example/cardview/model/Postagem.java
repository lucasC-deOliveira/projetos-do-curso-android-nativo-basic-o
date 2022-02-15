package com.example.cardview.model;

public class Postagem {
    private String nome;
    private String postagem;
    //imagem é int porque para o metodo image resources e passaado um interio de refencia da imagem
    private int imagem;

    public Postagem(){}

    public Postagem(String nome, String postagem, int imagem) {
        this.nome = nome;
        this.postagem = postagem;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
