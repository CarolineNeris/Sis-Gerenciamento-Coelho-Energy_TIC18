package Reembolsos;

import java.util.Date;

public class Reembolso {
    private double valor;
    private Date data;

    public Reembolso(double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public void exibirDetalhes() {
        System.out.println("\nDetalhes do Reembolso:");
        System.out.println("Valor: " + valor);
        System.out.println("Data: " + data);
    }
}