import java.util.Random;

public class Mago extends Jogador {
    public Mago() {
        super(0);
        Random random = new Random();
        int poderAtaque = random.nextInt(10) + 1;
        setPoderAtaque(poderAtaque);
    }
}

//Gera dano de 0 a 19 e por esse motivo tem que colocar o +1 no final ou coloca 21 dentro
//Vai gerar dano entre 10 e 20
// System.out.println(frases[random.nextInt(frases.length)]);
