package Clientes;

import java.util.ArrayList;
import java.util.List;

import Imoveis.Imovel;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Imovel> imoveis = new ArrayList<Imovel>();

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

}
