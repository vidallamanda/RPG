import java.util.Random;

public class Jogador {

    private int quantidadeVida;
    private int poderAtaque;

    public Jogador(int poderAtaque) {
        this.quantidadeVida = 100;
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

    public void atacar(Inimigo inimigo){
        if (inimigo.estaVivo()) {
            Random ran = new Random();
            poderAtaque = ran.nextInt(10) + 1;

            int quantVida = inimigo.getQuantidadeVida();

            inimigo.setQuantidadeVida(quantVida - poderAtaque);
            System.out.println("Você deu " + poderAtaque + " de dano.");
            System.out.println("O inimigo ficou com " + inimigo.getQuantidadeVida() +
                    " de vida.");
        } else {
            System.out.println("O inimigo já está morto!");
        }
    }

    public boolean estaVivo(){
        return quantidadeVida > 0;
    }
}
