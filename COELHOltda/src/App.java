import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Clientes.*;
import Reparos.*;
import Pagamentos.*;
import Reembolsos.Reembolso;
import Imoveis.*;
import Falhas.*;
import Faturas.*;
import Faturas.Fatura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Imovel> imoveis = new ArrayList<>();
    private static ArrayList<Fatura> listaFaturas = new ArrayList<>();
    private static ArrayList<Pagamento> listaPagamentos = new ArrayList<>();
    private static List<Falha> falhas = new ArrayList<>();
    private static List<Reparo> reparos = new ArrayList<>();

    public static void incluirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static String listarClientes() {
        StringBuilder lista = new StringBuilder();
        for (Cliente cliente : clientes) {
            lista.append("Nome: ").append(cliente.getNome()).append(", CPF: ").append(cliente.getCpf()).append("\n");
        }
        return lista.toString();
    }

    public static Cliente pesquisarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static void atualizarCliente(Cliente clienteAtualizado, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                cliente.setNome(clienteAtualizado.getNome());
                break;
            }
        }
    }

    public static boolean excluirCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return clientes.remove(cliente);
            }
        }
        return false;
    }

    public static void incluirImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    private static void listarImoveis() {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
        } else {
            System.out.println("Lista de Imóveis:");
            for (Imovel imovel : imoveis) {
                System.out.println("Código: " + imovel.getMatricula());
                System.out.println("Endereço: " + imovel.getEndereco());
                System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
                System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
                System.out.println("--------------------");
            }
        }
    }

    private static void alterarImovel(Scanner scanner) {
        System.out.print("Informe o código do imóvel que deseja alterar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Imovel imovelExistente = null;

        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == codigo) {
                imovelExistente = imovel;
                break;
            }
        }

        if (imovelExistente != null) {
            System.out.print("Informe o novo endereço do imóvel: ");
            String novoEndereco = scanner.nextLine();

            System.out.print("Informe a nova penúltima leitura: ");
            int novaPenultimaLeitura = scanner.nextInt();

            System.out.print("Informe a nova última leitura: ");
            int novaUltimaLeitura = scanner.nextInt();

            imovelExistente.setEndereco(novoEndereco);
            imovelExistente.setPenultimaLeitura(novaPenultimaLeitura);
            imovelExistente.setUltimaLeitura(novaUltimaLeitura);

            System.out.println("Imóvel alterado com sucesso!");
        } else {
            System.out.println("Imóvel não encontrado.");
        }
    }

    public static Imovel pesquisarImovel(int matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matricula) {
                return imovel;
            }
        }
        return null;
    }

    public static boolean excluirImovel(int matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matricula) {
                return imoveis.remove(imovel);
            }
        }
        return false;
    }

    private static void criarFatura(Scanner scanner) {
        System.out.print("Informe a matrícula do imóvel: ");
        int matricula = scanner.nextInt();

        Imovel imovel = encontrarImovel(matricula);

        if (imovel != null) {
            double ultimaLeitura = imovel.getUltimaLeitura();
            double penultimaLeitura = imovel.getPenultimaLeitura();

            Fatura novaFatura = new Fatura(matricula, ultimaLeitura, penultimaLeitura);
            listaFaturas.add(novaFatura);

            System.out.println("Fatura criada com sucesso!");
        } else {
            System.out.println("Imóvel não encontrado.");
        }
    }

    private static void listarTodasFaturas() {
        System.out.println("Lista de Todas as Faturas:");
        for (Fatura fatura : listaFaturas) {
            fatura.exibirDetalhes();
        }
    }

    private static void listarFaturasEmAberto() {
        System.out.println("Lista de Faturas em Aberto:");
        for (Fatura fatura : listaFaturas) {
            if (!fatura.isQuitada()) {
                fatura.exibirDetalhes();
            }
        }
    }

    private static Imovel encontrarImovel(int matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matricula) {
                return imovel;
            }
        }
        return null;
    }

    private static void incluirPagamento(Scanner scanner) {
        System.out.print("Informe o valor do pagamento: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Informe a data do pagamento (no formato dd/MM/yyyy): ");
        String dataString = scanner.nextLine();

        Date data;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            data = dateFormat.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
            return;
        }

        Pagamento pagamento = new Pagamento(valor, data, "Pagamento");

        System.out.print("Informe o valor do reembolso associado (0 se não houver): ");
        double valorReembolso = scanner.nextDouble();
        scanner.nextLine();

        if (valorReembolso > 0) {
            Reembolso reembolso = new Reembolso(valorReembolso, new Date());
            pagamento.setReembolso(reembolso);
        }

        listaPagamentos.add(pagamento);

        System.out.println("Pagamento incluído com sucesso!");
    }

    private static void listarPagamentos() {
        System.out.println("\nLista de Pagamentos:");
        for (Pagamento pagamento : listaPagamentos) {
            if ("Pagamento".equals(pagamento.getTipo())) {
                pagamento.exibirDetalhes();
            }
        }
    }

    private static void listarReembolsos() {
        System.out.println("\nLista de Reembolsos:");
        for (Pagamento pagamento : listaPagamentos) {
            if ("Pagamento".equals(pagamento.getTipo()) && pagamento.getReembolso() != null) {
                pagamento.getReembolso().exibirDetalhes();
            }
        }
    }

    private static void incluirFalha(Scanner scanner) {
        System.out.println("Inclusão de Falhas");
        System.out.print("A falha é de geração? (true/false): ");
        boolean deGeracao = scanner.nextBoolean();

        Falha falha = new Falha(deGeracao);
        falhas.add(falha);

        if (!deGeracao) {
            System.out.println("Esta falha requer reparo. Criando reparo...");
            criarReparo(scanner, falha);
        }

        System.out.println("Falha incluída com sucesso!");
    }

    private static void criarReparo(Scanner scanner, Falha falha) {
        System.out.println("Criando Reparo");
        System.out.print("Descrição do Reparo: ");
        String descricao = scanner.next();

        Reparo reparo = new Reparo(descricao, falha);
        reparos.add(reparo);

        System.out.println("Reparo criado com sucesso!");
    }

    private static void listarReparosEmAberto() {
        System.out.println("\nReparos em Aberto:");
        for (Reparo reparo : reparos) {
            if (!reparo.isConcluido()) {
                reparo.exibirDetalhes();
            }
        }
    }

    private static void encerrarReparo(Scanner scanner) {
        System.out.print("Informe o ID do reparo que deseja encerrar: ");
        int idReparo = scanner.nextInt();

        Reparo reparo = encontrarReparoPorID(idReparo);

        if (reparo != null && !reparo.isConcluido()) {
            System.out.println("Encerrando Reparo...");
            reparo.setConcluido(true);

            if (!falhaResolvida()) {
                System.out.println("A falha não foi resolvida. Criando novo reparo...");
                criarReparo(scanner, reparo.getFalha());
            }

            System.out.println("Reparo encerrado com sucesso!");
        } else {
            System.out.println("Reparo não encontrado ou já encerrado.");
        }
    }

    private static Reparo encontrarReparoPorID(int idReparo) {
        for (Reparo reparo : reparos) {
            if (reparo.getId() == idReparo) {
                return reparo;
            }
        }
        return null;
    }

    private static boolean falhaResolvida() {
        System.out.print("A falha foi resolvida? (true/false): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }

    private static void incluirFalha(Scanner scanner) {
        System.out.print("Informe a descrição da falha: ");
        String descricao = scanner.next();

        System.out.print("Informe a previsão para a resolução: ");
        String previsao = scanner.next();

        System.out.print("Informe a data de início da falha: ");
        String dataInicio = scanner.next();

        System.out.print("Informe a data de fim da falha: ");
        String dataFim = scanner.next();

        System.out.print("Informe o tipo de falha (G para Geração, D para Distribuição): ");
        char tipoFalha = scanner.next().charAt(0);

        Falha novaFalha;
        if (tipoFalha == 'G') {
            novaFalha = new FalhaGeracao(descricao, previsao, dataInicio, dataFim);
        } else if (tipoFalha == 'D') {
            novaFalha = new FalhaDistribuicao(descricao, previsao, dataInicio, dataFim);
        } else {
            System.out.println("Tipo de falha inválido.");
            return;
        }

        novaFalha.setDescricao(descricao);
        novaFalha.setPrevisao(previsao);
        novaFalha.setDataInicio(dataInicio);
        novaFalha.setDataFim(dataFim);

        // Agora você pode adicionar a novaFalha à lista de falhas
        // (certifique-se de ter uma lista de falhas no seu App)
        // listaFalhas.add(novaFalha);

        System.out.println("Falha incluída com sucesso!");
    }

    private static void listarReparosEmAberto() {
        System.out.println("Lista de Reparos em Aberto:");
        for (Reparos reparo : listaReparos) {
            if (!reparo.isFalhaResolvida()) {
                System.out.println("Descrição da atividade: " + reparo.getDescricaoAtividade());
                System.out.println("Previsão inicial: " + reparo.getPrevisaoInicial());
                System.out.println("Data de início: " + reparo.getDataInicio());
                System.out.println("--------------------");
            }
        }
    }

    private static void encerrarReparo(Scanner scanner) {
        System.out.print("Informe a descrição da atividade a ser encerrada: ");
        String descricaoAtividade = scanner.next();

        for (Reparos reparo : listaReparos) {
            if (!reparo.isFalhaResolvida() && reparo.getDescricaoAtividade().equals(descricaoAtividade)) {
                // Obtém a falha associada ao reparo
                Falha falhaAssociada = reparo.getFalhaAssociada();

                if (falhaAssociada != null) {
                    System.out.print("Informe a data de encerramento do reparo: ");
                    String dataEncerramento = scanner.next();

                    // Atualiza a falha associada ao reparo
                    falhaAssociada.setFalhaResolvida(true);
                    falhaAssociada.setDataFim(dataEncerramento);

                    // Atualiza o reparo
                    reparo.setFalhaResolvida(true);
                    reparo.atualizarDataFim(dataEncerramento);

                    System.out.println("Reparo encerrado com sucesso!");
                    return;
                } else {
                    System.out.println("Falha associada não encontrada.");
                }
            }
        }

        System.out.println("Reparo não encontrado ou já encerrado.");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Gestão de Pagamentos");
            System.out.println("5. Gestão de Falhas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuImoveis(scanner);
                    break;
                case 3:
                    menuFaturas(scanner);
                    break;
                case 4:
                    menuPagamentos(scanner);
                    break;
                case 5:
                    menuFalhas(scanner);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuClientes(Scanner scanner) {
        int opcaoClientes;

        do {
            System.out.println("\nGestão de Clientes");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Alterar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoClientes = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoClientes) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    incluirCliente(new Cliente(nome, cpf));
                    System.out.println("Cliente incluído com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de clientes:");
                    System.out.println(listarClientes());
                    break;

                case 3:
                    System.out.println("Alterar Nome do Cliente:");
                    System.out.print("Digite o CPF do cliente que deseja alterar: ");
                    String cpfAlterar = scanner.nextLine();
                    Cliente clientePesquisado = pesquisarCliente(cpfAlterar);
                    if (clientePesquisado != null) {
                        System.out.println("Nome atual: " + clientePesquisado.getNome());
                        System.out.print("Digite o novo nome do cliente: ");
                        String novoNome = scanner.nextLine();
                        atualizarCliente(new Cliente(novoNome, cpfAlterar), cpfAlterar);
                        System.out.println("Nome do cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Excluir Cliente:");
                    System.out.print("Digite o CPF do cliente que deseja excluir: ");
                    String cpfExcluir = scanner.nextLine();
                    Cliente clienteExcluir = pesquisarCliente(cpfExcluir);
                    if (clienteExcluir != null) {
                        System.out.println("Nome: " + clienteExcluir.getNome());
                        System.out.print("Confirma a exclusão desse cliente? (S/N): ");
                        char resposta = scanner.next().charAt(0);
                        if (resposta == 'S' || resposta == 's') {
                            if (excluirCliente(cpfExcluir)) {
                                System.out.println("Cliente excluído com sucesso!");
                            } else {
                                System.out.println("Erro ao excluir o cliente.");
                            }
                        } else {
                            System.out.println("Operação de exclusão cancelada.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoClientes != 0);

        while (opcaoClientes != 0)
            ;
    }

    private static void menuImoveis(Scanner scanner) {
        int opcaoImoveis;

        do {
            System.out.println("\nGestão de Imoveis");
            System.out.println("1. Cadastrar Imovel");
            System.out.println("2. Listar Imovel");
            System.out.println("3. Excluir Imovel");
            System.out.println("4. Alterar Imovel");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoImoveis = scanner.nextInt();

            switch (opcaoImoveis) {
                case 1:
                    System.out.println("Cadastrar Imóvel");
                    System.out.print("Informe o código do imóvel: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Informe o endereço do imóvel: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Informe a penúltima leitura: ");
                    int penultimaLeitura = scanner.nextInt();

                    System.out.print("Informe a última leitura: ");
                    int ultimaLeitura = scanner.nextInt();

                    Imovel novoImovel = new Imovel();
                    novoImovel.setMatricula(matricula);
                    novoImovel.setEndereco(endereco);
                    novoImovel.setPenultimaLeitura(penultimaLeitura);
                    novoImovel.setUltimaLeitura(ultimaLeitura);
                    incluirImovel(novoImovel);
                    System.out.println("Imóvel incluído com sucesso!");
                    break;

                case 2:
                    listarImoveis();
                    break;
                case 3:
                    alterarImovel(scanner);
                    break;
                case 4:
                    System.out.print("Informe o código do imóvel: ");
                    int ma = scanner.nextInt();
                    if (excluirImovel(ma)) {
                        System.out.print("Imovel Excluido");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoImoveis != 0);
    }

    private static void menuFaturas(Scanner scanner) {
        int opcaoFaturas;

        do {
            System.out.println("\nGestão de Faturas");
            System.out.println("1. Criar Fatura");
            System.out.println("2. Listar Todas as Faturas");
            System.out.println("3. Listar Faturas em Aberto");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoFaturas = scanner.nextInt();

            switch (opcaoFaturas) {
                case 1:
                    criarFatura(scanner);
                    break;

                case 2:
                    listarTodasFaturas();
                    break;

                case 3:
                    listarFaturasEmAberto();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoFaturas != 0);
    }

    private static void menuPagamentos(Scanner scanner) {
        int opcaoPagamentos;

        do {
            System.out.println("\nGestão de Pagamentos");
            System.out.println("1. Inclusão de Pagamentos");
            System.out.println("2. Listar Pagamentos");
            System.out.println("3. Listar Reembolsos");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoPagamentos = scanner.nextInt();

            switch (opcaoPagamentos) {
                case 1:
                    incluirPagamento(scanner);
                    break;
                case 2:
                    listarPagamentos();
                    break;
                case 3:
                    listarReembolsos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoPagamentos != 0);
    }

    private static void menuFalhas(Scanner scanner) {
        int opcaoFalhas;

        do {
            System.out.println("\nGestão de Falhas");
            System.out.println("1. Inclusão de Falhas");
            System.out.println("2. Gestão de Reparos ");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoFalhas = scanner.nextInt();

            switch (opcaoFalhas) {
                case 1:
                    incluirFalha(scanner);
                    break;
                case 2:
                    menuReparos(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoFalhas != 0);
    }

    private static void menuReparos(Scanner scanner) {
        int opcaoReparos;

        do {
            System.out.println("\nGestão de Reparos");
            System.out.println("1. Listar reparos em aberto");
            System.out.println("2. Encerrar reparo ");
            System.out.println("0. Voltar ao menu anterior");
            System.out.print("Escolha uma opção: ");
            opcaoReparos = scanner.nextInt();

            switch (opcaoReparos) {
                case 1:
                    listarReparosEmAberto();
                    break;
                case 2:
                    encerrarReparo(scanner);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoReparos != 0);
    }
}
