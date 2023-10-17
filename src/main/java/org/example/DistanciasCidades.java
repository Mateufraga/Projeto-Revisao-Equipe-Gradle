package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DistanciasCidades {
    public Map<String, Integer> Indice = new HashMap<>();
    private int[][] matrizDeDistancias;

    public DistanciasCidades(String caminhoCSV) {
        carregaMatrizDeDistancias(caminhoCSV);
    }

    private void carregaMatrizDeDistancias(String caminhoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoCSV))) {
            String linha;
            String[] cidades = null;
            int linhaAtual = 0;

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(";");
                if (cidades == null) {

                    cidades = valores;
                    matrizDeDistancias = new int[cidades.length][cidades.length];
                    for (int i = 0; i < cidades.length; i++) {
                        Indice.put(cidades[i], i);
                    }
                } else {
                    for (int coluna = 0; coluna < valores.length; coluna++) {
                        matrizDeDistancias[linhaAtual][coluna] = Integer.parseInt(valores[coluna]);
                    }
                    linhaAtual++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Tu coloca duas cidades, ele vai te retornar a distância delas
    public int pegaDistancia(String cidade1, String cidade2) {
        if (Indice.containsKey(cidade1) && Indice.containsKey(cidade2)) {
            int indice1 = Indice.get(cidade1);
            int indice2 = Indice.get(cidade2);
            return matrizDeDistancias[indice1][indice2];
        } else {
            return -1;
        }
    }

    public void listaCidades() {
        final String horizontalLine = "+---------------------------------------------------------------------------" +
                "------------------+";
        final String verticalBar = "|";
        final String resetColor = "\u001B[0m";
        final String cyanText = "\u001B[36m";

        String title = "Aqui estão as rotas disponíveis:                ";

        System.out.println(cyanText + horizontalLine + resetColor);
        System.out.println(cyanText + verticalBar + String.format("%53s", title) + verticalBar + resetColor);
        System.out.println(horizontalLine);

        int count = 0;

        for (String cidade : Indice.keySet()) {
            System.out.print(cyanText + verticalBar + " " + String.format("%-27s", cidade) + " " + resetColor);
            count++;

            if (count == 3) {
                System.out.print(" " + verticalBar);
                System.out.println("\n" + verticalBar + "                                                           " +
                        verticalBar);
                System.out.print(cyanText + verticalBar + " " + resetColor);
                count = 0;
            }
        }
        for (int i = count; i < 3; i++) {
            System.out.print("                           ");
        }
        System.out.println(" " + verticalBar);
        System.out.println(horizontalLine);
    }
    public void limparTela() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }

        for (int i = 0; i < 40; i++) {
            System.out.println("                                                     ");
        }
    }


    public boolean verificaCidade(String cidade) {
        return Indice.containsKey(cidade);
    }
}
