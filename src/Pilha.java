public class Pilha {
    private Node topo;
    public Pilha(){
        topo = null;
    }

    public void inserir(int valor) {
        Node no = new Node(valor);

        if (topo == null) {
            topo = no;
        } else {
            no.setProximo(topo);
            topo = no;
        }
    }
    public void imprimir() {
        Node no = topo;
        while (no != null) {
            System.out.print(no.getValor()+" ");
            no = no.getProximo();
        }
    }

    public Node pop() {
        Node no = topo;
        topo = topo.getProximo();
        return no;
    }
    public void push(Node no) {
        no.setProximo(topo);
        topo = no;
    }

    public boolean vazia() {
        return topo == null;
    }
    public int getValorTopo() {
        if (topo == null){
            return 0;
        } else {
            return topo.getValor();
        }
    }

}
