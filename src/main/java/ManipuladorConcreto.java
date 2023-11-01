public class ManipuladorConcreto extends ManipuladorCompraBase {
    private double limiteAprovacao;

    public ManipuladorConcreto(double limiteAprovacao) {
        this.limiteAprovacao = limiteAprovacao;
    }

    @Override
    public String processarSolicitacao(SolicitacaoCompra solicitacao) {
        if (solicitacao.getValor() <= limiteAprovacao) {
            return "Solicitação aprovada por um ManipuladorConcreto com limite de " + limiteAprovacao;
        } else if (getProximo() != null) {
            return getProximo().processarSolicitacao(solicitacao);
        } else {
            return "Solicitação não pode ser aprovada.";
        }
    }
}
