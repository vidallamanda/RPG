import java.util.Random;

public class Jogador {

   // public abstract  void  ataqueEspecial(Inimigo inimigo);

    String[] frases = {"Você é fraco, lhe falta ódio",
            "Você tacou a vassoura na cabeça do inimigo",
            "Você invocou um dragão que cuspiu uma bola de fogo",
            "Você utilizou a varinha de unicórnio e jogou o feitiço avada kedrava"};

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

        if (inimigo.estaVivo()) {
          //  int poderAtaque = random.nextInt(10) + 1;
            int quantVida = inimigo.getQuantidadeVida();

            inimigo.setQuantidadeVida(quantVida - poderAtaque);
            System.out.println("********** ENTROU EM ATACAR **********");
            System.out.println(frases[random.nextInt(frases.length)]);
          //  System.out.println("Você utilizou a varinha de unicórnio e jogou o feitiço ");
            System.out.println("Você deu " + getPoderAtaque() + " de dano no inimigo.");
            System.out.println("O inimigo ficou com " + inimigo.getQuantidadeVida() +
                    " de vida.");
        } else {
            System.out.println("O Inimigo foi derrotado!");
        }
    }

    public void ataqueEspecial(Inimigo inimigo) {
        int quantVida = inimigo.getQuantidadeVida();

        if (inimigo.estaVivo()) {
            int poderAtaqueEspecial = random.nextInt(11) + 10;

            inimigo.setQuantidadeVida(quantVida - poderAtaqueEspecial);
            System.out.println("********** ENTROU EM ATAQUE ESPECIAL **********");
            System.out.println(frases[random.nextInt(frases.length)]);
            System.out.println("O Jogador desferiu um ataque especial, causando " + poderAtaqueEspecial + " de dano.");
            System.out.println("O Inimigo ficou com " + inimigo.getQuantidadeVida() +
                    " de vida.");
        } else {
            System.out.println("O Inimigo foi derrotado!");
        }
    }
    public boolean estaVivo(){
        return quantidadeVida > 0;
    }
}
