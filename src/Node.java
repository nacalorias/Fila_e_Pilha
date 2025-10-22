
public class Node {
    // Guarda a informação principal
    private Elemento informacao;
    // Aponta para o próximo nó da lista/fila/pilha.
    private Node proximo;

    // Construtor: é chamado quando um novo nó é criado.
    public Node(Elemento informacao) {
        // Guarda a informação (Elemento) que foi passada.
        this.informacao = informacao;
        // O próximo nó começa como nulo.
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
