import java.util.Random;

public class Jogador {

    private int quantidadeVida;
    private int poderAtaque;
    private Random random = new Random();

    public Jogador() {
        this.quantidadeVida = 50;
        this.poderAtaque = 0;
    }

    public int getQuantidadeVida() {
        return quantidadeVida;
    }

    public void setQuantidadeVida(int quantidadeVida) {
        this.quantidadeVida = quantidadeVida;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(int poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    public void atacar(Inimigo inimigo) {
        System.out.println("Você precisa ser um guerreiro ou mago para atacar.");
    };

    public void ataqueEspecial(Inimigo inimigo) {
        if (inimigo.estaVivo()) {
            this.poderAtaque = random.nextInt(11) + 10;

            System.out.println("********** ATAQUE ESPECIAL **********");
            System.out.println("O Jogador desferiu um ataque especial, causando " + poderAtaque + " de dano.");
            if (poderAtaque > inimigo.getQuantidadeVida()) {
                inimigo.setQuantidadeVida(0);
                System.out.println("\nVocê derrotou o Inimigo!");
                System.out.println("  ∧_______∧\n" +
                        "( ͡° ͜ʖ ͡°)\n" +
                        "⊂　　つcxxxx{}:::::::::::::::::::::>\n" +
                        "(つ ﾉ\n" +
                        "(ノ");
            } else {
                inimigo.setQuantidadeVida(inimigo.getQuantidadeVida() - poderAtaque);
                System.out.println("O Inimigo ficou com " + inimigo.getQuantidadeVida() +
                        " de vida.");
            }
        } else {
            System.out.println("\nO Inimigo foi derrotado!");
        }
    }

    public boolean estaVivo() {
        return quantidadeVida > 0;
    }
}
