import java.util.*;

public class Main {
    private List<Map<String, Object>> dados;
    private List<Map<String, Object>> estoque;

    public Main() {
        dados = new ArrayList<>();
        estoque = new ArrayList<>(Arrays.asList(
            criarEstoqueItem("Bloco do motor", "Por encomenda", "Por encomenda", 1001),
            criarEstoqueItem("Pistão", 400, 0, 1002),
            criarEstoqueItem("Biela", 400, 0, 1003),
            criarEstoqueItem("Virabrequim", 2500, 0, 1004),
            criarEstoqueItem("Cabeçote", "Por encomenda", "Por encomenda", 1005),
            criarEstoqueItem("Válvulas", 150, 0, 1006),
            criarEstoqueItem("Comando de válvulas", 350, 0, 1007),
            criarEstoqueItem("Velas de ignição", 20, 15, 1008),
            criarEstoqueItem("Alternador", 1000, 0, 1009),
            criarEstoqueItem("Anéis do pistão", 400, 0, 1010),
            criarEstoqueItem("Bateria", 479, 4, 1011),
            criarEstoqueItem("Cilindros", 260, 0, 1012),
            criarEstoqueItem("Radiador", 350, 3, 1013),
            criarEstoqueItem("Filtro de ar", 47, 11, 1014),
            criarEstoqueItem("Filtro de óleo", 45, 19, 1015),
            criarEstoqueItem("Porta", 570, 0, 1016),
            criarEstoqueItem("Suspensão a ar", 3550, 6, 1017)
        ));

        // Adicionando registros conforme a tabela fornecida
        adicionarRegistro("13/04/2025", "Receita", "Manutenção", 
                          Arrays.asList("Bomba", "2x Suspensão", "Bateria", "Mangueira"), "Bryan Assolini", 3499.99);
        adicionarRegistro("13/04/2025", "Despesa", "Equipamentos e máquinas", 
                          Arrays.asList("2x Morsa"), "Fornecedor 4", 430);
        adicionarRegistro("13/04/2025", "Despesa", "Salário de funcionários", 
                          Arrays.asList("3x Salário (3.000)"), "Fornecedor 7", 9000);
        adicionarRegistro("13/04/2025", "Receita", "Venda", 
                          Arrays.asList("Kit de freio p/ carro", "Filtro de óleo"), "Fabio Giaretta", 1020);
        adicionarRegistro("13/04/2025", "Despesa", "Encomenda de motor", 
                          Arrays.asList("Bloco do motor"), "Fornecedor 9", 2500);
        adicionarRegistro("13/04/2025", "Receita", "Venda + manutenção", 
                          Arrays.asList("Bloco de motor", "Kit de amortecedor"), "Cliente 3", 4500);
        adicionarRegistro("13/04/2025", "Receita", "Venda", 
                          Arrays.asList("Suspensão"), "Dieicon", 1000);
        adicionarRegistro("13/04/2025", "Receita", "Venda", 
                          Arrays.asList("Porta"), "Rafael Kruger", 2500);
    }

    private void adicionarRegistro(String data, String classificacao, String detalhamento, 
                                   List<String> pecas, String cliente_fornecedor, double valor) {
        Map<String, Object> registro = new HashMap<>();
        registro.put("data", data);
        registro.put("classificacao", classificacao);
        registro.put("detalhamento", detalhamento);
        registro.put("pecas", pecas);
        registro.put("cliente_fornecedor", cliente_fornecedor);
        registro.put("valor", valor);
        dados.add(registro);
    }

    private Map<String, Object> criarEstoqueItem(String nome, Object preco, Object quantidade, int codigo) {
        Map<String, Object> item = new HashMap<>();
        item.put("nome", nome);
        item.put("preco", preco);
        item.put("quantidade", quantidade);
        item.put("codigo", codigo);
        return item;
    }

    public void visualizarEstoque() {
        System.out.println("\nTabela de Estoque:");
        System.out.printf("%-20s | %-10s | %-12s | %-6s%n", "Peça", "Preço (R$)", "Em Estoque", "Código");
        System.out.println("------------------------------------------------");
        for (Map<String, Object> item : estoque) {
            System.out.printf("%-20s | %-10s | %-12s | %-6s%n", item.get("nome"), item.get("preco"),
                    item.get("quantidade"), item.get("codigo"));
        }
    }

