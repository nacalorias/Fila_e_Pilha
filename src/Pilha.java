
public class Pilha {
    // Aponta para o item que está no topo da pilha.
    private Node topo;

    // Construtor: cria uma nova pilha.
    public Pilha() {
        // A pilha começa vazia, então o topo aponta para nulo.
        this.topo = null;
    }

    // Verifica se a pilha está vazia.
    public boolean vazia() {
        // Se o topo for nulo, não há nada na pilha.
        return this.topo == null;
    }

    // Adiciona um novo elemento no TOPO da pilha
    public void insere(Elemento elemento) {
        // Cria um Node para guardar o elemento.
        Node novoNode = new Node(elemento);
        // O próximo do novo nó passa a ser o antigo topo.
        novoNode.setProximo(this.topo);
        // O novo nó se torna o novo topo da pilha.
        this.topo = novoNode;
    }

    // Remove e retorna o elemento do TOPO da pilha.
    public Elemento remove() {
        if (vazia()) {
            return null;
        }
        // Pega a informação guardada no nó do topo.
        Elemento elementoRemovido = this.topo.getInformacao();

        // "Desempilha": o "topo" agora passa a ser o nó que estava abaixo dele.
        this.topo = this.topo.getProximo();
        // Retorna o elemento que foi removido.
        return elementoRemovido;
    }

    // Imprime todos os itens da pilha, do topo até a base.
    public void imprime() {
        if (vazia()) {
            System.out.println("O histórico (pilha) está vazio.");
            return;
        }
        System.out.println("--- Histórico de Solicitações (pilha) ---");
        Node atual = this.topo; // Começa pelo topo
        // Loop que continua enquanto não chegar na base da pilha.
        while (atual != null) {
            Elemento el = atual.getInformacao();
            System.out.println("-> ID: " + el.campo1 + " / Descrição: " + el.campo2 + " / Data: " + el.campo3);

            // Passa para o próximo nó de baixo.
            atual = atual.getProximo();
        }
        System.out.println("--------------------");
    }
}
