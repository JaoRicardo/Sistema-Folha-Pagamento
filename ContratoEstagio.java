public class ContratoEstagio implements ContratoTrabalho {
    private Nome titulo;
    private Dinheiro bolsa;
    private Horas cargaHoraria;
    private RegraDescontoHoras regraDesconto;

    public ContratoEstagio(Nome titulo, Dinheiro bolsa, Horas cargaHoraria, RegraDescontoHoras regraDesconto) {
        this.titulo = titulo;
        this.bolsa = bolsa;
        this.cargaHoraria = cargaHoraria;
        this.regraDesconto = regraDesconto;
    }

    @Override
    public Dinheiro calcularRemuneracao(Horas horasTrabalhadas) {
        if (horasTrabalhadas.ehMenorQue(cargaHoraria)) {
            Horas faltas = cargaHoraria.subtrair(horasTrabalhadas);
            Dinheiro desconto = regraDesconto.calcularDesconto(bolsa, cargaHoraria, faltas);
            return bolsa.subtrair(desconto);
            // Não recebe extra
        }
        return bolsa;
    }

    @Override
    public void registrarDados(ImpressoraDeFolha impressora, Nome nomeFuncionario, Dinheiro totalPago) {
        String detalhes = "Bolsa: R$" + bolsa + " | Carga Fixa: " + cargaHoraria + "hrs";
        impressora.imprimir(nomeFuncionario, titulo, detalhes, totalPago);
    }
}
