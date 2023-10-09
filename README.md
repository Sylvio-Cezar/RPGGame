# Atividade de Orientação a Objetos - Desenvolvimento de um Jogo de RPG

## Contexto

Imagine que você faz parte de uma equipe de desenvolvimento de jogos de computador. A equipe decidiu criar um novo jogo épico de RPG (Role-Playing Game) em um mundo de fantasia. O jogo envolve personagens, missões, batalhas e um vasto mundo virtual. Você foi designado como líder técnico para projetar e implementar a estrutura principal do jogo usando princípios avançados de orientação a objetos.

## Tarefa

Sua tarefa é projetar e implementar a estrutura do jogo de RPG, incluindo a criação de classes para personagens, habilidades, missões, inimigos, itens e o mundo virtual em si. O objetivo é criar um sistema flexível e expansível que permita a adição de novos elementos de forma fácil e intuitiva.

## Requisitos

1. Crie uma classe `Personagem` que represente os personagens jogáveis no jogo. Esta classe deve conter:
   - Atributos para nome, nível, saúde, energia, habilidades e itens.
   - Novos itens são adicionados sempre que um personagem pega um item no mundo ou completa uma missão
   - Métodos para realizar as seguintes ações: atacar, pegar item, usar item, caminhar e usar habilidades.
   - O método atacar recebe um inimigo e a implementação pode ser um print "Você atacou o inimigo NOME_DO_INIMIGO". Você deve retirar uma quantidade de pontos do nível de energia do inimigo.
   - O método pegar item recebe um item e a implementação pode ser um print "Você pegou o item NOME_DO_ITEM" e adiciona o item na lista de itens do personagem.
   - O método caminhar recebe um X e um Y (double) e a implementação pode ser um print "Você foi para o ponto X e Y".
   - O método usar habilidade recebe uma habilidade e ativa a habilidade.
   - O método usar item recebe um item e chama o método usar do item.

2. Crie uma classe `Habilidade` que represente as habilidades disponíveis no jogo. Esta classe deve conter:
   - Atributos para nome, descrição e custo de energia.
   - Métodos para ativar a habilidade. Esse método deve imprimir uma mensagem "A habilidade NOME_DA_HABILIDADE foi ativada" e deve subtrair a quantidade de energia gasta do personagem.

3. Crie uma classe `Missao` que represente as missões que os personagens podem realizar. Esta classe deve conter:
   - Atributos para título, descrição, recompensa (lista de itens) e objetivos.
   - Métodos para iniciar, completar e atualizar o progresso da missão.
   - O método iniciar deve receber um personagem e deve imprimir uma mensagem "A missão TITULO foi iniciada por NOME_DO_PERSONAGEM".
   - O método completar deve receber um personagem e deve imprimir uma mensagem "A missão TITULO foi completada". A lista de itens deve ir para o personagem que completou a missão.

4. Crie uma classe `Inimigo` que represente os inimigos que os personagens podem enfrentar. Esta classe deve conter:
   - Atributos para nome, nível, saúde, energia e habilidades de combate.
   - Métodos para atacar. O método atacar recebe um personagem e a implementação pode ser um print "Você atacou o personagem NOME_DO_PERSONAGEM". Você deve retirar uma quantidade de pontos do nível de energia do PERSONAGEM.

5. Crie uma classe `Item` que represente os itens que os personagens podem coletar e usar. Esta classe deve conter:
   - Atributos para nome, descrição, tipo e efeitos.
   - Métodos para usar o item e aplicar seus efeitos (a implementação pode ser uma mensagem).

6. Crie uma classe `MundoVirtual` que represente o mundo do jogo. Esta classe deve conter:
   - Atributos para um mapa do mundo, lista de personagens, lista de missões ativas e lista de inimigos.
   - Métodos para gerenciar a interação entre os elementos do jogo e a progressão do mundo.
  
7. Crie uma classe Main testando o sistema criado

## Critérios de Avaliação

Você será avaliado com base nos seguintes critérios:

- Implementação correta e completa das classes `Personagem`, `Habilidade`, `Missao`, `Inimigo`, `Item` e `MundoVirtual`.
- Funcionamento correto do jogo de RPG, incluindo interações entre personagens, missões, batalhas e itens.
- Uso adequado de princípios avançados de orientação a objetos, como herança, polimorfismo, encapsulamento, etc.
- Qualidade do código, incluindo boas práticas de nomenclatura, modularização e organização.

## Tempo de Execução

Este é um desafio de nível muito difícil e pode levar dias ou até semanas para ser concluído, dependendo do escopo do jogo. Reserve tempo suficiente para planejar, projetar e implementar a solução. Boa sorte!
