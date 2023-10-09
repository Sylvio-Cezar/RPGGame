package models;

import interfaces.IUsavel;

public class Item {
    private String nome;
    private String descricao;
    private String tipo;
    private String efeitos;

    public Item(String nome, String descricao, String tipo, String efeitos) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.efeitos = efeitos;
    }

    public void usar() {
        System.out.println("Você usou o item " + nome + ", efeito(s) aplicado(s): " + efeitos);
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return nome + ": " + descricao;
    }

}