package org.example;

import java.util.HashMap;
import java.util.Map;

class ListaDeProdutos {
    private Map<String, Double> products;

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
        // Implemente a lógica para permitir ao usuário selecionar produtos e quantidades desejados
    }
}