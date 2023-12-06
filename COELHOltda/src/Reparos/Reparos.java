// Classe Reparo
package Reparos;

import Imoveis.Imovel;
import Falhas.Falha;

public class Reparos {
    private Falha falhaAssociada;
    private String descricaoAtividade;
    private String previsaoInicial;
    private String dataInicio;
    private String dataFim;
    private boolean falhaResolvida;
    // Outros atributos necessários

    // Métodos GET e SET para os atributos

    // Método construtor
    public Reparos(Falha falhaAssociada, String descricaoAtividade, String previsaoInicial, String dataInicio,
            String dataFim) {
        this.falhaAssociada = falhaAssociada;
        this.descricaoAtividade = descricaoAtividade;
        this.previsaoInicial = previsaoInicial;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.falhaResolvida = false;
        // Inicialização de outros atributos, se houver
    }

    // Outros métodos específicos, se necessário
}
