// Classe Pagamento
package Pagamentos;

import Faturas.Fatura;

public class Pagamento {
    private Fatura fatura;
    private double valor;
    // Outros atributos necessários

    // Métodos GET e SET para os atributos

    // Método construtor
    public Pagamento(Fatura fatura, double valor) {
        this.fatura = fatura;
        this.valor = valor;
        // Inicialização de outros atributos, se houver
    }

    // Outros métodos específicos, se necessário
}
