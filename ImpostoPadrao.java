public class ImpostoPadrao implements RegraImposto {
    private final double taxa;

    public ImpostoPadrao(double taxa) {
        this.taxa = taxa;
    }
    
    @Override
    public Dinheiro calcularDesconto(Dinheiro salarioBruto) {
        return salarioBruto.multiplicar(taxa);
    }
}
