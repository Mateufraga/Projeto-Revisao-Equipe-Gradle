import org.example.CadastroTransporte;
import org.example.DistanciasCidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class CadastroTransporteTeste {
    CadastroTransporte cadastroTransporte = new CadastroTransporte();
    @Test
    public void testCalulaCustoTotal(){
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
