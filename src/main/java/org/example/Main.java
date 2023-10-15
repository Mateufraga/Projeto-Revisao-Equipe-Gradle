package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DistanciasCidades Amarelinha = new DistanciasCidades("src/main/java/org/example/DistanciasCidadesCSV.csv");
        ListaDeProdutos productList = new ListaDeProdutos();

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Bem-vindo à Amarelinha - Sistema de Transporte  |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("| 1. Consultar Trechos e Modalidades                |");
            System.out.println("| 2. Cadastrar transporte                          |");
            System.out.println("| 3. Dados estatísticos                            |");
            System.out.println("| 4. Finalizar o programa                          |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("| Escolha a opção (1/2/3/4): ");
            System.out.println("+--------------------------------------------------+");

            int choice = scanner.nextInt();
            Amarelinha.limparTela();
            switch (choice) {
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                        Amarelinha.listaCidades();
                    System.out.println("+--------------------------+");
                    System.out.println("|  Escolha as cidades!    |");
                    System.out.println("+--------------------------+");
                    String cidade1;
                        String cidade2;
                        cidade1 = scanner1.nextLine();
                        cidade2 = scanner1.nextLine();
                    String Cide1 = cidade1.toUpperCase();
                    String Cide2 = cidade2.toUpperCase();
                    if (Cide1 == Cide2) {
                        System.out.println("+-----------------------------------------+");
                        System.out.println("|  Não podemos fazer com a mesma cidade! |");
                        System.out.println("+-----------------------------------------+");
                        break;
                    } else {
                        if (Amarelinha.verificaCidade(Cide1) && Amarelinha.verificaCidade(Cide2)) {
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("|  As cidades selecionadas foram " + Cide1 + " e " + Cide2 + "  |");
                            System.out.println("|  Escolha o tipo de caminhão que será utilizado nesta rota acima! |");
                            System.out.println("|  1 - Pequeno                                                    |");
                            System.out.println("|  2 - Médio                                                      |");
                            System.out.println("|  3 - Grande                                                     |");
                            System.out.println("+---------------------------------------------------------------+");
                            int caminhaoEscolhido = scanner1.nextInt();
                            Caminhoes caminhao = new Caminhoes(caminhaoEscolhido);
                            double distancia = Amarelinha.pegaDistancia(Cide1, Cide2);
                            double Valor = caminhao.Calcularvalor(distancia);
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("|                Informações sobre o trajeto                     |");
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("|   Origem: " + Cide1);
                            System.out.println("|   Destino: " + Cide2);
                            System.out.println("|   Distância: " + distancia + " km");
                            System.out.println("|   Custo: R$ " + Valor);
                            System.out.println("+---------------------------------------------------------------+");
                        } else {
                            System.out.println("+------------------------+");
                            System.out.println("|  Erro, tente novamente  |");
                            System.out.println("+------------------------+");

                            break;
                        }
                    }
                    break;
                case 2:
                    // Opção de Cadastrar transporte
                    productList.listarProdutos(); // Implemente este método na classe ProductList
                    productList.selecionarProdutos(); // Implemente este método na classe ProductList
                    //transportSystem.cadastrarTransporte(productList); // Implemente este método na classe TransportSystem
                    break;
                case 3:
                    // Opção de Dados estatísticos
                    //transportSystem.exibirDadosEstatisticos(); // Implemente este método na classe TransportSystem
                    break;
                case 4:
                    // Opção de Finalizar o programa
                    System.out.println("O programa foi encerrado. Obrigado por usar a Amarelinha!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
