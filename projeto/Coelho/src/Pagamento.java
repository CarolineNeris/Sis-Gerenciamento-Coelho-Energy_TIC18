import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pagamento {
    private String faturaId;
    private double valor;
    private Date data;
    private double devolucaoValor;

    public Pagamento(String faturaId, double valor) {
        this.faturaId = faturaId;
        this.valor = valor;
        this.data = new Date();
        this.devolucaoValor = 0.0;
    }
    public Pagamento(){}

    public String getFaturaId() {
        return faturaId;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public double getDevolucaoValor() {
        return devolucaoValor;
    }

   public void setDevolucaoValor(double devolucaoValor) {
        this.devolucaoValor = devolucaoValor;
    }
    /*
        public static void main(String[] args) {
        Pagamento pagamentoMenu = new Pagamento();

        // Add pagamentos
        pagamentoMenu.Pagamento("INV001", 100.0);
        pagamentoMenu.Pagamento("INV001", 50.0);
        pagamentoMenu.Pagamento("INV002", 200.0);
        pagamentoMenu.Pagamento("INV003", 150.0);

        // List all pagamentos
        pagamentoMenu.listarTodosPagamentos();

        // List pagamentos for a specific fatura
        pagamentoMenu.listarPagamentosPorFatura("INV001");

        // List all devolucaos
        pagamentoMenu.listarTodasDevolucoes();
    }*/
    public static void main(String[] args) {
        // Create an instance of PagamentoMenu
        PagamentoMenu pagamentoMenu = new PagamentoMenu();

        // List all pagamentos
        pagamentoMenu.listarTodosPagamentos();

        // List pagamentos for a specific fatura
        pagamentoMenu.listarPagamentosPorFatura("INV001");

        // List all devolucaos
        pagamentoMenu.listarTodasDevolucoes();

        // Create an instance of Fatura
        Fatura fatura = new Fatura("INV001", 100.0);

        // Add pagamentos to the fatura
        fatura.adicionarPagamento(new Pagamento("PAY001", 50.0));
        fatura.adicionarPagamento(new Pagamento("PAY002", 30.0));
        fatura.adicionarPagamento(new Pagamento("PAY003", 20.0));

        // Print the fatura details
        System.out.println("Fatura ID: " + fatura.getFaturaId());
        System.out.println("Fatura Valor: " + fatura.getValor());
        System.out.println("Fatura status: " + fatura.getQuitada());
        System.out.println("Fatura Pagamentos: " + fatura.getPagamentos());

        // Mark the fatura as quitada
        fatura.getQuitada();

        // Print the updatad fatura details
        System.out.println("Fatura status: " + fatura.getQuitada());
    }
}


class Fatura {
    private String faturaId;
    private double valor;
    private boolean quitada;
    private List<Pagamento> pagamentos;

    public Fatura(String faturaId, double valor) {
        this.faturaId = faturaId;
        this.valor = valor;
        this.quitada = false;
        this.pagamentos = new ArrayList<>();
    }

    public String getFaturaId() {
        return faturaId;
    }

    public void setFaturaId() {
        this.faturaId = faturaId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor() {
        this.valor = valor;
    }

    public boolean getQuitada() {
        return quitada;
    }
    
    public void setQuitada(boolean quitada) {
        this.quitada = quitada;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }
}

class PagamentoMenu {
    private List<Pagamento> pagamentos;
    private List<Fatura> faturas;

    public PagamentoMenu() {
        this.pagamentos = new ArrayList<>();
        this.faturas = new ArrayList<>();
    }

    public void adicionarPagamento(String faturaId, double valor) {
        Fatura fatura = encontrarFatura(faturaId);
        if (fatura == null) {
            System.out.println("Fatura não encontrada!");
            return;
        }

        if (fatura.getQuitada()) {
            System.out.println("Fatura já está getQuitada!");
            return;
        }

        Pagamento pagamento = new Pagamento(faturaId, valor);
        fatura.adicionarPagamento(pagamento);

        double totalPagamentos = fatura.getPagamentos().stream().mapToDouble(Pagamento::getValor).sum();
        if (totalPagamentos >= fatura.getValor()) {
            fatura.setQuitada(true);
        }

        if (totalPagamentos > fatura.getValor()) {
            double devolucaoValor = totalPagamentos - fatura.getValor();
            Pagamento devolucao = new Pagamento(faturaId, devolucaoValor);
            devolucao.setDevolucaoValor(devolucaoValor);
            pagamentos.add(devolucao);
            System.out.println("Devolução gerada: " + devolucaoValor);
        }
    }

    public void listarTodosPagamentos() {
        for (Pagamento pagamento : pagamentos) {
            System.out.println("Fatura ID: " + pagamento.getFaturaId());
            System.out.println("Pagamento Valor: " + pagamento.getValor());
            System.out.println("Pagamento Data: " + pagamento.getData());
            System.out.println("Devolução Valor: " + pagamento.getDevolucaoValor());
            System.out.println("-----------------------------");
        }
    }

    public void listarPagamentosPorFatura(String faturaId) {
        Fatura fatura = encontrarFatura(faturaId);
        if (fatura == null) {
            System.out.println("Fatura não encontrada!");
            return;
        }

        for (Pagamento pagamento : fatura.getPagamentos()) {
            System.out.println("Fatura ID: " + pagamento.getFaturaId());
            System.out.println("Pagamento Valor: " + pagamento.getValor());
            System.out.println("Pagamento Data: " + pagamento.getData());
            System.out.println("Devolução Valor: " + pagamento.getDevolucaoValor());
            System.out.println("-----------------------------");
        }
    }

    public void listarTodasDevolucoes() {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getDevolucaoValor() > 0) {
                System.out.println("Fatura ID: " + pagamento.getFaturaId());
                System.out.println("Devolução Valor: " + pagamento.getDevolucaoValor());
                System.out.println("-----------------------------");
            }
        }
    }

    private Fatura encontrarFatura(String faturaId) {
        for (Fatura fatura : faturas) {
            if (fatura.getFaturaId().equals(faturaId)) {
                return fatura;
            }
        }
        return null;
    }
}

/*
//public class Main {
    public static void main(String[] args) {
        Pagamento pagamentoMenu = new Pagamento();

        // Add pagamentos
        pagamentoMenu.Pagamento("INV001", 100.0);
        pagamentoMenu.Pagamento("INV001", 50.0);
        pagamentoMenu.Pagamento("INV002", 200.0);
        pagamentoMenu.Pagamento("INV003", 150.0);

        // List all pagamentos
        pagamentoMenu.listarTodosPagamentos();

        // List pagamentos for a specific fatura
        pagamentoMenu.listarPagamentosPorFatura("INV001");

        // List all devolucaos
        pagamentoMenu.listarTodasDevolucoes();
    }
//}
 
//public static void main(String[] args) throws Exception {
//        System.out.println("Hello, World!");
//    }
*/
