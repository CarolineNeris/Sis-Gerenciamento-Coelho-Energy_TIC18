import Clientes.*;
import Reparos.*;
import Pagamentos.*;
import Imoveis.*;
import Falhas.*;
import Faturas.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // clientes pré-cadastrados para simplificar testes no menu
        Cliente cliente1 = new Cliente("João Silva", "12345678901");
        Cliente cliente2 = new Cliente("Maria Oliveira", "234567890123");
        Cliente cliente3 = new Cliente("Ana Pereira", "3456789012345");

        Cliente.incluirCliente(cliente1);
        Cliente.incluirCliente(cliente2);
        Cliente.incluirCliente(cliente3); // para remover, basta apagar apenas esse trecho.

        // imóveis pré-cadastrados para simplificar testes no menu
        Imovel imovel1 = new Imovel();
        Imovel imovel2 = new Imovel();
        Imovel imovel3 = new Imovel();

        Imovel.incluirImovel(imovel1);
        Imovel.incluirImovel(imovel2);
        Imovel.incluirImovel(imovel3);

        // importante para o funcionamento do menu
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Alterar Nome do Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Cadastrar Imóvel");
            System.out.println("6. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Incluir Cliente:");
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    Cliente.incluirCliente(new Cliente(nome, cpf));
                    System.out.println("Cliente incluído com sucesso!");
                    break;

                case 2:
                    // System.out.println("Listar Clientes:");
                    // System.out.println(Cliente.listarClientes());
                    break;

                case 3:
                    System.out.println("Alterar Nome do Cliente:");
                    System.out.print("Digite o CPF do cliente que deseja alterar: ");
                    String cpfAlterar = scanner.nextLine();
                    Cliente clientePesquisado = Cliente.pesquisarCliente(cpfAlterar);
                    if (clientePesquisado != null) {
                        System.out.println("Nome atual: " + clientePesquisado.getNome());
                        System.out.print("Digite o novo nome do cliente: ");
                        String novoNome = scanner.nextLine();
                        Cliente.atualizarCliente(new Cliente(novoNome, cpfAlterar), cpfAlterar);
                        System.out.println("Nome do cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Excluir Cliente:");
                    System.out.print("Digite o CPF do cliente que deseja excluir: ");
                    String cpfExcluir = scanner.nextLine();
                    Cliente clienteExcluir = Cliente.pesquisarCliente(cpfExcluir);
                    if (clienteExcluir != null) {
                        System.out.println("Nome: " + clienteExcluir.getNome());
                        System.out.print("Confirma a exclusão desse cliente? (S/N): ");
                        char resposta = scanner.next().charAt(0);
                        if (resposta == 'S' || resposta == 's') {
                            if (Cliente.excluirCliente(cpfExcluir)) {
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

                case 5:
                    System.out.println("Cadastrar Imóvel:");
                    System.out.print("Informe o código do imóvel: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    System.out.print("Informe o endereço do imóvel: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Informe a penúltima leitura: ");
                    int penultimaLeitura = scanner.nextInt();

                    System.out.print("Informe a última leitura: ");
                    int ultimaLeitura = scanner.nextInt();

                    Imovel novoImovel = new Imovel();
                    novoImovel.setMatricula(matricula);
                    novoImovel.setEndereco(endereco);
                    novoImovel.setPenultimaLeitura(penultimaLeitura);
                    novoImovel.setUltimaLeitura(ultimaLeitura);
                    Imovel.incluirImovel(novoImovel);
                    System.out.println("Imóvel incluído com sucesso!");
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
