package Reparos;

import java.util.Date;

public class Reparo {
    private static int contadorID = 1;

    private int id;
    private String descricao;
    private Falhas.Falha falha;
    private Date dataInicio;
    private Date dataFim;
    private boolean concluido;

    public Reparo(String descricao, Falhas.Falha falha) {
        this.id = contadorID++;
        this.descricao = descricao;
        this.falha = falha;
        this.dataInicio = new Date();
        this.dataFim = null;
        this.concluido = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Falhas.Falha getFalha() {
        return falha;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
        if (concluido) {
            this.dataFim = new Date();
        }
    }

    public void exibirDetalhes() {
        System.out.println("\nDetalhes do Reparo:");
        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Falha Associada:");
        falha.exibirDetalhes();
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Data de Fim: " + (concluido ? dataFim : "Em andamento"));
        System.out.println("Concluído: " + (concluido ? "Sim" : "Não"));
    }
}