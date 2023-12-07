package Pagamentos;

import java.util.Date;

import Reembolsos.Reembolso;

public class Pagamento {
    private double valor;
    private Date data;
    private String tipo; // "Pagamento" ou "Reembolso"
    private Reembolso reembolso;

    public Pagamento(double valor, Date data, String tipo) {
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.reembolso = null;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public Reembolso getReembolso() {
        return reembolso;
    }

    public void setReembolso(Reembolso reembolso) {
        this.reembolso = reembolso;
    }

    public void exibirDetalhes() {
        System.out.println("\nDetalhes do " + tipo + ":");
        System.out.println("Valor: " + valor);
        System.out.println("Data: " + data);

        if (reembolso != null) {
            System.out.println("Reembolso associado:");
            reembolso.exibirDetalhes();
        }
    }
}