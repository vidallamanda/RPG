import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    Jogador jogador;
    Inimigo inimigo;
    Scanner entrada = new Scanner(System.in);

    public Jogo() {
        this.jogador = new Jogador();
        this.inimigo = new Inimigo();
    }

    public void iniciarJogo() throws InterruptedException {
        System.out.println("********** Start Game **********");

        String[] opcoesJogador = {"1 - Guerreiro", "2 - Mago"};
        int jogadorEscolhido = validaEscolha("\nEscolha seu jogador: ", opcoesJogador,
                "Informe" +
                " o jogador escolhido: ");
        switch (jogadorEscolhido) {
            case 1:
                jogador = new Guerreiro();
                System.out.println("Você escolheu o GUERREIRO");
                break;
            case 2:
                jogador = new Mago();
                System.out.println("Você escolheu o MAGO");
                break;
            default:
                System.out.println("Opção inválida!");
        }

        System.out.println("O Jogador está iniciando com = " + jogador.getQuantidadeVida() + " vidas");
        System.out.println("O Inimigo está iniciando com = " + inimigo.getQuantidadeVida() + " vidas");

        Thread.sleep(1000);

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            String[] opcoesAtaque = {"1 - Ataque Normal", "2 - Ataque Especial"};
            int ataqueEscolhido = validaEscolha("\nEscolha um ataque: ", opcoesAtaque,
                    "Informe o ataque escolhido: ");
            switch (ataqueEscolhido) {
                case 1:
                    jogador.atacar(inimigo);
                    break;
                case 2:
                    jogador.ataqueEspecial(inimigo);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            Thread.sleep(1000);
            if (inimigo.estaVivo()) {
                inimigo.atacar(jogador);
            }
            Thread.sleep(1000);
        }

        if (jogador.estaVivo()) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Game Over!");
        }
    }

    public int validaEscolha(String mensagemInicial, String[] opcoes,
                             String mensagemFinal) {
        while (true) {
            try {
                System.out.println(mensagemInicial);
                for (String op : opcoes) {
                    System.out.println(op);
                }
                System.out.print(mensagemFinal);
                int escolha = entrada.nextInt();

                if (escolha < 1 || escolha > opcoes.length) {
                    throw new InputMismatchException();
                }

                System.out.println();
                return escolha;
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite um número válido!");
                entrada.nextLine();
            }
        }
    }
}