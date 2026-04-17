public class ImpostoIsento implements RegraImposto {
    @Override
    public Dinheiro calcularDesconto(Dinheiro salarioBruto) {
        return new Dinheiro(0);
    }
}
