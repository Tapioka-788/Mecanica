// private List<Map<String, Object>> dados;
//     private List<Map<String, Object>> estoque;

//     public Main() {
//         dados = new ArrayList<>();
//         estoque = new ArrayList<>(Arrays.asList(
//             criarEstoqueItem("Bloco do motor", "Por encomenda", "Por encomenda", 1001),
//             criarEstoqueItem("Pistão", 400, 0, 1002),
//             criarEstoqueItem("Biela", 400, 0, 1003),
//             criarEstoqueItem("Virabrequim", 2500, 0, 1004),
//             criarEstoqueItem("Cabeçote", "Por encomenda", "Por encomenda", 1005),
//             criarEstoqueItem("Válvulas", 150, 0, 1006),
//             criarEstoqueItem("Comando de válvulas", 350, 0, 1007),
//             criarEstoqueItem("Velas de ignição", 20, 15, 1008),
//             criarEstoqueItem("Alternador", 1000, 0, 1009),
//             criarEstoqueItem("Anéis do pistão", 400, 0, 1010),
//             criarEstoqueItem("Bateria", 479, 4, 1011),
//             criarEstoqueItem("Cilindros", 260, 0, 1012),
//             criarEstoqueItem("Radiador", 350, 3, 1013),
//             criarEstoqueItem("Filtro de ar", 47, 11, 1014),
//             criarEstoqueItem("Filtro de óleo", 45, 19, 1015),
//             criarEstoqueItem("Porta", 570, 0, 1016),
//             criarEstoqueItem("Suspensão a ar", 3550, 6, 1017)
//         ));

//         // Adicionando registros conforme a tabela fornecida
//         adicionarRegistro("13/04/2025", "Receita", "Manutenção", 
//                           Arrays.asList("Bomba", "2x Suspensão", "Bateria", "Mangueira"), "Bryan Assolini", 3499.99);
//         adicionarRegistro("13/04/2025", "Despesa", "Equipamentos e máquinas", 
//                           Arrays.asList("2x Morsa"), "Fornecedor 4", 430);
//         adicionarRegistro("13/04/2025", "Despesa", "Salário de funcionários", 
//                           Arrays.asList("3x Salário (3.000)"), "Fornecedor 7", 9000);
//         adicionarRegistro("13/04/2025", "Receita", "Venda", 
//                           Arrays.asList("Kit de freio p/ carro", "Filtro de óleo"), "Fabio Giaretta", 1020);
//         adicionarRegistro("13/04/2025", "Despesa", "Encomenda de motor", 
//                           Arrays.asList("Bloco do motor"), "Fornecedor 9", 2500);
//         adicionarRegistro("13/04/2025", "Receita", "Venda + manutenção", 
//                           Arrays.asList("Bloco de motor", "Kit de amortecedor"), "Cliente 3", 4500);
//         adicionarRegistro("13/04/2025", "Receita", "Venda", 
//                           Arrays.asList("Suspensão"), "Dieicon", 1000);
//         adicionarRegistro("13/04/2025", "Receita", "Venda", 
//                           Arrays.asList("Porta"), "Rafael Kruger", 2500);
//     }