import java.util.Random;

public class Mago extends Jogador {

    String[] frases = { "Você é fraco, lhe falta ódio",
            "Você tacou a vassoura na cabeça do inimigo",
            "Você invocou um dragão que cuspiu uma bola de fogo",
            "Você utilizou a varinha de unicórnio e jogou o feitiço avada kedrava"};

    public Mago(int poderAtaque) {
        super(poderAtaque);
    }

    @Override
    public void atacar(Inimigo inimigo) {
        if (inimigo.estaVivo()) {
            Random ran = new Random();
            setPoderAtaque(ran.nextInt(10) + 1);

            int quantVida = inimigo.getQuantidadeVida();

            inimigo.setQuantidadeVida(quantVida - getPoderAtaque());
            System.out.println("Você utilizou a varinha de unicórnio e jogou o feitiço ");
            System.out.println("Você deu " + getPoderAtaque() + " de dano.");
            System.out.println("O jogador ficou com " + inimigo.getQuantidadeVida() +
                    " de vida.");
        } else {
            System.out.println("O jogador já está morto!");
        }
    }
}
