# ATIVIDADE PRATICA SUPERVISIONADA 1 RA01 - Fila E Pilha

Este projeto foi desenvolvido para a disciplina de **Resolução de Problemas Estruturados em Computação**, lecionada pelo professor **Andrey Cabral Meira**.

## Alunos

* Ana Carolina Curi de Sales
* Ana Carolina Afonso Meiado

---

## Sobre o Projeto

Este trabalho é uma simulação de um sistema de atendimento ao cliente, desenvolvido em Java. O objetivo principal é gerenciar duas estruturas de dados diferentes:

1.  **A Fila (Ordem de Atendimento):** Organiza os clientes que chegam para o atendimento. Funciona como uma fila normal, onde o primeiro que entra é o primeiro a ser atendido.
2.  **A Pilha (Histórico de Solicitações):** Guarda os atendimentos que já foram concluídos. Funciona como uma pilha de pratos, onde o último atendimento feito fica no topo do histórico.

## Como o Código Funciona

O programa principal (`Main`) roda um menu de texto que permite ao usuário gerenciar o sistema de atendimento:

1.  **Adicionar Cliente (Opção 1):** Quando um novo cliente é adicionado, o programa pede suas informações (nome, ID, motivo) e o coloca no **final da fila** de espera.
2.  **Atender Cliente (Opção 2):** Quando o usuário escolhe atender, o programa remove o cliente que está no **início da fila** (o que chegou primeiro).
3.  **Salvar no Histórico:** Imediatamente após o atendimento, o programa pega os dados desse serviço e os coloca no **topo da pilha** de histórico.
4.  **Visualizar (Opções 3 e 4):** O usuário pode, a qualquer momento, pedir para imprimir a lista de espera (a Fila) ou o histórico de atendimentos já feitos (a Pilha).
