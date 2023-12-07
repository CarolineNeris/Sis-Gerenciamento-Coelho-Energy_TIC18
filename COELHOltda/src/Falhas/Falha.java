package Falhas;

public class Falha {
    private boolean deGeracao;

    public Falha(boolean deGeracao) {
        this.deGeracao = deGeracao;

    }

    public boolean isDeGeracao() {
        return deGeracao;
    }

    public void exibirDetalhes() {
        System.out.println("\nDetalhes da Falha:");
        System.out.println("Tipo: " + (deGeracao ? "Geração" : "Distribuição"));

    }
}
