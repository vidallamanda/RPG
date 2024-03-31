import java.util.Random;

public class Mago extends Jogador {

    String[] frases = {"Você é fraco, lhe falta ódio",
            "Você tacou a vassoura na cabeça do inimigo",
            "Você invocou um dragão que cuspiu uma bola de fogo",
            "O jogador balança uma galinha pelo pescoço e a arremessa com precisão no inimigo",
            "o jogador cria uma tempestade de raios que desce dos céus, atingindo o inimigo com" +
                    " um poder avassalador",
            "Utilizando seus conhecimentos em alquimia, o jogador lança uma poção " +
                    "explosiva em direção ao inimigo, causando uma explosão que estremece o solo",
            "Canalizando a essência da lua cheia, o jogador lança um feitiço lunar que " +
                    "enfraquece o inimigo, drenando sua energia e enfraquecendo sua resistência",
            "O jogador lança um raio de energia mágica que corta o ar em direção ao " +
                    "inimigo, atingindo-o em cheio",
            "o jogador faz brotar raízes do solo que se enrolam em torno do inimigo, " +
                    "prendendo-o e restringindo seus movimentos",
            "Você utilizou a varinha de unicórnio e jogou o feitiço avada kedrava"
    };
    private Random random = new Random();

    public Mago() {
        super();
    }

    public void atacar(Inimigo inimigo) {
        if (inimigo.estaVivo()) {
            setPoderAtaque(random.nextInt(10));

            System.out.println("********** ATAQUE DO MAGO **********");
            System.out.println(frases[getPoderAtaque()]);
            System.out.println("Você causou " + getPoderAtaque() + " de dano no " +
                    "inimigo.");
            if (getPoderAtaque() >= inimigo.getQuantidadeVida()) {
                inimigo.setQuantidadeVida(0);
                System.out.println("\nVocê derrotou o Inimigo!");
                System.out.println("  ∧_______∧\n" +
                        "( ͡° ͜ʖ ͡°)\n" +
                        "⊂　　つcxxxx{}:::::::::::::::::::::>\n" +
                        "(つ ﾉ\n" +
                        "(ノ");
            } else {
                inimigo.setQuantidadeVida(inimigo.getQuantidadeVida() - getPoderAtaque());
                System.out.println("O inimigo ficou com " + inimigo.getQuantidadeVida() +
                        " de vida.");
            }
        } else {
            System.out.println("\nO Inimigo foi derrotado!");
        }
    }
}