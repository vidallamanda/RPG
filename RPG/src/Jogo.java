import java.util.Scanner;

public class Jogo {
    Jogador jogador;
    Inimigo inimigo = new Inimigo();
    Scanner entrada = new Scanner(System.in);
    public void iniciarJogo() {
        System.out.println("********** Start Game **********");
        System.out.println("Escolha seu jogador: ");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("\n********** Loading ... **********");
        System.out.print("Informe o jogador escolhido: ");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        switch (escolha) {
            case 1:
                jogador = new Guerreiro();
                System.out.println("Você escolheu o GUERREIRO");
                break;
            case 2:
                jogador = new Mago();
                System.out.println("Você escolheu o MAGO");
                break;
            default:
                System.out.println("Opção invalida!");
        }

        System.out.println("O jogador está iniciando com = " +jogador.getQuantidadeVida() + " vidas");
        System.out.println("O Inimigo está iniciando com = " +inimigo.getQuantidadeVida()  + " vidas");

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\nEscolha um golpe: ");
            System.out.println("1 - Golpe Normal");
            System.out.println("2 - Golpe Especial");
            System.out.print("Informe o golpe escolhido: ");
            int golpeEscolhido = entrada.nextInt();
            entrada.nextLine();

            switch (golpeEscolhido) {
                case 1:
                    jogador.atacar(inimigo);
                    break;
                case 2:
                    jogador.ataqueEspecial(inimigo);
                    break;
                default:
                    System.out.println("Opção invalida!");
            }

            if (inimigo.estaVivo()) {
                inimigo.ataqueInimigo(jogador);
            }
        }

        if (jogador.estaVivo()) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Game Over!");
        }
    }
}