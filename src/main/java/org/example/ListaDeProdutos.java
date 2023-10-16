package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ListaDeProdutos {
    Scanner promptString = new Scanner(System.in);
    Scanner promptDouble = new Scanner(System.in);
    private Map<String, Double> products;
    protected Map<String, Double> selectProducts = new HashMap<String, Double>();

    public ListaDeProdutos() {
        products = new HashMap<>();
        // Inicialize a lista de produtos com os nomes e pesos
        products.put("Celular", 0.7);
        products.put("Geladeira", 50.0);
        products.put("Air Fryer", 3.5);
        products.put("Cadeira", 5.0);
        products.put("Luminária", 0.8);
        products.put("Lavadora de roupa", 15.0);
        products.put("PlayStation 5", 3.9);
        products.put("Nintendo Switch", 0.3);
    }

    public void listarProdutos() {
        System.out.println("Lista de Produtos Disponíveis:");
        for (String productName : products.keySet()) {
            System.out.println(productName + " - Peso: " + products.get(productName) + " kg");
        }
    }

    public void selecionarProdutos() {
        int flag = 0;
        while(flag != 9){
            System.out.println(products);
            System.out.println("Qual item voce deseja adicionar na carga? ");
            String item = promptString.nextLine();
            System.out.println("Quantos itens voce deseja?");
            double quantidade = promptDouble.nextDouble();
            switch (item) {
                case "Celular" -> {
                    selectProducts.put(item, (quantidade * 0.7));
                    break;
                }
                case "Geladeira" -> {
                    selectProducts.put(item, (quantidade * 50.0));
                    break;
                }
                case "Air Fryer" -> {
                    selectProducts.put(item, (quantidade * 3.5));
                    break;
                }
                case "Cadeira" -> {
                    selectProducts.put(item, (quantidade * 5.0));
                    break;
                }
                case "Luminaria" -> {
                    selectProducts.put(item, (quantidade * 0.8));
                    break;
                }
                case "Lavadora de roupa" -> {
                    selectProducts.put(item, (quantidade * 15.0));
                    break;
                }
                case "PlayStation 5" -> {
                    selectProducts.put(item, (quantidade * 3.9));
                    break;
                }
                case "Nintendo Switch" -> {
                    selectProducts.put(item, (quantidade * 0.3));
                    break;
                }
            }
            System.out.println("Se deseja continuar, digite 0. Se deseja encerrar, digite 9!");
            flag = promptDouble.nextInt();
        }
        System.out.println("Sua lista de carga: " + selectProducts);
    }
}