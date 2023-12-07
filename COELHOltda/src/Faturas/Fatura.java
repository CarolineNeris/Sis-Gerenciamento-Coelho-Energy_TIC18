// Classe Fatura
package Faturas;

import java.util.Date;

public class Fatura {
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valorCalculado;
    private boolean quitada;
    private int matricula;
    private Date dataEmissao;

    public Fatura(int matricula, double ultimaLeitura, double penultimaLeitura) {
        this.matricula = matricula;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.dataEmissao = new Date();
        this.valorCalculado = calcularValor();
        this.quitada = false;
    }

    private double calcularValor() {
        return 10 * (ultimaLeitura - penultimaLeitura);
    }

    public void exibirDetalhes() {
        System.out.println("\nDetalhes da Fatura:");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Data de Emissão: " + dataEmissao);
        System.out.println("Última Leitura: " + ultimaLeitura);
        System.out.println("Penúltima Leitura: " + penultimaLeitura);
        System.out.println("Valor Calculado: " + valorCalculado);
        System.out.println("Quitada: " + (quitada ? "Sim" : "Não"));
    }

    // Getters e Setters

    public double getUltimaLeitura() {
        return ultimaLeitura;
    }

    public void setUltimaLeitura(double ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public double getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public void setPenultimaLeitura(double penultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
    }

    public double getValorCalculado() {
        return valorCalculado;
    }

    public void setValorCalculado(double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public boolean isQuitada() {
        return quitada;
    }

    public void setQuitada(boolean quitada) {
        this.quitada = quitada;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}