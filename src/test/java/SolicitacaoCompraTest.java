import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SolicitacaoCompraTest {

    @Test
    public void testCadeiaSolicitacaoCompra() {
        SolicitacaoCompra solicitacao1 = new SolicitacaoCompra(500);
        SolicitacaoCompra solicitacao2 = new SolicitacaoCompra(1500);

        ManipuladorCompra manipulador1 = new ManipuladorConcreto(1000);
        ManipuladorCompra manipulador2 = new ManipuladorConcreto(2000);

        manipulador1.setProximo(manipulador2);

        String resultado1 = manipulador1.processarSolicitacao(solicitacao1);
        String resultado2 = manipulador1.processarSolicitacao(solicitacao2);

        assertEquals("Solicitação aprovada por um ManipuladorConcreto com limite de 1000.0", resultado1);
        assertEquals("Solicitação aprovada por um ManipuladorConcreto com limite de 2000.0", resultado2);
    }

    @Test
    public void testAprovacaoLimiteExato() {
        ManipuladorConcreto manipulador = new ManipuladorConcreto(1000);
        SolicitacaoCompra solicitacao = new SolicitacaoCompra(1000);

        String resultado = manipulador.processarSolicitacao(solicitacao);

        assertEquals("Solicitação aprovada por um ManipuladorConcreto com limite de 1000.0", resultado);
    }

    @Test
    public void testRejeicaoLimiteExato() {
        ManipuladorConcreto manipulador = new ManipuladorConcreto(1000);
        SolicitacaoCompra solicitacao = new SolicitacaoCompra(1500);

        String resultado = manipulador.processarSolicitacao(solicitacao);

        assertEquals("Solicitação não pode ser aprovada.", resultado);
    }

    @Test
    public void testPassagemParaProximoManipulador() {
        ManipuladorConcreto manipulador1 = new ManipuladorConcreto(1000);
        ManipuladorConcreto manipulador2 = new ManipuladorConcreto(2000);
        manipulador1.setProximo(manipulador2);

        SolicitacaoCompra solicitacao = new SolicitacaoCompra(1500);

        String resultado = manipulador1.processarSolicitacao(solicitacao);

        assertEquals("Solicitação aprovada por um ManipuladorConcreto com limite de 2000.0", resultado);
    }
}
