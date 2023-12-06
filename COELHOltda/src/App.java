import Clientes.*;
import Reparos.*;
import Pagamentos.*;
import Imoveis.*;
import Falhas.*;
import Faturas.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // clientes pré cadastrados para simplificar testes no menu
        Cliente cliente1 = new Cliente("João Silva", "12345678901");
        Cliente cliente2 = new Cliente("Maria Oliveira", "234567890123");
        Cliente cliente3 = new Cliente("Ana Pereira", "3456789012345");

        Cliente.incluirCliente(cliente1);
        Cliente.incluirCliente(cliente2);
        Cliente.incluirCliente(cliente3); /// para remover, basta apagar apenas esse trecho.

        // importante para o funcionamento do menu
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Incluir cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Alterar nome do cliente");
            System.out.println("5. Excluir cliente");

            System.out.println("6. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            Cliente cliente = new Cliente();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    Cliente.incluirCliente(new Cliente(nome, cpf));
                    System.out.println("Cliente incluído com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de clientes:");
                    System.out.println(cliente.listarClientes());
                    break;

                case 3:
                    System.out.println("Digite o CPF do cliente que deseja alterar");
                    String Cpf = scanner.nextLine();
                    Cliente clientePesquisado = Cliente.pesquisarCliente(Cpf);
                    if (clientePesquisado != null) {
                        System.out.println("Nome atual: " + clientePesquisado.getNome());
                        System.out.println("Digite o novo nome do cliente:");
                        String novoNome = scanner.nextLine();
                        Cliente.atualizarCliente(new Cliente(novoNome, Cpf), Cpf);
                        System.out.println("Nome do cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o CPF do cliente que deseja excluir");
                    String CpfEcluir = scanner.nextLine();
                    Cliente clienteExcluir = Cliente.pesquisarCliente(CpfEcluir);
                    if (clienteExcluir != null) {
                        System.out.println("Nome: " + clienteExcluir.getNome());
                        System.out.println("Confirma a exclusão desse cliente?(S/N)");
                        char resposta = scanner.next().charAt(0);
                        if (resposta == 'S' || resposta == 's') {
                            if (Cliente.excluirCliente(CpfEcluir)) {
                                System.out.println("Cliente excluído com sucesso!");
                            } else {
                                System.out.println("Erro ao excluir o cliente.");
                            }
                        } else {
                            System.out.println("Operação de exclusão cancelada.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}