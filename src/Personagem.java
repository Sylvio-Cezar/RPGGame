import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private String nome;
    private int nivel;
    private int saude;
    private int energia;
    private List<Habilidade> habilidades;
    private List<Item> itens;
    private Missao missaoAtiva;

    public Personagem(String nome, int nivel, int saude, int energia) {
        this.nome = nome;
        this.nivel = nivel;
        this.saude = saude;
        this.energia = energia;
        this.habilidades = new ArrayList<>();
        this.itens = new ArrayList<>();
    }

    public void atacar(Inimigo inimigo) {
        int dano = ((saude + energia) / 10) * nivel;
        if (dano > 75) {
            dano = 75;
        }
        if (dano < 5) {
            dano = 5;
        }
        System.out.println("Você atacou o inimigo " + inimigo.getNome());
        inimigo.setSaude(inimigo.getSaude() - dano);
        inimigo.setEnergia(inimigo.getEnergia() - dano);
        System.out.println("O inimigo " + inimigo.getNome() + " perdeu " + dano + " de saúde e energia.");
    }

    public void pegarItem(Item item) {
        System.out.println("Você pegou o item " + item.getNome());
        itens.add(item);
    }

    public void caminhar(double x, double y) {
        System.out.println("Você foi para o ponto (" + x + ", " + y + ")");
    }

    public void usarHabilidade(Habilidade habilidade) {
        habilidade.ativar(this);
    }

    public void usarItem(Item item) {
        item.usar();
        itens.remove(item);
    }

    public String getNome() {
        return nome;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setSaude(int saude){
        this.saude = saude;
    }

    public int getSaude() {
        return saude;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Missao getMissaoAtiva() {
        return missaoAtiva;
    }

    public void setMissaoAtiva(Missao missaoAtiva) {
        this.missaoAtiva = missaoAtiva;
    }
}
