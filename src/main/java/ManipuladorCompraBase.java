public abstract class ManipuladorCompraBase implements ManipuladorCompra {
    private ManipuladorCompra proximoManipulador;

    @Override
    public void setProximo(ManipuladorCompra manipulador) {
        this.proximoManipulador = manipulador;
    }

    public ManipuladorCompra getProximo() {
        return proximoManipulador;
    }
}