package Imoveis;

import java.util.ArrayList;
import java.util.List;

import Clientes.Cliente;

public class Imovel {
    private int matricula;
    private String endereco;
    private int penultimaLeitura;
    private int ultimaLeitura;
    private Cliente proprietario;
    private static List<Imovel> imoveis = new ArrayList<>();

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

    public static void incluirImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public static Imovel pesquisarImovel(int matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matricula) {
                return imovel;
            }
        }
        return null;
    }

    public static boolean excluirImovel(int matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matricula) {
                return imoveis.remove(imovel);
            }
        }
        return false;
    }
}