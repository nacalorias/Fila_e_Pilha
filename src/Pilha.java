
public class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean vazia() {
        return this.topo == null;
    }

    public void insere(Elemento elemento) {
        Node novoNode = new Node(elemento);
        novoNode.setProximo(this.topo);
        this.topo = novoNode;
    }

    public Elemento remove() {
        if (vazia()) {
            return null;
        }
        Elemento elementoRemovido = this.topo.getInformacao();
        this.topo = this.topo.getProximo();
        return elementoRemovido;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("O histórico (pilha) está vazio.");
            return;
        }
        System.out.println("--- Histórico de Solicitações (pilha) ---");
        Node atual = this.topo;
        while (atual != null) {
            Elemento el = atual.getInformacao();
            System.out.println("-> ID: " + el.campo1 + " / Descrição: " + el.campo2 + " / Data: " + el.campo3);
            atual = atual.getProximo();
        }
        System.out.println("--------------------");
    }
}