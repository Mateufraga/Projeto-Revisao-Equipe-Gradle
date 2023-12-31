package org.example;

public class Caminhoes {
    private int Tipo;
    private double Valorkm;
    private double CapacidadeMaxima;

    private double capacidadeAtual;

    public Caminhoes(int tipo) {

        this.Tipo = tipo;

        if (this.Tipo == 1 ) {
            this.CapacidadeMaxima = 1000.0;
            this.Valorkm = 5.83;
            this.capacidadeAtual = 0;

        } else if (this.Tipo == 2) {
            this.CapacidadeMaxima = 4000.0;
            this.Valorkm = 13.42;
            this.capacidadeAtual = 0;

        } else if (this.Tipo == 3) {
            this.CapacidadeMaxima = 10000.0;
            this.Valorkm = 29.21;
            this.capacidadeAtual = 0;
        } else{
            System.out.println("Erro. O custo será definido como 0. Escolha um caminhão válido e tente novamente.");
        }
    }
    public double Calcularvalor(double distancia, int quantidadeCaminhoes) {
        double Valor = this.Valorkm * distancia * quantidadeCaminhoes;
        return Valor;
    }
    public boolean Verificapeso(double peso) {
        if (peso > CapacidadeMaxima) {
            return false;
        } else {
            return true;
        }
    }
}