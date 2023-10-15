import org.example.DistanciasCidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistanciasCidadesTeste {
    private static DistanciasCidades distanciasCidades;

    @BeforeAll
    public static void setUp() {
        distanciasCidades = new DistanciasCidades("src/main/java/org/example/DistanciasCidadesCSV.csv");
    }

    @Test
    public void testPegaDistanciaCidadesExistentes() {
        int distancia = distanciasCidades.pegaDistancia("BELEM", "PORTO ALEGRE");
        assertEquals(3852.0, distancia);
    }

    @Test
    public void testPegaDistanciaCidadesNaoExistentes() {
        int distancia = distanciasCidades.pegaDistancia("BRASILIA", "ARROZ");
        assertEquals(-1, distancia);
    }

    @Test
    public void testListaCidades() {
        distanciasCidades.listaCidades();
    }

    @Test
    public void testVerificaCidadeExistente() {
        boolean existe = distanciasCidades.verificaCidade("BRASILIA");
        assertTrue(existe);
    }

    @Test
    public void testVerificaCidadeNaoExistente() {
        boolean existe = distanciasCidades.verificaCidade("RATANABA");
        assertFalse(existe);
    }
}
