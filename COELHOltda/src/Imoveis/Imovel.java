package Imoveis;

import java.util.ArrayList;
import java.util.List;

import Clientes.Cliente;
import Faturas.Fatura;
import Falhas.Falha;  // Importe a classe Falha

public class Imovel {
    private int matricula;
    private String endereco;
    private int penultimaLeitura;
    private int ultimaLeitura;
    private Cliente proprietario;
    private List<Fatura> faturas = new ArrayList<>();
    private Falha falhaAssociada;  // Adicione a referência à classe Falha

    public Imovel() {

    }

    // Getters and Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public void setPenultimaLeitura(int penultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
    }

    public int getUltimaLeitura() {
        return ultimaLeitura;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public void setUltimaLeitura(int ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public Falha getFalhaAssociada() {
        return falhaAssociada;
    }

    public void setFalhaAssociada(Falha falhaAssociada) {
        this.falhaAssociada = falhaAssociada;
    }
}
