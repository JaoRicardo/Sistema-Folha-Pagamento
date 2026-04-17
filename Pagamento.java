public class Pagamento {
    private Funcionario funcionario;
    private Horas horasTrabalhadas;
    private RegraImposto regraImposto;

    public Pagamento(Funcionario funcionario, Horas horasTrabalhadas, RegraImposto regraImposto) {
        this.funcionario = funcionario;
        this.horasTrabalhadas = horasTrabalhadas;
        this.regraImposto = regraImposto;
    }

    public void efetuarPagamento(ImpressoraDeFolha impressora) {
        Dinheiro salarioBruto = funcionario.processarSalarioBruto(horasTrabalhadas);
        Dinheiro impostoASerPago = regraImposto.calcularDesconto(salarioBruto);
        Dinheiro salarioLiquido = salarioBruto.subtrair(impostoASerPago);
        
        funcionario.registrarDados(impressora, salarioLiquido);
    }
}
