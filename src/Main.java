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
        Missao missao2 = new Missao("Derrotar o Dragão", "Enfrente o terrível Dragão e salve o reino!",
                List.of(new Item("Espada Épica", "Uma espada poderosa", "Arma", "Dano +30")),
                "Matar o dragão");

        mundo.adicionarMissao(missao1);
        mundo.adicionarMissao(missao2);

        // Adicionando inimigos
        Inimigo inimigo1 = new Inimigo("Orc", 5, 120, 80, new ArrayList<>());
        Inimigo inimigo2 = new Inimigo("Dragão", 10, 250, 150, new ArrayList<>());
        Inimigo inimigo3 = new Inimigo("Goblin", 1, 40, 20, new ArrayList<>());


        mundo.adicionarInimigo(inimigo1);
        mundo.adicionarInimigo(inimigo1);
        mundo.adicionarInimigo(inimigo2);
        mundo.adicionarInimigo(inimigo2);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);


        System.out.println("Você está pronto para começar sua jornada!");

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
                    System.out.println(jogador1.getNome() + " - Nível: " + jogador1.getNivel() + " Saúde: "
                            + jogador1.getSaude() + " Energia: " + jogador1.getEnergia());
                    System.out.println("Itens: " + jogador1.getItens().toString());
                }
                case 2 -> {
                    System.out.println("Missões disponíveis:");
                    if (mundo.getMissoes().size() > 0) {
                        for (int i = 0; i < mundo.getMissoes().size(); i++) {
                            Missao missao = mundo.getMissoes().get(i);
                            System.out.println(i + 1 + ". " + missao.getTitulo());
                        }
                    } else {
                        System.out.println("Não há missões disponíveis");
                    }
                }
                case 3 -> {
                    System.out.println("Missões disponíveis:");
                    if (mundo.getMissoes().size() > 0) {
                        for (int i = 0; i < mundo.getMissoes().size(); i++) {
                            Missao missao = mundo.getMissoes().get(i);
                            System.out.println(i + 1 + ". " + missao.getTitulo());
                        }
                        System.out.print("Escolha uma missão para iniciar (Digite o número): ");
                        int escolhaMissao = scanner.nextInt();
                        if (escolhaMissao >= 1 && escolhaMissao <= mundo.getMissoes().size()) {
                            Missao missaoSelecionada = mundo.getMissoes().get(escolhaMissao - 1);
                            jogador1.setMissaoAtiva(missaoSelecionada);
                            jogador1.getMissaoAtiva().iniciar(jogador1);
                        } else {
                            System.out.println("Opção de missão inválida.");
                        }
                    } else {
                        System.out.println("Não há missões disponíveis");
                    }
                }
                case 4 -> {
                    System.out.println("Digite a posição X: ");
                    double posX = scanner.nextDouble();
                    System.out.println("Digite a posição Y: ");
                    double posY = scanner.nextDouble();
                    jogador1.caminhar(posX, posY);
                    double probabilidadeEncontro = 0.3;
                    if (Math.random() < probabilidadeEncontro && mundo.getInimigos().size() > 0) {
                        List<Inimigo> inimigosDisponiveis = mundo.getInimigos();
                        int indiceInimigoEscolhido = (int) (Math.random() * inimigosDisponiveis.size());
                        Inimigo inimigoEscolhido = inimigosDisponiveis.get(indiceInimigoEscolhido);
                        mundo.iniciarCombate(inimigoEscolhido, jogador1);
                        if (inimigoEscolhido.getNome().equals("Dragão") && jogador1.getMissaoAtiva().equals(missao2)) {
                            jogador1.getMissaoAtiva().completar(jogador1);
                            mundo.removerMissao(jogador1.getMissaoAtiva());
                        }
                    } else {
                        if (Math.random() < 0.4 && !jogador1.getMissaoAtiva().equals(missao1)) {
                            System.out.println("Você encontrou uma poção de cura!");
                            jogador1.pegarItem(item1);
                        } else if (Math.random() < 0.4 && jogador1.getMissaoAtiva().equals(missao1)) {
                            System.out.println("Você encontrou as relíquias perdidas!");
                            jogador1.getMissaoAtiva().completar(jogador1);
                            mundo.removerMissao(jogador1.getMissaoAtiva());
                        } else {
                            System.out.println("Você não encontrou nada!");
                        }
                    }
                }
                case 5 -> {
                    if (jogador1.getItens().size() >= 1) {
                        System.out.println("Itens disponíveis:");
                        List<Item> itensDisponiveis = jogador1.getItens();
                        for (int i = 0; i < itensDisponiveis.size(); i++) {
                            Item item = itensDisponiveis.get(i);
                            System.out.println(i + 1 + ". " + item.getNome());
                        }
                        System.out.print("Escolha um item para usar (Digite o número): ");
                        int escolhaItem = scanner.nextInt();
                        if (escolhaItem >= 1 && escolhaItem <= itensDisponiveis.size()) {
                            Item itemSelecionado = itensDisponiveis.get(escolhaItem - 1);
                            jogador1.usarItem(itemSelecionado);
                        } else {
                            System.out.println("Opção de item inválida.");
                        }
                    } else {
                        System.out.println("Não há itens disponíveis");
                    }
                }
                case 6 -> {
                    System.out.println("Obrigado por jogar!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }
}
