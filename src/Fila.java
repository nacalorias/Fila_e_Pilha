
public class Fila {
    private Node primeiro;
    private Node ultimo;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean vazia() {
        return this.primeiro == null;
    }

    public void insere(Elemento elemento) {
        Node novoNode = new Node(elemento);
        if (vazia()) {
            this.primeiro = novoNode;
            this.ultimo = novoNode;
        } else {
            this.ultimo.setProximo(novoNode);
            this.ultimo = novoNode;
        }
    }

    public Elemento remove() {
        if (vazia()) {
            return null;
        }
        Elemento elementoRemovido = this.primeiro.getInformacao();
        this.primeiro = this.primeiro.getProximo();
        if (this.primeiro == null) {
            this.ultimo = null;
        }
        return elementoRemovido;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("A fila de atendimento está vazia.");
            return;
        }
        System.out.println("--- Fila de Atendimento ---");
        Node atual = this.primeiro;
        int posicao = 1;
        while (atual != null) {
            Elemento el = atual.getInformacao();
            System.out.println(posicao + "º -> Cliente: " + el.campo1 + " | ID: " + el.campo2 + " | Motivo: " + el.campo3);
            atual = atual.getProximo();
            posicao++;
        }
        System.out.println("-----------------");
    }
}