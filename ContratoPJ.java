public class ContratoPJ implements ContratoTrabalho {
    private Nome titulo;
    private Dinheiro valorHora;

    public ContratoPJ(Nome titulo, Dinheiro valorHora) {
        this.titulo = titulo;
        this.valorHora = valorHora;
    }

    @Override
    public Dinheiro calcularRemuneracao(Horas horasTrabalhadas) {
        return valorHora.multiplicar(horasTrabalhadas.getQuantidade());
    }

    @Override
    public void registrarDados(ImpressoraDeFolha impressora, Nome nomeFuncionario, Dinheiro totalPago) {
        String detalhes = "Consultor/PJ - Valor Hora: R$" + valorHora;
        impressora.imprimir(nomeFuncionario, titulo, detalhes, totalPago);
    }
}
