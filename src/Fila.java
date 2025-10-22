
public class Fila {
    // Aponta para o primeiro item da fila.
    private Node primeiro;
    // Aponta para o último item da fila (para facilitar a inserção).
    private Node ultimo;

    // Construtor: cria uma nova fila.
    public Fila() {
        // A fila começa vazia.
        this.primeiro = null;
        this.ultimo = null;
    }

    // Verifica se a fila está vazia.
    public boolean vazia() {
        // Se o "primeiro" for nulo, não há ninguém na fila.
        return this.primeiro == null;
    }

    // Adiciona um novo elemento no FINAL da fila.
    public void insere(Elemento elemento) {
        // Cria um "pacote" (Node) para guardar o elemento.
        Node novoNode = new Node(elemento);
        if (vazia()) {
            // O novo nó é o primeiro E o último.
            this.primeiro = novoNode;
            this.ultimo = novoNode;
        } else {
            // Se já tinha gente, o último antigo agora aponta para o novo.
            this.ultimo.setProximo(novoNode);
            // e o novo nó se torna o último.
            this.ultimo = novoNode;
        }
    }

    // Remove e retorna o elemento do INÍCIO da fila.
    public Elemento remove() {
        if (vazia()) {
            return null;
        }

        // Pega a informação (Elemento) guardada no primeiro nó.
        Elemento elementoRemovido = this.primeiro.getInformacao();
        // "Anda" a fila: o "primeiro" agora passa a ser o próximo da lista.
        this.primeiro = this.primeiro.getProximo();
        if (this.primeiro == null) {
            this.ultimo = null;
        }
        return elementoRemovido;
    }

    // Imprime todos os itens da fila, do primeiro ao último.
    public void imprime() {
        if (vazia()) {
            System.out.println("A fila de atendimento está vazia.");
            return;
        }
        System.out.println("--- Fila de Atendimento ---");
        Node atual = this.primeiro; //Começa pelo primeiro.
        int posicao = 1; //Contador para a posição na fila.

        // Loop que continua enquanto não chegar no fim da fila (nulo).
        while (atual != null) {

            // Pega a informação (Elemento) de dentro do nó atual
            Elemento el = atual.getInformacao();
            // Imprime os dados formatados (assumindo que 'Elemento' tem campo1, campo2, campo3).
            System.out.println(posicao + "º -> Cliente: " + el.campo1 + " | ID: " + el.campo2 + " | Motivo: " + el.campo3);
            // Passa para o próximo nó da fila.
            atual = atual.getProximo();
            posicao++;
        }
        System.out.println("-----------------");
    }
}
