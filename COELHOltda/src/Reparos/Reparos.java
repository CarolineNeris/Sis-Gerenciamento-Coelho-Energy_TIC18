// Classe Reparo
package Reparos;

import Imoveis.Imovel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    public Falha getFalhaAssociada() {
        return falhaAssociada;
    }
    
    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }
    
    public String getPrevisaoInicial() {
        return previsaoInicial;
    }
    
    public String getDataInicio() {
        return dataInicio;
    }
    
    public String getDataFim() {
        return dataFim;
    }
    
    public boolean isFalhaResolvida() {
        return falhaResolvida;
    }
    
    public void setFalhaResolvida(boolean falhaResolvida) {
        this.falhaResolvida = falhaResolvida;
    }    

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
    public void atualizarDataFim(String novaDataFim) {
        this.dataFim = novaDataFim;
    }

    // Método para verificar se o reparo está atrasado
    public boolean estaAtrasado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataFimReparo = LocalDate.parse(dataFim, formatter);
        LocalDate dataAtual = LocalDate.now();

        return dataFimReparo.isBefore(dataAtual) && !falhaResolvida;
    }
}
