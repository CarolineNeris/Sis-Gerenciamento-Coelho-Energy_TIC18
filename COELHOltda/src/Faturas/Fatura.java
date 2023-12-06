// Classe Fatura
package Faturas;

import Imoveis.Imovel;
import java.util.Date;



public class Fatura {
    private Imovel imovel;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valorCalculado;
    private boolean quitada;
    private int matricula;
    private Date dataEmissao;

    // Construtor...
    public Fatura(int matricula, double ultimaLeitura, double penultimaLeitura) {
        this.matricula = matricula;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.dataEmissao = new Date();
        this.valorCalculado = calcularValor();
        this.quitada = false;
    }

    // Método privado para calcular o valor...
    private double calcularValor() {
        return 10 * (ultimaLeitura - penultimaLeitura);
    }

    // Método público para exibir detalhes da fatura...
    public void exibirDetalhes() {
        System.out.println("\nDetalhes da Fatura:");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Data de Emissão: " + dataEmissao);
        System.out.println("Última Leitura: " + ultimaLeitura);
        System.out.println("Penúltima Leitura: " + penultimaLeitura);
        System.out.println("Valor Calculado: " + valorCalculado);
        System.out.println("Quitada: " + (quitada ? "Sim" : "Não"));
    }
}
