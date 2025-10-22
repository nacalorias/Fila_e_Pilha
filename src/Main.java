import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila filaDeAtendimento = new Fila();
        Pilha historicoDeSolicitacoes = new Pilha();
        int idSolicitacaoCounter = 1;

        int opcao = 0;

        while (opcao != 6) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o número de identificação: ");
                        String id = scanner.nextLine();
                        System.out.print("Digite o motivo do atendimento: ");
                        String motivo = scanner.nextLine();

                        Elemento novoCliente = new Elemento(nome, id, motivo);
                        filaDeAtendimento.insere(novoCliente);
                        System.out.println("Cliente inserido na fila com sucesso!!");
                        break;

                    case 2:
                        Elemento clienteAtendido = filaDeAtendimento.remove();
                        if (clienteAtendido == null) {
                            System.out.println("A fila esta vazia.");
                        } else {
                            System.out.println("Atendendo cliente: " + clienteAtendido.campo1);

                            String idSolicitacao = "" + idSolicitacaoCounter++;
                            String dataHora = "15/10/2025 19:21";
                            String descricao = "Motivo: " + clienteAtendido.campo3;

                            Elemento novaSolicitacao = new Elemento(idSolicitacao, descricao, dataHora);
                            historicoDeSolicitacoes.insere(novaSolicitacao);
                            System.out.println("Atendimento registrado no histórico (pilha).");
                        }
                        break;

                    case 3:
                        filaDeAtendimento.imprime();
                        break;

                    case 4:
                        historicoDeSolicitacoes.imprime();
                        break;

                    case 5:
                        System.out.println("-- Status --");
                        System.out.println("Fila esta vazia? " + (filaDeAtendimento.vazia() ? "Sim" : "Não"));
                        System.out.println("Pilha esta vazia? " + (historicoDeSolicitacoes.vazia() ? "Sim" : "Não"));
                        System.out.println("--------------");
                        break;

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
            if (opcao != 6 && opcao >= 1 && opcao <= 5) {
                System.out.println("Digite enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

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