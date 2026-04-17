public class Funcionario {
    private Nome nome;
    private ContratoTrabalho contrato;

    public Funcionario(Nome nome, ContratoTrabalho contrato) {
        this.nome = nome;
        this.contrato = contrato;
    }

    public Dinheiro processarSalarioBruto(Horas horasTrabalhadas) {
        return contrato.calcularRemuneracao(horasTrabalhadas);
    }

    public void registrarDados(ImpressoraDeFolha impressora, Dinheiro totalPago) {
        contrato.registrarDados(impressora, this.nome, totalPago);
    }
}
