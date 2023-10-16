package org.example;

public class CadastroTransporte extends DistanciasCidades{
    public CadastroTransporte(String caminhoCSV) {
        super(caminhoCSV);
    }

    public double pegarDistanciaEntreCidades(String cidadeOrigem, String cidadeDestino){
        double distanciaEntreCidades = pegaDistancia(cidadeOrigem, cidadeDestino);
        return distanciaEntreCidades;
    }
    public void adicionarObjetosNaCarga(){
        ListaDeProdutos lista = new ListaDeProdutos();
        lista.selecionarProdutos();
        System.out.println("Sua carga: " + lista.selectProducts);
    }
}
