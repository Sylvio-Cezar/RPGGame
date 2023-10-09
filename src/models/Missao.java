package models;

import java.util.List;

public class Missao {
    private String titulo;
    private String descricao;
    private List<Item> recompensa;
    private String objetivos;

    public Missao(String titulo, String descricao, List<Item> recompensa, String objetivos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.recompensa = recompensa;
        this.objetivos = objetivos;
    }

    public void iniciar(Personagem personagem) {
        System.out.println("A missão " + titulo + " foi iniciada por " + personagem.getNome());
    }

    public void atualizar(Personagem personagem) {
        System.out.println("Missão: " + titulo);
        System.out.println("O personagem " + personagem.getNome() + " progrediu nos objetivos: " + objetivos);
    }

    public void completar(Personagem personagem) {
        System.out.println("A missão " + titulo + " foi completada");
        for (Item item : recompensa) {
            System.out.println("O item " + item.getNome() + " foi adicionado ao inventário do personagem " + personagem.getNome());
            personagem.pegarItem(item);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}

