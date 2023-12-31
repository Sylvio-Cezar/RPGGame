package main;

import interfaces.IUsavel;
import models.*;
import mundoVirtual.MundoVirtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo de RPG!");
        System.out.print("Digite o nome do seu personagem: ");
        String nomePersonagem = scanner.nextLine();

        Personagem jogador1 = new Personagem(nomePersonagem, 1, 100, 100);
        Habilidade habilidade1 = new Habilidade("Magia de Fogo", "Lança uma bola de fogo", 10);
        Item item1 = new Item("Poção de Cura", "Cura 50 pontos de saúde", "Cura", "Cura 50 pontos de saúde");

        MundoVirtual mundo = new MundoVirtual();
        mundo.adicionarPersonagem(jogador1);

        // Adicionando missões
        Missao missao1 = new Missao("Coletar Relíquias", "Encontre as antigas relíquias perdidas!",
                List.of(new Item("Relíquia de Ouro", "Uma valiosa relíquia", "Relíquia", "Valor incalculável")),
                "Coletar as relíquias escondidas no mapa");
        Missao missao2 = new Missao("Derrotar o Dragão", "Enfrente o Dragão!",
                List.of(new Item("Espada Épica", "Uma espada poderosa", "Arma", "Dano +30")),
                "Matar o dragão");
        Missao missao3 = new Missao("Derrotar o Rei Demônio", "Enfrente o terrível Rei Demônio e salve o reino!",
                List.of(new Item("Lança do Rei Demônio", "Uma lança inbuída em magia", "Arma", "Dano +100")),
                "Matar o Rei Demônio e salvar o reino");


        mundo.adicionarMissao(missao1);
        mundo.adicionarMissao(missao2);
        mundo.adicionarMissao(missao3);

        // Adicionando inimigos
        Inimigo inimigo1 = new Inimigo("Orc", 5, 120, 80, new ArrayList<>());
        Inimigo inimigo2 = new Inimigo("Dragão", 10, 250, 150, new ArrayList<>());
        Inimigo inimigo3 = new Inimigo("Goblin", 1, 40, 20, new ArrayList<>());
        Inimigo inimigo4 = new Inimigo("Lobo", 3, 90, 50, new ArrayList<>());
        Inimigo inimigo5 = new Inimigo("Rei Demônio", 15, 400, 200, new ArrayList<>());

        mundo.adicionarInimigo(inimigo1);
        mundo.adicionarInimigo(inimigo1);
        mundo.adicionarInimigo(inimigo2);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo5);

        System.out.println("Você está pronto para começar sua jornada!");
        jogador1.pegarHabilidade(habilidade1);

        while (true) {
            int escolha;
            if (jogador1.getSaude() > 0) {
                System.out.println("\nOpções:");
                System.out.println("1. Ver status do personagem");
                System.out.println("2. Ver missões disponíveis");
                System.out.println("3. Iniciar missão");
                System.out.println("4. Caminhar pelo mapa");
                System.out.println("5. Usar item");
                System.out.println("6. Sair do jogo");
                System.out.print("Escolha uma opção: ");

                escolha = scanner.nextInt();
            } else {
                escolha = 4;
            }

            switch (escolha) {
                case 1 -> {
                    System.out.println("\n" + jogador1.getNome() + " - Nível: " + jogador1.getNivel() + " Saúde: "
                            + jogador1.getSaude() + " Energia: " + jogador1.getEnergia());
                    System.out.println("Itens: " + jogador1.getItens());
                    System.out.println("Habilidades: " + jogador1.getHabilidades());
                }
                case 2 -> {
                    System.out.println("\nMissões disponíveis:");
                    if (mundo.getMissoes().size() > 0) {
                        for (int i = 0; i < mundo.getMissoes().size(); i++) {
                            Missao missao = mundo.getMissoes().get(i);
                            System.out.println(i + 1 + ". " + missao.getTitulo() + ": " + missao.getDescricao());
                        }
                    } else {
                        System.out.println("\nNão há missões disponíveis");
                    }
                }
                case 3 -> {
                    System.out.println("\nMissões disponíveis:");
                    if (mundo.getMissoes().size() > 0) {
                        for (int i = 0; i < mundo.getMissoes().size(); i++) {
                            Missao missao = mundo.getMissoes().get(i);
                            System.out.println(i + 1 + ". " + missao.getTitulo() + ": " + missao.getDescricao());
                        }
                        System.out.print("\nEscolha uma missão para iniciar (Digite o número): ");
                        int escolhaMissao = scanner.nextInt();
                        if (escolhaMissao >= 1 && escolhaMissao <= mundo.getMissoes().size()) {
                            Missao missaoSelecionada = mundo.getMissoes().get(escolhaMissao - 1);
                            jogador1.setMissaoAtiva(missaoSelecionada);
                            jogador1.getMissaoAtiva().iniciar(jogador1);
                        } else {
                            System.out.println("\nOpção de missão inválida.");
                        }
                    } else {
                        System.out.println("\nNão há missões disponíveis");
                    }
                }
                case 4 -> {
                    System.out.println("\nDigite a posição X: ");
                    double posX = scanner.nextDouble();
                    System.out.println("\nDigite a posição Y: ");
                    double posY = scanner.nextDouble();
                    jogador1.caminhar(posX, posY);
                    double probabilidadeEncontro = 0.3;
                    if (Math.random() < probabilidadeEncontro && mundo.getInimigos().size() > 0) {
                        List<Inimigo> inimigosDisponiveis = mundo.getInimigos();
                        int indiceInimigoEscolhido = (int) (Math.random() * inimigosDisponiveis.size());
                        Inimigo inimigoEscolhido = inimigosDisponiveis.get(indiceInimigoEscolhido);
                        mundo.iniciarCombate(inimigoEscolhido, jogador1);
                        if (jogador1.getMissaoAtiva() != null) {
                            if (inimigoEscolhido.getNome().equals("Dragão") && jogador1.getMissaoAtiva().equals(missao2)) {
                                jogador1.getMissaoAtiva().atualizar(jogador1);
                                jogador1.getMissaoAtiva().completar(jogador1);
                                mundo.removerMissao(jogador1.getMissaoAtiva());
                            } else if (inimigoEscolhido.getNome().equals("Rei Demônio") && jogador1.getMissaoAtiva().equals(missao3)) {
                                jogador1.getMissaoAtiva().atualizar(jogador1);
                                jogador1.getMissaoAtiva().completar(jogador1);
                                mundo.removerMissao(jogador1.getMissaoAtiva());
                            }
                        }
                    } else {
                        if (Math.random() < 0.4 && (jogador1.getMissaoAtiva() == null || !jogador1.getMissaoAtiva().equals(missao1))) {
                            System.out.println("\nVocê encontrou uma poção de cura!");
                            jogador1.pegarItem(item1);
                        } else if (Math.random() < 0.4 && (jogador1.getMissaoAtiva() != null && jogador1.getMissaoAtiva().equals(missao1))) {
                            System.out.println("\nVocê encontrou as relíquias perdidas!");
                            jogador1.getMissaoAtiva().atualizar(jogador1);
                            jogador1.getMissaoAtiva().completar(jogador1);
                            mundo.removerMissao(jogador1.getMissaoAtiva());
                        } else {
                            System.out.println("\nVocê não encontrou nada!");
                        }
                    }
                }
                case 5 -> {
                    if (jogador1.getItens().size() >= 1) {
                        System.out.println("\nItens disponíveis:");
                        List<Item> itensDisponiveis = jogador1.getItens();
                        for (int i = 0; i < itensDisponiveis.size(); i++) {
                            Item item = itensDisponiveis.get(i);
                            System.out.println(i + 1 + ". " + item.getNome());
                        }
                        System.out.print("\nEscolha um item para usar (Digite o número): ");
                        int escolhaItem = scanner.nextInt();
                        if (escolhaItem >= 1 && escolhaItem <= itensDisponiveis.size()) {
                            Item itemSelecionado = itensDisponiveis.get(escolhaItem - 1);
                            jogador1.usarItem(itemSelecionado);
                        } else {
                            System.out.println("\nOpção de item inválida.");
                        }
                    } else {
                        System.out.println("\nNão há itens disponíveis");
                    }
                }
                case 6 -> {
                    System.out.println("\nObrigado por jogar!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("\nOpção inválida. Escolha novamente.");
            }
        }
    }
}
