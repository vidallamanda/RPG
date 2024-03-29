import java.util.Random;

public class Inimigo {

    private int quantidadeVida;
    private int poderAtaque;

    public Inimigo() {
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


    public void ataqueInimigo(Jogador jogador) {
        if (jogador.estaVivo()) {
            Random random = new Random();
            int poderAtaque = random.nextInt(10) + 1;
            int quantVida = jogador.getQuantidadeVida();

            if (poderAtaque >= quantVida) {
                jogador.setQuantidadeVida(0);
                System.out.println("Você derrotou o Jogador!");
            } else {
                jogador.setQuantidadeVida(quantVida - poderAtaque);
                System.out.println("O inimigo deu " + poderAtaque + " de dano");
                System.out.println("O jogador ficou com " + jogador.getQuantidadeVida() +
                        " de vida.");
            }
        } else {
            System.out.println("O jogador já está morto!");
        }
    }

    public boolean estaVivo() {
        return quantidadeVida > 0;
    }
}
