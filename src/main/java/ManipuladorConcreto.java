import java.util.Locale;

public class ManipuladorConcreto extends ManipuladorCompraBase {
    private double limiteAprovacao;

    public ManipuladorConcreto(double limiteAprovacao) {
        this.limiteAprovacao = limiteAprovacao;
    }

    @Override
    public String processarSolicitacao(SolicitacaoCompra solicitacao) {
        if (solicitacao.getValor() <= limiteAprovacao) {
            return String.format(Locale.US, "Solicitação aprovada por um ManipuladorConcreto com limite de %.1f", limiteAprovacao);
        } else if (getProximo() != null) {
            return getProximo().processarSolicitacao(solicitacao);
        } else {
            return "Solicitação não pode ser aprovada.";
        }
    }
}
