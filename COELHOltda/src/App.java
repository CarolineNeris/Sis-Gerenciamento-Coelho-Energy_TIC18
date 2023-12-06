import Clientes.*;
import Reparos.*;
import Pagamentos.*;
import Imoveis.*;
import Falhas.*;

public class App {

    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente1 = new Cliente("João", "123.456.789-00");

        // Acessando e exibindo informações do cliente
        System.out.println("Nome do cliente: " + cliente1.getNome());
        System.out.println("CPF do cliente: " + cliente1.getCpf());

        // Modificando o nome do cliente
        cliente1.setNome("Maria");

        // Exibindo o novo nome do cliente
        System.out.println("Novo nome do cliente: " + cliente1.getNome());
    }
}