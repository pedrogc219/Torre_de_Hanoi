public class Auto {
    private Pilha[] pilhas;
    public Auto(Pilha[] pilhas) {
        this.pilhas = pilhas;
    }

    public void resolver(int tamanho, Pilha origem, Pilha destino, Pilha auxiliar) {
        if (tamanho == 1) {
            movimentar(origem, destino);
        } else {
            resolver(tamanho-1, origem, auxiliar, destino);
            movimentar(origem, destino);
            resolver(tamanho-1, auxiliar, destino, origem);
        }
    }
    public void movimentar(Pilha origem, Pilha destino) {
        destino.push(origem.pop());
        System.out.print("\n------ PILHAS ------");
        for (int i = 0; i < pilhas.length; i++) {
            System.out.printf("\nPilha %d: ", i);
            pilhas[i].imprimir();
        }
    }
}
