package com.novaes.projetomvc.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private String nacionalidade;
    private List<Livro> obrasPublicadas;

    public Autor() {
        this.obrasPublicadas = new ArrayList<>();
    }

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.obrasPublicadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getObrasPublicadas() {
        return obrasPublicadas;
    }

    public void setObrasPublicadas(List<Livro> obrasPublicadas) {
        this.obrasPublicadas = obrasPublicadas;
    }

    public void adicionarObra(Livro livro) {
        if (this.obrasPublicadas == null) {
            this.obrasPublicadas = new ArrayList<>();
        }
        this.obrasPublicadas.add(livro);
    }
}
