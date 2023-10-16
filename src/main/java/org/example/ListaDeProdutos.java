package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ListaDeProdutos {
    Scanner promptString = new Scanner(System.in);
    Scanner promptDouble = new Scanner(System.in);
    private Map<String,Double> products;
    public Map<String,Double> selectProducts = new HashMap<>();
    public Map<String,Integer> productsQuantity = new HashMap<>();

    public ListaDeProdutos() {
        products = new HashMap<>();
        // Inicialize a lista de produtos com os nomes e pesos
        products.put("Celular", 0.7);
        products.put("Geladeira", 50.0);
        products.put("Air fryer", 3.5);
        products.put("Cadeira", 5.0);
        products.put("Luminaria", 0.8);
        products.put("Lavadora de roupa", 15.0);
        products.put("Playstation 5", 3.9);
        products.put("Nintendo Switch", 0.3);
    }

    public void listarProdutos() {
        System.out.println("Lista de Produtos Disponíveis:");
        for (String productName : products.keySet()) {
            System.out.println(productName + " - Peso: " + products.get(productName) + " kg");
        }
    }

    public void selecionarProdutos() {
        int flag;
        do{
            System.out.println(products);
            System.out.println("Qual item voce deseja adicionar na carga? (Digite o item como ele aparece na lista) ");
            String item = promptString.nextLine().toUpperCase();
            System.out.println("Quantos itens você deseja transportar?");
            int quantidade = promptDouble.nextInt();
            switch (item) {
                case "CELULAR" -> {
                    selectProducts.put(item, (quantidade * 0.70));
                    productsQuantity.put(item,quantidade);
                }
                case "GELADEIRA" -> {
                    selectProducts.put(item, (quantidade * 50.0));
                    productsQuantity.put(item,quantidade);
                }
                case "AIR FRYER" -> {
                    selectProducts.put(item, (quantidade * 3.50));
                    productsQuantity.put(item,quantidade);
                }
                case "CADEIRA" -> {
                    selectProducts.put(item, (quantidade * 5.0));
                    productsQuantity.put(item,quantidade);
                }
                case "LUMINARIA" -> {
                    selectProducts.put(item, (quantidade * 0.80));
                    productsQuantity.put(item,quantidade);
                }
                case "LAVADORA DE ROUPA" -> {
                    selectProducts.put(item, (quantidade * 15.0));
                    productsQuantity.put(item,quantidade);
                }
                case "PLAYSTATION 5" -> {
                    selectProducts.put(item, (quantidade * 3.90));
                    productsQuantity.put(item,quantidade);
                }
                case "NINTENDO SWITCH" -> {
                    selectProducts.put(item, (quantidade * 0.3));
                    productsQuantity.put(item,quantidade);
                }
                default -> System.out.println("Este produto não está na lista. Verifique a sua ortografia e tente novamente");
            }
            System.out.println("Você deseja (Digite o número): ");
            System.out.println("1 - Continuar adicionando itens ");
            System.out.println("2 - Sair ");
            flag = promptDouble.nextInt();
        }while(flag != 2);
        System.out.println("Sua lista de carga: (Produto / Peso total em KG) " + selectProducts);
    }
}