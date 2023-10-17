package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DistanciasCidades Amarelinha = new DistanciasCidades("src/main/java/org/example/DistanciasCidadesCSV.csv");
        ListaDeProdutos productList = new ListaDeProdutos();
        CadastroTransporte cadastrosDeTransportes = new CadastroTransporte();

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
                    String enter;
                    System.out.println("Digite a cidade de partida: ");
                    cidade1 = scanner1.nextLine();
                    System.out.println("Digite a cidade de destino: ");
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
                            double Valor = caminhao.Calcularvalor(distancia, 1);
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("|                Informações sobre o trajeto                     |");
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("|   Origem: " + Cide1);
                            System.out.println("|   Destino: " + Cide2);
                            System.out.println("|   Distância: " + distancia + " km");
                            System.out.println("|   Custo: R$ " + Valor);
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("Aperte Enter para continuar");
                            scanner1.nextLine();
                            scanner1.nextLine();

                        } else {
                            System.out.println("+------------------------+");
                            System.out.println("|  Erro, tente novamente  |");
                            System.out.println("+------------------------+");
                            System.out.println("Aperte Enter para continuar");
                            scanner1.nextLine();
                            scanner1.nextLine();

                            break;
                        }
                    }
                    break;
                case 2:
                    // Arredondar numeros e interacao com usuario

                    DecimalFormat df = new DecimalFormat("###.##");
                    Scanner prompt = new Scanner(System.in);

                    // Listar Cidades

                    Amarelinha.listaCidades();
                    String cidadeOrigem;
                    String cidadeDestino;
                    do {
                        System.out.println("Qual sua cidade de origem? ");
                        cidadeOrigem = prompt.nextLine().toUpperCase();
                        System.out.println("Qual sua cidade de destino? ");
                        cidadeDestino = prompt.nextLine().toUpperCase();
                        if(!Amarelinha.Indice.containsKey(cidadeOrigem) || !Amarelinha.Indice.containsKey(cidadeDestino) || cidadeOrigem.equals(cidadeDestino)){
                            System.out.println("Atenção: Uma das cidades digitadas não está presente na lista ou as duas cidades são iguais. Revise a sua ortografia e tente novamente.");
                        }
                    } while (!Amarelinha.Indice.containsKey(cidadeOrigem) || !Amarelinha.Indice.containsKey(cidadeDestino) || cidadeOrigem.equals(cidadeDestino));
                    double distanciaASerPercorrida = Amarelinha.pegaDistancia(cidadeOrigem, cidadeDestino);

                    // Criar Lista de Carga

                    productList.listarProdutos();
                    productList.selecionarProdutos();

                    // Calcular Preco e Melhor Caminhao

                    double soma = productList.selectProducts.values().stream().mapToDouble(Double::doubleValue).sum();
                    double valorTransporte = 0;
                    double valorOpcional = 0;
                    int caminhaoPequeno = 0;
                    int caminhaoMedio = 0;
                    int caminhaoGrande = 0;
                    int contador = 0;

                    if (soma > 10000) {
                        Caminhoes caminhoes = new Caminhoes(3);
                        while (soma > 10000) {
                            soma -= 10000;
                            contador += 1;
                        }
                        valorOpcional += caminhoes.Calcularvalor(distanciaASerPercorrida, contador);
                    }
                    if (soma <= 2301.88) {
                        if (soma > 1000) {
                            Caminhoes caminhoes1 = new Caminhoes(1);
                            valorTransporte += caminhoes1.Calcularvalor(distanciaASerPercorrida, 2);
                            caminhaoPequeno += 2;
                        } else {
                            Caminhoes caminhoes2 = new Caminhoes(1);
                            valorTransporte += caminhoes2.Calcularvalor(distanciaASerPercorrida, 1);
                            caminhaoPequeno += 1;
                        }
                    }
                    if (soma > 2301.88 && soma <= 8706.40) {
                        if (soma <= 4000) {
                            Caminhoes caminhoes3 = new Caminhoes(2);
                            valorTransporte += caminhoes3.Calcularvalor(distanciaASerPercorrida, 1);
                            caminhaoMedio += 1;
                        } else if (soma < 8706.40 && soma > 4000) {
                            Caminhoes caminhoes4 = new Caminhoes(2);
                            Caminhoes caminhoes42 = new Caminhoes(1);
                            valorTransporte += caminhoes4.Calcularvalor(distanciaASerPercorrida, 1) + caminhoes42.Calcularvalor(distanciaASerPercorrida, 1);
                            caminhaoPequeno += 1;
                            caminhaoMedio += 1;
                        }
                    }
                    if (soma > 8706.40) {
                        Caminhoes caminhoes5 = new Caminhoes(3);
                        valorTransporte += caminhoes5.Calcularvalor(distanciaASerPercorrida, 1);
                        caminhaoGrande += 1;
                    }

                    String valorTotal = df.format(valorTransporte + valorOpcional);
                    valorTotal = valorTotal.replace(',', '.');
                    System.out.println("A distancia da viagem eh de " + distanciaASerPercorrida + " KM.");
                    System.out.println("O custo da viagem de " + cidadeOrigem + " ate a cidade de " + cidadeDestino + " eh de: R$" + valorTotal);

                    System.out.println("Foram utilizados: " + caminhaoPequeno + " caminhões pequenos, " + caminhaoMedio + " caminhões medios" + " e " + (caminhaoGrande + contador) + " caminhões grandes!");

                    cadastrosDeTransportes.numeroDeTrechos++;
                    cadastrosDeTransportes.precosAdicionados.add(Double.valueOf(valorTotal));
                    cadastrosDeTransportes.distanciaDeTrechos.add(distanciaASerPercorrida);
                    cadastrosDeTransportes.precosTotais.add(Double.valueOf(valorTotal));
                    System.out.println("Aperte Enter para continuar");
                    prompt.nextLine();
                    break;
                case 3:
                    Scanner input = new Scanner(System.in);
                    // Opção de Dados estatísticos
                    //transportSystem.exibirDadosEstatisticos(); // Implemente este método na classe TransportSystem
                    cadastrosDeTransportes.exibeEstatisticas();
                    cadastrosDeTransportes.calculaCustoMedioPorProduto(productList.selectProducts,productList.productsQuantity,cadastrosDeTransportes.precosAdicionados);
                    cadastrosDeTransportes.contaTotalDeItensTransportados(productList.productsQuantity);
                    System.out.println("Aperte Enter para continuar");
                    input.nextLine();
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
