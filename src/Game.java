import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private static final int TAM = 6;

    private ElementoTabuleiro[][] tabuleiro;
    private Set<String> visitados = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    private int x = 0, y = 0;
    private int pontos = 0;
    private int movimentos = 0;

    public Game() {
        tabuleiro = new ElementoTabuleiro[TAM][TAM];
        inicializarTabuleiro();
        posicionar(new Tesouro(), 3);
        posicionar(new Armadilha(), 3);
    }

    public void start() {

        System.out.println("INICIO: " + tabuleiro[x][y].simbolo());

        System.out.println("🎯 Bem-vindo ao Caça ao Tesouro!");

        while (movimentos < 6) {

            System.out.println("\nVocê está na posição (" + x + "," + y + ")");
            String pos = x + "," + y;

            if (!visitados.contains(pos)) {

                int resultado = tabuleiro[x][y].interagir();
                pontos += resultado;
                visitados.add(pos);

                System.out.println("Você encontrou: " +
                        tabuleiro[x][y].simbolo() +
                        " (Pontos: " + resultado + ")");
            } else {
                System.out.println("⚠️ Você já esteve aqui.");
            }

            System.out.println("Pontos atuais: " + pontos);
            System.out.print("Mover (W/A/S/D): ");
            String move = scanner.next().toUpperCase();

            switch (move) {
                case "W": if (x > 0) x--; break;
                case "S": if (x < TAM - 1) x++; break;
                case "A": if (y > 0) y--; break;
                case "D": if (y < TAM - 1) y++; break;
                default: System.out.println("Movimento inválido.");
            }

            movimentos++;
        }

        System.out.println("🎮 Fim de jogo! Você fez " + pontos + " pontos.");
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                tabuleiro[i][j] = new Vazio();
            }
        }
    }

    
    private void posicionar(ElementoTabuleiro elemento, int quantidade) {

        Random rand = new Random();
        int colocados = 0;

        while (colocados < quantidade) {

            int i = rand.nextInt(TAM);
            int j = rand.nextInt(TAM);

            if (tabuleiro[i][j].podeSerSubstituido()) {

                tabuleiro[i][j] = elemento.criar(); // 🔥 AQUI ESTÁ A CORREÇÃO
                colocados++;
            }
        }
    }
}