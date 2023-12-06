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

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Gestão de Pagamentos");
            System.out.println("5. Gestão de Falhas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuImoveis(scanner);
                    break;
                case 3:
                    menuFaturas(scanner);
                    break;
                case 4:
                    menuPagamentos(scanner);
                    break;
                case 5:
                    menuFalhas(scanner);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuClientes(Scanner scanner) {
        int opcaoClientes;

        do {
            System.out.println("\nGestão de Clientes");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoClientes = scanner.nextInt();

            switch (opcaoClientes) {
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
                    // System.out.println(cliente.listarClientes());
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

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoClientes != 0);
        // Adicione aqui as ações de cada opção

        while (opcaoClientes != 0)
            ;
    }

    private static void menuImoveis(Scanner scanner) {
        int opcaoImoveis;

        do {
            System.out.println("\nGestão de Imoveis");
            System.out.println("1. Cadastrar Imovel");
            System.out.println("2. Listar Imovel");
            System.out.println("3. Excluir Imovel");
            System.out.println("4. Alterar Imovel");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoImoveis = scanner.nextInt();

            switch (opcaoImoveis) {
                case 1:
                    System.out.println("Cadastrar Imóvel");
                    System.out.print("Informe o código do imóvel: ");
                    int matricula = scanner.nextInt();

                    System.out.print("Informe o endereço do imóvel: ");
                    String endereco = scanner.next();

                    System.out.print("Informe a penúltima leitura: ");
                    int penultimaLeitura = scanner.nextInt();

                    System.out.print("Informe a última leitura: ");
                    int ultimaLeitura = scanner.nextInt();

                    Imovel imovel = new Imovel();
                    imovel.setMatricula(matricula);
                    imovel.setEndereco(endereco);
                    imovel.setPenultimaLeitura(penultimaLeitura);
                    imovel.setUltimaLeitura(ultimaLeitura);
                    Imovel.incluirImovel(imovel);
                    System.out.println("Imóvel incluído com sucesso!");
                    break;

                case 2:
                    // Listar;
                    break;
                case 3:
                    // alterar;
                    break;
                case 4:
                    // excluir;
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoImoveis != 0);
    }

    private static void menuFaturas(Scanner scanner) {
        int opcaoFaturas;

        do {
            System.out.println("\nGestão de Faturas");
            System.out.println("1. Faturas abertas");
            System.out.println("2. Listar Faturas ");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoFaturas = scanner.nextInt();

            switch (opcaoFaturas) {
                case 1:
                    // Faturas abertas;
                    break;

                case 2:
                    // Listar Faturas;
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoFaturas != 0);
    }

    private static void menuPagamentos(Scanner scanner) {
        int opcaoPagamentos;

        do {
            System.out.println("\nGestão de Pagamentos");
            System.out.println("1. Inclusão de Pagamentos");
            System.out.println("2.Listar Pagamentos ");
            System.out.println("3.Listar Reembolsos  ");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoPagamentos = scanner.nextInt();

            switch (opcaoPagamentos) {
                case 1:
                    // Inclusão de Pagamentos;
                    break;

                case 2:
                    // Listar Pagamentos;
                    break;
                case 3:
                    // Listar Reembolsos;
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoPagamentos != 0);
    }

    private static void menuFalhas(Scanner scanner) {
        int opcaoFalhas;

        do {
            System.out.println("\nGestão de Falhas");
            System.out.println("1. Inclusão de Falhas");
            System.out.println("2. Gestão de Reparos ");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoFalhas = scanner.nextInt();

            switch (opcaoFalhas) {
                case 1:
                    // Inclusão de Falhas;
                    break;

                case 2:
                    menuReparos(scanner);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoFalhas != 0);
    }

    private static void menuReparos(Scanner scanner) {
        int opcaoReparos;

        do {
            System.out.println("\nGestão de Reparos");
            System.out.println("1. Listar reparos em aberto");
            System.out.println("2. Encerrar reparo ");
            System.out.println("0. Voltar ao menu anterior");
            System.out.print("Escolha uma opção: ");
            opcaoReparos = scanner.nextInt();

            switch (opcaoReparos) {
                case 1:
                    // Listar reparos em aberto;
                    break;

                case 2:
                    // Encerrar reparo;
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoReparos != 0);
    }
}
