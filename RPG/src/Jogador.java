import java.util.Random;

public class Jogador {

    private int quantidadeVida;
    private int poderAtaque;
    private Random random = new Random();

    public Jogador(int poderAtaque) {
        this.quantidadeVida = 50;
        this.poderAtaque = poderAtaque;
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
    }

    public void ataqueEspecial(Inimigo inimigo) {
        int quantVida = inimigo.getQuantidadeVida();

        if (inimigo.estaVivo()) {
            int poderAtaqueEspecial = random.nextInt(11) + 10;

            System.out.println("\n********** ATAQUE ESPECIAL **********");
            if (poderAtaqueEspecial >= quantVida) {
                inimigo.setQuantidadeVida(0);
                System.out.println("\nVocê derrotou o Inimigo!");
                System.out.println("  ∧_______∧\n" +
                        "( ͡° ͜ʖ ͡°)\n" +
                        "⊂　　つcxxxx{}:::::::::::::::::::::>\n" +
                        "(つ ﾉ\n" +
                        "(ノ");
            } else {
                inimigo.setQuantidadeVida(quantVida - poderAtaqueEspecial);
                System.out.println("O Jogador desferiu um ataque especial, causando " + poderAtaqueEspecial + " de dano.");
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
