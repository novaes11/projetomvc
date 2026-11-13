package com.novaes.projetomvc.model;

public class Livro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private Categoria categoria;
    private boolean disponivel;

    public Livro() {
        this.disponivel = true;
    }

    public Livro(String titulo, Autor autor, String isbn, Categoria categoria, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setAutor(String nomeAutor) {
        this.autor = new Autor(nomeAutor, "");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCategoria(String nomeCategoria) {
        this.categoria = new Categoria(nomeCategoria, "", "", "");
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
