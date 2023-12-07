package Falhas;

public class Falha {
    private String descricao;
    private String previsao;
    private String dataInicio;
    private String dataFim;

    public Falha() {
        // Inicialize os atributos, se for necessário
    }

    // Construtor
    public Falha(String descricao, String previsao, String dataInicio, String dataFim) {
        this.descricao = descricao;
        this.previsao = previsao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public String getPrevisao() {
        return previsao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrevisao(String previsao) {
        this.previsao = previsao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setFalhaResolvida(boolean b) {
    }
}
