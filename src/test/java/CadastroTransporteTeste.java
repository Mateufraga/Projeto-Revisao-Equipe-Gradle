import org.example.CadastroTransporte;
import org.example.DistanciasCidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class CadastroTransporteTeste {
    CadastroTransporte cadastroTransporte = new CadastroTransporte();

    @Test
    public void testaCalculaCustoPorCaminhoesPequenos(){
        cadastroTransporte.caminhoesPequenos = 1;
        double custoDeCaminhoesPequenos = cadastroTransporte.calculaCustoPorCaminhaoPequeno(1);
        assertEquals(5.83,custoDeCaminhoesPequenos);
    }

    @Test
    public void testaCalculaCustoPorCaminhoesMedios(){
        cadastroTransporte.caminhoesMedios = 1;
        double custoDeCaminhoesMedios = cadastroTransporte.calculaCustoPorCaminhaoMedio(1);
        assertEquals(13.42,custoDeCaminhoesMedios);
    }

    @Test
    public void testaCalculaCustoPorCaminhoesGrandes(){
        cadastroTransporte.caminhoesGrandes = 1;
        double custoDeCaminhoesGrandes = cadastroTransporte.calculaCustoPorCaminhaoGrande(1);
        assertEquals(29.21,custoDeCaminhoesGrandes);
    }

    @Test
    public void testCalculaCustoTotal(){
        double soma = cadastroTransporte.calculaCustoTotal(new ArrayList());
        assertEquals(0, soma);
    }
    @Test
    public void testCalculaDistanciaTotalDeTrechos(){
        double distancia = cadastroTransporte.calculaDistanciaTotalDeTrechos(new ArrayList());
        assertEquals(0, distancia);
    }
    @Test
    public void testCalculaCustoPorTrecho(){
        double custo = cadastroTransporte.calculaCustoPorTrecho(5);
        assertEquals(0, custo);
    }
}
