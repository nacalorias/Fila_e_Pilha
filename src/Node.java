
public class Node {
    private Elemento informacao;
    private Node proximo;

    public Node(Elemento informacao) {
        this.informacao = informacao;
        this.proximo = null;
    }

    public Elemento getInformacao() {
        return informacao;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}