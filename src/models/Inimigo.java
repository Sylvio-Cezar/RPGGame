package models;

import interfaces.IAtacavel;

import java.util.List;

public class Inimigo implements IAtacavel {
    private String nome;
    private int nivel;
    private int saude;
    private int energia;
    private List<Habilidade> habilidadesDeCombate;

    public Inimigo(String nome, int nivel, int saude, int energia, List<Habilidade> habilidadesDeCombate) {
        this.nome = nome;
        this.nivel = nivel;
        this.saude = saude;
        this.energia = energia;
        this.habilidadesDeCombate = habilidadesDeCombate;
    }

    public void atacar(IAtacavel alvo) {
        int dano = calcularDano();
        if (dano > 75) {
            dano = 75;
        }
        if (dano < 5) {
            dano = 5;
        }
        System.out.println(nome + " atacou " + ((Personagem)alvo).getNome() + " causando " + dano + " de dano.");
        ((Personagem)alvo).receberDano(dano);
    }

    private int calcularDano() {
        return (saude + energia) / 10;
    }

    public void receberDano(int dano) {
        saude -= dano;
        energia -= dano;
        if (saude < 0) {
            saude = 0;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getSaude() {
        return this.saude;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return this.energia;
    }
}
