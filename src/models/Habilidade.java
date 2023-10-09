package models;

public class Habilidade {
    private String nome;
    private String descricao;
    private int custoEnergia;

    public Habilidade(String nome, String descricao, int custoEnergia) {
        this.nome = nome;
        this.descricao = descricao;
        this.custoEnergia = custoEnergia;
    }

    public void ativar(Personagem personagem) {
        if (personagem.getEnergia() >= custoEnergia) {
            System.out.println("A habilidade " + nome + " foi ativada!");
            personagem.setEnergia(personagem.getEnergia() - custoEnergia);
        } else {
            System.out.println("A habilidade " + nome + " não pôde ser ativada, energia insuficiente!");
        }
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + ": " + descricao + ", custo de energia: " + custoEnergia;
    }
}
