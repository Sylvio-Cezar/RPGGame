import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MundoVirtual {
    private List<Personagem> personagens;
    private List<Missao> missoes;
    private List<Inimigo> inimigos;

    public MundoVirtual() {
        personagens = new ArrayList<>();
        missoes = new ArrayList<>();
        inimigos = new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }

    public void adicionarMissao(Missao missao) {
        missoes.add(missao);
    }

    public void removerMissao(Missao missao) {
        missoes.remove(missao);
    }

    public void adicionarInimigo(Inimigo inimigo) {
        inimigos.add(inimigo);
    }

    public void removerInimigo(Inimigo inimigo) {
        inimigos.remove(inimigo);
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void iniciarCombate(Inimigo inimigo, Personagem jogador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você encontrou um " + inimigo.getNome() + "!");

        while (true) {
            System.out.println("\nOpções de combate:");
            System.out.println("1. Atacar inimigo");
            System.out.println("2. Fugir");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> {
                    System.out.println("Turno do jogador:");
                    jogador.atacar(inimigo);
                    if (inimigo.getSaude() > 0) {
                        System.out.println("Turno do inimigo:");
                        inimigo.atacar(jogador);
                    }
                }
                case 2 -> {
                    System.out.println("Turno do jogador:");
                    if (Math.random() < 0.5) {
                        System.out.println("Você fugiu do combate!");
                        return;
                    } else {
                        System.out.println("Você não conseguiu fugir!");
                        System.out.println("Turno do inimigo:");
                        inimigo.atacar(jogador);
                    }
                }
                default -> System.out.println("Opção inválida. Escolha novamente.");
            }

            if (jogador.getSaude() <= 0) {
                System.out.println("Você foi derrotado!");
                return;
            } else if (inimigo.getSaude() <= 0) {
                System.out.println("Você derrotou o " + inimigo.getNome() + "!");
                jogador.setNivel(jogador.getNivel() + inimigo.getNivel());
                jogador.setSaude(jogador.getSaude() + 50 * inimigo.getNivel());
                jogador.setEnergia(jogador.getEnergia() + 10 * inimigo.getNivel());
                removerInimigo(inimigo);
                return;
            }
        }
    }
}
