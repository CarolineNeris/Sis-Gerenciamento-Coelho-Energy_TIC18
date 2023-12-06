import Clientes.*;
import Reparos.*;
import Pagamentos.*;
import Imoveis.*;
import Falhas.*;
import Faturas.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Incluir cliente");

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