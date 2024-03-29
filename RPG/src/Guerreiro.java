import java.util.Random;

public class Guerreiro extends Jogador {
    public Guerreiro() {
        super(0);
        Random random = new Random();
        int poderAtaque = random.nextInt(10) + 1;
        setPoderAtaque(poderAtaque);
    }
}
