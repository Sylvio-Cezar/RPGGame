package models;

import java.util.List;

public class Inimigo {
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

    public void atacar(Personagem personagem) {
        int dano = ((saude + energia) / 10);
        if (dano > 75) {
            dano = 75;
        }
        if (dano < 5) {
            dano = 5;
        }
        System.out.println("O inimigo " + nome + " atacou " + personagem.getNome());
        personagem.setSaude(personagem.getSaude() - dano);
        System.out.println("O personagem " + personagem.getNome() + " perdeu " + dano + " de saúde.");
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
