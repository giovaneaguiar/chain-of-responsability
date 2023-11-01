public interface ManipuladorCompra {
    void setProximo(ManipuladorCompra manipulador);
    String processarSolicitacao(SolicitacaoCompra solicitacao);
}

