package Clientes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private static List<Cliente> clientes = new ArrayList<>(); // Declaração da lista de clientes como estática

    public Cliente() { // Adição do construtor vazio
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Métodos para acessar e modificar os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Incluir cliente
    public static void incluirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static String listarClientes() {
        StringBuilder lista = new StringBuilder();
        for (Cliente cliente : clientes) {
            lista.append("Nome: ").append(cliente.getNome()).append(", CPF: ").append(cliente.getCpf()).append("\n");
        }
        return lista.toString();
    }

    public static Cliente pesquisarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static void atualizarCliente(Cliente clienteAtualizado, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                cliente.setNome(clienteAtualizado.getNome());
                break;
            }
        }
    }

    public static boolean excluirCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return clientes.remove(cliente);
            }
        }
        return false;
    }

}
