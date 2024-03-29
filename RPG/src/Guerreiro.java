import java.util.Random;

public class Guerreiro extends Jogador {

    String[] frases = {"Se eu fosse você teria escolhido o mago",
            "Com um golpe certeiro, o guerreiro desfere sua espada contra o inimigo",
            "O guerreiro investe com fúria, brandindo sua arma em um arco mortal",
            "Com determinação, o guerreiro avança, derrubando o inimigo com um golpe " +
                    "poderoso",
            "Em um movimento ágil, o guerreiro salta sobre o inimigo, desferindo golpes" +
                    " precisos",
            "Com força bruta, o guerreiro golpeia o inimigo, quebrando sua defesa",
            "O guerreiro ataca com ferocidade, sua arma cortando o ar com velocidade",
            "Com habilidade marcial, o guerreiro executa uma série de golpes rápidos",
            "O guerreiro balança sua arma com destreza, desviando dos ataques do inimigo",
            "Com um rugido de batalha, o guerreiro investe contra o inimigo, pronto para o combate"
    };
    private Random random = new Random();

    public Guerreiro() {
        super(0);
        Random random = new Random();
        int poderAtaque = random.nextInt(10) + 1;
        setPoderAtaque(poderAtaque);
    }

    public void atacar(Inimigo inimigo) {
        if (inimigo.estaVivo()) {
            int poderAtaque = random.nextInt(10);
            int quantVida = inimigo.getQuantidadeVida();

            System.out.println("\n********** ATAQUE DO GUERREIRO **********");
            System.out.println(frases[poderAtaque]);

            if (poderAtaque >= quantVida) {
                inimigo.setQuantidadeVida(0);
                System.out.println("\nVocê derrotou o Inimigo!");
                System.out.println("  ∧_______∧\n" +
                        "( ͡° ͜ʖ ͡°)\n" +
                        "⊂　　つcxxxx{}:::::::::::::::::::::>\n" +
                        "(つ ﾉ\n" +
                        "(ノ");
            } else {
                inimigo.setQuantidadeVida(quantVida - poderAtaque);
                System.out.println("Você deu " + poderAtaque + " de dano no inimigo.");
                System.out.println("O inimigo ficou com " + inimigo.getQuantidadeVida() +
                        " de vida.");
            }
        } else {
            System.out.println("\nO Inimigo foi derrotado!");
        }
    }
}

