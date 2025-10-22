// Importa a classe Scanner para ler a entrada do teclado.
import java.util.Scanner;


// Classe principal que executa o menu interativo.
public class Main {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler o que o usuário digita.
        Scanner scanner = new Scanner(System.in);
        // Cria a fila de atendimento (onde os clientes esperam).
        Fila filaDeAtendimento = new Fila();
         // Cria a pilha de histórico.
        Pilha historicoDeSolicitacoes = new Pilha();
        // Um contador para gerar IDs únicos para cada atendimento.
        int idSolicitacaoCounter = 1;

        // Guarda a opção que o usuário escolheu no menu.
        int opcao = 0;

        // Loop principal: continua rodando o menu enquanto a opção não for 6 (Sair)
        while (opcao != 6) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                // "switch" verifica qual número foi escolhido e executa o bloco certo.
                switch (opcao) {
                        // Caso 1: Inserir cliente. 
                    case 1:
                        System.out.print("Digite o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o número de identificação: ");
                        String id = scanner.nextLine();
                        System.out.print("Digite o motivo do atendimento: ");
                        String motivo = scanner.nextLine();

                        // Cria um "pacote" de dados (Elemento) com as infos do cliente.
                        Elemento novoCliente = new Elemento(nome, id, motivo);
                        //Coloca o novo cliente no final da fila.
                        filaDeAtendimento.insere(novoCliente);
                        System.out.println("Cliente inserido na fila com sucesso!!");
                        break;

                    // Caso 2: Atender Cliente.
                    case 2:
                        // Tira o primeiro cliente da fila para atendê-lo.
                        Elemento clienteAtendido = filaDeAtendimento.remove();

                        // Se "remove()" retornou nulo, a fila estava vazia.
                        if (clienteAtendido == null) {
                            System.out.println("A fila esta vazia.");
                        } else {
                            // Se conseguiu remover, informa quem está sendo atendido.
                            System.out.println("Atendendo cliente: " + clienteAtendido.campo1);

                            // Prepara os dados para salvar no histórico (Pilha).
                            String idSolicitacao = "" + idSolicitacaoCounter++;
                            String dataHora = "15/10/2025 19:21";
                            String descricao = "Motivo: " + clienteAtendido.campo3;

                            // Cria um novo "pacote" de dados para o histórico.
                            Elemento novaSolicitacao = new Elemento(idSolicitacao, descricao, dataHora);
                            // Coloca (empilha) o atendimento no topo do histórico.
                            historicoDeSolicitacoes.insere(novaSolicitacao);
                            System.out.println("Atendimento registrado no histórico (pilha).");
                        }
                        break;

                        //Caso 3: Mostrar a Fila.
                    case 3:
                        filaDeAtendimento.imprime(); // Chama o método de impressão da Fila.
                        break;

                        // Caso 4: Mostrar a Pilha.
                    case 4:
                        
                        historicoDeSolicitacoes.imprime(); // Chama o método de impressão da Pilha.
                        break;

                        //Caso 5: Verificar status.
                    case 5:
                        System.out.println("-- Status --");
                        // Usa o método "vazia()" de cada estrutura para checar.
                        System.out.println("Fila esta vazia? " + (filaDeAtendimento.vazia() ? "Sim" : "Não"));
                        System.out.println("Pilha esta vazia? " + (historicoDeSolicitacoes.vazia() ? "Sim" : "Não"));
                        System.out.println("--------------");
                        break;

                        //Caso 6: Sair.
                    case 6:
                        System.out.println("Encerrando o programa...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro de entrada. Por favor, digite um número.");
                scanner.nextLine();
                opcao = 0;
            }
            // Pausa para o usuário ler o resultado antes de mostrar o menu de novo.
            if (opcao != 6 && opcao >= 1 && opcao <= 5) {
                System.out.println("Digite enter para continuar...");
                scanner.nextLine();
            }
        }
        // Fecha o scanner para liberar recursos do sistema.
        scanner.close();
    }

    // Apenas imprime o menu de opções na tela.
    private static void exibirMenu() {
        System.out.println("--- Sistema de Gerenciamento de Atendimento ---");
        System.out.println("1. Inserir cliente na fila");
        System.out.println("2. Atender (remover) cliente da fila");
        System.out.println("3. Imprimir fila de atendimento");
        System.out.println("4. Imprimir histórico (pilha)");
        System.out.println("5. Verificar se estruturas estão vazias");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção:   ");
    }
}
