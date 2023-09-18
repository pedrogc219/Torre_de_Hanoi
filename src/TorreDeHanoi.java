import java.util.Random;
import java.util.Scanner;

public class TorreDeHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int tamanho;
        System.out.print("Tamanho das pilhas: ");
        tamanho = scanner.nextInt();

        Pilha pilha0 = new Pilha();
        Pilha pilha1 = new Pilha();
        Pilha pilha2 = new Pilha();
        Pilha[] pilhas = {pilha0, pilha1, pilha2};

        Auto bot = new Auto(pilhas);

        for (int i = 0; i < tamanho; i++) {
            pilhas[0].inserir(rand.nextInt(100));
        }

        int modo_de_ordenacao = -1;
        System.out.println("Ordenacao para ganhar: ");
        System.out.println("0 - Crescente");
        System.out.println("1 - Decrescente");
        while (!(modo_de_ordenacao == 1 ^ modo_de_ordenacao == 0)) {
            System.out.print("Escolha: ");
            modo_de_ordenacao = scanner.nextInt();
        }

        int pilhaPop;
        int pilhaPush;
        Node no = null;
        int movimentos = 0;

        int acao;
        boolean jogo = true;
        while (jogo) {
            System.out.print("\n------ PILHAS ------");
            for (int i = 0; i < pilhas.length; i++) {
                System.out.printf("\nPilha %d: ", i);
                pilhas[i].imprimir();
            }

            System.out.println("\n----- COMANDOS -----");
            System.out.println("0 - Sair do jogo.");
            System.out.println("1 - Movimentar.");
            System.out.println("2 - Solucao automatica.");
            System.out.print("Acao: ");
            acao = scanner.nextInt();
            switch (acao) {
                case 0:
                    jogo = false;
                    break;
                case 1:
                    System.out.print("Escolha uma pilha para pop: ");
                    pilhaPop = scanner.nextInt();

                    if (pilhas[pilhaPop].vazia()) {
                        System.out.println("Pilha vazia.");
                        break;
                    } else {
                        no = pilhas[pilhaPop].pop();
                    }

                    System.out.print("Escolha uma pilha para push: ");
                    pilhaPush = scanner.nextInt();
                    try {
                        if (modo_de_ordenacao == 0){    // CRESCENTE
                            if ((no.getValor() >= pilhas[pilhaPush].getValorTopo()) || pilhas[pilhaPush].vazia()) {
                                pilhas[pilhaPush].push(no);
                                movimentos++;
                            } else {
                                throw new Exception();
                            }
                        } else {    // DECRESCENTE
                            if ((no.getValor() <= pilhas[pilhaPush].getValorTopo()) || pilhas[pilhaPush].vazia()) {
                                pilhas[pilhaPush].push(no);
                                movimentos++;
                            } else {
                                throw new Exception();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Operacao invalida.");
                        pilhas[pilhaPop].push(no);
                        break;
                    }


                    if (pilha0.vazia() && (pilha1.vazia() || pilha2.vazia())) {
                        jogo = false;
                        System.out.print("\n------ PILHAS ------");
                        for (int i = 0; i < pilhas.length; i++) {
                            System.out.printf("\nPilha %d: ", i);
                            pilhas[i].imprimir();
                        }
                        System.out.println("\nOrdenacao concluida em "+movimentos+" jogadas.");
                    }
                    break;

                case 2:


                    break;
            }
        }
    }
}