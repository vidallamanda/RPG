import java.util.Random;

public class Inimigo {

    String[] frases = {"O inimigo conjura uma explosão de energia negra, lançando o jogador para trás com força.",
            "Prepare-se para enfrentar a ira implacável de um verdadeiro vilão.",
            "Um enxame de flechas é disparado pelo inimigo, chovendo sobre o jogador",
            "Com um rugido selvagem, o inimigo avança, desferindo um golpe poderoso com" +
                    " sua espada em direção ao jogador.",
            "Com uma risada sinistra, o inimigo convoca uma legião de mortos-vivos para cercar o jogador, prontos para dilacerá-lo."};
    private int quantidadeVida;
    private int poderAtaque;

    public Inimigo() {
        this.quantidadeVida = 100;
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

    public void atacar(Jogador jogador) {
        if (jogador.estaVivo()) {
            Random random = new Random();
            this.poderAtaque = random.nextInt(10) + 1;

            System.out.println("\n********** CONTRA-ATAQUE **********");
            System.out.println((frases[random.nextInt(frases.length)]));
            if (poderAtaque >= jogador.getQuantidadeVida()) {
                jogador.setQuantidadeVida(0);
                System.out.println("Inimigo derrotou o Jogador!");
            } else {
                jogador.setQuantidadeVida(jogador.getQuantidadeVida() - poderAtaque);
                System.out.println("O inimigo deu " + poderAtaque + " de dano");
                System.out.println("O jogador ficou com " + jogador.getQuantidadeVida() +
                        " de vida.");
            }
        } else {
            System.out.println("\nO jogador já está morto!");
        }
    }

    public boolean estaVivo() {
        return quantidadeVida > 0;
    }
}