    public void adicionarItemEstoque(Scanner scanner) {
        System.out.print("Digite o nome da peça: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço: ");
        Object preco = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        Object quantidade = scanner.nextLine();
        System.out.print("Digite o código da peça: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        estoque.add(criarEstoqueItem(nome, preco, quantidade, codigo));
        System.out.println("Item adicionado ao estoque com sucesso!");
    }

    public void removerItemEstoque(Scanner scanner) {
        visualizarEstoque();
        System.out.print("Digite o código do item que deseja remover: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        estoque.removeIf(item -> (int) item.get("codigo") == codigo);
        System.out.println("Item removido do estoque com sucesso!");
    }

    public void editarItemEstoque(Scanner scanner) {
        visualizarEstoque();
        System.out.print("Digite o código do item que deseja editar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for (Map<String, Object> item : estoque) {
            if ((int) item.get("codigo") == codigo) {
                System.out.print("Novo nome da peça: ");
                item.put("nome", scanner.nextLine());
                System.out.print("Novo preço: ");
                item.put("preco", scanner.nextLine());
                System.out.print("Nova quantidade: ");
                item.put("quantidade", scanner.nextLine());

                System.out.println("Item do estoque editado com sucesso!");
                return;
            }
        }
        System.out.println("Código inválido!");
    }

    public void menuEstoque(Scanner scanner) {
        while (true) {
            System.out.println("\nMenu de Estoque:");
            System.out.println("1 - Exibir estoque");
            System.out.println("2 - Adicionar item");
            System.out.println("3 - Remover item");
            System.out.println("4 - Editar item");
            System.out.println("0 - Voltar ao menu principal");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    visualizarEstoque();
                    break;
                case 2:
                    adicionarItemEstoque(scanner);
                    break;
                case 3:
                    removerItemEstoque(scanner);
                    break;
                case 4:
                    editarItemEstoque(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public void exibirTabela() {
        System.out.println("\nTabela de Serviços:");
        for (int i = 0; i < dados.size(); i++) {
            Map<String, Object> linha = dados.get(i);
            System.out.println((i + 1) + " | " + linha.get("data") + " | " 
                + linha.get("classificacao") + " | " + linha.get("detalhamento") 
                + " | " + linha.get("pecas") + " | " + linha.get("cliente_fornecedor") 
                + " | R$ " + linha.get("valor"));
        }
    }

    public void adicionarServico(Scanner scanner) {
        System.out.print("Digite a data do serviço: ");
        String data = scanner.nextLine();
        System.out.print("Digite a classificação (Receita/Despesa): ");
        String classificacao = scanner.nextLine();
        System.out.print("Digite o detalhamento: ");
        String detalhamento = scanner.nextLine();
        System.out.print("Digite o nome do cliente/fornecedor: ");
        String cliente_fornecedor = scanner.nextLine();
        System.out.print("Digite o valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        adicionarRegistro(data, classificacao, detalhamento, new ArrayList<>(), cliente_fornecedor, valor);
        System.out.println("Serviço adicionado com sucesso!");
    }

    public void removerServico(Scanner scanner) {
        exibirTabela();
        System.out.print("Digite o número do serviço que deseja remover: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < dados.size()) {
            dados.remove(indice);
            System.out.println("Serviço removido com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    }

    public void editarServico(Scanner scanner) {
        exibirTabela();
        System.out.print("Digite o número do serviço que deseja editar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < dados.size()) {
            Map<String, Object> servico = dados.get(indice);
            System.out.print("Novo detalhamento: ");
            String detalhamento = scanner.nextLine();
            System.out.print("Novo valor: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            servico.put("detalhamento", detalhamento);
            servico.put("valor", valor);
            System.out.println("Serviço editado com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    }

public void menuServicos(Scanner scanner) {
    while (true) {
        System.out.println("\nMenu de Serviços:");
        System.out.println("1 - Exibir serviços");
        System.out.println("2 - Adicionar serviço");
        System.out.println("3 - Remover serviço");
        System.out.println("4 - Editar serviço");
        System.out.println("0 - Voltar ao menu principal"); // Alterado para 0

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1: exibirTabela(); break;
            case 2: adicionarServico(scanner); break;
            case 3: removerServico(scanner); break;
            case 4: editarServico(scanner); break;
            case 0: return; // Alterado para 0
            default: System.out.println("Opção inválida!");
        }
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Main sistema = new Main();

    while (true) {
        System.out.println("\nMenu Principal:");
        System.out.println("1 - Serviços");
        System.out.println("2 - Estoque");
        System.out.println("0 - Sair"); // Alterado para 0

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1: sistema.menuServicos(scanner); break;
case 2: sistema.menuEstoque(scanner); break;

            case 0: // Alterado para 0
                System.out.println("Saindo...");
                scanner.close();
                return;
            default: System.out.println("Opção inválida!");
        }
    }
}

}
