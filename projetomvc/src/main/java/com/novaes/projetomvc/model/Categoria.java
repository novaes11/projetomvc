package com.novaes.projetomvc.model;

public class Categoria {
    private String nome;
    private String genero;
    private String area;
    private String descricao;

    public Categoria() {
    }

    public Categoria(String nome, String genero, String area, String descricao) {
        this.nome = nome;
        this.genero = genero;
        this.area = area;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
